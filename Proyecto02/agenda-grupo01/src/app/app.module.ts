import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AddContactoComponent } from './componentes/add-contacto/add-contacto.component';
import { ListaContactosComponent } from './componentes/lista-contactos/lista-contactos.component';
import { ServiciosService } from './servicios/servicios.service'; 
import { HttpClientModule } from '@angular/common/http'; 
import { FormsModule } from '@angular/forms';
import { HeaderComponent } from './componentes/estilos/header/header.component';
import { FooterComponent } from './componentes/estilos/footer/footer.component'; 

const appRoutes: Routes = [
  { path: 'addContacto', component: AddContactoComponent },
  { path: 'listaContactos',  component: ListaContactosComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    AddContactoComponent,
    ListaContactosComponent,
    HeaderComponent,
    FooterComponent
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
