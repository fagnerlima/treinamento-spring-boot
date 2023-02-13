package br.com.guilhermeribeiro.apivendas.service;

import br.com.guilhermeribeiro.apivendas.dto.PagamentoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PagamentoConsumer {

    @Autowired
    private CobrancaService cobrancaService;

    public static final String QUEUE_NAME = "pag-efetuado";

    @RabbitListener(queues = QUEUE_NAME)
    public void listener(@Payload PagamentoDTO pagamentoDTO) {
        log.info("Pagamento efetuado: {}", pagamentoDTO);
        cobrancaService.atualizarCobrancaDeAcordoComPagamento(pagamentoDTO);
    }
}
