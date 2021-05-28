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
    if (this.authService.isLogged) this.showContent = 3;
    this.createForms();
  }

  changeContent(num: number){
    this.createForms();
    this.showContent = num;
    delete this.msg;
  }

  hasError(): string{
    if (this.registrationForm.get('password') != this.registrationForm.get('repeat')){
      return "Password don't match";
    }
    return this.registrationForm.get('password').errors == null ? null : "You must enter a value";
  }

  loginIsValid(): boolean{
    return this.loginForm.get('name').errors !=null || this.loginForm.get('password').errors !=null;
  }

  registerIsValid(): boolean{
    return this.loginForm.get('name').errors !=null || this.registrationForm.get('password').errors !=null || this.registrationForm.get('repeat').errors !=null;
  }

}
