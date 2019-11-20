import { Component, OnInit } from '@angular/core';
import {Nutritionist} from '../../model/nutritionist';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.scss']
})
export class AccountComponent implements OnInit {

  nutritionist: Nutritionist;

  constructor() { }

  ngOnInit() {
  }

  get name() {
    return 'MockResources.nutritionist();';
  }
  get avatar() {
    return 'MockResources.avatar();';
  }
}
