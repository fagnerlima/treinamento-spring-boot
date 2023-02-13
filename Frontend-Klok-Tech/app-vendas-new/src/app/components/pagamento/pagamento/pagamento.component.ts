import { AlertasService } from './../../../shared/alertas.service';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { PagamentoService } from './../pagamento.service';
import { Pagamento } from './../pagamento';
import { Component, OnInit } from '@angular/core';

interface FormasPagamentos {
  value: string;
  viewValue: string;
}

@Component({
  selector: 'app-pagamento',
  templateUrl: './pagamento.component.html',
  styleUrls: ['./pagamento.component.css']
})
export class PagamentoComponent implements OnInit {

  pagamento: Pagamento = {
    dataParcela: '',
    valorPagamento: 0.00,
    opcaoPagamento: '',
    pagamentoEfetuado: false
  };

  formaPagamentoSelecionada: string = '';
  
  formasPagamentos: FormasPagamentos[] = [
    {value: 'Espécie', viewValue: 'Espécie'},
    {value: 'PIX', viewValue: 'PIX'},
    {value: 'Cartão-Débito', viewValue: 'Cartão-Débito'},
    {value: 'Cartão-Crédito', viewValue: 'Cartão-Crédito'}
  ];


  constructor(
              private pagamentoService: PagamentoService, 
              private router: Router, 
              private route: ActivatedRoute,
              private alertaService: AlertasService
  ) { }

  ngOnInit(): void {
      const id = this.route.snapshot.paramMap.get('id');
      this.pagamentoService.findById(id!).subscribe(pagamento => {
          this.pagamento = pagamento;
      })
  }

  atualizarPagamento(): void {
        this.pagamento.opcaoPagamento = this.formaPagamentoSelecionada;
        this.pagamento.pagamentoEfetuado = true;
        this.pagamentoService.update(this.pagamento).subscribe(() => {
            this.alertaService.alertaSucesso('Pagamento efetuado com sucesso!');
            this.router.navigate(['/cobrancas']);
        });
  }

}
