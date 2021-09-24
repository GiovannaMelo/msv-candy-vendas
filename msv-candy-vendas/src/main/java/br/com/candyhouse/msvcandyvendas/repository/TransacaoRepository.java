package br.com.candyhouse.msvcandyvendas.repository;

import br.com.candyhouse.msvcandyvendas.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, Integer> {
}
