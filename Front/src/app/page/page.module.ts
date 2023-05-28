import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home/home.component';
import { PageRoutingModule } from './page-routing.module';
import { ProductComponent } from './product/product.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { CarrouselMarcasComponent } from './carrousel-marcas/carrousel-marcas.component';
import { SearchedProductsComponent } from './searched-products/searched-products.component';
import { FormsModule } from '@angular/forms';



@NgModule({
  declarations: [
    HomeComponent,
    ProductComponent,
    ShoppingCartComponent,
    CarrouselMarcasComponent,
    SearchedProductsComponent,
  ],
  imports: [
    CommonModule,
    PageRoutingModule,
    FormsModule
  ],
  bootstrap:[
    HomeComponent,
    ProductComponent,
    ShoppingCartComponent,
    CarrouselMarcasComponent,
    SearchedProductsComponent,
  ]

})
export class PageModule { }
