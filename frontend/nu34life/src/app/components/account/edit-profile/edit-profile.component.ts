import { Component, OnInit } from '@angular/core';
import {AwsService} from '../../../service/aws.service';
import { OauthService } from 'src/app/service/oauth.service';
import { User } from 'src/app/model/user';
import { ApiService } from 'src/app/service/api.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {

  file: string;
  firstName: string;
  lastName: string;
  
  constructor(private awsService: AwsService, private authService: OauthService, private rest: ApiService) { 
    const u = this.authService.user;
    this.firstName = u.firstName;
    this.lastName = u.lastName;
  }

  ngOnInit() {
    const u = this.authService.user;
    this.firstName = u.firstName;
    this.lastName = u.lastName;
  }
  fileEvent(input) {
    this.awsService.uploadFile(input.target.files).subscribe(res => {
      console.log(res);
      this.file = res.Location;
      console.log(this.file);
    }, err => {
      console.log(err);
    });
  }

  updateProfile(){
    const u = this.authService.user;
    u.firstName = this.firstName;
    u.lastName = this.lastName;
    this.rest.updateProfile(u).subscribe(res=>{
      console.log(res);
    },err=>{
      Swal.fire('Ha ocurrido un error','Ha habido un error en el servidor.');
    });
  }
}
