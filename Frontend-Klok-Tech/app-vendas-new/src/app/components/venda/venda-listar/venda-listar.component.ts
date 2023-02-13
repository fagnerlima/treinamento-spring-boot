import { VendaService } from './../venda.service';
import { Venda } from './../venda';
import { Observable, catchError, of } from 'rxjs';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-venda-listar',
  templateUrl: './venda-listar.component.html',
  styleUrls: ['./venda-listar.component.css']
})
export class VendaListarComponent implements OnInit {

  vendas$: Observable<Venda[]>

  displayedColumns = ['id', 'cliente', 'data', 'valor', 'status', 'action']

  constructor(private vendaService: VendaService) {
    this.vendas$ = this.vendaService.findAll().pipe(
      catchError(error => {
        return of([])
      })
    );
  }

  ngOnInit(): void {
  }

}
