import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Recipe} from '../model/recipe';
import {Meal} from '../model/meal';
import {Diet} from '../model/diet';
import {API_ROUTES, ApiRoutes} from './api-routes';
import {MOCK_ROUTES} from '../mocks/mock-routes';

const ENDPOINTS: ApiRoutes = MOCK_ROUTES;

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private http: HttpClient) { }

  viewRoutes() {
    console.log(ENDPOINTS);
  }

  getAllMeals(): Observable<Meal[]> {
    alert(ENDPOINTS.diets.GET_MEALS);
    return this.http.get<Meal[]>(ENDPOINTS.diets.GET_MEALS);
  }

  getAllRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(ENDPOINTS.recipes.GET_RECIPES);
  }

  postDiet(diet: Diet): Observable<any> {
    return this.http.post(ENDPOINTS.diets.POST_DIET, diet);
  }
}
