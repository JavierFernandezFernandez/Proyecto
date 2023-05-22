import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { PageRoutingModule } from './page-routing.module';
import { ProductComponent } from './product/product.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { CarrouselMarcasComponent } from './carrousel-marcas/carrousel-marcas.component';



@NgModule({
  declarations: [
    HomeComponent,
    ProductComponent,
    ShoppingCartComponent,
    CarrouselMarcasComponent,
  ],
  imports: [
    CommonModule,
    PageRoutingModule,
  ]
})
export class PageModule { }
