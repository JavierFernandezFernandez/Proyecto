import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL, GET_HEADERS } from 'src/app/config';
import { FormaPago } from 'src/app/models/FormaPago.model';
import { FormaPagoUsuario } from 'src/app/models/FormaPagoUsuarios';
import { Usuario } from 'src/app/models/Usuario.model';

@Injectable({
  providedIn: 'root'
})
export class FormaPagoUsuarioService {
  private url = API_URL + '/formaPagoUsuario/'
  private headers: HttpHeaders

  constructor(private http: HttpClient) {
    this.headers = GET_HEADERS()
  }
  getUserPaymentMethodByUserId(userId: number): Observable<FormaPagoUsuario> {
    return this.http.get<FormaPagoUsuario>(`${this.url}usuario/${userId}`, { headers: this.headers })
  }

  addUserPaymentMethod(id: number, datos: string, usuario: Usuario, formaPago: FormaPago): Observable<FormaPagoUsuario> {
    const userPaymentMethod: FormaPagoUsuario = {
      id: id,
      datos: datos,
      usuario: usuario,
      formaPago: formaPago
    }

    return this.http.post<FormaPagoUsuario>(this.url+'guardar',userPaymentMethod,{headers:this.headers});
  }
}
