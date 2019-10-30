import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { FoodsComponent } from './foods/foods.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { NutritionFactsComponent } from './nutritionfacts/nutritionfacts.component';
import { PlanRecipesComponent } from './plan-recipes/plan-recipes.component';
import { RecipesComponent } from './recipes/recipes.component';
import { StepsComponent } from './steps/steps.component';

import { DietsComponent} from './diets/diets.component';
import { DishComponent } from './dish/dish.component';
import { NavigationComponent } from './navigation/navigation.component';

import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {DragDropModule} from '@angular/cdk/drag-drop';
import {FlexLayoutModule} from '@angular/flex-layout';

import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule, MatDatepickerModule,
  MatFormFieldModule, MatIconModule, MatInputModule,
  MatListModule,
  MatMenuModule, MatNativeDateModule, MatSelectModule, MatSidenavModule,
  MatToolbarModule, NativeDateModule
} from '@angular/material';
import { FoodAddComponent } from './food-add/food-add.component';
import { RecipeAddComponent } from './recipe-add/recipe-add.component';


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
    path: 'food-add',
    component: FoodAddComponent,
    data: { title: 'Food Add' }
  },
  {
    path: 'recipe-add',
    component: RecipeAddComponent,
    data: { title: 'Recipe Add' }
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
    NavigationComponent,
    DietsComponent,
    DishComponent,
    FoodsComponent,
    IngredientsComponent,
    NutritionFactsComponent,
    PlanRecipesComponent,
    RecipesComponent,
    StepsComponent,
    FoodAddComponent,
    RecipeAddComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DragDropModule,
    MatCardModule,
    MatButtonModule,
    MatToolbarModule,
    MatMenuModule,
    MatCheckboxModule,
    MatListModule,
    MatFormFieldModule,
    MatDatepickerModule,
    MatNativeDateModule,
    NativeDateModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatIconModule,
    MatSidenavModule,
    FlexLayoutModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
