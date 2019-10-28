import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';


import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodsComponent } from './foods/foods.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { NutritionFactsComponent } from './nutritionfacts/nutritionfacts.component';
import { PlanRecipesComponent } from './plan-recipes/plan-recipes.component';
import { RecipesComponent } from './recipes/recipes.component';
import { StepsComponent } from './steps/steps.component';
import {HttpClientModule} from '@angular/common/http';

const appRoutes: Routes = [
  {
    path: 'foods',
    component: FoodsComponent,
    data: { title: 'Foods List' }
  },
  {
    path: 'ingredients',
    component: IngredientsComponent,
    data: { title: 'Ingredients List' }
  },
  {
    path: 'ingredients',
    component: NutritionFactsComponent,
    data: { title: 'NutritionFact List' }
  },
  {
    path: 'planrecipes',
    component: PlanRecipesComponent,
    data: { title: 'PlanRecipe List' }
  },
  {
    path: 'recipes',
    component: RecipesComponent,
    data: { title: 'Recipes List' }
  },
  {
    path: 'steps',
    component: StepsComponent,
    data: { title: 'Steps List' }
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FoodsComponent,
    IngredientsComponent,
    NutritionFactsComponent,
    PlanRecipesComponent,
    RecipesComponent,
    StepsComponent
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
