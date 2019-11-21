import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {OauthService} from '../../service/oauth.service';
import {User} from '../../model/user';
import {getResource} from '../../service/aws.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  opened: boolean;

  private user: User;

  constructor(private router: Router, private authService: OauthService) {
    router.events.subscribe(e => {
      if (e instanceof NavigationEnd) {
        this.opened = false;
      }
    });
  }

  ngOnInit() {
    this.user = this.authService.user;
  }


  logout() {
    this.authService.logout();
  }

  get name() {
    return this.user.firstName + ' ' + this.user.lastName;
  }
  get avatar() {
    return getResource(this.user.imagen)
  }
}
