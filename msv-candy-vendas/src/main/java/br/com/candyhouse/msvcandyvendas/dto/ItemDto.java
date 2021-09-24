package br.com.candyhouse.msvcandyvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemDto {

    private Integer idItem;

    private String nomeProduto;

    private  Integer qtdProduto;

    private Double valor;

}
