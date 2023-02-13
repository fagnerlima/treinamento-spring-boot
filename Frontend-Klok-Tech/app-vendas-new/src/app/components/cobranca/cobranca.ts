export interface Cobranca {
    id?: number;
    cliente: string;
    dataParcela: Date
    valorParcela: number;
    opcaoPagamento: string;
    pagamentoEfetuado: boolean;
    cobrancaCancelada: boolean;
}