package br.com.guilhermeribeiro.apipagamentos.service;

import br.com.guilhermeribeiro.apipagamentos.dto.PagamentoDTO;
import br.com.guilhermeribeiro.apipagamentos.entity.Pagamento;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarPagamento(Pagamento pagamento) {

        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        pagamentoDTO.setId(pagamento.getId());
        pagamentoDTO.setValorPagamento(pagamento.getValorPagamento());
        pagamentoDTO.setOpcaoPagamento(pagamento.getOpcaoPagamento());
        pagamentoDTO.setPagamentoEfetuado(pagamento.isPagamentoEfetuado());

        String routingKey = "pag-efetuado";

        rabbitTemplate.convertAndSend(routingKey, pagamentoDTO);
    }
}
