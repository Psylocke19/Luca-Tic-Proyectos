import { Component, OnInit } from '@angular/core';

//Nuevo
import { Router } from '@angular/router';

import { Contacto } from '../../model/contacto';
import { ServiciosService } from '../../servicios/servicios.service';

@Component({
  selector: 'app-add-contacto',
  templateUrl: './add-contacto.component.html',
  styleUrls: ['./add-contacto.component.css']
})
export class AddContactoComponent implements OnInit {

  contacto : Contacto = new Contacto();

  constructor(private router: Router, private service: ServiciosService) { }

  addUsuario(): void {
    this.service.addContacto(this.contacto)
        .subscribe( data => {
          alert("Usuario generado de forma correcta.");
        });

  };

  ngOnInit() {
  }

}
