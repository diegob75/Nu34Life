import { Component, OnInit } from '@angular/core';
import {AwsService} from '../../../service/aws.service';
import { OauthService } from 'src/app/service/oauth.service';
import { User } from 'src/app/model/user';
import { ApiService } from 'src/app/service/api.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {

  file: string;
  firstName: string;
  lastName: string;
  
  constructor(private awsService: AwsService, private authService: OauthService, private rest: ApiService) { }

  ngOnInit() {
    const u = this.authService.user;
    this.firstName = u.firstName;
    this.lastName = u.lastName;
  }
  fileEvent(input) {
    this.file = this.awsService.uploadFile(input.target.files);
    console.log(this.file);
  }

  updateProfile(){
    
  }
}
