import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from 'src/app/models/Producto.model';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {
  url: string = 'http://localhost:8080';

  constructor(private http:HttpClient) {}

  getProducts():Observable<Producto[]> {
    return this.http.get<Producto[]>(this.url+'/api/producto/listar')
  }
}
