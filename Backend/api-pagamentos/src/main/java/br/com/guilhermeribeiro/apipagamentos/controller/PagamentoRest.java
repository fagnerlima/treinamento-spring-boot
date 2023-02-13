package br.com.guilhermeribeiro.apipagamentos.controller;

import br.com.guilhermeribeiro.apipagamentos.entity.Pagamento;
import br.com.guilhermeribeiro.apipagamentos.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/pagamentos")
public class PagamentoRest {

    @Autowired
    private PagamentoService pagamentoService;

    @GetMapping
    public List<Pagamento> listarPagamentos() {
        return pagamentoService.listarPagamentos();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pagamento> buscarPagamentoPorId(@PathVariable Long id) {
        return pagamentoService.buscarPagamentoPorId(id);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pagamento> atualizarPagamento(@PathVariable Long id, @RequestBody Pagamento pagamento) {
        return pagamentoService.atualizarPagamento(id, pagamento);
    }
}
