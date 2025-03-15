package com.cupom.core.dtos.elasticDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record CupomFiscalElasticDTO(@JsonProperty("numeroCupom") String numeroCupom,
                                    @JsonProperty("cnpj") String cnpj,
                                    @JsonProperty("valor") String valor,
                                    @JsonProperty("dataEmissao") Date dataEmissao) {
}
