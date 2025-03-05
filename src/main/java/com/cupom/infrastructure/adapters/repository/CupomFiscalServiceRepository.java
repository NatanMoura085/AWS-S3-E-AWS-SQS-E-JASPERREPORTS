package com.cupom.infrastructure.adapters.repository;

import com.cupom.core.dtos.CupomFiscalDTO;
import com.cupom.core.ports.repositories.CupomFiscalRepositoryPort;
import com.cupom.infrastructure.assembler.CupomFiscalAssembler;
import com.cupom.infrastructure.entities.CupomFiscalEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CupomFiscalServiceRepository implements CupomFiscalRepositoryPort {
    private CupomFiscalRepository cupomFiscalRepository;
    private CupomFiscalAssembler assembler;

    @Autowired
    public CupomFiscalServiceRepository(CupomFiscalRepository cupomFiscalRepository, CupomFiscalAssembler cupomFiscalAssembler) {
        this.assembler = cupomFiscalAssembler;
        this.cupomFiscalRepository = cupomFiscalRepository;
    }

    @Override
    public List<CupomFiscalDTO> listaTodos() {
        return assembler.toCollectionCupomFiscalEntity(cupomFiscalRepository.findAll());
    }

    @Override
    public CupomFiscalDTO salvarCupom(CupomFiscalDTO cupomFiscalDTO) {
        CupomFiscalEntity cupomFiscal = new CupomFiscalEntity(cupomFiscalDTO);
        if (cupomFiscal == null) {
            throw new RuntimeException("os campos estão vazio");
        }
        cupomFiscalRepository.save(cupomFiscal);
        return cupomFiscalDTO;
    }

    @Override
    public CupomFiscalDTO atualizarCupom(CupomFiscalDTO cupomFiscalDTO) {
        Optional<CupomFiscalEntity> cupomFiscal = Optional.ofNullable(cupomFiscalRepository.findById(cupomFiscalDTO.id()).orElseThrow(() -> new RuntimeException("nao exite o id")));
        if (cupomFiscal.isPresent()) {
            cupomFiscal.stream().map(c -> {
                c.setId(cupomFiscalDTO.id());
                c.setNumeroCupom(cupomFiscalDTO.numeroCupom());
                c.setCnpj(cupomFiscalDTO.cnpj());
                c.setValor(cupomFiscalDTO.valor());
                c.setDataEmissao(cupomFiscalDTO.dataEmissao());

                return cupomFiscal;
            });
        }
        CupomFiscalEntity cupomFiscal1 = cupomFiscal.get();
        cupomFiscalRepository.save(cupomFiscal1);

        return assembler.toCupomFiscalDTO(cupomFiscal1);
    }

    @Override
    public void excluir(Long id) {
        CupomFiscalEntity cupomFiscal = cupomFiscalRepository.findById(id).get();

        cupomFiscalRepository.delete(cupomFiscal);

    }
}
