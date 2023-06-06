import { DireccionService } from './../../services/direccion/direccion.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router} from '@angular/router';
import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from 'src/app/services/product/product.service';
import { Usuario } from 'src/app/models/Usuario.model';
import { FormaPagoUsuario } from 'src/app/models/FormaPagoUsuarios';
import { FormaPagoUsuarioService } from 'src/app/services/foma-pago-usuario/forma-pago-usuario.service';
import { Direccion } from 'src/app/models/Direccion.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-process-order',
  templateUrl: './process-order.component.html',
  styleUrls: ['./process-order.component.scss']
})
export class ProcessOrderComponent implements OnInit {
  isCollapsedAddress: boolean = true;
  isCollapsedUserPaymentMethod: boolean = true;

  roundedAddressId: number = 0;
  selectedAddress: Direccion | false = false;
  roundedUserPaymentMethodId: number = 0;
  selectedUserPaymentMethod: FormaPagoUsuario | false = false;

  idUser: number = 0;
  cart: Producto[] = [];
  addresses: Direccion[] = [];
  userPaymentMethods: FormaPagoUsuario[] = [];

  constructor(
    private router: Router,
    private usuarioService: UsuarioService,
    private productService: ProductService,
    private direccionService: DireccionService,
    private formaPagoUsusarioService: FormaPagoUsuarioService,
    private ngbModal: NgbModal
  ) {}
  ngOnInit(): void {
    this.isCollapsedAddress = true;
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
  onSelectedAddressChange(address: Direccion) {
    this.selectedAddress = address;
    this.isCollapsedAddress = true;
  }
  onSelectedUserPaymentMethodChange(userPaymentMethod: FormaPagoUsuario) {
    this.selectedUserPaymentMethod = userPaymentMethod;
    this.isCollapsedAddress = true;
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
    //console.log(this.selectedAddress)
  }
  selectUserPaymentMethod() {
    this.selectedUserPaymentMethod = this.userPaymentMethods.find((userPaymentMethod: FormaPagoUsuario) => {
      return userPaymentMethod.id == this.roundedUserPaymentMethodId
    }) as FormaPagoUsuario;
    //console.log(this.selectedUserPaymentMethod)
  }

  //ng-bootstrap
  openVerticallyCentered(content:any) {
		this.ngbModal.open(content, { centered: true });
	}

}
