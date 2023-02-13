import { AlertasService } from './../../../shared/alertas.service';
import { ActivatedRoute, Router } from '@angular/router';
import { VendaService } from './../venda.service';
import { Venda } from './../venda';
import { Component, OnInit } from '@angular/core';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-venda-cancelar',
  templateUrl: './venda-cancelar.component.html',
  styleUrls: ['./venda-cancelar.component.css']
})
export class VendaCancelarComponent implements OnInit {

  venda: Venda = {
      cliente: '',
      dataVenda: '',
      faturada: false,
      cancelada: false,
      valorVenda: 0
  }

  constructor(
              private vendaService: VendaService, 
              private router: Router, 
              private route: ActivatedRoute, 
              private alertasService: AlertasService) { }

  ngOnInit(): void {
      const id = this.route.snapshot.paramMap.get('id');
      this.vendaService.findById(id!).subscribe(venda => {
          this.venda = venda;
      })
  }

  cancelarVenda() {
    Swal.fire({
        title: 'Deseja cancelar essa venda?',
        text: "Essa ação não poderá ser desfeita!",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonColor: '#4428AA',
        cancelButtonColor: '#C91D1D',
        confirmButtonText: 'Sim',
        cancelButtonText: 'Não'
      }).then((result) => {
        if (result.isConfirmed) {
            this.venda.cancelada = true;
            this.vendaService.update(this.venda).subscribe(() => {
                this.alertasService.alertaSucesso('Venda cancelada com sucesso!');
                this.router.navigate(['/vendas']);
            }, (error) => {
                console.log(error);
                this.alertasService.alertaErro('Não foi possivel cancelar a venda!');
            });
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          )
        }
      })


      
  }
}

