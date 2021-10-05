package br.com.candyhouse.msvcandyvendas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "Transacao")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transacao")
    private Integer idTransacao;

    @Column(name = "valor_fabricacao")
    private Double valorFabricacao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "data_transacao")
    private LocalDate dataTransacao;

    @ManyToOne
    @JoinColumn(name = "fk_item")
    private Item fkItem;
}
