import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from './../services/auth.service';
import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
})
export class RegistrationComponent {
  form = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(4), Validators.maxLength(45)]),
    phone: new FormControl('',[Validators.required, Validators.minLength(9), Validators.maxLength(9)]),
    email: new FormControl('',[Validators.required,Validators.email, Validators.minLength(4), Validators.maxLength(45)]),
    password: new FormControl('',[Validators.required,Validators.email, Validators.minLength(8), Validators.maxLength(45)]),
    confirmPassword: new FormControl('',[Validators.required,Validators.email, Validators.minLength(8), Validators.maxLength(45)]),
  });

  constructor(private authService: AuthService, private router: Router) {}

  get name(): FormControl {
    return this.form.get('name') as FormControl;
  }
  get phone(): FormControl {
    return this.form.get('phone') as FormControl;
  }
  get email(): FormControl {
    return this.form.get('email') as FormControl;
  }
  get password(): FormControl {
    return this.form.get('password') as FormControl;
  }
  get confirmPassword(): FormControl {
    return this.form.get('confirmPassword') as FormControl;
  }

  register(
    event: SubmitEvent
  ) {
    if (this.password.value === this.confirmPassword.value) {
      // console.log(
      //   `${name.value}\n${phone.value}\n${email.value}\n${password.value}\n${confirmPassword.value}`
      // );

      this.authService
        .saveUser(this.name.value, this.phone.value, this.email.value, this.password.value, 6)
        .subscribe((response) => {
          console.log(response);
        });
      this.router.navigate(['/']);
    } else {
      console.log('contaseñas no coinciden');
      event.preventDefault();
    }
  }
}
