package br.com.candyhouse.msvcandyvendas.mapper;

import br.com.candyhouse.msvcandyvendas.dto.TransacaoDto;
import br.com.candyhouse.msvcandyvendas.entity.Transacao;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransacaoMapper {

    public TransacaoDto converterEntidadeParaDto(Transacao transacao) {
        return new TransacaoDto(transacao.getIdTransacao(), transacao.getValorFabricacao(), transacao.getDataTransacao(), transacao.getFkItem());
    }

    public Transacao converterDtoParaEntidade(TransacaoDto transacaoDto) {
        return new Transacao(transacaoDto.getIdTransacao(), transacaoDto.getValorFabricacao(), transacaoDto.getDataTransacao(), transacaoDto.getFkItem());
    }

    public List<TransacaoDto> converterListaEntidadeParaDto(List<Transacao> listaTransacao) {

        List<TransacaoDto> listaTransacaoDto = new ArrayList<>();

        for (Transacao valor : listaTransacao) {
            TransacaoDto transacaoDto = new TransacaoDto();
            transacaoDto.setIdTransacao(valor.getIdTransacao());
            transacaoDto.setValorFabricacao(valor.getValorFabricacao());
            transacaoDto.setDataTransacao(valor.getDataTransacao());
            transacaoDto.setFkItem(valor.getFkItem());
        }
        return listaTransacaoDto;
    }
}

