package com.cupom.application.controllers;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.infrastructure.entities.CupomFiscalEntity;
import com.cupom.infrastructure.adpaters.jasper.JasperReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("v1/api")
public class CupomFiscalController {
    @Autowired
    private JasperReportService jasperReportService;
    @PostMapping("/cupons")
    public ResponseEntity<String> geraCupom(@RequestBody CupomFiscalDTO cupomFiscalDTO) throws JRException, IOException {
      String pdf = jasperReportService.gerarCupomFiscalPDF(cupomFiscalDTO);

      return ResponseEntity.ok(pdf);
    }
}
