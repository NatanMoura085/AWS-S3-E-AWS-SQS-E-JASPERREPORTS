package com.cupom.infrastructure.entities;
import com.cupom.core.dtos.CupomFiscalDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;
import java.util.Date;

@Entity
@Table(name = "tb_cupons")
@AllArgsConstructor
public class CupomFiscalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroCupom;
    private String cnpj;
    private String valor;
    @Column(name = "data_emissao")
    private Date dataEmissao;
    public CupomFiscalEntity() {}
    private CupomFiscalEntity(Builder builder) {
        this.id = builder.id;
        this.numeroCupom = builder.numeroCupom;
        this.cnpj = builder.cnpj;
        this.valor = builder.valor;
        this.dataEmissao = builder.dataEmissao;
    }


    public CupomFiscalEntity(CupomFiscalDTO cupomFiscalDTO){
        this.id = cupomFiscalDTO.id();
        this.numeroCupom = cupomFiscalDTO.numeroCupom();
        this.cnpj = cupomFiscalDTO.cnpj();
        this.valor = cupomFiscalDTO.valor();
        this.dataEmissao = cupomFiscalDTO.dataEmissao();
    }



    public static class Builder {
        private Long id;
        private String numeroCupom;
        private String cnpj;
        private String valor;
        private Date dataEmissao;


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

        public Builder withDataEmissao(Date dataEmissao) {
            this.dataEmissao = dataEmissao;
            return this;
        }

        public CupomFiscalEntity build() {
            return new CupomFiscalEntity(this);
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

        public Date getDataEmissao() {
            return dataEmissao;
        }

        public void setDataEmissao(Date dataEmissao) {
            this.dataEmissao = dataEmissao;
        }
    }
