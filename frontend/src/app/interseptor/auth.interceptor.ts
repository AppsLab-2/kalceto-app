import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpHeaders,
  HttpErrorResponse
} from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService } from '../auth.service';
import { catchError } from 'rxjs/operators';
import { Router } from '@angular/router';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
  ) {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(this.authService.isLoggedIn()) {
      request = request.clone(update: {
        headers: new HttpHeaders(headers {
          Authorization: this.authService.getToken()
        })
      });
    }

    return next.handle(request).pipe(
      catchError(selector:(err: HttpErrorResponse) => {
        if (this.authService.isLoggedIn() && err.status === 401 ) {
          this.authService.logout();
          this.router.navigateByUrl(url: '/');
        }
        throw err;
      })
    );
  }

}
