package com.cupom.application.controllers;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.infrastructure.adapters.jasper.JasperReportService;
import com.cupom.infrastructure.adapters.repository.CupomFiscalServiceRepository;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("v1/api")
public class CupomFiscalController {
    @Autowired
   private  CupomFiscalServiceRepository cupomFiscalServiceRepository;
    @Autowired
    private JasperReportService jasperReportService;
    @PostMapping("/cupons")
    public ResponseEntity<String> geraCupom(@RequestBody CupomFiscalDTO cupomFiscalDTO) throws JRException, IOException {
        var cupomfsical = cupomFiscalServiceRepository.salvarCupom(cupomFiscalDTO);
      String pdf = jasperReportService.gerarCupomFiscalPDF(cupomFiscalDTO);

      return ResponseEntity.ok(pdf);
    }
}
