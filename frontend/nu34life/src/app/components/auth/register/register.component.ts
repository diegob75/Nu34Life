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

    this.apiService.registerNutritionist(user)
      .subscribe(
        product => {
          this.router.navigate(['/products']);
          swal.fire('Nuevo Producto', `El product ${product.name} ha sido creado con éxito`, 'success');
        },
        err => {
          this.errors = err.error.errors as string[];
          console.error('Código del error desde el backend: ' + err.status);
          console.error(err.error.errors);
        }
      );
  }
}
