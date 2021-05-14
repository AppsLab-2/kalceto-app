import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeaguesComponent } from './leagues/leagues.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { GenerateLeaguesComponent } from './generate-leagues/generate-leagues.component';

import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { MyLeagueComponent } from './my-league/my-league.component';
import { EditMatchComponent } from './edit-match/edit-match.component';
import { LoginComponent } from './login/login.component';
import { AuthInterceptor } from './interseptor/auth.interceptor';
import { RouterModule } from '@angular/router';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ScrollingModule } from '@angular/cdk/scrolling';
import { MatTableModule } from '@angular/material/table';

@NgModule({
  declarations: [
    AppComponent,
    LeaguesComponent,
    GenerateLeaguesComponent,
    MyLeagueComponent,
    EditMatchComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    RouterModule,
    BrowserAnimationsModule,
    ScrollingModule,
    MatTableModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      multi: true,
      useClass: AuthInterceptor
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
