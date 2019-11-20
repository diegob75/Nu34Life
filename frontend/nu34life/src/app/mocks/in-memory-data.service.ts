import {InMemoryDbService} from 'angular-in-memory-web-api';
import {Injectable} from '@angular/core';
import {recipeDb} from './data/recipe-db';
import {mealDb} from './data/meal-db';
import {foodDB} from './data/food-db';
import {patientDb} from './data/patient-fb';


@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

  constructor() {
  }

  createDb() {
    return {
      meals: mealDb,
      recipes: recipeDb,
      foods: foodDB,
      patients: patientDb
    };
  }
}
