package com.cupom.application.dtos.elasticDTO;

import com.cupom.shared.validation.ValidCupom;

import java.math.BigDecimal;
import java.util.Date;

public record CupomFiscalElasticDTO(@ValidCupom String numeroCupom, String cnpj, BigDecimal valor, Date dataEmissao) {
}
