import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {FoodsComponent} from './foods/foods.component';
import {IngredientsComponent} from './ingredients/ingredients.component';
import {NutritionFactsComponent} from './nutritionfacts/nutritionfacts.component';
import {PlanRecipesComponent} from './plan-recipes/plan-recipes.component';
import {RecipesComponent} from './recipes/recipes.component';
import {StepsComponent} from './steps/steps.component';
import {DietsComponent} from './components/diets/diets.component';
import {FoodAddComponent} from './food-add/food-add.component';
import {RecipeAddComponent} from './recipe-add/recipe-add.component';
import {HomeComponent} from './components/home/home.component';
import {PatientsComponent} from './components/patients/patients.component';
import {DishComponent} from './components/dish/dish.component';
import {AccountComponent} from './components/account/account.component';
import {EditAccountComponent} from './components/account/edit-account/edit-account.component';
import {EditProfileComponent} from './components/account/edit-profile/edit-profile.component';
import {CloseAccountComponent} from './components/account/close-account/close-account.component';
import {EditPaymentComponent} from './components/account/edit-payment/edit-payment.component';
import {NotFoundComponent} from './components/account/not-found/not-found.component';


const routes: Routes = [
  {
    path: 'home',
    component: HomeComponent,
    data: {title: 'Dashboard'}
  },
  {
    path: '',
    pathMatch: 'full',
    redirectTo: '/home'
  },
  {
    path: 'patients',
    component: PatientsComponent,
    data: {title: 'Mis pacientes'}
  },
  {
    path: 'diets',
    component: DietsComponent,
    data: {title: 'Crear dieta'}
  },
  {
    path: 'dishes',
    component: DishComponent,
    data: {title: 'Recetas'}
  },
  {
    path: 'foods',
    component: FoodsComponent,
    data: {title: 'Foods List'}
  },
  {
    path: 'account',
    component: AccountComponent,
    children: [
      {path: 'edit-account', component: EditAccountComponent},
      {path: 'edit-profile', component: EditProfileComponent},
      {path: 'edit-payment', component: EditPaymentComponent},
      {path: 'close-account', component: CloseAccountComponent}
    ]
  },
  {
    path: 'ingredients',
    component: IngredientsComponent,
    data: {title: 'Ingredients List'}
  },
  {
    path: 'ingredients',
    component: NutritionFactsComponent,
    data: {title: 'NutritionFact List'}
  },
  {
    path: 'planrecipes',
    component: PlanRecipesComponent,
    data: {title: 'PlanRecipe List'}
  },
  {
    path: 'recipes',
    component: RecipesComponent,
    data: {title: 'Recipes List'}
  },
  {
    path: 'food-add',
    component: FoodAddComponent,
    data: {title: 'Food Add'}
  },
  {
    path: 'recipe-add',
    component: RecipeAddComponent,
    data: {title: 'Recipe Add'}
  },
  {
    path: 'steps',
    component: StepsComponent,
    data: {title: 'Steps List'}
  },
  {
    path: '**',
    component: NotFoundComponent,
    data: {title: 'Error'}
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
