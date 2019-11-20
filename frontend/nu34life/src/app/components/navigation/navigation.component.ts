import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {OauthService} from '../../service/oauth.service';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  opened: boolean;

  constructor(private router: Router, private authService: OauthService) {
    router.events.subscribe(e => {
      if (e instanceof NavigationEnd) {
        this.opened = false;
      }
    });
  }

  ngOnInit() {

  }
  get name() {
    return '';
  }
  get avatar() {
    return '';
  }

  logout() {
    this.authService.logout();
  }
}
