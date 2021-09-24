package br.com.candyhouse.msvcandyvendas.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item")
    private Integer idItem;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "qtd_produto")
    private  Integer qtdProduto;

    @Column(name = "valor")
    private Double valor;
}
