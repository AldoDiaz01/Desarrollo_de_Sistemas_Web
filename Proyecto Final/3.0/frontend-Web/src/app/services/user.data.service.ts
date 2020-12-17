import { Injectable } from '@angular/core';
import {Observable, throwError} from 'rxjs';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {catchError, retry} from 'rxjs/operators';
import {Usuario} from '../models/user';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  httpOptionsJSON = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      Accept: 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  login(email, clave): Observable<any> {
    const body = new URLSearchParams();
    body.set('email', email);
    body.set('clave', clave);

    return this.http.post(environment.url + '/login',
      body.toString(),
      {
        headers: new HttpHeaders()
          .set('Content-Type', 'application/x-www-form-urlencoded')
      }
    );
  }

  signup(user: Usuario): Observable<Usuario> {
    return this.http.post<Usuario>(environment.url + '/sign-up', user, this.httpOptionsJSON).pipe(retry(1),
      catchError(this.handleError));
  }

  handleError(error) {
    let errorMessage;

    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }

    console.log(errorMessage);

    return throwError(errorMessage);
  }

}
