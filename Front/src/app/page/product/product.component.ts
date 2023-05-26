import { UsuarioService } from './../../auth/services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from '../services/product/product.service';
import { Router } from '@angular/router';
import { CommentService } from '../services/comment/comment.service';
import { Comentario } from 'src/app/models/Comentario.model';
import { Usuario } from 'src/app/models/Usuario.model';
import { catchError, pipe, throwError } from 'rxjs';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  idProducto: string = '';
  product: Producto = new Producto();
  comments: Comentario[] = [];

  averageNote: number = 0;
  totalPrice: number = 0;

  constructor(
    private productService: ProductService,
    private commentService: CommentService,
    private usuarioService: UsuarioService,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.averageNote= 0;
    const urlSplitted: string[] = this.router.url.split("/");
    this.idProducto = urlSplitted[urlSplitted.length - 1];
    this.initializeProduct();
    this.initializeComments();
  }
  postComment(stars: HTMLInputElement, title: HTMLInputElement, messaje: HTMLTextAreaElement) {
    
    if (localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((user: Usuario) => {
          this.commentService.createComment(title.value, messaje.value, Number(stars.value), user.id as number, Number(this.idProducto))
            .pipe(catchError(error => {
              return error.messaje;
            }))
            .subscribe((comment) => {
              console.log("Comment created")
              this.ngOnInit();
            })
        })
    } else {
      console.log("Inicia sesion para escribir el comentario")
    }
  }
  private initializeProduct() {
    this.productService.getProductById(this.idProducto).subscribe((response: Producto) => {
      this.product = response;
      if (this.product.precio && this.product.iva) {
        this.totalPrice = Number((this.product.precio + (this.product.precio % this.product.iva)).toFixed(2))
      }
    })
  }

  private initializeComments() {
    this.commentService.getCommentsByProduct(this.idProducto)
      .subscribe((response: Comentario[]) => {
        this.comments = response
        console.log(response)
        if (this.comments.length > 0) {
          for (const comment of this.comments) {
            if (comment.puntuacion) this.averageNote += comment.puntuacion
          }
          this.averageNote /= this.comments.length
        }
      });
  }



}
