package com.cupom.infrastructure.entities;

import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

@Document(indexName = "cupons")
public class CupomFiscalElasticEntity {

    public CupomFiscalElasticEntity(CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        this.id = cupomFiscalElasticDTO.id();
        this.numeroCupom = cupomFiscalElasticDTO.cnpj();
        this.valor = cupomFiscalElasticDTO.valor();
        this.dataEmissao = cupomFiscalElasticDTO.dataEmissao();
    }

    @Id
    private String id;
    private String numeroCupom;
    private String cnpj;
    private String valor;
    private Date dataEmissao;

    public void setId(String id) {
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
