package com.cupom.application.dtos.elasticDTO;

import java.util.Date;

public record CupomFiscalElasticDTO(String numeroCupom, String cnpj, String valor, Date dataEmissao) {
}
