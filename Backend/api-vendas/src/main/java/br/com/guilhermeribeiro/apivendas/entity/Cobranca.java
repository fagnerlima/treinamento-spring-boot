package br.com.guilhermeribeiro.apivendas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "cobrancas")
public class Cobranca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataParcela;

    private String cliente;

    private double valorParcela;

    private String opcaoPagamento;

    private boolean pagamentoEfetuado;

    private boolean cobrancaCancelada;
}
