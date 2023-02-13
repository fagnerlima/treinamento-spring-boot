package br.com.guilhermeribeiro.apivendas.dto;

public class CobrancaDTO {

    private Long id;

    private double valorParcela;

    private String cliente;

    private String opcaoPagamento;

    private boolean pagamentoEfetuado;

    private boolean cobrancaCancelada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValorParcela() {
        return valorParcela;
    }

    public void setValorParcela(double valorParcela) {
        this.valorParcela = valorParcela;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getOpcaoPagamento() {
        return opcaoPagamento;
    }

    public void setOpcaoPagamento(String opcaoPagamento) {
        this.opcaoPagamento = opcaoPagamento;
    }

    public boolean isPagamentoEfetuado() {
        return pagamentoEfetuado;
    }

    public void setPagamentoEfetuado(boolean pagamentoEfetuado) {
        this.pagamentoEfetuado = pagamentoEfetuado;
    }

    public boolean isCobrancaCancelada() {
        return cobrancaCancelada;
    }

    public void setCobrancaCancelada(boolean cobrancaCancelada) {
        this.cobrancaCancelada = cobrancaCancelada;
    }
}
