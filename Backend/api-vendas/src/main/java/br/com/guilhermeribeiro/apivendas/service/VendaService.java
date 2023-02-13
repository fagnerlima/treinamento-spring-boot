package br.com.guilhermeribeiro.apivendas.service;

import br.com.guilhermeribeiro.apivendas.dto.CobrancaDTO;
import br.com.guilhermeribeiro.apivendas.dto.VendaDTO;
import br.com.guilhermeribeiro.apivendas.entity.Venda;
import br.com.guilhermeribeiro.apivendas.repository.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VendaService {

    @Autowired
    public VendasRepository vendasRepository;

    @Autowired
    public CobrancaService cobrancaService;

    public List<Venda> listarVendas() {
        return vendasRepository.findAll();
    }

    public ResponseEntity<Venda> pesquisarVendaPorId(Long id) {
        return vendasRepository.findById(id)
                .map(venda -> ResponseEntity.ok().body(venda))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<Venda> gerarNovaVenda(VendaDTO vendaDTO) {
        try {
            Venda venda = new Venda();
            venda.setCliente(vendaDTO.getCliente());
            venda.setValorVenda(vendaDTO.getValorVenda());
            venda.setCancelada(false);
            venda.setDataVenda(LocalDateTime.now());
            vendasRepository.save(venda);

            CobrancaDTO cobrancaDTO = new CobrancaDTO();

            cobrancaDTO.setValorParcela(venda.getValorVenda());
            cobrancaDTO.setCliente(venda.getCliente());
            cobrancaDTO.setPagamentoEfetuado(false);
            cobrancaDTO.setCobrancaCancelada(false);

            cobrancaService.criarNovaCobranca(cobrancaDTO);

            return new ResponseEntity<Venda>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<Venda>(HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Venda> atualizarVenda(Long id, Venda venda) {
        return vendasRepository.findById(id)
                .map(vendaUp -> {
                    vendaUp.setCliente(venda.getCliente());
                    vendaUp.setCancelada(venda.isCancelada());
                    Venda atualizacao = vendasRepository.save(vendaUp);

                    cobrancaService.atualizarCobrancaDaVenda(venda);

                    return ResponseEntity.ok().body(atualizacao);
                }).orElse(ResponseEntity.notFound().build());
    }
}
