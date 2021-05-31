import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../Services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-regstration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registerGroup = new FormGroup({
    username: new FormControl('', Validators.required),
    password: new FormControl('', Validators.required),
  })
  constructor(private authService: AuthService, private readonly router: Router) { }

  ngOnInit(): void {
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

}
