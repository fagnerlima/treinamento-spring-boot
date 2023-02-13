import { AlertasService } from './../../../shared/alertas.service';
import { Router } from '@angular/router';
import { VendaEnviar } from './../venda-enviar';
import { VendaService } from './../venda.service';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
    selector: 'app-venda-gerar',
    templateUrl: './venda-gerar.component.html',
    styleUrls: ['./venda-gerar.component.css']
})
export class VendaGerarComponent implements OnInit {


    vendaForm = new FormGroup({
        cliente: new FormControl('', Validators.required),
        valorVenda: new FormControl(0, [Validators.required, Validators.min(1)])
    })

    displayedColumns = ['descricao', 'precoUnitario', 'quantidade', 'valor', 'action']

    constructor(private vendaService: VendaService, private alertasService: AlertasService,  private router: Router) { }

    ngOnInit(): void {

    }

    gerarVenda(): void {
        const vendaEnviar = this.vendaForm.value as VendaEnviar;
        this.vendaService.create(vendaEnviar).subscribe(() => {
            this.alertasService.alertaSucesso('Venda gerada com sucesso!')
            this.router.navigate(['/vendas']);
            console.log(vendaEnviar);
        }, (error) => {
            this.alertasService.alertaErro('Verifique as informações e tente novamante!')
            console.error(error);
        });
    }
}
