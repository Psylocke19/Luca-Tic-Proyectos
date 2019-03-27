import { Component, OnInit } from '@angular/core';


//Nuevo
import { Router } from '@angular/router';

import { Contacto } from '../../model/contacto';
import { ServiciosService } from '../../servicios/servicios.service';


@Component({
  selector: 'app-lista-contactos',
  templateUrl: './lista-contactos.component.html',
  styleUrls: ['./lista-contactos.component.css']
})
export class ListaContactosComponent implements OnInit {

  contactos : Contacto[];

  constructor(private router: Router, private service: ServiciosService) { }

  //Iniciamos el componente mostando la lista de Contactos, llamamos a la clase Servicios para realizar la peticion
  ngOnInit() {
    this.service.getContactos()
    .subscribe( data => {
      this.contactos = data;
    });
  }

  //Metodo que le pasamos un contacto por parametros y llama a la clase Servicios para realizar la peticion  de eliminar
  eliminarContacto(contacto: Contacto): void {
    this.service.eliminarContacto(contacto)
      .subscribe( data => {
        this.contactos = this.contactos.filter(u => u !== contacto);
        //Lo de arriba filtra la lista para que si el contacto se ha eliminado desaparezca
      })
  };

}
