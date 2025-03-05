package com.cupom.infrastructure.adapters.jasper;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.core.ports.jaspers.JasperReportServicePort;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
public class JasperReportService implements JasperReportServicePort {
    private final AmazonS3 s3Client;

    private SqsTemplate sqsTemplate;
    private final ResourceLoader resourceLoader;
    private static final String SQS_QUEUE_URL = "https://sqs.us-east-1.amazonaws.com/156041430072/cupons-fila";
    private static final String TEMPLATE_PATH = "classpath:resources/"; // Atualizado para classpath
    public static final String ARQUIVOJRXML = "cupomFiscal.jrxml";
    private static final String BUCKET_NAME = "bucket-cupons";
    private static final String DESTINOPDF = "/desktop/";
    private static final Logger logger = LoggerFactory.getLogger(JasperReportService.class);

    @Autowired
    public JasperReportService(SqsTemplate sqsTemplate, AmazonS3 s3Client, ResourceLoader resourceLoader) {
        this.sqsTemplate = sqsTemplate;
        this.s3Client = s3Client;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String gerarCupomFiscalPDF(CupomFiscalDTO cupom) {
        try {
            String pathAbsoluto = getAbsultePath();
            try (InputStream jasperStream = new FileInputStream(pathAbsoluto)) {
                JasperReport jasperReport1 = loadCompiledReport();

                Map<String, Object> parametros = new HashMap<>();
                parametros.put("numeroCupom", cupom.numeroCupom());
                parametros.put("cnpj", cupom.cnpj());
                parametros.put("valor", cupom.valor().toString());
                parametros.put("dataEmissao", cupom.dataEmissao().toString());

                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport1, parametros, new JREmptyDataSource());

                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);
                String pdfKey = "cupons/" + cupom.numeroCupom() + ".pdf";
                sendMessageToSQS(pdfKey);
                uploadToS3(pdfKey, outputStream);
                return s3Client.getUrl(BUCKET_NAME, pdfKey).toString();
            }
        } catch (IOException | JRException e) {
            throw new RuntimeException("Erro ao gerar o cupom fiscal", e);
        }
    }


    @Override
    public void uploadToS3(String pdfKey, ByteArrayOutputStream outputStream) {
        try (ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray())) {
            PutObjectRequest metadata = new PutObjectRequest(BUCKET_NAME, pdfKey, "application/pdf");

            s3Client.putObject(BUCKET_NAME, pdfKey, inputStream, metadata.getMetadata());
        } catch (IOException e) {
            throw new RuntimeException("Erro ao fazer upload para o S3", e);
        } catch (AmazonServiceException e) {
            logger.error("Erro ao enviar o arquivo para o S3: " + e.getErrorMessage());
        } catch (SdkClientException e) {
            logger.error("Erro no cliente S3: " + e.getMessage());
        }

    }

    @Override
    public void sendMessageToSQS(String pdfKey) {
        try {
            sqsTemplate.send(to -> to.queue(SQS_QUEUE_URL).payload(pdfKey));
            logger.info("Mensagem enviada para SQS com sucesso:🔥🔥🔥🔥🔥 " + pdfKey);
        } catch (Exception e) {
            logger.info("Erro ao enviar mensagem para SQS:😒😒😒 " + e.getMessage());
            salvarMensagemFalha(pdfKey, e.getMessage());
        }
    }

    public void salvarMensagemFalha(String pdfKey, String erro) {
        logger.info("Salvando mensagem falha para reprocessamento: " + pdfKey);
    }


    private String getAbsultePath() throws FileNotFoundException {
        return ResourceUtils.getFile("classpath:cupomFiscal.jrxml").getAbsolutePath();
    }

    private JasperReport loadCompiledReport() throws JRException, IOException {
        return (JasperReport) JRLoader.loadObject(
                resourceLoader.getResource("classpath:cupomFiscal.jasper").getInputStream()
        );
    }

}
