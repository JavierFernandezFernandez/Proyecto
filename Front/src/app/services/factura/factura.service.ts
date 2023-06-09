import { Direccion } from './../../models/Direccion.model';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL, GET_HEADERS } from 'src/app/config';
import { Factura } from 'src/app/models/Factura.model';
import { Usuario } from 'src/app/models/Usuario.model';

@Injectable({
  providedIn: 'root'
})
export class FacturaService {
  private url = API_URL + '/factura/';
  private headers: HttpHeaders = GET_HEADERS();
  constructor(private http: HttpClient) { }

  addInvoice(user: Usuario, address: Direccion, observations?: string): Observable<Factura> {
    const invoice: Factura = {
      usuario: user,
      direccion: address,
      observaciones: observations
    } as Factura;
    return this.http.post<Factura>(this.url + 'guardar', invoice, { headers: this.headers })
  }
  getLastUserInvoice(user: Usuario): Observable<Factura> {
    return this.http.get<Factura>(`${this.url}usuario/end/${user.id}`, { headers: this.headers })
  }

}
