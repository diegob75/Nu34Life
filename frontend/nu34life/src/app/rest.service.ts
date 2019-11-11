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

  getFood(id): Observable<any> {
    return this.http.get(endpoint + 'recipes/' + id).pipe(
      map(this.extractData));
  }

  getSteps(): Observable<any> {
    return this.http.get(endpoint + 'steps').pipe(
      map(this.extractData));
  }
  addFood (food): Observable<any> {
    console.log(food);
    return this.http.post<any>(endpoint + 'foods', JSON.stringify(food), httpOptions).pipe(
      tap((food) => console.log(`added food w/ id=${food.id}`)),
      catchError(this.handleError<any>('addFood'))
    );
  }

  addRecipe (recipe): Observable<any> {
    console.log(recipe);
    return this.http.post<any>(endpoint + 'recipes', JSON.stringify(recipe), httpOptions).pipe(
      tap((food) => console.log(`added recipe w/ id=${recipe.id}`)),
      catchError(this.handleError<any>('addRecipe'))
    );
  }


  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
  
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
  
      // TODO: better job of transforming error for user consumption
      console.log(`${operation} failed: ${error.message}`);
  
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

}



