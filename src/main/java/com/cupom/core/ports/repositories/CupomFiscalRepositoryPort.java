package com.cupom.core.ports.repositories;

import com.cupom.application.dtos.CupomFiscalDTO;

import java.util.List;

public interface CupomFiscalRepositoryPort {
    List<CupomFiscalDTO> listaTodos();

    CupomFiscalDTO salvarCupom(CupomFiscalDTO cupomFiscalDTO);

    CupomFiscalDTO atualizarCupom(CupomFiscalDTO cupomFiscalDTO);

    void excluir(Long id);

}
