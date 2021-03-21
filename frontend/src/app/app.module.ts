import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LeaguesComponent } from './leagues/leagues.component';

import { FormsModule } from '@angular/forms';
import { GenerateLeaguesComponent } from './generate-leagues/generate-leagues.component';

import { HttpClientModule } from '@angular/common/http';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { MyLeagueComponent } from './my-league/my-league.component';
import { EditMatchComponent } from './edit-match/edit-match.component';

@NgModule({
  declarations: [
    AppComponent,
    LeaguesComponent,
    GenerateLeaguesComponent,
    MyLeagueComponent,
    EditMatchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
