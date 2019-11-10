import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Recipe} from '../model/recipe';
import {Meal} from '../model/meal';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  constructor() {
  }

  createDb() {
    // RECIPES
    const recipes = new Array<Recipe>();
    recipes.push({id: 1, name: 'test1', servings: 1});
    recipes.push({id: 2, name: 'test2', servings: 1});
    recipes.push({id: 3, name: 'test3', servings: 1});
    recipes.push({id: 4, name: 'test4', servings: 1});
    recipes.push({id: 5, name: 'test5', servings: 1});
    recipes.push({id: 6, name: 'test6', servings: 1});
    recipes.push({id: 7, name: 'test7', servings: 1});
    recipes.push({id: 8, name: 'test8', servings: 1});
    recipes.push({id: 9, name: 'test9', servings: 1});
    recipes.push({id: 10, name: 'test10', servings: 1});
    recipes.push({id: 11, name: 'test11', servings: 1});
    recipes.push({id: 12, name: 'test12', servings: 1});
    // MEALS
    const meals = new Array<Meal>();
    meals.push({id: 1, name: 'Breakfast'});
    meals.push({id: 2, name: 'Lunch'});
    meals.push({id: 3, name: 'Dinner'});
    // --END--
    return {meals, recipes};
  }
}
