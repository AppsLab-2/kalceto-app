import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from './player';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  url = "https://localhost:8080"

  constructor(private httpClient: HttpClient) { }

  getPlayer() {
    return this.httpClient.get<Player>(this.url + "/getAllPlayers");
  }

  addPlayer(player: Player) {
    return this.httpClient.post<Player>(this.url + "/addplayer", player)
  }

  deletePlayer(player: Player) {
    return this.httpClient.delete<Player>(`${this.url}/deleteplayer/${player.id}`)
  }

  
}
