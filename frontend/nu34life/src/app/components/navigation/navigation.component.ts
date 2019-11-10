import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, NavigationEnd, Router} from '@angular/router';
import {MockResources} from '../../mocks/mock-resources';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent implements OnInit {

  opened: boolean;

  constructor(private router: Router) {
    router.events.subscribe(e => {
      if (e instanceof NavigationEnd) {
        this.opened = false;
      }
    });
  }

  ngOnInit() {

  }
  get name() {
    return MockResources.nutritionist();
  }
  get avatar() {
    return MockResources.avatar();
  }
}
