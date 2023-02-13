import { AlertasService } from './../../../shared/alertas.service';
import { Router, ActivatedRoute } from '@angular/router';
import { VendaService } from './../venda.service';
import { Component, OnInit } from '@angular/core';
import { Venda } from '../venda';

@Component({
  selector: 'app-venda-atualizar',
  templateUrl: './venda-atualizar.component.html',
  styleUrls: ['./venda-atualizar.component.css']
})
export class VendaAtualizarComponent implements OnInit {

  venda!: Venda;

  nomeCliente: string = '';

  constructor(
              private vendaService: VendaService, 
              private router: Router, 
              private route: ActivatedRoute, 
              private alertasService: AlertasService
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
      this.vendaService.findById(id!).subscribe(venda => {
          this.venda = venda;
      })
  }

  atualizarVenda() {
    this.venda.cliente = this.nomeCliente;
    this.vendaService.update(this.venda).subscribe(() => {
        this.alertasService.alertaSucesso('Venda cancelada com sucesso!');
        this.router.navigate(['/vendas']);
    }, (error) => {
        console.log(error);
        this.alertasService.alertaErro('Não foi possivel cancelar a venda!');
    });
}

}
