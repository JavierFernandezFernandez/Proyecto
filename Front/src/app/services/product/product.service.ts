import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Producto } from 'src/app/models/Producto.model';
import { API_URL, GET_HEADERS } from 'src/app/config';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private url: string = API_URL+'/producto/';
  private headers: HttpHeaders

  constructor(private http:HttpClient) {
    this.headers = GET_HEADERS()
  }

  getProductById(id: string): Observable<Producto> {
    return this.http.get<Producto>(this.url+id)
  }

  getProducts():Observable<Producto[]> {
    return this.http.get<Producto[]>(this.url+'listar')
  }
  get4RandomProducts():Observable<Producto[]> {
    return this.http.get<Producto[]>(this.url+'random/4')
  }

  getProductByName(name: string): Observable<Producto[]> {
    return this.http.get<Producto[]>(`${this.url}nombre/${name}`)
  }

  getPriceWithIva(product: Producto): number {
    if (product.precio && product.iva) {
      if (product.quantity) {
        return (product.precio + (product.precio / product.iva)) * product.quantity;
      }
      return (product.precio + (product.precio / product.iva));
    }
    return 0;
  }

}
