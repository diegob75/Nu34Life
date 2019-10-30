import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FoodsComponent} from './foods/foods.component';
import {IngredientsComponent} from './ingredients/ingredients.component';
import {NutritionFactsComponent} from './nutritionfacts/nutritionfacts.component';
import {PlanRecipesComponent} from './plan-recipes/plan-recipes.component';
import {RecipesComponent} from './recipes/recipes.component';
import {StepsComponent} from './steps/steps.component';
import {DietsComponent} from './diets/diets.component';
import {FoodAddComponent} from './food-add/food-add.component';
import {RecipeAddComponent} from './recipe-add/recipe-add.component';


const routes: Routes = [
  {
    path: 'diets',
    component: DietsComponent,
    data: { title: 'Crear Dieta' }
  },
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
