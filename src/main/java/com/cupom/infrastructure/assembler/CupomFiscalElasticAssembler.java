package com.cupom.infrastructure.assembler;

import com.cupom.application.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CupomFiscalElasticAssembler {

    private final ModelMapper modelMapper = new ModelMapper();

    public CupomFiscalElasticEntity toCupomFiscalElasticEntity(CupomFiscalElasticDTO cupomFiscalElasticDTO){
        return modelMapper.map(cupomFiscalElasticDTO, CupomFiscalElasticEntity.class);
    }

    public CupomFiscalElasticDTO toCupomFiscalElasticDTO(CupomFiscalElasticEntity cupomFiscalEntity){
        return modelMapper.map(cupomFiscalEntity,CupomFiscalElasticDTO.class);
    }

    public List<CupomFiscalElasticDTO> toCollectionCupomFiscalEntity(List<CupomFiscalElasticEntity> cupomFiscalElasticEntities){
        return cupomFiscalElasticEntities.stream().map(this::toCupomFiscalElasticDTO).toList();
    }


}
