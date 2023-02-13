package br.com.guilhermeribeiro.apivendas.repository;

import br.com.guilhermeribeiro.apivendas.entity.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {

    @Query(value = "SELECT * FROM cobrancas WHERE UPPER(cobrancas.cliente) LIKE CONCAT('%',UPPER(:cliente),'%')", nativeQuery = true)
    public List<Cobranca> findByCliente(String cliente);
}
