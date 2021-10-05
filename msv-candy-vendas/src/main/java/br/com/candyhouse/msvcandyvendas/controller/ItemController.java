package br.com.candyhouse.msvcandyvendas.controller;

import br.com.candyhouse.msvcandyvendas.dto.ItemDto;
import br.com.candyhouse.msvcandyvendas.dto.ProdutosDisponiveisDto;
import br.com.candyhouse.msvcandyvendas.entity.Item;
import br.com.candyhouse.msvcandyvendas.service.ApiCandyProducaoService;
import br.com.candyhouse.msvcandyvendas.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ApiCandyProducaoService apiCandyProducao;

    @GetMapping
    public ResponseEntity<List<ItemDto>> listarItens(){
        return ResponseEntity.ok(itemService.listarItens());
    }

    @PostMapping
    public ResponseEntity<ItemDto> adicionarItem(@RequestBody Item item){
        return ResponseEntity.ok(itemService.adicionarItem(item));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> buscarIdItem(@PathVariable Integer id){
        return ResponseEntity.ok(itemService.buscarIdItem(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> detelarItem(@PathVariable Integer id){
        itemService.deletarItem(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<ItemDto> modificarItem(@PathVariable Integer id, @RequestBody ItemDto item){
        return ResponseEntity.ok(itemService.modificarItem(id, item));
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutosDisponiveisDto>> listarProdutos(){
       return ResponseEntity.ok(apiCandyProducao.listarProdutos());
    }

}
