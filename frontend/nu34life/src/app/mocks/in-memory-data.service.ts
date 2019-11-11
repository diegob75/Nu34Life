import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {Recipe} from '../model/recipe';
import {Meal} from '../model/meal';

const gaa = {
  id: null,
  name: 'asd',
  servings: 5,
  steps: [
    {
      id: null,
      instruction: 'asdga',
      stepNumber: 1
    },
    {
      id: null,
      instruction: 'asdga',
      stepNumber: 1
    },
    {
      id: null,
      instruction: 'asdga',
      stepNumber: 1
    }
  ],
  ingredients: [
    {
      id: null,
      food: {
        id: null,
        name: 'asdgf',
        nutrFact: {
          id: null,
          energeticValue: 3.2,
          totalFat: 3.2,
          saturatedFats: 3.2,
          carbohydrates: 3.2,
          sugars: 3.2,
          protein: 3.2,
          salt: 3.2
        }
      },
      quantity: 1,
      unit: 'adag',
      nutrFact: {
        id: null,
        energeticValue: 3.2,
        totalFat: 3.2,
        saturatedFats: 3.2,
        carbohydrates: 3.2,
        sugars: 3.2,
        protein: 3.2,
        salt: 3.2
      }
    },
    {
      id: null,
      food: {
        id: null,
        name: 'asdgf',
        nutrFact: {
          id: 1,
          energeticValue: 3.2,
          totalFat: 3.2,
          saturatedFats: 3.2,
          carbohydrates: 3.2,
          sugars: 3.2,
          protein: 3.2,
          salt: 3.2
        }
      },
      quantity: 1,
      unit: 'adag',
      nutrFact: {
        id: null,
        energeticValue: 3.2,
        totalFat: 3.2,
        saturatedFats: 3.2,
        carbohydrates: 3.2,
        sugars: 3.2,
        protein: 3.2,
        salt: 3.2
      }
    },
    {
      id: null,
      food: {
        id: null,
        name: 'asdgf',
        nutrFact: {
          id: 1,
          energeticValue: 3.2,
          totalFat: 3.2,
          saturatedFats: 3.2,
          carbohydrates: 3.2,
          sugars: 3.2,
          protein: 3.2,
          salt: 3.2
        }
      },
      quantity: 1,
      unit: 'adag',
      nutrFact: {
        id: null,
        energeticValue: 3.2,
        totalFat: 3.2,
        saturatedFats: 3.2,
        carbohydrates: 3.2,
        sugars: 3.2,
        protein: 3.2,
        salt: 3.2
      }
    }
  ],
  nutrFact: {
    id: null,
    energeticValue: 3.2,
    totalFat: 3.2,
    saturatedFats: 3.2,
    carbohydrates: 3.2,
    sugars: 3.2,
    protein: 3.2,
    salt: 3.2
  }
};

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  constructor() {
  }

  createDb() {
    // FOODS


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
