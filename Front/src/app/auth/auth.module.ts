import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';

import { DataComponent } from './data/data.component';
import { BucketListComponent } from './bucket-list/bucket-list.component';
import { OrdersComponent } from './orders/orders.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { PaymentMethodsComponent } from './payment-methods/payment-methods.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';


@NgModule({
  declarations: [
    DataComponent,
    BucketListComponent,
    OrdersComponent,
    ReviewsComponent,
    PaymentMethodsComponent,
    CustomerServiceComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule
  ]
})
export class AuthModule { }
