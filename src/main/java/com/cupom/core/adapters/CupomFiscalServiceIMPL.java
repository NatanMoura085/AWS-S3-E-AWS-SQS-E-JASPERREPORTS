package com.cupom.core.adapters;

import com.cupom.application.dtos.CupomFiscalDTO;
import com.cupom.core.model.CupomFiscal;
import com.cupom.core.ports.interfaces.CupomFiscalServicePort;

import java.util.List;

public class CupomFiscalServiceIMPL implements CupomFiscalServicePort {
    private final CupomFiscalServicePort cupomFiscalServicePort;

    public CupomFiscalServiceIMPL(CupomFiscalServicePort cupomFiscalServicePort) {
        this.cupomFiscalServicePort = cupomFiscalServicePort;
    }

    @Override
    public List<CupomFiscalDTO> trazerTodos() {

        return cupomFiscalServicePort.trazerTodos();
    }

    @Override
    public CupomFiscalDTO salvar(CupomFiscalDTO cupomFiscalDTO) {
        CupomFiscal cupomFiscal = new CupomFiscal(cupomFiscalDTO);
        return cupomFiscalServicePort.salvar(cupomFiscalDTO);
    }

    @Override
    public CupomFiscalDTO atualizar(CupomFiscalDTO cupomFiscalDTO) {
        CupomFiscal cupomFiscal = new CupomFiscal(cupomFiscalDTO);
        cupomFiscal.setId(cupomFiscalDTO.id());
        cupomFiscal.setNumeroCupom(cupomFiscalDTO.numeroCupom());
        cupomFiscal.setCnpj(cupomFiscalDTO.cnpj());
        cupomFiscal.setValor(cupomFiscalDTO.valor());
        cupomFiscal.setDataEmissao(cupomFiscalDTO.dataEmissao());
        return cupomFiscalServicePort.atualizar(cupomFiscal.toCupomFiscalDTO());
    }

    @Override
    public void deletar(Long id) {
        boolean cupomFiscalDTOS = trazerTodos().remove(id);


    }
}
