import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { MaterialModule } from './shared/material.module';

import { FormsModule} from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { VendaListarComponent } from './components/venda/venda-listar/venda-listar.component';
import { VendaGerarComponent } from './components/venda/venda-gerar/venda-gerar.component';
import { VendaAtualizarComponent } from './components/venda/venda-atualizar/venda-atualizar.component';
import { VendaCancelarComponent } from './components/venda/venda-cancelar/venda-cancelar.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeComponent } from './template/home/home.component';
import { FooterComponent } from './template/footer/footer.component';
import { NavComponent } from './template/nav/nav.component';
import { HeaderComponent } from './template/header/header.component';
import { PagamentoComponent } from './components/pagamento/pagamento/pagamento.component';
import { CobrancaListarComponent } from './components/cobranca/cobranca-listar/cobranca-listar.component';

@NgModule({
  declarations: [
    AppComponent,
    VendaListarComponent,
    VendaGerarComponent,
    VendaAtualizarComponent,
    VendaCancelarComponent,
    HomeComponent,
    FooterComponent,
    NavComponent,
    HeaderComponent,
    PagamentoComponent,
    CobrancaListarComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
