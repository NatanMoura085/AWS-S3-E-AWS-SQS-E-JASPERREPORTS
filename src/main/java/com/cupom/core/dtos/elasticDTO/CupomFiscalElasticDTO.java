package com.cupom.core.dtos.elasticDTO;

import java.util.Date;

public record CupomFiscalElasticDTO(String numeroCupom,String cnpj, String valor,Date dataEmissao) {

}
