import { Cobranca } from './cobranca';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CobrancaService {

  api = environment.api_vendas;
  endpoint = 'cobrancas'

  constructor(private httpClient: HttpClient) { }

  findAll(): Observable<Cobranca[]> {
    return this.httpClient.get<Cobranca[]>(`${this.api}/${this.endpoint}`);
  }

  findByClient(cliente: string): Observable<Cobranca[]> {
    return this.httpClient.get<Cobranca[]>(`${this.api}/${this.endpoint}/${cliente}`)
  }

}
