package com.cupom.core.dtos.elasticDTO;

import java.util.Date;

public record CupomFiscalElasticDTO(String id, String numeroCupom,String cnpj, String valor,Date dataEmissao) {

    @Override
    public String id() {
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
    public Date dataEmissao() {
        return dataEmissao;
    }
}
