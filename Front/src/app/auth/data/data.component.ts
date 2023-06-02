import { Usuario } from 'src/app/models/Usuario.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario/usuario.service';
import { catchError } from 'rxjs';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { RespuestaLogin } from 'src/app/models/RespuestaLogin.model';

@Component({
  selector: 'app-data',
  templateUrl: './data.component.html',
  styleUrls: ['./data.component.scss']
})
export class DataComponent implements OnInit {
  editing: boolean = false;
  id: number = 0;
  email: string = '';
  name: string = '';
  phone: string = '';
  originalEmail: string = '';
  originalName: string = '';
  originalPhone: string = '';

  cursorNotAllowed: string = 'cursor-not-allowed';

  editCorrect: boolean = false;
  editPasswordCorrect: boolean = false;

  form: FormGroup = this.formBuilder.group({
    actualPassword: ['',
      Validators.required
    ],
    newPassword: ['', [
      Validators.required,
      Validators.minLength(8),
      Validators.maxLength(255)
    ]],
    confirmPassword: ['', [
      Validators.required,
    ]]
  });

  equalsPassword: boolean = true;
  passwordIncorrect: boolean = false;


  constructor(
    private usuarioService: UsuarioService,
    private formBuilder: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.editPasswordCorrect = false;
    this.usuarioService.getUserByEmail(localStorage.getItem('email') as string)
      .subscribe((response: Usuario) => {
        this.email = response.email as string;
        this.name = response.nombre as string;
        this.phone = response.telefono as string;
        this.id = response.id as number;
      })
  }

  get actualPassword(): FormControl {
    return this.form.get('actualPassword') as FormControl;
  }
  get newPassword(): FormControl {
    return this.form.get('newPassword') as FormControl;
  }
  get confirmPassword(): FormControl {
    return this.form.get('confirmPassword') as FormControl;
  }

  edit() {
    this.editing = true;
    this.cursorNotAllowed = ''
    this.originalEmail = this.email;
    this.originalName = this.name;
    this.originalPhone = this.phone;
  }

  saveEdit() {
    const user: Usuario = {
      email: this.email,
      nombre: this.name,
      telefono: this.phone
    } as Usuario;
    this.usuarioService.updateUser(this.id, user)
      .pipe(catchError((error) => {
        return error.message
      }))
      .subscribe((response: Usuario | string) => {
        if (typeof response !== 'string') {
          this.editing = false;
          this.cursorNotAllowed = 'cursor-not-allowed'
          this.email = response.email as string;
          this.name = response.nombre as string;
          this.phone = response.telefono as string;
          this.editCorrect = true
          this.ngOnInit()
        }
      })
  }

  cancelEdit() {
    this.editing = false;
    this.cursorNotAllowed = 'cursor-not-allowed'
    this.email = this.originalEmail;
    this.name = this.originalName;
    this.phone = this.originalPhone;
  }

  changePassword() {
    this.usuarioService.login(this.email, this.actualPassword.value)
      .pipe(catchError(error => {
        return error.message
      }))
      .subscribe(
        (response: RespuestaLogin | string) => {
          if (!(typeof response === 'string')) {
            this.passwordIncorrect = false;
            if (this.newPassword.value === this.confirmPassword.value) {
              const password: Usuario = { password: this.newPassword.value } as Usuario
              this.usuarioService.updateUser(this.id, password)
                .pipe(catchError(error => {
                  return error.message
                }))
                .subscribe((response: Usuario | string) => {
                  if (!(typeof response === 'string')) {
                    this.editPasswordCorrect = true
                  }else{
                    console.log(response)
                  }
                })
            }
          } else {
            this.passwordIncorrect = true;
            console.log('Contraseña incorrecta');
          }
        });
  }
}

