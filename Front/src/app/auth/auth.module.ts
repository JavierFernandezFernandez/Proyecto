import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AuthRoutingModule } from './auth-routing.module';

import { DataComponent } from './data/data.component';
import { BucketListComponent } from './bucket-list/bucket-list.component';
import { OrdersComponent } from './orders/orders.component';
import { ReviewsComponent } from './reviews/reviews.component';
import { PaymentMethodsComponent } from './payment-methods/payment-methods.component';
import { CustomerServiceComponent } from './customer-service/customer-service.component';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { ReactiveFormsModule } from '@angular/forms';
import { SidebarComponent } from './layout/sidebar/sidebar.component';


@NgModule({
  declarations: [
    DataComponent,
    BucketListComponent,
    OrdersComponent,
    ReviewsComponent,
    PaymentMethodsComponent,
    CustomerServiceComponent,
    LoginComponent,
    RegistrationComponent,
    SidebarComponent
  ],
  imports: [
    CommonModule,
    AuthRoutingModule,
    ReactiveFormsModule
  ]
})
export class AuthModule { }
