package com.cupom.core.model;

import com.cupom.core.dtos.CupomFiscalDTO;

import java.time.OffsetDateTime;


public class CupomFiscal {

    private Long id;

    private String numeroCupom;
    private String cnpj;
    private String valor;
    private OffsetDateTime dataEmissao;

    public CupomFiscal() {
    }

    public CupomFiscal(CupomFiscalDTO cupomFiscalDTO){
        this.numeroCupom = cupomFiscalDTO.numeroCupom();
        this.cnpj = cupomFiscalDTO.cnpj();
        this.valor = cupomFiscalDTO.valor();
        this.dataEmissao = cupomFiscalDTO.dataEmissao();
    }
    private CupomFiscal(Builder builder) {
        this.id = builder.id;
        this.numeroCupom = builder.numeroCupom;
        this.cnpj = builder.cnpj;
        this.valor = builder.valor;
        this.dataEmissao = builder.dataEmissao;
    }


<<<<<<< HEAD
=======

>>>>>>> 02e72ab (update: git)
    public static class Builder {
        private Long id;
        private String numeroCupom;
        private String cnpj;
        private String valor;
        private OffsetDateTime dataEmissao;


        public Builder withNumeroCumpom(String numeroCupom) {
            this.numeroCupom = numeroCupom;
            return this;
        }

        public Builder withCnpj(String cnpj) {
            this.cnpj = cnpj;
            return this;
        }

        public Builder withValor(String valor) {
            this.valor = valor;
            return this;
        }

        public Builder withDataEmissao(OffsetDateTime dataEmissao) {
            this.dataEmissao = dataEmissao;
            return this;
        }

        public CupomFiscal build() {
            return new CupomFiscal(this);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroCupom() {
        return numeroCupom;
    }

    public void setNumeroCupom(String numeroCupom) {
        this.numeroCupom = numeroCupom;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public OffsetDateTime getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(OffsetDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
<<<<<<< HEAD
=======


    public CupomFiscalDTO toCupomFiscalDTO() {
        return new CupomFiscalDTO(this.id,this.numeroCupom,this.cnpj,this.valor,this.dataEmissao);
    }
>>>>>>> 02e72ab (update: git)
}
