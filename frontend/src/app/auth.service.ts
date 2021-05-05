import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  
  token: string | undefined;

  constructor(
    private readonly httpClient: HttpClient
  ) { }

getToken(): string | undefined {
  return this.token;
}

isLoggedIn(): boolean {
  return !!this.token;
}

login(username: string, password: string): Observable<any> {
  const info = btoa(`${username}:${password}`);
  const token = 'Basic ${info}';
  const options = {
      headers: new  HttpHeaders({
          Authorization: token,
          'X-Requested-With' : 'XMLHttpRequest'
      }),
      withCreantials: true
  };
  return this.httpClient.get('http://localhost:8080/login', options).pipe(
      tap(() => this.token = token)
  );
}

 logout(): void {
  this.token = null!;
 }

}
