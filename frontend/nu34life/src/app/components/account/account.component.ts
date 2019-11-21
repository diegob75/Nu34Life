import { Component, OnInit } from '@angular/core';
import {Nutritionist} from '../../model/nutritionist';
import {OauthService} from '../../service/oauth.service';
import {User} from '../../model/user';
import {getResource} from '../../service/aws.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  user: User;

  constructor(private authService: OauthService) { }

  ngOnInit() {
    this.user = this.authService.user;
  }

  get name() {
    return this.user.firstName + ' ' + this.user.lastName;
  }
  get avatar() {
    return getResource(this.user.imagen)
  }
}
