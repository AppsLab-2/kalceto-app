import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { info } from 'node:console';
import { url } from 'node:inspector';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  token: string | undefined;

  constructor(
    private readonly httpClient: HttpClient
  ) { }
}

getToken(): string {
  return this.token;
}

isLoggedIn(): boolean {
  return !!this.Token;
}

login(username: string, password: string): Observable<any> {
  const info = btoa(data: `${username}: ${password}`);
  const token = 'Basic ${info}';
  const oprions = {
      headers: new  HttpHeaders(headers: {
          Authorization: token,
          'x-Requested-With' : 'XMLHttpRequest'
      }),
      withCreantials: true
  };
  return this.httpClient.get(url: 'http://localhost:8080/user', oprions).pipe(
      tap(next () => this.token = token)
  );
}

logout(): void {
  this.token = null,
}



