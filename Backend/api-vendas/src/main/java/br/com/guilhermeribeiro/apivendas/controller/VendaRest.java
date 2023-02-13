package br.com.guilhermeribeiro.apivendas.controller;

import br.com.guilhermeribeiro.apivendas.dto.VendaDTO;
import br.com.guilhermeribeiro.apivendas.entity.Cobranca;
import br.com.guilhermeribeiro.apivendas.entity.Venda;
import br.com.guilhermeribeiro.apivendas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/vendas")
public class VendaRest {

    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> listarVendas() {
        return vendaService.listarVendas();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Venda> pesquisarVendaPorId(@PathVariable Long id) {
        return vendaService.pesquisarVendaPorId(id);
    }

    @PostMapping
    public ResponseEntity<Venda> gerarNovaVenda(@RequestBody VendaDTO vendaDTO) {
        return vendaService.gerarNovaVenda(vendaDTO);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<Venda> atualizarVenda(@PathVariable Long id, @RequestBody Venda venda) {
        return vendaService.atualizarVenda(id, venda);
    }
}
