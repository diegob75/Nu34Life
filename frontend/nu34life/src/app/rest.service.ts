import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { map, catchError, tap } from 'rxjs/operators';

const endpoint = 'http://localhost:8080/';
const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})

export class RestService {

  constructor(private http: HttpClient) { }
  private extractData(res: Response) {
    let body = res;
    return body || { };
  }

  getFoods(): Observable<any> {
    return this.http.get(endpoint + 'foods').pipe(
      map(this.extractData));
  }

  getIngredients(): Observable<any> {
    return this.http.get(endpoint + 'ingredients').pipe(
      map(this.extractData));
  }

  getNutritionFacts(): Observable<any> {
    return this.http.get(endpoint + 'nutritionfacts').pipe(
      map(this.extractData));
  }

  getPlanRecipes(): Observable<any> {
    return this.http.get(endpoint + 'planrecipes').pipe(
      map(this.extractData));
  }

  getRecipes(): Observable<any> {
    return this.http.get(endpoint + 'recipes').pipe(
      map(this.extractData));
  }

  getSteps(): Observable<any> {
    return this.http.get(endpoint + 'steps').pipe(
      map(this.extractData));
  }


}



