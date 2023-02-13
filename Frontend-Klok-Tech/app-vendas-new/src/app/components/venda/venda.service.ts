import { VendaEnviar } from './venda-enviar';
import { Observable } from 'rxjs';
import { Venda } from './venda';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class VendaService {

  api = environment.api_vendas;
  endpoint = 'vendas'

  constructor(private httpClient: HttpClient) { }

  create(vendaEnviar: VendaEnviar): Observable<VendaEnviar> {
    return this.httpClient.post<VendaEnviar>(`${this.api}/${this.endpoint}`, vendaEnviar);
  }

  findAll(): Observable<Venda[]> {
    return this.httpClient.get<Venda[]>(`${this.api}/${this.endpoint}`);
  }

  findById(id: string): Observable<Venda> {
    const url = `${this.api}/${this.endpoint}/${id}`;
    return this.httpClient.get<Venda>(url);
  }

  update(venda: Venda): Observable<Venda> {
    const url = `${this.api}/${this.endpoint}/${venda.id}`;
    return this.httpClient.put<Venda>(url, venda);
  }
}
