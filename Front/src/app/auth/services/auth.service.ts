import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { async } from '@angular/core/testing';
import { Observable, catchError, of, throwError } from 'rxjs';
import { API_URL } from 'src/app/config';
import { Usuario } from 'src/app/models/Usuario.model';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  url = API_URL + '/usuario';
  constructor(private http: HttpClient) {}

  saveUser(
    name: string,
    phone: string,
    email: string,
    password: string,
    rolId: number
  ) {
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const usuario: Usuario = {
      nombre: name,
      email: email,
      telefono: phone,
      contraseña: password,
      rol: {
        id: rolId,
      },
    };
    return this.http.post<Usuario>(this.url + '/guardar', usuario, { headers });
  }
}
