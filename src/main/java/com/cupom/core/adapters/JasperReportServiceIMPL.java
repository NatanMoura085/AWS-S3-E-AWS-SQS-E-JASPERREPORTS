package com.cupom.core.adapters;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.core.model.CupomFiscal;
import com.cupom.core.ports.interfaces.JasperPort;
import com.cupom.infrastructure.adapters.jasper.JasperReportService;
import org.apache.commons.io.output.ByteArrayOutputStream;

public class JasperReportServiceIMPL implements JasperPort {
    private JasperReportService jasperReportService;

    public JasperReportServiceIMPL(JasperReportService jasperReportService) {
        this.jasperReportService = jasperReportService;
    }

    @Override
    public String gerarCupomFiscalPDF(CupomFiscalDTO cupomFiscalDTO) {
        CupomFiscal cupomFiscal = new CupomFiscal(cupomFiscalDTO);

        return jasperReportService.gerarCupomFiscalPDF(cupomFiscalDTO);
    }

    @Override
    public void uploadToS3(String pdfKey, ByteArrayOutputStream outputStream) {
        jasperReportService.uploadToS3(pdfKey, outputStream);
    }

    @Override
    public void sendMessageToSQS(String pdfKey) {
        jasperReportService.sendMessageToSQS(pdfKey);
    }
}
