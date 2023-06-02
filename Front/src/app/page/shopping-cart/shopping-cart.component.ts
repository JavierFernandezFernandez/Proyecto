import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Producto } from 'src/app/models/Producto.model';
import { Component, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/Usuario.model';
import { catchError } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-shopping-basket',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {

  idUser: number = 0;
  cart: Producto[] = [];

  constructor(
    private usuarioService: UsuarioService,
    private router: Router
  ) { }

  ngOnInit(): void {
    if (localStorage.getItem("token") && localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((response: Usuario) => {
          this.idUser = response.id
          this.cart = JSON.parse(response.cesta as string);
          for (const product of this.cart) {
            if (!product.cuantity) {
              product.cuantity = 1
            }
          }
        })
    }
  }
  priceWithIva(product: Producto): number {
    if (product.precio && product.iva) {
      if (product.cuantity) {
        return (product.precio + (product.precio / product.iva)) * product.cuantity;
      }
      return (product.precio + (product.precio / product.iva));
    }
    return 0;
  }
  lessQuantity(input: HTMLInputElement, product: Producto) {
    if (Number(input.value) > 1) {
      input.value = String(Number(input.value) - 1);
      product.cuantity = Number(input.value);
    }
  }
  moreQuantity(input: HTMLInputElement, product: Producto) {
    input.value = String(Number(input.value) + 1);
    product.cuantity = Number(input.value);
  }
  totalPrice() {
    let totalPrice: number = 0;
    for (const product of this.cart) {
      if (product?.cuantity) {
        totalPrice += this.priceWithIva(product) * product?.cuantity;
      } else {
        totalPrice += this.priceWithIva(product)
      }
    }
    return totalPrice.toFixed(2)
  }
  confirmOrder() {
    const usuer: Usuario = { cesta: JSON.stringify(this.cart) } as Usuario;
    this.usuarioService.updateUser(this.idUser, usuer)
      .pipe(catchError((error) => {
        return error.message
      }))
      .subscribe((response: Usuario | string) => {
        if (!(typeof response === 'string')) {
          this.router.navigate(['process-oreder'])
        } else {
          console.log(response)
        }
      })
  }
}
