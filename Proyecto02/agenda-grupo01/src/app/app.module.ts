import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddContactoComponent } from './componentes/add-contacto/add-contacto.component';
import { ListaContactosComponent } from './componentes/lista-contactos/lista-contactos.component';
import { ServiciosService } from './servicios/servicios.service'; 
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule } from '@angular/forms'; 


@NgModule({
  declarations: [
    AppComponent,
    AddContactoComponent,
    ListaContactosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [ServiciosService],
  bootstrap: [AppComponent]
})
export class AppModule { }
