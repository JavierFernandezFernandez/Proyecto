import { Usuario } from 'src/app/models/Usuario.model';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { LineaPedidoService } from '../../services/linea-pedido/linea-pedido.service';
import { PedidoService } from '../../services/pedido/pedido.service';
import { Component, OnInit } from '@angular/core';
import { Pedido } from 'src/app/models/Pedido.model';
import { LineaPedido } from 'src/app/models/LineaPedido.model';
import { Observable, finalize, forkJoin, map } from 'rxjs';
import { Producto } from 'src/app/models/Producto.model';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.scss']
})
export class OrdersComponent implements OnInit {
  user: Usuario = {} as Usuario;
  orders: Pedido[] = [];
  constructor(
    private usuarioService: UsuarioService,
    private pedidoService: PedidoService,
    private lineaPedidoService: LineaPedidoService,
    private productService:ProductService
  ) { }
  ngOnInit(): void {
    if (localStorage.getItem('email')) {
      this.usuarioService.getUserByEmail(localStorage.getItem('email') as string)
        .subscribe((response: Usuario) => {
          this.user = response
          this.pedidoService.getOrderByUserId(this.user.id)
            .pipe(finalize(() => {
              let arrObservables: Observable<any>[] = [];
              for (const order of this.orders) {
                const observ = this.lineaPedidoService.getOrederLineByOrederId(order.id);
                arrObservables.push(observ);
                observ
                  .subscribe((response: LineaPedido[]) => {
                    order.lineas = response
                  });
              }
              forkJoin(arrObservables)
              .pipe(map(()=>{
                this.orders = this.orders.reverse();
              }))
              .subscribe()
            }))
            .subscribe((response: Pedido[]) => {
              this.orders = response
            })
        })


    }
  }
  priceWithIva(product: Producto): number {
    return this.productService.getPriceWithIva(product)
  }


}
