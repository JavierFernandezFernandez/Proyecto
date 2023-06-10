import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from './../../services/product/product.service';
import { Component, OnInit } from '@angular/core';
import { catchError } from 'rxjs';
import { Usuario } from 'src/app/models/Usuario.model';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-searched-products',
  templateUrl: './searched-products.component.html',
  styleUrls: ['./searched-products.component.scss']
})
export class SearchedProductsComponent implements OnInit {
  term: string;
  products: Producto[] = [];

  constructor(
    private productService: ProductService,
    private usuarioService: UsuarioService,
    private router:Router
  ) {
    const arrHref = location.href.split('/');
    this.term = arrHref[arrHref.length - 1];
  }

  ngOnInit(): void {
    this.productService.getProductByName(this.term)
      .subscribe((response: Producto[]) => {
        this.products = response
      })
  }
  checkDescriptionQuantity(product: Producto): boolean {
    if (product.descripcion) {
      if (product.descripcion.length > 297) {
        return true;
      }
    }
    return false;
  }
  addToCart(product:Producto) {
    if (localStorage.getItem("token") && localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((response: Usuario) => {
          if (response.cesta != null || response.cesta != undefined) {
            if (response.cesta == '') {
              response.cesta = '[]';
            }
            let cart: Producto[] = JSON.parse(response.cesta);
            const productIndex: number = cart.findIndex((p: Producto) => p.id == product.id)
            if (productIndex == -1) {
              product.quantity = 1
              cart.push(product);
            } else {
              if (cart[productIndex].quantity) {
                (cart[productIndex].quantity as number)++;
              }
            }
            response.cesta = JSON.stringify(cart);
            const user: Usuario = { cesta: response.cesta } as Usuario
            this.usuarioService.updateUser(response.id as number, user)
              .pipe(catchError((err) => {
                return err.messaje
              }))
              .subscribe((response: Usuario | string) => {
                if (!(typeof response === 'string')) {
                  product.addCartSuccess = true;
                }
              });
          }
        })
    } else {
      this.router.navigate(['auth/login']);
    }

  }
}
