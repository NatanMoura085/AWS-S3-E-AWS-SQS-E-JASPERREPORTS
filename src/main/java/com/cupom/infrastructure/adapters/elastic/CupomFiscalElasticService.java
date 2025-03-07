package com.cupom.infrastructure.adapters.elastic;

import com.cupom.core.dtos.elasticDTO.CupomFiscalElasticDTO;
import com.cupom.core.ports.interfaces.CupomFiscalElasticPort;
import com.cupom.infrastructure.assembler.CupomFiscalElasticAssembler;
import com.cupom.infrastructure.entities.CupomFiscalElasticEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class CupomFiscalElasticService implements CupomFiscalElasticPort {
    private final CupomFiscalElasticRepository cupomFiscalElasticRepository;
    private final CupomFiscalElasticAssembler assembler;

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
        CupomFiscalElasticEntity cupomFiscalElasticEntity = new CupomFiscalElasticEntity(cupomFiscalElasticDTO);
        cupomFiscalElasticRepository.save(cupomFiscalElasticEntity);
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
