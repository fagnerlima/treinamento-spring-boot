package br.com.guilhermeribeiro.apivendas.repository;

import br.com.guilhermeribeiro.apivendas.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Venda, Long> {

}
