package com.cupom.infrastructure.adapters.elastic;

import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.core.ports.interfaces.CupomFiscalElasticPort;
import com.cupom.infrastructure.assembler.CupomFiscalElasticAssembler;
import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class CupomFiscalElasticService implements CupomFiscalElasticPort {
    private final CupomFiscalElasticRepository cupomFiscalElasticRepository;
    private final CupomFiscalElasticAssembler assembler;
    private static Logger logger = LoggerFactory.getLogger(CupomFiscalElasticService.class);

    @Autowired
    public CupomFiscalElasticService(CupomFiscalElasticAssembler assembler, CupomFiscalElasticRepository cupomFiscalElasticRepository) {
        this.cupomFiscalElasticRepository = cupomFiscalElasticRepository;
        this.assembler = assembler;
    }

    @Override
    public List<CupomFiscalElasticDTO> trazerTodos() {
        List<CupomFiscalElasticEntity> cupomFiscalElasticEntities = new ArrayList<>();
        Iterator<CupomFiscalElasticEntity> cuponsElastic = cupomFiscalElasticRepository.findAll().iterator();
        while (cuponsElastic.hasNext()) {
            cupomFiscalElasticEntities.add(cuponsElastic.next());
        }


        return assembler.toCollectionCupomFiscalEntity(cupomFiscalElasticEntities);
    }

    @Override
    public CupomFiscalElasticDTO salvarElastic(CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        try {
        CupomFiscalElasticEntity cupomFiscalElasticEntity = new CupomFiscalElasticEntity(cupomFiscalElasticDTO);
           logger.info(cupomFiscalElasticEntity.getNumeroCupom());
            logger.info("Tentando salvar cupom no ElasticSearch..💣💣💣💣💣💣💣.");
          CupomFiscalElasticEntity salvo =  cupomFiscalElasticRepository.save(cupomFiscalElasticEntity);
            logger.info("Cupom salvo com sucesso! 🎉ID: {}",salvo.getId());

            logger.info("SALVO ->👌👌👌👌👌👌👌👌👌👌👌👌👌👌👌👌");
        return salvo.toCupomFiscalElasticDTO();
        } catch (ElasticsearchException e) {
            e.printStackTrace();

            logger.error(e.getMessage() + "📍📍📍📍📍📍📍📍📍📍📍📍📍📍📍",e);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Erro inesperado ao salvar cupom no ElasticSearch: 📍📍📍📍📍📍📍📍📍📍📍{}", e.getMessage(), e);
        }

        return cupomFiscalElasticDTO;
    }

    @Override
    public CupomFiscalElasticDTO atualizarElastic(String id, CupomFiscalElasticDTO cupomFiscalElasticDTO) {
        CupomFiscalElasticEntity cupomFiscalElasticEntity = new CupomFiscalElasticEntity(cupomFiscalElasticDTO);
        if (cupomFiscalElasticRepository.existsById(id)) {
            ResponseEntity.notFound().build();

        }
        cupomFiscalElasticEntity.setId(id);

        return assembler.toCupomFiscalElasticDTO(cupomFiscalElasticRepository.save(cupomFiscalElasticEntity));
    }

    @Override
    public void deletar(String id) {

        cupomFiscalElasticRepository.deleteById(id);
    }
}
