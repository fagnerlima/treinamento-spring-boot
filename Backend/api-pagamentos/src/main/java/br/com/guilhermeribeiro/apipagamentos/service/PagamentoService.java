package br.com.guilhermeribeiro.apipagamentos.service;

import br.com.guilhermeribeiro.apipagamentos.dto.PagamentoDTO;
import br.com.guilhermeribeiro.apipagamentos.entity.Pagamento;
import br.com.guilhermeribeiro.apipagamentos.repository.CobrancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PagamentoService {

    @Autowired
    private CobrancaRepository pagamentoRepository;

    @Autowired
    private PagamentoProducer pagamentoProducer;

    public List<Pagamento> listarPagamentos() {
        return pagamentoRepository.findAll();
    }

    public ResponseEntity<Pagamento> buscarPagamentoPorId(Long id) {
        return pagamentoRepository.findById(id)
                .map(pagamento -> ResponseEntity.ok().body(pagamento))
                .orElse(ResponseEntity.notFound().build());
    }

    public String gerarPagamento(PagamentoDTO pagamentoDTO) {
        try {
            Pagamento pagamento = new Pagamento();
            pagamento.setDataParcela(LocalDateTime.now());
            pagamento.setValorPagamento(pagamentoDTO.getValorPagamento());
            pagamento.setPagamentoEfetuado(pagamentoDTO.isPagamentoEfetuado());
            pagamento.setOpcaoPagamento(pagamentoDTO.getOpcaoPagamento());
            pagamentoRepository.save(pagamento);

            return "Pagamento gerado com sucesso.";
        } catch (Exception e) {
            return ("Não foi possivel gerar o pagamento." + e);
        }
    }

    public ResponseEntity<Pagamento> atualizarPagamento(Long id, Pagamento pagamento) {

        pagamentoProducer.enviarPagamento(pagamento);

        return pagamentoRepository.findById(id)
                .map(pagamentoUp -> {
                    pagamentoUp.setOpcaoPagamento(pagamento.getOpcaoPagamento());
                    pagamentoUp.setPagamentoEfetuado(pagamento.isPagamentoEfetuado());
                    Pagamento atualizado = pagamentoRepository.save(pagamentoUp);

                    return ResponseEntity.ok().body(atualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

}
