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
import { User } from '../model/user';

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
    return this.http.get<Recipe>(ENDPOINTS.recipes.GET_RECIPE_BY_ID + '/' + id);
  }


  getAllPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(ENDPOINTS.patients.GET_PATIENTS,{ headers: this.addAuthorizationHeader() })
    .pipe(
      map((response: any) => response.patients as Patient[]),
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

  postPatient(patient: Patient) {
    return this.http.post(ENDPOINTS.patients.POST_PATIENT, patient)
      .pipe(
        map((response: any) => response.patient as Patient),
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
  putPatient(patient: Patient) {
    return this.http.put(ENDPOINTS.patients.POST_PATIENT, patient, { headers: this.addAuthorizationHeader() })
      .pipe(
        map((response: any) => response.patient as Patient),
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
  
  findPatient(id: number): Observable<Food> {
    return this.http.get<Food>(ENDPOINTS.patients.GET_PATIENT_BY_ID + '/' + id);
  }

  getAffiliatedPatients(id: number): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${ENDPOINTS.patients.GET_PATIENTS_AFFILIATED}/${id}`)
    .pipe(
      map((response: any) => response.patients as Patient[]),
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

  putFood(food: Food) {
    return this.http.put(ENDPOINTS.foods.PUT_FOOD, food, { headers: this.addAuthorizationHeader() })
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

  findFood(id: number): Observable<Food> {
    return this.http.get<Food>(ENDPOINTS.foods.GET_FOOD_BY_ID + '/' + id);
  }

  desactivateFood(id: number): Observable<Boolean>{
    return this.http.put(ENDPOINTS.foods.DEACTIVATE_FOOD + '/' + id,{headers: this.addAuthorizationHeader()})
      .pipe(
        map((response:any)=> response.recipe as Boolean),
        catchError(e=>{
          if(this.unAthorized(e) || e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
          
        })
      );
  }


  postRecipe(recipe: Recipe){
    return this.http.post(ENDPOINTS.recipes.POST_RECIPE,recipe,{headers: this.addAuthorizationHeader()})
      .pipe(
        map((response:any)=> response.recipe as Recipe),
        catchError(e=>{
          if(this.unAthorized(e) || e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
          
        })
      );
  }

  getRecipes(query: string, sort: string, order: string, page: number, perPage: number, id: number): Observable<Page<Recipe>> {
    const params = new URLSearchParams();
    params.set('sort', sort);
    params.set('order', order);
    params.set('page', page.toString());
    console.log(params.toString());

    return this.http.get<Page<Recipe>>(ENDPOINTS.recipes.PAGE_RECIPES + '?' + params.toString());
  }

  putRecipe(recipe: Recipe) {
    return this.http.put(ENDPOINTS.recipes.PUT_RECIPE, recipe, { headers: this.addAuthorizationHeader() })
      .pipe(
        map((response: any) => response.recipe as Recipe),
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

  desactivateRecipe(id: number): Observable<Boolean>{
    return this.http.put(ENDPOINTS.recipes.DEACTIVATE_RECIPE + '/' + id,{headers: this.addAuthorizationHeader()})
      .pipe(
        map((response:any)=> response.recipe as Boolean),
        catchError(e=>{
          if(this.unAthorized(e) || e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
          
        })
      );
  }

  registerNutritionist(user: User): Observable<User>{
    return this.http.post(ENDPOINTS.users.REGISTER_NUTRITIONIST,user)
      .pipe(
        map((response:any) => response.user as User),
        catchError(e=>{
          if( e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }

  registerPatient(user: User): Observable<User>{
    return this.http.post(ENDPOINTS.users.REGISTER_PATIENT,user)
      .pipe(
        map((response:any) => response.user as User),
        catchError(e=>{
          if( e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      );
  }

  requestAffiliation(idPatient:number,idNutritionist:number): Observable<Boolean>{
    const params = new URLSearchParams();
    params.set('nutritionistId', idNutritionist.toString());
    params.set('patientId', idPatient.toString());
    return this.http.post(ENDPOINTS.affiliations.AFFILIATION_REQUEST + '?' + params.toString(),null,{headers: this.addAuthorizationHeader()})
      .pipe(
        map((response:any)=>response as Boolean),
        catchError(e=>{
          if( e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      )
    ;
  }

  confirmAffiliation(idPatient:number,id:number): Observable<Boolean>{
    const params = new URLSearchParams();
    params.set('id', id.toString());
    params.set('patientId', idPatient.toString());
    return this.http.post(ENDPOINTS.affiliations.AFFILIATION_CONFIRM + '?' + params.toString(),null,{headers: this.addAuthorizationHeader()})
      .pipe(
        map((response:any)=>response as Boolean),
        catchError(e=>{
          if( e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      )
    ;
  }

  deactiveAffiliation(idPatient:number,idNutritionist:number): Observable<Boolean>{
    const params = new URLSearchParams();
    params.set('nutritionistId', idNutritionist.toString());
    params.set('patientId', idPatient.toString());
    return this.http.post(ENDPOINTS.affiliations.AFFILIATION_DEACTIVATE + '?' + params.toString(),null,{headers: this.addAuthorizationHeader()})
      .pipe(
        map((response:any)=>response as Boolean),
        catchError(e=>{
          if( e.status == 400){
            swal.fire('Usted no posee permisos para esta accion', 'error');
            return throwError(e);
          }

          console.error(e.error.mensaje);
          swal.fire(e.error.mensaje, e.error.error, 'error');
          return throwError(e);
        })
      )
    ;
  }



}
