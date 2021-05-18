import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Matches } from '../matches';

@Injectable({
  providedIn: 'root'
})
export class MyLeagueService {

  url = "http://localhost:8080";

  constructor(private httpclient: HttpClient) { }

  getMatchesfromLeague() {
    return this.httpclient.get<Matches>(`${this.url}/getMatchesFromLeague/${}`);
  }


}
