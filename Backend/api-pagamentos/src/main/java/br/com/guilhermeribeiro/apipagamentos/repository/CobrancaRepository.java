package br.com.guilhermeribeiro.apipagamentos.repository;

import br.com.guilhermeribeiro.apipagamentos.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CobrancaRepository extends JpaRepository<Pagamento, Long> {

}
