package br.com.candyhouse.msvcandyvendas.dto;

import br.com.candyhouse.msvcandyvendas.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TransacaoDto {

    private Integer idTransacao;

    private Double valorFabricacao;

    private LocalDate dataTransacao;

    private Item fkItem;

}
