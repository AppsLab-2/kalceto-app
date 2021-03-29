import { Component, OnInit } from '@angular/core';
import { Player } from '../logged-player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private playerservice: PlayerService) { }
 
  player: Player | undefined;
  ngOnInit(): void {
  }

}
