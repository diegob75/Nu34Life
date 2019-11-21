import {Component, AfterViewInit, ViewChild} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Recipe} from '../../../model/recipe';
import {AwsService} from '../../../service/aws.service';
import {RecipeStep} from '../../../model/recipe-step';
import {Food} from '../../../model/food';
import {ApiService} from '../../../service/api.service';
import {MatPaginator} from '@angular/material';
import {catchError, delay, map, startWith, switchMap} from 'rxjs/operators';
import {FormControl} from '@angular/forms';
import {merge, of} from 'rxjs';
import {Page} from '../../../shared/page';
import {Ingredient} from '../../../model/ingredient';

@Component({
  selector: 'app-recipe-add',
  templateUrl: './recipe-add.component.html',
  styleUrls: ['./recipe-add.component.scss']
})
export class RecipeAddComponent implements AfterViewInit {

  recipe: Recipe = new Recipe();
  directions: string;
  file: string;
  foods: Food[] = [];
  isLoadingResults = true;
  connectionError = false;
  resultLength = 0;
  ingredients: Ingredient[] = [];
  search = new FormControl('');
  @ViewChild(MatPaginator, {static: false}) paginator: MatPaginator;

  constructor(public rest: ApiService,
              private route: ActivatedRoute,
              private router: Router,
              private awsService: AwsService) {
  }

  ngAfterViewInit() {
    merge(this.search.valueChanges.pipe(delay(1500)), this.paginator.page)
      .pipe(
        startWith({}),
        switchMap(() => {
          this.isLoadingResults = true;
          return this.rest.getFoods(this.search.value, null, null, this.paginator.pageIndex, this.paginator.pageSize, true);
        }),
        map((data: Page<Food>) => {

          this.isLoadingResults = false;
          this.connectionError = false;
          this.resultLength = data.totalElements;

          return data.content;
        }),
        catchError(() => {
          this.isLoadingResults = false;
          this.connectionError = true;
          return of([]);
        })
      ).subscribe((data: Food[]) => this.foods = data);
  }

  addIngredient(food) {
    if (this.ingredients.findIndex(x => x.food.id === food.id) !== -1)
      return;
    this.ingredients.push({ quantity: 0, food });
  }

  addRecipe() {
    this.recipe.image = this.file;
    this.recipe.steps = mapSteps(this.directions);

    this.recipe.ingredients = this.ingredients;

    console.log(JSON.stringify(this.recipe, null, 2));

    this.rest.postRecipe(this.recipe).subscribe((result) => {
      this.router.navigate(['/recipes']);
    }, (err) => {
      console.log(err);
    });
  }

  cancel() {
    this.router.navigate(['/recipes']);
  }

  fileEvent(input) {
    this.awsService.uploadFile(input.target.files).subscribe(res => {
      console.log(res);
      this.file = res.Location;
      console.log(this.file);
    }, err => {
      console.log(err);
    });
  }

  applyFilter(query: string) {

  }

}

const mapSteps = (text: string): RecipeStep[] => {
  const arr = text.split('\n\n');
  return arr.map((x, i) => ({instruction: x, id: { stepNumber: i + 1 }})) as RecipeStep[];
};


