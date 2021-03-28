import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { League } from './league';

@Injectable({
  providedIn: 'root'
})
export class LeagueService {

  constructor(private httpClient: HttpClient) { }

  addLeague(league: League) {
    return this.httpClient.post<League>("https://localhost:8080/requestLeague", league)
  }

  deleteLeague(league: League) {
    return this.httpClient.post<League>("https://localhost:8080/requestLeague", league)
    }


}
