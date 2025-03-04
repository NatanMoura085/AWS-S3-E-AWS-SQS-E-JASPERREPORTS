package com.cupom.infrastructure.config;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.infrastructure.entities.CupomFiscalEntity;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
       var modelMapper =  new ModelMapper();
       modelMapper.createTypeMap(CupomFiscalEntity.class, CupomFiscalDTO.class);
       return modelMapper;
    }
}
