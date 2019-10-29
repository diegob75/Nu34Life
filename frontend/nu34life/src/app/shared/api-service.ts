import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Recipe} from '../model/recipe';
import {Meal} from '../model/meal';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  private BASE_URL = '';

  constructor(private http: HttpClient) { }

  getAllMeals(): Meal[] {
    const meals = new Array<Meal>();
    meals.push({id: 1, name: 'Breakfast'});
    meals.push({id: 2, name: 'Lunch'});
    meals.push({id: 3, name: 'Dinner'});
    return meals;
  }

  getAllRecipes(): Recipe[] {
    const recipes = new Array<Recipe>();
    recipes.push({ id: 1, name: 'test1' });
    recipes.push({ id: 2, name: 'test2' });
    recipes.push({ id: 3, name: 'test3' });
    recipes.push({ id: 4, name: 'test4' });
    recipes.push({ id: 5, name: 'test5' });
    recipes.push({ id: 6, name: 'test6' });
    recipes.push({ id: 7, name: 'test7' });
    recipes.push({ id: 8, name: 'test8' });
    recipes.push({ id: 9, name: 'test9' });
    recipes.push({ id: 10, name: 'test10' });
    recipes.push({ id: 11, name: 'test11' });
    recipes.push({ id: 12, name: 'test12' });
    return recipes;
  }

}
