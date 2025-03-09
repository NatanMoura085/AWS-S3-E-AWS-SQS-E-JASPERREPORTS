package com.cupom.application.controllers;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.infrastructure.adapters.elastic.CupomFiscalElasticService;
import com.cupom.infrastructure.adapters.jasper.JasperReportService;
import com.cupom.infrastructure.adapters.repository.CupomFiscalServiceRepository;
import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("v1/api")
public class CupomFiscalController {
    @Autowired
   private  CupomFiscalServiceRepository cupomFiscalServiceRepository;
    @Autowired
    private JasperReportService jasperReportService;

    @Autowired
    private CupomFiscalElasticService cupomFiscalElasticService;

    @GetMapping("/cupons")
    public List<CupomFiscalDTO> todosCupons(){
        return cupomFiscalServiceRepository.listaTodos();
    }
    @PostMapping("/cupons")
    public ResponseEntity<String> geraCupom(@RequestBody CupomFiscalDTO cupomFiscalDTO) throws JRException, IOException {
        var cupomfsical = cupomFiscalServiceRepository.salvarCupom(cupomFiscalDTO);
      String pdf = jasperReportService.gerarCupomFiscalPDF(cupomFiscalDTO);
        CupomFiscalElasticEntity cupomFiscalElasticEntity = new CupomFiscalElasticEntity(cupomFiscalDTO);
       CupomFiscalElasticDTO cupomFiscalElasticDTO =  cupomFiscalElasticEntity.toCupomFiscalElasticDTO();
      cupomFiscalElasticService.salvarElastic(cupomFiscalElasticDTO);

      return ResponseEntity.ok(pdf);
    }
}
