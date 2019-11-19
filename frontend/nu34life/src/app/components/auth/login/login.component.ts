import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../../model/user';
import {OauthService} from '../../../shared/oauth.service';
import {Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  error: string | null;

  constructor(private authService: OauthService,
              private snackBar: MatSnackBar,
              private router: Router) {
  }

  ngOnInit() {
  }

  login(username: string, password: string): void {
    if (username.length === 0 || password.length === 0) {
      this.message('Complete usuario y contraseña', 'Ok');
      return;
    }
    let user = new User();
    user.username = username;
    user.password = password;

    this.authService.login(user).subscribe(response => {
        console.log(response);
        this.authService.saveUser(response.access_token);
        this.authService.saveToken(response.access_token);
        user = this.authService.user;
        this.router.navigate(['/home']);
        this.message('Has iniciado sesion con exito!', 'Ok');
      }, err => {
        if (err.status === 400) {
          console.log(err);
          this.message('Usuario o contraseña oncorrecta', 'Ok');
        }
      }
    );
  }

  message(message: string, action: string) {
    this.snackBar.open(message, action, {
      duration: 2000,
    });
  }

}
