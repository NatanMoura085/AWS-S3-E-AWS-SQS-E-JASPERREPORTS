package com.cupom.core.ports.interfaces;

import com.cupom.application.dtos.elasticDTO.CupomFiscalElasticDTO;

import java.util.List;

public interface CupomFiscalElasticPort {
    List<CupomFiscalElasticDTO> trazerTodos();

    CupomFiscalElasticDTO salvarElastic(CupomFiscalElasticDTO cupomFiscalElasticDTO);

    CupomFiscalElasticDTO atualizarElastic(String id, CupomFiscalElasticDTO cupomFiscalElasticDTO);

    void deletar(String id);

}
