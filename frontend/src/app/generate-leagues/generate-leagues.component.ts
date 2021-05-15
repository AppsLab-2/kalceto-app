import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { League } from '../league';
import { LeagueService } from '../Services/league.service';


@Component({
  selector: 'app-generate-leagues',
  templateUrl: './generate-leagues.component.html',
  styleUrls: ['./generate-leagues.component.css']
})
export class GenerateLeaguesComponent implements OnInit {

  leagueForm = new FormGroup({
    leagueName: new FormControl("", Validators.required)
  });

  get submit(): boolean {
    return this.leagueForm.valid;
  }

  constructor(private leaguesService: LeagueService) { }

  ngOnInit(): void {}

  add(): void {
    const league = {
      leagueName: this.leagueForm.controls.leagueName.value
    }
    this.leaguesService.addLeague(league as League).subscribe();
  }
}