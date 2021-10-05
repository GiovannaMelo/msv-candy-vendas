package br.com.candyhouse.msvcandyvendas.service;

import br.com.candyhouse.msvcandyvendas.dto.ItemDto;
import br.com.candyhouse.msvcandyvendas.dto.ProdutosDisponiveisDto;
import br.com.candyhouse.msvcandyvendas.entity.Item;
import br.com.candyhouse.msvcandyvendas.mapper.ItemMapper;
import br.com.candyhouse.msvcandyvendas.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private ApiCandyProducaoService apiCandyProducao;

    public List<ItemDto> listarItens(){
        return itemMapper.converterListaEntidadeParaDto(itemRepository.findAll());
    }

    public ItemDto adicionarItem(Item item){
        ProdutosDisponiveisDto dto = new ProdutosDisponiveisDto();
        List<ProdutosDisponiveisDto> produtosDisponiveisDtos = apiCandyProducao.listarProdutos();
        ProdutosDisponiveisDto produtosDisponiveisDto = produtosDisponiveisDtos.stream().filter(v -> v.getNome().equalsIgnoreCase(item.getNomeProduto())).findFirst().get();
        Integer qtdAtual = produtosDisponiveisDto.getQtdDisponivel() -  item.getQtdProduto();
        Item save = itemRepository.save(item);
        apiCandyProducao.alterar(produtosDisponiveisDto.getIdProduto(), qtdAtual);
        return itemMapper.converterEntidadeParaDto(save);
    }

    public ItemDto buscarIdItem(Integer id){
        return itemMapper.converterEntidadeParaDto(itemRepository.findById(id).get());
    }

    public void deletarItem(Integer id){
        itemRepository.deleteById(id);
    }

    public ItemDto modificarItem(Integer id, ItemDto itemDto){

        Item itemAtual = itemMapper.converterDtoParaEntidade(itemDto);

        itemAtual.setIdItem(id);

        return itemMapper.converterEntidadeParaDto(itemRepository.save(itemAtual));
    }
}
