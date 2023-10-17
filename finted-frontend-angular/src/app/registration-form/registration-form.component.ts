import { Component, OnInit } from '@angular/core';
import { UserControllerService } from 'src/api/userController.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserRegistrationDto } from 'src/model/userRegistrationDto';
import { CredentialsRegistrationDto } from 'src/model/credentialsRegistrationDto';
import { AddressDto } from 'src/model/addressDto';
import { HttpErrorResponse, HttpStatusCode } from '@angular/common/http';
import { catchError, of } from 'rxjs';

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css'],
})
export class RegistrationFormComponent implements OnInit {
  registrationForm!: FormGroup;

  constructor(private userService: UserControllerService) {}

  ngOnInit(): void {
    this.registrationForm = new FormGroup({
      firstName: new FormControl('', Validators.required),
      lastName: new FormControl('', Validators.required),

      username: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [
        Validators.required,
        Validators.minLength(8),
      ]),

      route: new FormControl('', Validators.required),
      number: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
    });
  }

  handleError(error: HttpErrorResponse) {
    alert(`Errore: ${error.message}`);
    return of({ error: true, message: error.message });
  }

  onSubmit(): void {
    try {
      if (this.registrationForm.controls['password'].invalid) {
        throw new Error('La password deve avere almeno 8 caratteri');
      }

      let newUser: UserRegistrationDto = {
        firstName: this.registrationForm.get('firstName')?.value,
        lastName: this.registrationForm.get('lastName')?.value,

        credentials: {
          username: this.registrationForm.get('username')?.value,
          email: this.registrationForm.get('email')?.value,
          password: this.registrationForm.get('password')?.value,
        },
        address: {
          route: this.registrationForm.get('route')?.value,
          number: this.registrationForm.get('number')?.value,
          city: this.registrationForm.get('city')?.value,
        },
        id: NaN,
      };
      this.userService.save(newUser).pipe(catchError(this.handleError)).subscribe(
        (response) => {
          console.log(response)
          alert(
            `Utente ${
              this.registrationForm.get('username')?.value
            } registrato con successo!`
          );
        }
      );
    } catch (e: unknown) {
      if (e instanceof Error) {
        alert(e.message);
      }
    }
  }
}
