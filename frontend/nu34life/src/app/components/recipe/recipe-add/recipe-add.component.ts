import { Component, OnInit, Input } from '@angular/core';
import { RestService } from '../../../rest.service';
import { ActivatedRoute, Router } from '@angular/router';
import {Recipe} from '../../../model/recipe';
import {AwsService} from '../../../service/aws.service';
import {RecipeStep} from '../../../model/recipe-step';
import {Ingredient} from '../../../model/ingredient';
import {Food} from '../../../model/food';

@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.scss']
})
export class RecipeAddComponent implements OnInit {

  recipe: Recipe;
  directions: string;
  file: string;
  foods: Food[] = [];

  constructor(public rest: RestService,
              private route: ActivatedRoute,
              private router: Router,
              private awsService: AwsService) { }

  ngOnInit() {
    this.recipe = new Recipe();
    this.loadFoods();
  }

  addIngredient(foods) {
    console.log(foods);
  }

  loadFoods() {
    this.rest.getFoods().subscribe(x => {
      this.foods = x;
    }, err => {
      console.log(err);
    });
  }

  addRecipe() {
    this.recipe.image = this.file;
    this.recipe.steps = mapSteps(this.directions);

    this.rest.addRecipe(this.recipe).subscribe((result) => {
      this.router.navigate(['/recipes']);
    }, (err) => {
      console.log(err);
    });
  }

  cancel() {
    this.router.navigate(['/recipes']);
  }

  fileEvent(input) {
    this.file = this.awsService.uploadFile(input.target.files);
    console.log(this.file);
  }
}

const mapSteps = (text: string): RecipeStep[] => {
  const arr = text.split('\n\n');
  return arr.map((x, i) => ({ instruction: x, stepNumber: i + 1 })) as RecipeStep[];
}


