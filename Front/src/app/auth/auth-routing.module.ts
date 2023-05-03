import { NgModule, Component } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DataComponent } from './data/data.component';
import { BucketListComponent } from './bucket-list/bucket-list.component';
import { OrdersComponent } from './orders/orders.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { PaymentMethodsComponent } from './payment-methods/payment-methods.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';

// configuration/informacion
// lista de deseos
// pedidos
// opiniones
// formas de pago
// atencion al clientes
const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: 'data-user',
        component: DataComponent
      },
      {
        path: 'bucket-list',
        component: BucketListComponent
      },
      {
        path:'orders',
        component: OrdersComponent
      },
      {
        path:'reviews',
        component: ReviewsComponent
      },
      {
        path: 'payment-method',
        component: PaymentMethodsComponent
      },
      {
        path: 'customer-service',
        component: CustomerServiceComponent
      },
      {
        path: '**',
        redirectTo: 'data-user'
      }
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {}
