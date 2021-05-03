import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../auth.service';
import { Player } from '../logged-player';
import { PlayerService } from '../player.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginGroup = new FormGroup( {
    username: new FormControl(Validators.required),
    password: new FormControl(Validators.required)
  });

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
    private playerservice: PlayerService
    ) { }

    login(): void {
      if (this.loginGroup.valid) {
        const username = this.loginGroup.value.username;
        const password = this.loginGroup.value.password;
        this.authService.login(username, password)
          .subscribe(() => this.router.navigateByUrl('/clicker'));
      }
    }
 
  player: Player | undefined;
  ngOnInit(): void {
  }

}
