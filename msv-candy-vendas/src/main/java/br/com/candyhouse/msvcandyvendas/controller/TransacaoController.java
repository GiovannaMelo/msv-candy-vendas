package br.com.candyhouse.msvcandyvendas.controller;
import br.com.candyhouse.msvcandyvendas.dto.TransacaoDto;
import br.com.candyhouse.msvcandyvendas.entity.Transacao;
import br.com.candyhouse.msvcandyvendas.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @GetMapping
    public ResponseEntity<List<TransacaoDto>> listarTransacao(){
        return ResponseEntity.ok(transacaoService.listarTransacao());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDto> buscarIdTransacao(@PathVariable Integer id){
        return ResponseEntity.ok(transacaoService.buscarIdTransacao(id));
    }
}
