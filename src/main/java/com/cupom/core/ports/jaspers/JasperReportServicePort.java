package com.cupom.core.ports.jaspers;

import com.cupom.core.dtos.CupomFiscalDTO;
import org.apache.commons.io.output.ByteArrayOutputStream;

public interface JasperReportServicePort {
    String gerarCupomFiscalPDF(CupomFiscalDTO cupomFiscalDTO);
    void uploadToS3(String pdfKey, ByteArrayOutputStream outputStream);
    void sendMessageToSQS(String pdfKey);
}
