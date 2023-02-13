import { AlertasService } from './../../../shared/alertas.service';
import { CobrancaService } from './../cobranca.service';
import { Cobranca } from './../cobranca';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cobranca-listar',
  templateUrl: './cobranca-listar.component.html',
  styleUrls: ['./cobranca-listar.component.css']
})
export class CobrancaListarComponent implements OnInit {

  cobrancas: Cobranca[] = [];

  cobrancaPesquisar: string = '';

  displayedColumns = ['id', 'cliente', 'data', 'valor', 'status', 'pagamento', 'action']

  constructor(private cobrancaService: CobrancaService, private alertaService: AlertasService) { }

  ngOnInit(): void {
      this.cobrancaService.findAll().subscribe(cobrancas => {
          this.cobrancas = cobrancas;
      }, (error) => {
          console.log(error);
      });
  }

  pesquisarCobrancaPorCliente(): void {
      this.cobrancaService.findByClient(this.cobrancaPesquisar).subscribe(cobrancasCliente => {
          this.cobrancas = cobrancasCliente;
      }, (error) => {
          console.log(error);
          this.alertaService.alertaErro('Não foi possivel executar essa ação!');
      });
  }

}
