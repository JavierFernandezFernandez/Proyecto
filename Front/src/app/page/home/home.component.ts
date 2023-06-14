import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { Producto } from 'src/app/models/Producto';
import { Router, RouterLink } from '@angular/router';
import { delay } from 'rxjs/operators';
import { Observable, of } from 'rxjs';
import { ProductoService } from 'src/app/services/producto/producto.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  ranodmProducts: Producto[] = [];
  imageNames: string[] = [];

  constructor( private router: Router, private productoService: ProductoService) { }

  ngOnInit(): void {
    this.productoService.get4RandomProducts()
      .subscribe(response => {
        this.ranodmProducts = response
        // console.log(this.ranodmProducts);
      });
  }

  goToProduct(id: number) {
    this.router.navigate([id]);
  }

}
