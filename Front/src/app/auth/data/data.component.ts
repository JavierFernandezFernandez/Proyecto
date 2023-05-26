import { UsuarioService } from './../services/usuario.service';
import { Usuario } from './../../models/Usuario.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent implements OnInit {
  editing: boolean = false;
  email: string = '';
  nombre: string = '';
  telefono: string = '';

  constructor(private usuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.usuarioService.getUserByEmail(localStorage.getItem('email') as string)
    .subscribe((response:Usuario) => {
      this.email = response.email as string;
      this.nombre = response.nombre as string;
      this.telefono = response.telefono as string;
    })

  }
}

