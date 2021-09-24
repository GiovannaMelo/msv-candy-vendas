package br.com.candyhouse.msvcandyvendas.service;

import br.com.candyhouse.msvcandyvendas.dto.TransacaoDto;
import br.com.candyhouse.msvcandyvendas.entity.Transacao;
import br.com.candyhouse.msvcandyvendas.mapper.TransacaoMapper;
import br.com.candyhouse.msvcandyvendas.repository.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private TransacaoMapper transacaoMapper;

    public List<TransacaoDto> listarTransacao(){
        return transacaoMapper.converterListaEntidadeParaDto(transacaoRepository.findAll());
    }

    public TransacaoDto buscarIdTransacao(Integer id){
        return transacaoMapper.converterEntidadeParaDto(transacaoRepository.findById(id).get());
    }
}
