import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { API_URL } from 'src/app/config';
import { Comment } from 'src/app/models/Comment.model';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  private url = API_URL + '/comentario/'

  constructor(private http: HttpClient) {}

  getCommentsByProduct(idProduct: string): Observable<Comment[]> {
    return this.http.get<Comment[]>(`${this.url}producto/${idProduct}`)
  }

}
