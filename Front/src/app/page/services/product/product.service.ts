import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from 'src/app/models/Producto.model';
import { API_URL } from 'src/app/config';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private url: string = API_URL+'/producto/';

  constructor(private http:HttpClient) {}

  getProductById(id: string): Observable<Producto> {
    return this.http.get<Producto>(this.url+id)
  }

  getProducts():Observable<Producto[]> {
    return this.http.get<Producto[]>(this.url+'listar')
  }
  get4RandomProducts():Observable<Producto[]> {
    return this.http.get<Producto[]>(this.url+'random/4')
  }
}
