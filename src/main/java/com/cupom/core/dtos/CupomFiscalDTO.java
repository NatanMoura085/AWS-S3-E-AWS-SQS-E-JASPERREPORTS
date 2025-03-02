package com.cupom.core.dtos;

import java.time.OffsetDateTime;

public record CupomFiscalDTO(Long id, String numeroCupom, String cnpj, String valor, OffsetDateTime dataEmissao) {
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
    public String valor() {
        return valor;
    }

    @Override
    public OffsetDateTime dataEmissao() {
        return dataEmissao;
    }
}
