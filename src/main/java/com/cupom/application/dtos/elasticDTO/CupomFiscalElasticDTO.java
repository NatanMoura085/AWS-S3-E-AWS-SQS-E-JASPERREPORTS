package com.cupom.application.dtos.elasticDTO;

import com.cupom.shared.validation.ValidCupom;

import java.util.Date;

public record CupomFiscalElasticDTO(@ValidCupom String numeroCupom, String cnpj, String valor, Date dataEmissao) {
}
