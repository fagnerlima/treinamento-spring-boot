import { PagamentoComponent } from './components/pagamento/pagamento/pagamento.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CobrancaListarComponent } from './components/cobranca/cobranca-listar/cobranca-listar.component';
import { VendaCancelarComponent } from './components/venda/venda-cancelar/venda-cancelar.component';
import { VendaAtualizarComponent } from './components/venda/venda-atualizar/venda-atualizar.component';
import { VendaGerarComponent } from './components/venda/venda-gerar/venda-gerar.component';
import { VendaListarComponent } from './components/venda/venda-listar/venda-listar.component';
import { HomeComponent } from './template/home/home.component';

const routes: Routes = [
  {
      path: "",
      component: HomeComponent
  },
  {
      path: "home",
      component: HomeComponent
  },
  {
      path: "vendas",
      component: VendaListarComponent
  },
  {
      path: "venda/gerar-venda",
      component: VendaGerarComponent
  },
  {
      path: "venda/atualizar/:id",
      component: VendaAtualizarComponent
  },
  {
      path: "venda/cancelar/:id",
      component: VendaCancelarComponent
  },
  {
      path: "cobrancas",
      component: CobrancaListarComponent
  },
  {
      path: "cobranca/baixar/:id",
      component: PagamentoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
