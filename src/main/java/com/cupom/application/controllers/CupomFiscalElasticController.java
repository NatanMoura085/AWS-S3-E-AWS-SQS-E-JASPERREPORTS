package com.cupom.application.controllers;

import com.cupom.application.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.infrastructure.adapters.elastic.CupomFiscalElasticService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class CupomFiscalElasticController {
    @Autowired
    private CupomFiscalElasticService cupomFiscalElasticService;
    private static Logger logger = LoggerFactory.getLogger(CupomFiscalElasticController.class);

    @PostMapping(value = "/insertElastic", produces = MediaType.APPLICATION_JSON_VALUE)
    public CupomFiscalElasticDTO insertElastic(@Valid @RequestBody CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        logger.info(String.valueOf(cupomFiscalElasticDTO) + "🔥🔥🔥");
        return cupomFiscalElasticService.salvarElastic(cupomFiscalElasticDTO);
    }
}
