import { DireccionService } from './../../services/direccion/direccion.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from 'src/app/services/product/product.service';
import { Usuario } from 'src/app/models/Usuario.model';
import { FormaPagoUsuario } from 'src/app/models/FormaPagoUsuarios';
import { FormaPagoUsuarioService } from 'src/app/services/foma-pago-usuario/forma-pago-usuario.service';
import { Direccion } from 'src/app/models/Direccion.model';

@Component({
  selector: 'app-process-order',
  templateUrl: './process-order.component.html',
  styleUrls: ['./process-order.component.scss']
})
export class ProcessOrderComponent implements OnInit {
  isCollapsed: boolean = false;

  roundedAddressId: number = 0;
  selectedAddress: Direccion | false = false;
  roundedPaymentMethodId: number = 0;
  selectedPaymentMethod: FormaPagoUsuario | false = false;

  idUser: number = 0;
  cart: Producto[] = [];
  addresses: Direccion[] = [];
  userPaymentMethods: FormaPagoUsuario[] = [];


  constructor(
    private router: Router,
    private usuarioService: UsuarioService,
    private productService: ProductService,
    private direccionService: DireccionService,
    private formaPagoUsusarioService: FormaPagoUsuarioService
  ) {

  }
  ngOnInit(): void {
    this.isCollapsed = true;
    if (localStorage.getItem("token") && localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((response: Usuario) => {
          this.idUser = response.id
          this.cart = JSON.parse(response.cesta as string);
          for (const product of this.cart) {
            if (!product.quantity) {
              product.quantity = 1
            }
          }
          this.direccionService.getAddressByUserId(this.idUser)
            .subscribe((response: Direccion[]) => {
              this.addresses = response
            })
          this.formaPagoUsusarioService.getUserPaymentMethodByUserId(this.idUser)
            .subscribe((response: FormaPagoUsuario[]) => {
              this.userPaymentMethods = response
            })
        })
    }
  }

  priceWithIva(product: Producto): number {
    return this.productService.getPriceWithIva(product)
  }
  totalPrice() {
    let totalPrice: number = 0;
    for (const product of this.cart) {
      if (product?.quantity) {
        totalPrice += this.priceWithIva(product) * product?.quantity;
      } else {
        totalPrice += this.priceWithIva(product)
      }
    }
    return totalPrice.toFixed(2)
  }

  selectAddress() {
    console.log(this.roundedAddressId)
    this.selectedAddress = this.addresses.find((address: Direccion) => {
      return address.id == this.roundedAddressId
    }) as Direccion;
    console.log(this.selectedAddress)
  }

}
