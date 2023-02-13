package br.com.guilhermeribeiro.apivendas.service;

import br.com.guilhermeribeiro.apivendas.dto.CobrancaDTO;
import br.com.guilhermeribeiro.apivendas.dto.PagamentoDTO;
import br.com.guilhermeribeiro.apivendas.entity.Cobranca;
import br.com.guilhermeribeiro.apivendas.entity.Venda;
import br.com.guilhermeribeiro.apivendas.repository.CobrancaRepository;
import br.com.guilhermeribeiro.apivendas.repository.VendasRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CobrancaService {

    @Autowired
    private CobrancaRepository cobrancaRepository;

    @Autowired
    private PagamentoProducer pagamentoProducer;

    @Autowired
    private VendasRepository vendasRepository;

    public List<Cobranca> listarCobrancas() {
        return  cobrancaRepository.findAll();
    }

    public List<Cobranca> listarCobrancasPorCliente(String cliente) {
        return cobrancaRepository.findByCliente(cliente);
    }

    public String criarNovaCobranca(CobrancaDTO cobrancaDTO) {
        try {
            Cobranca cobranca = new Cobranca();
            cobranca.setCliente(cobrancaDTO.getCliente());
            cobranca.setDataParcela(LocalDateTime.now());
            cobranca.setValorParcela(cobrancaDTO.getValorParcela());
            cobranca.setPagamentoEfetuado(false);
            cobranca.setCobrancaCancelada(false);
            cobrancaRepository.save(cobranca);
            pagamentoProducer.enviarCobrancaParaPagamento(cobranca);
            return "Pagamento gerado com sucesso.";
        } catch (Exception e) {
            return ("Não foi possivel gerar o pagamento." + e);
        }
    }

    public ResponseEntity<Cobranca> atualizarCobrancaDeAcordoComPagamento(PagamentoDTO pagamentoDTO) {

        atualizarVendaDeAcordoComPagmento(pagamentoDTO);

        return cobrancaRepository.findById(pagamentoDTO.getId())
                .map(cobrancaUp -> {
                    cobrancaUp.setOpcaoPagamento(pagamentoDTO.getOpcaoPagamento());
                    cobrancaUp.setPagamentoEfetuado(pagamentoDTO.isPagamentoEfetuado());
                    Cobranca atualizado =  cobrancaRepository.save(cobrancaUp);
                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    public String atualizarVendaDeAcordoComPagmento(PagamentoDTO pagamentoDTO) {
        try {
            vendasRepository.findById(pagamentoDTO.getId())
                    .map(vendaUp -> {
                        vendaUp.setFaturada(pagamentoDTO.isPagamentoEfetuado());
                        Venda atualizada = vendasRepository.save(vendaUp);
                        return ResponseEntity.ok().body(atualizada);
                    }).orElse(ResponseEntity.notFound().build());
            return ("Venda atualizada com sucesso.");
        } catch (Exception e) {
            return ("Não foi possivel atualizar a venda." + e);
        }
    }

    public String atualizarCobrancaDaVenda(Venda venda) {
         return cobrancaRepository.findById(venda.getId())
                .map(cobrancaUp -> {
                    cobrancaUp.setCobrancaCancelada(venda.isCancelada());
                    cobrancaUp.setCliente(venda.getCliente());
                    Cobranca atualizada = cobrancaRepository.save(cobrancaUp);
                    return ("Cobranca atualizada. " + atualizada);
                }).orElse("Não foi possivel atualizar a cobraca.");
    }
}
