package com.cupom.infrastructure.adapters.elastic;

import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CupomFiscalElasticRepository extends ElasticsearchRepository<CupomFiscalElasticEntity, String> {
    List<CupomFiscalElasticEntity> findByCnpj(String cnpj);
     List<CupomFiscalElasticEntity> findByValor(String valor);
}
