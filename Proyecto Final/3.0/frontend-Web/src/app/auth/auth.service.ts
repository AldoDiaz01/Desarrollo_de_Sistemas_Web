import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {

  constructor() { }

  public isAuthenticated(): boolean{
    if(localStorage.getItem('token')){
      return true;
    } else {
      return false;
    }
  }
}
