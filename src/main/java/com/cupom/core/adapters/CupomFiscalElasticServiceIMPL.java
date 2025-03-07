package com.cupom.core.adapters;

import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.core.ports.interfaces.CupomFiscalElasticPort;
import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;

import java.util.List;

public class CupomFiscalElasticServiceIMPL implements CupomFiscalElasticPort {

    private final CupomFiscalElasticPort cupomFiscalElasticPort;

    public CupomFiscalElasticServiceIMPL(CupomFiscalElasticPort cupomFiscalElasticPort){
        this.cupomFiscalElasticPort = cupomFiscalElasticPort;
    }
    @Override
    public List<CupomFiscalElasticDTO> trazerTodos() {
        return cupomFiscalElasticPort.trazerTodos();
    }

    @Override
    public CupomFiscalElasticDTO salvarElastic(CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        return cupomFiscalElasticPort.salvarElastic(cupomFiscalElasticDTO);
    }

    @Override
    public CupomFiscalElasticDTO atualizarElastic(String id, CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        CupomFiscalElasticEntity cupomFiscalElasticEntity = new CupomFiscalElasticEntity(cupomFiscalElasticDTO);
        return cupomFiscalElasticDTO;
    }

    @Override
    public void deletar(String id) {
     cupomFiscalElasticPort.deletar(id);
    }
}
