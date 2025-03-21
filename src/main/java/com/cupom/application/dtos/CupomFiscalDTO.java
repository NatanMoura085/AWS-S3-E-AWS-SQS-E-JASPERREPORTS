package com.cupom.application.dtos;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.Date;

public record CupomFiscalDTO(Long id, String numeroCupom, String cnpj, BigDecimal valor, Date dataEmissao) {
    @Override
    public Long id() {
        return id;
    }

    @Override
    public String numeroCupom() {
        return numeroCupom;
    }

    @Override
    public String cnpj() {
        return cnpj;
    }

    @Override
    public BigDecimal valor() {
        return valor;
    }

    @Override
    public Date dataEmissao() {
        return dataEmissao;
    }
}
