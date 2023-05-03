import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { PageRoutingModule } from './page-routing.module';
import { ProductComponent } from './product/product.component';
import { ShoppingBasketComponent } from './shopping-basket/shopping-basket.component';



@NgModule({
  declarations: [
    HomeComponent,
    ProductComponent,
    ShoppingBasketComponent
  ],
  imports: [
    CommonModule,
    PageRoutingModule
  ]
})
export class PageModule { }
