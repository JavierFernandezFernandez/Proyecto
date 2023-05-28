import { HttpClient, HttpHeaders} from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL, GET_HEADERS } from 'src/app/config';
import { Comentario } from 'src/app/models/Comentario.model';
import { Producto } from 'src/app/models/Producto.model';
import { Usuario } from 'src/app/models/Usuario.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private url = API_URL + '/comentario/'
  private headers = new HttpHeaders();

  constructor(private http: HttpClient) {
    this.headers = GET_HEADERS(this.headers)
  }

  getCommentsByProduct(idProduct: string): Observable<Comentario[]> {
    return this.http.get<Comentario[]>(`${this.url}producto/${idProduct}`)
  }

  createComment(title:string,message:string,stars:number,userId:number,productId:number){
    const user: Usuario = {id:userId}
    const product: Producto = {id:productId}
    const comment: Comentario= {
      titulo:title,
      mensaje:message,
      puntuacion:stars,
      producto:product,
      usuario:user
    }
    return this.http.post(this.url+'guardar',comment,{headers:this.headers})
  }
}
