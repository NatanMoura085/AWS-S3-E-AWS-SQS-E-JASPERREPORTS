package com.cupom.infrastructure.assembler;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.infrastructure.entities.CupomFiscalEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CupomFiscalAssembler {
    private final ModelMapper modelMapper = new ModelMapper();

    public CupomFiscalEntity toCupomFiscalEntity(CupomFiscalDTO cupomFiscalDTO) {
        return modelMapper.map(cupomFiscalDTO, CupomFiscalEntity.class);

    }

    public CupomFiscalDTO toCupomFiscalDTO(CupomFiscalEntity cupomFiscal){
        return modelMapper.map(cupomFiscal,CupomFiscalDTO.class);
    }

    public List<CupomFiscalDTO> toCollectionCupomFiscalEntity(List<CupomFiscalEntity> cupomFiscalEntityList){
        return cupomFiscalEntityList.stream().map(this::toCupomFiscalDTO).toList();
    }
}
