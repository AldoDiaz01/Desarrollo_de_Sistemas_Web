import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Usuario } from 'src/app/models/user';
import { UserDataService } from 'src/app/services/user.data.service';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  email: string;
  password: string;
  displaySaveDialog: boolean;
  user: Usuario;

  constructor(private userService: UserDataService, private messageService: MessageService, private router: Router) { }

  ngOnInit(): void {
    this.displaySaveDialog = true;
    this.user = new Usuario();
  }

  signup() {
    this.userService.signup(this.user).subscribe(
      (result: any) => {
        this.messageService.add({ severity: 'success', summary: 'Resultado', detail: 'Se guardo el usuario correctamente' });
        this.displaySaveDialog = false;
        this.router.navigate(['/']);
      },
      error => {
        console.log(error);
      }
    )
  }

  login() {
    this.userService.login(this.email, this.password).subscribe(res => {
      if (res) {
        if (res.message.toString() === 'El usuario no existe') {
          this.messageService.add({ severity: 'error', summary: 'Advertencia', detail: 'El correo no existe' })
        } else if (res.message.toString() === 'Password incorrecta') {
          this.messageService.add({ severity: 'warn', summary: 'Advertencia', detail: 'Contraseña incorrecta' })
        } else {
          this.messageService.add({ severity: 'success', summary: 'Resultado', detail: 'Usuario accedio correctamente' })
          environment.token = res.message;
        }
      }
    });
  }

  navegarLogin() {
    this.router.navigate(['/']);
  }


}
