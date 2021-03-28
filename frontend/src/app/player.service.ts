import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from './player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  constructor(private httpClient: HttpClient) { }

  addPlayer(player: Player) {
    return this.httpClient.post<Player>("https://localhost:8080/requestPlayer", player)
  }

  deletePlayer(player: Player) {
    return this.httpClient.post<Player>("https://localhost:8080/requestPlayer", player)
  }

  
}
