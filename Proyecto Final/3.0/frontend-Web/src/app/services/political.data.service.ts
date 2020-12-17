import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, retry} from 'rxjs/operators';
import { environment } from 'src/environments/environment';
import { Partido } from '../models/political';

@Injectable({
  providedIn: 'root'
})
export class PoliticalDataService {
  httpOptions = {
    headers: new HttpHeaders({
      Authorization: 'Bearer ' + localStorage.getItem('token'),
      'Content-Type': 'application/json',
      'Access-Control-Allow-Origin': '*',
      Accept: 'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  create(political: Partido): Observable<Partido> {
    return this.http.post<Partido>(environment.url + '/partidos', political, this.httpOptions).pipe(retry(1),
      catchError(this.handleError));
  }

  getAll() {
    return this.http.get(environment.url + '/partidos', this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  get(id): Observable<Partido> {
    return this.http.get<Partido>(environment.url + '/partidos/' + id, this.httpOptions).pipe(retry(1), catchError(this.handleError));
  }

  delete(id) {
    return this.http.delete<Partido>(environment.url + '/partidos/' + id, this.httpOptions).pipe(retry(1),
      catchError(this.handleError));
  }

  update(political: Partido): Observable<Partido> {
    return this.http.put<Partido>(environment.url + '/partidos', political, this.httpOptions).pipe(retry(1),
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
