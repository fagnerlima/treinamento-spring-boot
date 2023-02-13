import { Pagamento } from './pagamento';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class PagamentoService {

  api = environment.api_pagamentos;
  endpoint = 'api/pagamentos';

  constructor(private httpClient: HttpClient) { }

  findById(id: string): Observable<Pagamento> {
    const url = `${this.api}/${this.endpoint}/${id}`;
    return this.httpClient.get<Pagamento>(url);
  }

  update(pagamento: Pagamento): Observable<Pagamento> {
    const url = `${this.api}/${this.endpoint}/${pagamento.id}`;
    return this.httpClient.put<Pagamento>(url, pagamento);
  }
}