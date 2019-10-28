import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';


import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HttpClientModule } from '@angular/common/http';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { FoodsComponent } from './foods/foods.component';
import { StepsComponent } from './steps/steps.component';
import { RecipesComponent } from './recipes/recipes.component';
import { NutritionfactsComponent } from './nutritionfacts/nutritionfacts.component';
import { PlanRecipesComponent } from './plan-recipes/plan-recipes.component';

const appRoutes: Routes = [
  {
    path: 'ingredients',
    component: IngredientsComponent,
    data: { title: 'Ingredient List' }
  },
  {
  path: 'foods',
  component: FoodsComponent,
  data: { title: 'Foods List' }
},
{
  path: 'steps',
  component: StepsComponent,
  data: { title: 'Step List' }
},
{
  path: 'recipes',
  component: RecipesComponent,
  data: { title: 'Recipe List' }
},
 {
    path: 'nutritionfacts',
    component: NutritionfactsComponent,
    data: { title: 'Nutritionfact List' }
  },
  {
    path: 'planrecipes',
    component: PlanRecipesComponent,
    data: { title: 'Plan List' }
  }



];

@NgModule({
  declarations: [
    AppComponent,
    IngredientsComponent,
    FoodsComponent,
    StepsComponent,
    RecipesComponent,
    NutritionfactsComponent,
    PlanRecipesComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
