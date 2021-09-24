package br.com.candyhouse.msvcandyvendas.repository;

import br.com.candyhouse.msvcandyvendas.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Integer> {
}
