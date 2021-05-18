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

import { RegstrationComponent } from './regstration/regstration.component';
import { OverlayModule } from '@angular/cdk/overlay';
import { CdkTreeModule } from '@angular/cdk/tree';
import { PortalModule } from '@angular/cdk/portal';

import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatChipsModule } from '@angular/material/chips';
import { MatDividerModule } from '@angular/material/divider';
import { MatExpansionModule } from '@angular/material/expansion';

const materialModules = [
  CdkTreeModule,
  OverlayModule,
  PortalModule,
  MatAutocompleteModule,
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule,
  MatChipsModule,
  MatDividerModule,
  MatExpansionModule,

];

@NgModule({
  declarations: [
    AppComponent,
    LeaguesComponent,
    GenerateLeaguesComponent,
    MyLeagueComponent,
    EditMatchComponent,
    LoginComponent,
    RegstrationComponent,
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
    MatPaginatorModule,
    MatSortModule,
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
