package br.com.guilhermeribeiro.apivendas.controller;

import br.com.guilhermeribeiro.apivendas.entity.Cobranca;
import br.com.guilhermeribeiro.apivendas.service.CobrancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/cobrancas")
public class CobrancaRest {

    @Autowired
    private CobrancaService cobrancaService;

    @GetMapping
    public List<Cobranca> listarCobrancas() {
        return cobrancaService.listarCobrancas();
    }

    @GetMapping(value = "/{cliente}")
    public List<Cobranca> listarCobrancasProCliente(@PathVariable String cliente) {
        return cobrancaService.listarCobrancasPorCliente(cliente);
    }
}
