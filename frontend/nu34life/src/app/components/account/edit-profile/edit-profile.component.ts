import { Component, OnInit } from '@angular/core';
import {AwsService} from '../../../service/aws.service';

@Component({
  selector: 'app-edit-profile',
  templateUrl: './edit-profile.component.html',
  styleUrls: ['./edit-profile.component.scss']
})
export class EditProfileComponent implements OnInit {

  file: string;
  firstName: string;
  lastName: string;

  constructor(private awsService: AwsService) { }

  ngOnInit() {
  }
  fileEvent(input) {
    this.file = this.awsService.uploadFile(input.target.files);
    console.log(this.file);
  }

  updateProfile(){

  }
}
