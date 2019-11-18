import { Component, OnInit } from '@angular/core';
import { User } from '../../../../model/user';
import { OauthService } from '../../../../shared/oauth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: []
})
export class LoginFormComponent implements OnInit {

  title = 'Iniciar Sesión';
  user: User;

  constructor(private authService: OauthService, private router: Router) {
    this.user = new User();
   }

  ngOnInit() {
    if (this.authService.isAuthenticated()) {
      alert('error encontrado')
    }
  }

  login(): void {
    console.log(this.user);
    if (this.user.username == null || this.user.password == null) {
      alert('aea');
      return;
    }

    this.authService.login(this.user).subscribe(response => {
      console.log(response);

      this.authService.saveUser(response.access_token);
      this.authService.saveToken(response.access_token);


      let user = this.authService.user;
      this.router.navigate(['/home']);

    }, err => {
      if (err.status == 400) {

      }
    }
    );


  }
}
