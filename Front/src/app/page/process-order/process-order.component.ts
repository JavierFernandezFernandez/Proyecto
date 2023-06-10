import { EjemplarService } from './../../services/ejemplar/ejemplar.service';
import { Ejemplar } from 'src/app/models/Ejemplar.model';
import { LineaPedidoService } from '../../services/linea-pedido/linea-pedido.service';
import { LineaFacturaService } from '../../services/linea-factura/linea-factura.service';
import { PedidoService } from './../../services/pedido/pedido.service';
import { DireccionService } from './../../services/direccion/direccion.service';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from 'src/app/services/product/product.service';
import { Usuario } from 'src/app/models/Usuario.model';
import { FormaPagoUsuario } from 'src/app/models/FormaPagoUsuarios';
import { FormaPagoUsuarioService } from 'src/app/services/foma-pago-usuario/forma-pago-usuario.service';
import { Direccion } from 'src/app/models/Direccion.model';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { FacturaService } from 'src/app/services/factura/factura.service';
import { Pedido } from 'src/app/models/Pedido.model';
import { Factura } from 'src/app/models/Factura.model';
import { LineaPedido } from 'src/app/models/LineaPedido.model';
import { LineaFactura } from 'src/app/models/LineaFactura.model';
import { Observable, catchError, forkJoin, map } from 'rxjs';

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

  user: Usuario = {} as Usuario;
  cart: Producto[] = [];
  addresses: Direccion[] = [];
  userPaymentMethods: FormaPagoUsuario[] = [];

  units: Ejemplar[] = [];



  constructor(
    private router: Router,
    private usuarioService: UsuarioService,
    private productService: ProductService,
    private direccionService: DireccionService,
    private formaPagoUsusarioService: FormaPagoUsuarioService,
    private facturaService: FacturaService,
    private pedidoService: PedidoService,
    private lineaFacturaService: LineaFacturaService,
    private lineaPedidoService: LineaPedidoService,
    private ejemplarService: EjemplarService,
    private ngbModal: NgbModal
  ) { }
  ngOnInit(): void {
    this.isCollapsedAddress = true;
    if (localStorage.getItem("token") && localStorage.getItem("email")) {
      this.usuarioService.getUserByEmail(localStorage.getItem("email") as string)
        .subscribe((response: Usuario) => {
          this.user = response
          this.cart = JSON.parse(response.cesta as string);
          for (const product of this.cart) {
            if (!product.quantity) {
              product.quantity = 1
            }
          }
          this.initUnits()
          this.direccionService.getAddressByUserId(this.user.id)
            .subscribe((response: Direccion[]) => {
              this.addresses = response
            })
          this.formaPagoUsusarioService.getUserPaymentMethodByUserId(this.user.id)
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
    this.selectedAddress = this.addresses.find((address: Direccion) => {
      return address.id == this.roundedAddressId
    }) as Direccion;
  }
  selectUserPaymentMethod() {
    this.selectedUserPaymentMethod = this.userPaymentMethods.find((userPaymentMethod: FormaPagoUsuario) => {
      return userPaymentMethod.id == this.roundedUserPaymentMethodId
    }) as FormaPagoUsuario;
  }

  //ng-bootstrap
  openVerticallyCentered(content: any) {
    this.ngbModal.open(content, { centered: true });
  }

  makePurchase() {
    let order: Pedido = {} as Pedido;
    let invoice: Factura = {} as Factura;

    this.pedidoService.addOrder(
      this.user,
      this.selectedAddress as Direccion,
      (this.selectedUserPaymentMethod as FormaPagoUsuario).formaPago
    )
      .subscribe(() => {
        this.pedidoService.getLastUserOrder(this.user)
          .subscribe((response: Pedido) => {
            order = response
            this.facturaService.addInvoice(this.user, this.selectedAddress as Direccion)
              .subscribe(() => {
                this.facturaService.getLastUserInvoice(this.user)
                  .subscribe((response: Factura) => {
                    invoice = response
                    for (const product of this.cart) {
                      this.lineaPedidoService.addOrderLine(
                        product.precio,
                        product.iva,
                        (product.quantity ? product.quantity : 1 ),
                        product,
                        order,
                        invoice
                      )
                        .subscribe((response: LineaPedido) => {
                        });
                    }

                    let observables: Observable<any>[] = [];

                    for (const unit of this.units) {
                      let observable = this.lineaFacturaService.addInvoiceLine(
                        unit.producto.precio,
                        unit.producto.iva,
                        unit.serie,
                        unit.producto,
                        invoice
                      );
                      observables.push(observable);

                      observable
                        .pipe(catchError(error => {
                          return error.message
                        }))
                        .subscribe((response: LineaFactura | string) => {
                          if (!(typeof response === 'string')) {
                            const chagedParameter: Ejemplar = {
                              estado: 'adquirido'
                            } as Ejemplar
                            this.ejemplarService.updateUnit(unit.id, chagedParameter)
                              .subscribe()
                          } else {
                            console.log(response)
                          }
                          console.log(response)
                        });
                    }
                    forkJoin(observables).pipe(
                      map(() => {
                        console.log('Todos los observables se completaron');
                        this.clearCart()
                        this.router.navigate(['correct-purchase'])
                      })
                    ).subscribe();
                  });
              });
          });
      });
  }

  private clearCart() {
    const cart: string = JSON.stringify([])
    this.usuarioService.updateUser(this.user.id, { cesta: cart } as Usuario)
      .subscribe(() => {
        console.log('carrito borrado');
      })
  }

  private initUnits() {
    for (const product of this.cart) {
      for (let index = 0; index < (product.quantity ? product.quantity : 1); index++) {
        this.ejemplarService.getUnitsByProductId(product.id)
          .subscribe((response: Ejemplar[]) => {
            for (const unit of response) {
              const existeEnCesta = this.units.some(item => item.id == unit.id);
              if (!existeEnCesta) {
                this.units.push(unit);
                return
              }
            }
          })
      }
    }
  }

}
