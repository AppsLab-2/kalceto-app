import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService} from '../Services/auth.service'
import { Router } from '@angular/router';
import { PlayerService } from '../Services/player.service';
import { Player } from '../player';

@Component({
  selector: 'app-front-page',
  templateUrl: './front-page.component.html',
  styleUrls: ['./front-page.component.css']
})
export class FrontPageComponent implements OnInit {
  public loginForm: any;
  public registrationForm: any;
  msg: String | undefined;
  showContent: number = 0;
  showFiller = false;

  loginGroup = new FormGroup( {
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

  registerGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  })

  constructor(
    private readonly authService: AuthService,
    private readonly router: Router,
    private playerservice: PlayerService
    ) { }

    private createForms(){
      this.loginForm = new FormGroup({
        'name': new FormControl(),
        'password': new FormControl()
      });
      this.registrationForm = new FormGroup({
        'name': new FormControl(),
        'password': new FormControl(),
        'second password': new FormControl()
      });
    }

    login(): void {
      if (this.loginGroup.valid) {
        const username = this.loginGroup.value.username;
        const password = this.loginGroup.value.password;
        this.authService.login(username, password)
          .subscribe(() => this.router.navigateByUrl('/leagues'));
      }
    }

    loginSuccess(res: Player){
      this.authService.player = res;
      this.authService.isLogged = true;
      this.showContent = 3;
    }

    register(): void {
      if (this.registerGroup.valid) {
        const username = this.registerGroup.value.username;
        const password = this.registerGroup.value.username;
        this.authService.register(username, password)
          .subscribe(() => {
            this.authService.login(username, password)
              .subscribe(() => this.router.navigateByUrl('/front-page'));
          });
      }
    }
 
  player: Player | undefined;
  ngOnInit(): void {
  }
}