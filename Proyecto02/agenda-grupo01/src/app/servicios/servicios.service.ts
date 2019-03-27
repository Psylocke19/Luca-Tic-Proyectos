import { Injectable } from '@angular/core';

//Nuevo
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Contacto } from '../model/contacto';

//Nuevo
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class ServiciosService {

  constructor(private http:HttpClient) { }

  //Url original para construir en base
  private url = 'http://localhost:8080/';

  public getContactos() {
    return this.http.get<Contacto[]>(this.url + "mostrarContacto");
  }
}
