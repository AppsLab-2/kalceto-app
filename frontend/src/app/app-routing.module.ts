import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { GenerateLeaguesComponent } from './generate-leagues/generate-leagues.component';
import { LeaguesComponent } from './leagues/leagues.component';
import { MyLeagueComponent } from './my-league/my-league.component';

const routes: Routes = [
  { path: 'leagues', component: LeaguesComponent },
  { path: 'generate-leagues', component: GenerateLeaguesComponent  },
  { path: '', redirectTo: '/leagues', pathMatch:'full' },
  { path: 'my-league', component: MyLeagueComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
