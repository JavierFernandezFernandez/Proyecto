import { HttpClient, HttpHeaders, HttpRequest, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, of, throwError } from 'rxjs';
import { API_URL } from 'src/app/config';
import { Usuario } from 'src/app/models/Usuario.model';

@Injectable({
  providedIn: 'root',
})
export class UsuarioService {
  url = API_URL + '/usuario';

  constructor(private http: HttpClient) { }

  saveUser(
    name: string,
    phone: string,
    email: string,
    password: string,
    rolId: number
  ): Observable<Usuario> {
    const usuario: Usuario = {
      nombre: name,
      email: email,
      telefono: phone,
      password: password,
      rol: null,
    };
    return this.http.post<Usuario>(this.url + '/guardar', usuario);
  }

  login(email: string, password: string): Observable<any> {
    const creds = { email: email, password: password }

    return this.http.post(
      API_URL + '/login',
      creds,
      { observe: 'response', responseType: 'json'}
    );
  }

  getToken(): String | null {
    return localStorage.getItem('token');
  }
}
