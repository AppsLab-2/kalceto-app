import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeaguesComponent } from './leagues/leagues.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { GenerateLeaguesComponent } from './generate-leagues/generate-leagues.component';

import { HttpClientModule } from '@angular/common/http';
import { MyLeagueComponent } from './my-league/my-league.component';
import { EditMatchComponent } from './edit-match/edit-match.component';
import { LoginComponent } from './login/login.component';

@NgModule({
  declarations: [
    AppComponent,
    LeaguesComponent,
    GenerateLeaguesComponent,
    MyLeagueComponent,
    EditMatchComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
