import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { ProductComponent } from './product/product.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { SearchedProductsComponent } from './searched-products/searched-products.component';

const routes: Routes = [
  {
    path: '',
    children: [
      {
        path: '',
        component: HomeComponent,
      },
      {
        path: 'shopping_cart',
        component: ShoppingCartComponent
      },
      {
        path: 'search/:therm',
        component: SearchedProductsComponent
      },
      {
        path: ':id',
        component: ProductComponent
      },

    ],
  },
];

@NgModule({
  declarations: [],
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class PageRoutingModule {}
