import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {Recipe} from '../model/recipe';
import {Meal} from '../model/meal';
import {Diet} from '../model/diet';
import {API_ROUTES, ApiRoutes} from './api-routes';
import {Patient} from '../model/patient';
import {Food} from '../model/food';
import {Page} from './page';
import swal from 'sweetalert2';
import {OauthService} from './oauth.service';
import {Router} from '@angular/router';
import {catchError, map} from 'rxjs/operators';

const ENDPOINTS: ApiRoutes = API_ROUTES;

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  private httpHeaders = new HttpHeaders({ 'Content-Type': 'application/json' });

  constructor(private http: HttpClient, private authService: OauthService, private router: Router) { }

  private addAuthorizationHeader() {
    let token = this.authService.token;
    if (token != null) {
      return this.httpHeaders.append('Authorization', 'Bearer ' + token);
    }
    return this.httpHeaders;
  }

  private unAthorized(e): boolean {
    if (e.status == 401) {
      if (this.authService.isAuthenticated) {
        this.authService.logout();
      }

      this.router.navigate(['/login']);
      return true;
    }

    if (e.status == 403) {

      this.router.navigate(['/products']);
      return true;
    }
    return false;
  }


  getAllMeals(): Observable<Meal[]> {
    return this.http.get<Meal[]>(ENDPOINTS.diets.GET_MEALS);
  }

  postDiet(diet: Diet): Observable<any> {
    return this.http.post(ENDPOINTS.diets.POST_DIET, diet, { headers: this.addAuthorizationHeader() })
      .pipe(
        map((response: any) => response.diet as Diet),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }


  getAllRecipes(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(ENDPOINTS.recipes.GET_RECIPES);
  }
  findRecipe(id: number): Observable<Recipe> {
    return this.http.get<Recipe>(ENDPOINTS.recipes.GET_RECIPES + '/' + id);
  }


  getAllPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(ENDPOINTS.patients.GET_PATIENTS);
  }

  getAffiliatedPatients(id: number): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${ENDPOINTS.patients.GET_PATIENTS}?nutritionistId=${id}`);
  }

  getFoods(query: string, sort: string, order: string, page: number, perPage: number, id: number): Observable<Page<Food>> {
    const params = new URLSearchParams();
    params.set('sort', sort);
    params.set('order', order);
    params.set('page', page.toString());
    console.log(params.toString());

    return this.http.get<Page<Food>>(ENDPOINTS.foods.PAGE_FOOD + '?' + params.toString());
  }

  postFood(food: Food) {
    return this.http.post(ENDPOINTS.foods.POST_FOOD, food, { headers: this.addAuthorizationHeader() })
      .pipe(
        map((response: any) => response.food as Food),
        catchError(e => {
          if (this.unAthorized(e)) {
            return throwError(e);
          }

          if (e.status == 400) {
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }
}
