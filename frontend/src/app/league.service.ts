import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { League } from './league';

@Injectable({
  providedIn: 'root'
})
export class LeagueService { 

  url = "https://localhost:8080";

  constructor(private httpClient: HttpClient) { }

  getLeagues() {
    return this.httpClient.get<League>(this.url + "/getAllLeagues");
  }

  addLeague(league: League) {
    return this.httpClient.post<League>(this.url + "/addLeague" , league)
  }

  deleteLeague(league: League) {
    return this.httpClient.delete<League>(`${this.url}/deleteLeague/${league.id}`)
    }


}
