import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FoodsComponent} from './foods/foods.component';
import {IngredientsComponent} from './ingredients/ingredients.component';
import {NutritionFactsComponent} from './nutritionfacts/nutritionfacts.component';
import {PlanRecipesComponent} from './plan-recipes/plan-recipes.component';
import {RecipesComponent} from './recipes/recipes.component';
import {StepsComponent} from './steps/steps.component';


const routes: Routes = [
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
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
