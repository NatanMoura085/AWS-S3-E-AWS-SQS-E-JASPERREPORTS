package com.cupom.application.controllers;

import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.infrastructure.adapters.elastic.CupomFiscalElasticService;
import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class CupomFiscalElasticController {
    @Autowired
    private CupomFiscalElasticService cupomFiscalElasticService;
    @PostMapping("/insertElastic")
    public CupomFiscalElasticDTO insertElastic(CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        return cupomFiscalElasticService.salvarElastic(cupomFiscalElasticDTO);
    }
}
