import { LayoutService } from './../../layout/services/layout.service';
import { FormBuilder, FormControl, Validators } from '@angular/forms';
import { UsuarioService } from './../services/usuario.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { JsonPipe } from '@angular/common';
import { RespuestaLogin } from 'src/app/models/RespuestaLogin.model';
import { catchError } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form = this.formB.group({
    email: ['', [
      Validators.required,
      Validators.email,
      Validators.maxLength(45),
    ]],
    password: ['', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(255),
    ]],
  });
  get email(): FormControl {
    return this.form.get('email') as FormControl;
  }
  get password(): FormControl {
    return this.form.get('password') as FormControl;
  }
  constructor(
    private usuarioService: UsuarioService,
    private formB: FormBuilder,
    private router: Router,
    private layoutService: LayoutService
  ) { }
  ngOnInit(): void {
    if (localStorage.getItem('token')) {
      this.router.navigate(['/'])
    }
  }

  login(event: SubmitEvent) {
    if (this.form.valid) {
      this.usuarioService.login(this.email.value, this.password.value)
        .pipe(catchError(error => {
          return error.message

        }))
        .subscribe(
          (response: RespuestaLogin | string) => {
            if (!(typeof response === 'string')) {
              const token = response.body.Authorization;
              localStorage.setItem('token', token);
              localStorage.setItem('email', this.email.value);
              this.layoutService.setLoggedIn(true);
              this.router.navigate(['/']);
            } else {
              console.log('Email o contraseña incorrectos');
            }
          });
    } else {
      event.preventDefault()
    }
  }
}
