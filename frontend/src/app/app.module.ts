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

import { RegistrationComponent } from './registration/registration.component';

import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatInputModule} from '@angular/material/input';
import { FrontPageComponent } from './front-page/front-page.component';
import { MatMenuModule} from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDialogModule } from '@angular/material/dialog';
import { MatButtonModule } from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    LeaguesComponent,
    GenerateLeaguesComponent,
    MyLeagueComponent,
    EditMatchComponent,
    LoginComponent,
    RegistrationComponent,
    FrontPageComponent,
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
    MatInputModule,
    MatMenuModule,
    MatIconModule,
    MatListModule,MatFormFieldModule,
    MatDialogModule,
    MatButtonModule,
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
