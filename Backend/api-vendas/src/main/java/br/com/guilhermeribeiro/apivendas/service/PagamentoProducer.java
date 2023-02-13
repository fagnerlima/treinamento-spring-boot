package br.com.guilhermeribeiro.apivendas.service;

import br.com.guilhermeribeiro.apivendas.dto.PagamentoDTO;
import br.com.guilhermeribeiro.apivendas.entity.Cobranca;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void enviarCobrancaParaPagamento(Cobranca cobranca) {
        PagamentoDTO pagamentoDTO = new PagamentoDTO();
        pagamentoDTO.setId(cobranca.getId());
        pagamentoDTO.setValorPagamento(cobranca.getValorParcela());
        pagamentoDTO.setOpcaoPagamento(cobranca.getOpcaoPagamento());
        pagamentoDTO.setPagamentoEfetuado(false);

        String routingKey = "pag-gerado";

        rabbitTemplate.convertAndSend(routingKey, pagamentoDTO);
    }
}
