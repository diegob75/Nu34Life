import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Recipe} from '../model/recipe';
import {Meal} from '../model/meal';
import {Diet} from '../model/diet';
import {API_ROUTES, ApiRoutes} from './api-routes';
import {MOCK_ROUTES} from '../mocks/mock-routes';
import {Patient} from '../model/patient';

const ENDPOINTS: ApiRoutes = API_ROUTES;

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  constructor(private http: HttpClient) { }

  getAllMeals(): Observable<Meal[]> {
    return this.http.get<Meal[]>(ENDPOINTS.diets.GET_MEALS);
  }

  getAllRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(ENDPOINTS.recipes.GET_RECIPES);
  }

  findRecipe(id: number): Observable<Recipe> {
    return this.http.get<Recipe>(ENDPOINTS.recipes.GET_RECIPES + '/' + id);
  }

  postDiet(diet: Diet): Observable<any> {

    return this.http.post(ENDPOINTS.diets.POST_DIET, diet);
  }

  getAllPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(ENDPOINTS.patients.GET_PATIENTS);
  }

  getAffiliatedPatients(id: number): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${ENDPOINTS.patients.GET_PATIENTS}?nutritionistId=${id}`);
  }
}
