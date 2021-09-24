package br.com.candyhouse.msvcandyvendas.service;

import br.com.candyhouse.msvcandyvendas.dto.ItemDto;
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

    public List<ItemDto> listarItens(){
        return itemMapper.converterListaEntidadeParaDto(itemRepository.findAll());
    }

    public ItemDto adicionarItem(Item item){
        return itemMapper.converterEntidadeParaDto(itemRepository.save(item));
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
