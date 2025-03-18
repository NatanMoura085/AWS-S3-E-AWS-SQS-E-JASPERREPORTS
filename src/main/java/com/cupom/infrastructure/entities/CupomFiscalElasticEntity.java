package com.cupom.infrastructure.entities;

import com.cupom.application.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.shared.validation.ValidCupom;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "cupons")
public class CupomFiscalElasticEntity {
    public CupomFiscalElasticEntity(){

    }

    public CupomFiscalElasticEntity(CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        this.numeroCupom = cupomFiscalElasticDTO.numeroCupom();
        this.cnpj = cupomFiscalElasticDTO.cnpj();
        this.valor = cupomFiscalElasticDTO.valor();
        this.dataEmissao = cupomFiscalElasticDTO.dataEmissao();
    }


    @Id
    @Field(type = FieldType.Keyword)
    private String id;
    @Field(type = FieldType.Text)
    @ValidCupom
    private String numeroCupom;
    @Field(type = FieldType.Text)
    private String cnpj;
    @Field(type = FieldType.Text)
    private String valor;
    @Field(type = FieldType.Date, format = {}, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    private Date dataEmissao;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
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

    public CupomFiscalElasticDTO toCupomFiscalElasticDTO (){
        return new CupomFiscalElasticDTO(this.numeroCupom,this.cnpj,this.valor,this.dataEmissao);
    }
}
