export interface Pagamento {
    id?: number;
    dataParcela: string;
    valorPagamento: number;
    opcaoPagamento: string;
    pagamentoEfetuado: boolean;
}