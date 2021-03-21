import { Component, OnInit } from '@angular/core';
import { Match } from '../league';

@Component({
  selector: 'app-leagues',
  templateUrl: './leagues.component.html',
  styleUrls: ['./leagues.component.css']
})
export class LeaguesComponent implements OnInit {

  leagues: Match[] = [];
  selectedMatch?: Match;

  constructor() { }

  ngOnInit(): void {
    
  }

  onSelect(match: Match): void {
    this.selectedMatch = match;
  }

}
