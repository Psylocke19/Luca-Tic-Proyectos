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

  //Metodo que recoge la lista de Contactos del servicio Rest
  public getContactos() {
    return this.http.get<Contacto[]>(this.url + "mostrarContacto");
  }

  //Metodo que envia el objeto contacto para annadirlo al servicio Rest
  public addContacto(contacto) {
    return this.http.post<Contacto>(this.url + "addContacto", contacto);
  }
}
