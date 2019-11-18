import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from '../../../model/recipe';

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.scss']
})
export class DishComponent implements OnInit {

  @Input() private recipe: Recipe;

  constructor() { }

  ngOnInit() {
  }

}
