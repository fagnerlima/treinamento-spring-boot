package br.com.guilhermeribeiro.apipagamentos.service;

import br.com.guilhermeribeiro.apipagamentos.dto.PagamentoDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PagamentoConsumer {

    @Autowired
    private PagamentoService pagamentoService;

    public static final String QUEUE_NAME = "pag-gerado";

    @RabbitListener(queues = QUEUE_NAME)
    public void listener(@Payload PagamentoDTO pagamentoDTO) {
        log.info("Pagamento recebido: {}", pagamentoDTO);
        pagamentoService.gerarPagamento(pagamentoDTO);
    }
}
