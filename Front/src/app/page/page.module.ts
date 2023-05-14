import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { PageRoutingModule } from './page-routing.module';
import { ProductComponent } from './product/product.component';
import { ShoppingBasketComponent } from './shopping-basket/shopping-basket.component';
import { FormsModule } from '@angular/forms';
import { CarrouselMarcasComponent } from './carrousel-marcas/carrousel-marcas.component';



@NgModule({
  declarations: [
    HomeComponent,
    ProductComponent,
    ShoppingBasketComponent,
    CarrouselMarcasComponent,
  ],
  imports: [
    CommonModule,
    PageRoutingModule,
    
  ]
})
export class PageModule { }
