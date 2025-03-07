package com.cupom.core.ports.elasticsearch;

import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;

import java.util.List;

public interface CupomFiscalElasticRepositoryPort {
    List<CupomFiscalElasticDTO> pegaTodos();
    CupomFiscalElasticDTO salvar(CupomFiscalElasticDTO cupomFiscalElasticDTO);
    CupomFiscalElasticDTO atualizar(String id , CupomFiscalElasticDTO cupomFiscalElasticDTO);
    void delete(String id);

}
