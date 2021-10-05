package br.com.candyhouse.msvcandyvendas.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProdutosDisponiveisDto {

    private Integer idProduto;
    
    private String nome;

    private LocalDate dataFabricacao;

    private Integer qtdDisponivel;

    private Double valorVenda;

}
