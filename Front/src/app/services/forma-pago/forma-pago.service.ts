import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL, GET_HEADERS } from 'src/app/config';
import { FormaPago } from 'src/app/models/FormaPago.model';

@Injectable({
  providedIn: 'root'
})
export class FormaPagoService {
  private url = API_URL + '/formaPagoUsuario/'
  private headers: HttpHeaders
  constructor(private http: HttpClient) {
    this.headers = GET_HEADERS()
  }
  getPaymentMethodByUserId(userId: number): Observable<FormaPago> {
    return this.http.get<FormaPago>(`${this.url}usuario/${userId}`,{headers:this.headers})
  }
}
