import { Usuario } from 'src/app/models/Usuario.model';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LayoutService } from 'src/app/services/layout/layout.service';
import { ProductService } from 'src/app/services/product/product.service';
import { NgbDropdown } from '@ng-bootstrap/ng-bootstrap';


@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;

  delay: boolean = false;

  name: string = '';

  items: string[] = [
    'The first choice!',
    'And another choice for you.',
    'but wait! A third!'
  ];

  constructor(
    private layoutService: LayoutService,
    private router: Router,
    private productService: ProductService,
    private usuarioService: UsuarioService,
  ) { }

  ngOnInit(): void {
    this.layoutService.isLoggedIn.subscribe((isLoggedIn) => {
      this.isLoggedIn = isLoggedIn;
    });
    this.getName()
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

  search(therm: HTMLInputElement) {
    therm.value.trim();
    if (therm.value != '') {
      this.router.navigate([`/search/${therm.value}`]);
    }
  }
  getName() {
    if (localStorage.getItem('email')) {
      this.usuarioService.getUserByEmail(localStorage.getItem('email') as string)
        .subscribe((response: Usuario) => {
          this.name = response.nombre as string;
        })
    }
  }
}
