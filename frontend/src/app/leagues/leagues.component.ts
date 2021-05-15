import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { League } from '../league';
import { LeagueService } from '../Services/league.service';

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {

  constructor(private leaguesService: LeagueService) { }
  
  leagues?: Observable<League[]>;

  ngOnInit(): void {
    this.leagues = this.leaguesService.getLeagues();
  }
}
