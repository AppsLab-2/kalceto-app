import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GenerateLeaguesComponent } from './generate-leagues/generate-leagues.component';
import { AuthGuard } from './guard/auth.guard';
import { LeaguesComponent } from './leagues/leagues.component';
import { LoginComponent } from './login/login.component';
import { MyLeagueComponent } from './my-league/my-league.component';
import { RegistrationComponent } from './registration/registration.component';

const routes: Routes = [
  { path: 'leagues', component: LeaguesComponent, canActivate: [AuthGuard] },
  { path: 'generate-leagues', component: GenerateLeaguesComponent  },
  { path: 'login', component: LoginComponent },
  { path: '', redirectTo: '/login', pathMatch:'full' },
  { path: 'my-league/:id', component: MyLeagueComponent },
  { path: 'registration', component: RegistrationComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
