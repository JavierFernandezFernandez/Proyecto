import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LayoutService } from 'src/app/services/layout/layout.service';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;

  items: string[] = [
    'The first choice!',
    'And another choice for you.',
    'but wait! A third!'
  ];

  constructor(
    private layoutService: LayoutService,
    private router: Router,
    private productService:ProductService
  ) { }

  ngOnInit(): void {
    this.layoutService.isLoggedIn.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
  }
  closeSesion() {
    localStorage.clear();
    this.isLoggedIn = false;
    this.router.navigate(['/']);
    location.reload()
  }

  getAcutualRoute(): string {
    return this.router.url
  }

  search(therm: HTMLInputElement){
    this.router.navigate([`/search/${therm.value}`]);
  }
}
