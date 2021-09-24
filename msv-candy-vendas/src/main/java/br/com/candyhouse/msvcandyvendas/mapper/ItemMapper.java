package br.com.candyhouse.msvcandyvendas.mapper;

import br.com.candyhouse.msvcandyvendas.dto.ItemDto;
import br.com.candyhouse.msvcandyvendas.entity.Item;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper {

    public ItemDto converterEntidadeParaDto(Item item){
        return new ItemDto(item.getIdItem(), item.getNomeProduto(), item.getQtdProduto(), item.getValor());
    }

    public Item converterDtoParaEntidade(ItemDto dto){
        return new Item(dto.getIdItem(), dto.getNomeProduto(), dto.getQtdProduto(), dto.getValor());
    }

    public List<ItemDto> converterListaEntidadeParaDto(List<Item> listaItens){

        List<ItemDto> listaItensDto = new ArrayList<>();

        for (Item valor: listaItens) {
            ItemDto itemDto = new ItemDto();
            itemDto.setIdItem(valor.getIdItem());
            itemDto.setNomeProduto(valor.getNomeProduto());
            itemDto.setQtdProduto(valor.getQtdProduto());
            itemDto.setValor(valor.getValor());
            listaItensDto.add(itemDto);
        }
        return listaItensDto;
    }


}
