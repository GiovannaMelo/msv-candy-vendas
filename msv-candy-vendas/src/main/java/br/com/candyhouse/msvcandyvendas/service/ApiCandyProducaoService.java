package br.com.candyhouse.msvcandyvendas.service;

import br.com.candyhouse.msvcandyvendas.dto.ProdutosDisponiveisDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "produto", url = "http://localhost:8080/produto")
public interface ApiCandyProducaoService {

    @RequestMapping(method = RequestMethod.GET, value = "")
    List<ProdutosDisponiveisDto> listarProdutos();

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/qtd/{qtdAtual}")
    String alterar(@PathVariable Integer id, @PathVariable Integer qtdAtual);

}
