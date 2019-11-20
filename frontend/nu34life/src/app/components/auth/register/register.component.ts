import { Component, OnInit } from '@angular/core';
import {ApiService} from '../../../service/api.service';
import {User} from '../../../model/user';
import {Router} from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  errors: string[];

  constructor(private apiService: ApiService,
              private router: Router) { }

  ngOnInit() {
  }
  registro(username, password, name, lastName, email) {
    const user = new User();
    user.username = username;
    user.password = password;
    user.firstName = name;
    user.lastName = lastName;
    user.email = email;
    console.log(user);
    this.apiService.registerNutritionist(user)
      .subscribe(
        user => {
          this.router.navigate(['/login']);
        },
        err => {
          this.errors = err.error.errors as string[];
          console.error('Código del error desde el backend: ' + err.status);
          console.error(err.error.errors);
          this.router.navigate(['/auth/login']);
         
        }
      );
  }
}
