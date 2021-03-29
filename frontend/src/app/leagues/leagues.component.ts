import { Component, OnInit } from '@angular/core';
import { League } from '../league';
import { LeagueService } from '../league.service';

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {


  constructor(private leaguesService: LeagueService) { }
  
  leagues:League | undefined;
  ngOnInit(): void {
    
  }
}
