import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AddContactoComponent } from './componentes/add-contacto/add-contacto.component';
import { ListaContactosComponent } from './componentes/lista-contactos/lista-contactos.component'; 

const routes: Routes = [ 
  { path: 'listaContactos', component: ListaContactosComponent },
  { path: 'addContacto', component: AddContactoComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
