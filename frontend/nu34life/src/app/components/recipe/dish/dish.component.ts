import {Component, Input, OnInit} from '@angular/core';
import {Recipe} from '../../../model/recipe';
import {ApiService} from '../../../service/api.service';

@Component({
  selector: 'app-dish',
  templateUrl: './dish.component.html',
  styleUrls: ['./dish.component.scss']
})
export class DishComponent implements OnInit {

  objectKeys = Object.keys;

  @Input() private recipe: Recipe;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    if (this.recipe.nutrFact == null || this.recipe.steps == null || this.recipe.ingredients == null) {
      this.apiService.findRecipe(this.recipe.id).subscribe(res => {
        this.recipe = res;
      }, err => {
        console.log(err);
      });
    }
  }

}
