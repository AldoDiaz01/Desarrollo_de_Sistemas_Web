import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import { Presidente } from '../models/president';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class PresidenteDataService {

  httpOptions = {
    headers: new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('token'),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      Accept: 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  create(president: Presidente): Observable<Presidente> {
    return this.http.post<Presidente>(environment.url + '/presidentes', president, this.httpOptions).pipe(retry(1),
      catchError(this.handleError));
  }

  getAll() {
    return this.http.get(environment.url + '/presidentes', this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  get(id): Observable<Presidente> {
    return this.http.get<Presidente>(environment.url + '/presidentes/' + id, this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  delete(id) {
    return this.http.delete<Presidente>(environment.url + '/presidentes/' + id, this.httpOptions).pipe(retry(1),
      catchError(this.handleError));
  }

  update(president: Presidente): Observable<Presidente> {
    return this.http.put<Presidente>(environment.url + '/presidentes', president, this.httpOptions).pipe(retry(1),
      catchError(this.handleError));
  }

  handleError(error) {
    let errorMessage;

    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }

    console.log('Ha ocurrido un error');

    return throwError(errorMessage);
  }
}
