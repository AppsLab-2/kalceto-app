import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Matches } from '../matches';
import { MyLeagueService } from '../Services/myleague.service';

@Component({
  selector: 'app-match-detail',
  templateUrl: './match-detail.component.html',
  styleUrls: ['./match-detail.component.css']
})
export class MatchDetailComponent implements OnInit {

  constructor(private myleagueservice: MyLeagueService) { }

  matches!: Observable<Matches>;
  
  ngOnInit(): void {
    this.matches = this.myleagueservice.getMatchesfromLeague();
  }

}
