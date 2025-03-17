package com.cupom.core.ports.interfaces;

import com.cupom.application.dtos.CupomFiscalDTO;

import java.util.List;

public interface CupomFiscalServicePort {
    List<CupomFiscalDTO> trazerTodos();
    CupomFiscalDTO salvar(CupomFiscalDTO cupomFiscalDTO);
    CupomFiscalDTO atualizar(CupomFiscalDTO cupomFiscalDTO);
    void deletar(Long id);
}
