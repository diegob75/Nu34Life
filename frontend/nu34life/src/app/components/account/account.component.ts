import { Component, OnInit } from '@angular/core';
import {MockResources} from '../../mocks/mock-resources';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  get name() {
    return MockResources.nutritionist();
  }
  get avatar() {
    return MockResources.avatar();
  }
}
