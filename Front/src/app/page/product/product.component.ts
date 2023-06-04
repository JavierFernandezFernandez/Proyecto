import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Producto, Marca, Categoria } from 'src/app/models/Producto.model';
import { Router } from '@angular/router';
import { ComentarioService } from '../../services/comentario/comentario.service';
import { Comentario } from 'src/app/models/Comentario.model';
import { Usuario } from 'src/app/models/Usuario.model';
import { catchError, pipe, throwError } from 'rxjs';
import { ProductService } from 'src/app/services/product/product.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { ViewportScroller } from '@angular/common';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  idProducto: string = '';
  product: Producto = {} as Producto;
  brand: Marca = {} as Marca;
  comments: Comentario[] = [];

  averageNote: number = 0;
  totalPrice: number = 0;
  stars: string = '1';
  cuantity: number = 1;

  addCartSuccess = false;

  constructor(
    private productService: ProductService,
    private commentService: ComentarioService,
    private usuarioService: UsuarioService,
    private viewportScroller: ViewportScroller,
    private router: Router,
  ) { }

  ngOnInit(): void {
    this.viewportScroller.scrollToAnchor('top');
    this.averageNote = 0;
    const urlSplitted: string[] = this.router.url.split("/");
    this.idProducto = urlSplitted[urlSplitted.length - 1];
    this.initializeProduct();
    this.initializeComments();
  }

  postComment(title: HTMLInputElement, messaje: HTMLTextAreaElement) {
    if (localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((user: Usuario) => {
          this.commentService.createComment(title.value, messaje.value, Number(this.stars), user.id as number, Number(this.idProducto))
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

  lessCuantity() {
    if (this.cuantity > 1) this.cuantity--;
  }

  moreCuantity() {
    if (true) this.cuantity++; //modificar con el stock
  }

  private initializeProduct() {
    this.productService.getProductById(this.idProducto).subscribe((response: Producto) => {
      this.product = response;
      this.brand = response.marca;
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

  addToCart() {
    //console.log('addToCart llamado')
    if (localStorage.getItem("token") && localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((response: Usuario) => {
          //console.log(response.cesta)
          if (response.cesta != null || response.cesta != undefined) {
            if (response.cesta == '') {
              response.cesta = '[]';
            }
            //console.log(response.cesta+'dentro')
            let cart: Producto[] = JSON.parse(response.cesta);
            cart.push(this.product);
            response.cesta = JSON.stringify(cart);
            const user: Usuario = { cesta: response.cesta } as Usuario
            this.usuarioService.updateUser(response.id as number, user)
              .pipe(catchError((err) => {
                return err.messaje
              }))
              .subscribe((response: Usuario | string) => {
                if (!(typeof response === 'string')) {
                  this.addCartSuccess = true;
                  //console.log(response);
                }
              });
          }
        })
    } else {
      console.log('no logeado')
    }

  }

}
