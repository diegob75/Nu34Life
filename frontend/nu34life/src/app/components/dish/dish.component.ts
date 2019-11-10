import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from '../../model/recipe';
import {MockResources} from '../../mocks/mock-resources';

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.scss']
})
export class DishComponent implements OnInit {

  @Input() recipe: Recipe;

  constructor() {
  }

  ngOnInit() {
  }

  get image() {
    return MockResources.recipePicture();
  }

}
