package com.cupom.infrastructure.adpaters.repository;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.core.model.CupomFiscal;
import com.cupom.core.ports.repositories.CupomFiscalRepositoryPort;
import com.cupom.infrastructure.assembler.CupomFiscalAssembler;
import com.cupom.infrastructure.entities.CupomFiscalEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CupomFiscalServiceRepository implements CupomFiscalRepositoryPort {
    private CupomFiscalRepository cupomFiscalRepository;
    private CupomFiscalAssembler assembler;

    public CupomFiscalServiceRepository(CupomFiscalRepository cupomFiscalRepository) {
        this.cupomFiscalRepository = cupomFiscalRepository;
    }

    @Override
    public List<CupomFiscalDTO> listaTodos() {
        return assembler.toCollectionCupomFiscalEntity(cupomFiscalRepository.findAll());
    }

    @Override
    public CupomFiscalDTO salvarCupom(CupomFiscalDTO cupomFiscalDTO) {
        CupomFiscalEntity cupomFiscal = assembler.toCupomFiscalEntity(cupomFiscalDTO);
        cupomFiscalRepository.save(cupomFiscal);
        return cupomFiscalDTO ;
    }

    @Override
    public CupomFiscalDTO atualizarCupom(CupomFiscalDTO cupomFiscalDTO) {
        Optional<CupomFiscalEntity> cupomFiscal = Optional.ofNullable(cupomFiscalRepository.findById(cupomFiscalDTO.id()).orElseThrow(() -> new RuntimeException("nao exite o id")));
            if (cupomFiscal.isPresent()){

            }

        return null;
    }

    @Override
    public void excluir(Long id) {

    }
}
