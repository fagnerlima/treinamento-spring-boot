export interface Venda {
    id?: number;
    cliente: string;
    dataVenda: string;
    faturada: boolean;
    cancelada: boolean;
    valorVenda: number;
}