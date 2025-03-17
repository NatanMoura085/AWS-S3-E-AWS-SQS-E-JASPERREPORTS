package com.cupom.core.adapters;

import com.cupom.application.dtos.CupomFiscalDTO;
import com.cupom.core.model.CupomFiscal;
import com.cupom.core.ports.interfaces.JasperPort;
import com.cupom.core.ports.jaspers.JasperReportServicePort;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class JasperReportServiceIMPL implements JasperPort {
    private final JasperReportServicePort jasperReportServicePort;

    public JasperReportServiceIMPL(JasperReportServicePort jasperReportServicePort) {
        this.jasperReportServicePort = jasperReportServicePort;
    }

    @Override
    public String gerarCupomFiscalPDF(CupomFiscalDTO cupomFiscalDTO) {
        CupomFiscal cupomFiscal = new CupomFiscal(cupomFiscalDTO);

        return jasperReportServicePort.gerarCupomFiscalPDF(cupomFiscalDTO);
    }

    @Override
    public void uploadToS3(String pdfKey, ByteArrayOutputStream outputStream) {
        jasperReportServicePort.uploadToS3(pdfKey, outputStream);
    }

    @Override
    public void sendMessageToSQS(String pdfKey) {
        jasperReportServicePort.sendMessageToSQS(pdfKey);
    }
}
