import { Injectable } from '@angular/core';
import Swal from 'sweetalert2';

@Injectable({
  providedIn: 'root'
})
export class AlertasService {

  constructor() { }

  alertaSucesso(msg: string) {
    Swal.fire({
      title: 'Parabéns',
      text: msg,
      icon: 'success',
      confirmButtonColor: '#4428AA',
      confirmButtonText: 'OK'
    });
  }

  alertaErro(msg: string) {
    Swal.fire({
      title: 'Erro!',
      text: msg,
      icon: 'error',
      confirmButtonColor: '#4428AA',
      confirmButtonText: 'OK'
    });
  }

  alertaAtencao(msg: string) {
    Swal.fire({
      title: 'Ops!',
      text: msg,
      icon: 'warning',
      confirmButtonColor: '#4428AA',
      confirmButtonText: 'OK'
    });
  }
}