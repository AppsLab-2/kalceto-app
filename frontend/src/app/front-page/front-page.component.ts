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
  showContent: number = 0;
  showFiller = false;

  loginGroup = new FormGroup( {
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required)
  });

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
 
  player: Player | undefined;
  ngOnInit(): void {
  }

  changeContent(num: number){
    this.createForms();
    this.showContent = num;
  }

}
