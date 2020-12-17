import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';
import { environment } from 'src/environments/environment';
import { Router } from '@angular/router';
import { UserDataService } from 'src/app/services/user.data.service';
import { stringify } from '@angular/compiler/src/util';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  email: string;
  password: string;
  displaySaveDialog: boolean;

  constructor(private userService: UserDataService, private messageService: MessageService, private router: Router) { }

  ngOnInit(): void {
    this.displaySaveDialog = true;
  }

  login() {
    this.userService.login(this.email, this.password).subscribe(res => {
      if (res) {
        if (stringify(res.message) === 'Clave incorrecta') {
          this.messageService.add({ severity: 'warn', summary: 'Advertencia', detail: 'Contraseña incorrecta' })
        } else {
          this.messageService.add({ severity: 'success', summary: 'Resultado', detail: 'Usuario accedio correctamente' })
          this.router.navigate(['/presidents']);
          environment.token = stringify(res.key)
          localStorage.setItem('token', environment.token);
        }
      }
    });
  }

  navegarRegistro() {
    this.router.navigate(['/signup']);
  }

}
