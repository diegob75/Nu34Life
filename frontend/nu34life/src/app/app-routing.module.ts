import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {DietsComponent} from './components/diets/diets.component';
import {HomeComponent} from './components/home/home.component';
import {AccountComponent} from './components/account/account.component';
import {EditAccountComponent} from './components/account/edit-account/edit-account.component';
import {EditProfileComponent} from './components/account/edit-profile/edit-profile.component';
import {CloseAccountComponent} from './components/account/close-account/close-account.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {RegisterComponent} from './components/auth/register/register.component';
import {PatientsComponent} from './components/patient/patients/patients.component';
import {Recipes2Component} from './components/recipe/recipes/recipes.component';
import {LoginComponent} from './components/auth/login/login.component';
import {RecipeAddComponent} from './components/recipe/recipe-add/recipe-add.component';
import {FoodsComponent} from './components/food/foods/foods.component';
import {FoodCreateComponent} from './components/food/food-create/food-create.component';
import {PatientCreateComponent} from './components/patient/patient-create/patient-create.component';
import {NavigationComponent} from './components/navigation/navigation.component';
import {AuthGuard} from './guards/auth.guard';

const routes: Routes = [
  {
    path: '',
    component: NavigationComponent,
    canActivate: [AuthGuard],
    children: [
      {
        path: '',
        redirectTo: '/home',
        pathMatch: 'full'
      },
      {
        path: 'home',
        component: HomeComponent,
        data: { title: 'Home'}
      },
      {
        path: 'patients',
        component: PatientsComponent,
        data: {title: 'Pacientes'}
      },
      {
        path: 'patients/create',
        component: PatientCreateComponent,
        data: {title: 'Crear paciente'}
      },
      {
        path: 'diets',
        component: DietsComponent,
        data: {title: 'Crear dieta'},
      },
      {
        path: 'foods',
        component: FoodsComponent,
        data: {title: 'Foods List'}
      },
      {
        path: 'account',
        redirectTo: 'account/edit-account',
        pathMatch: 'full'
      },
      {
        path: 'account',
        component: AccountComponent,
        children: [
          {path: 'edit-account', component: EditAccountComponent, data: { title: 'Editar cuenta'}},
          {path: 'edit-profile', component: EditProfileComponent, data: { title: 'Editar Perfil'}},
          {path: 'close-account', component: CloseAccountComponent, data: { title: 'Cerrar cuenta'}}
        ]
      },
      {
        path: 'recipes',
        component: Recipes2Component,
        data: {title: 'Recipes List'}
      },
      {
        path: 'food-add',
        component: FoodCreateComponent,
        data: { title: 'Food Add' }
      },
      {
        path: 'recipe-add',
        component: RecipeAddComponent,
        data: {title: 'Recipe Add'}
      }
    ]
  },
  {
    path: 'auth',
    redirectTo: 'auth/login',
    pathMatch: 'full'
  },
  {
    path: 'auth',
    children: [
      {
        path: 'login',
        component: LoginComponent,
        data: { title: 'Iniciar sesión'}
      },
      {
        path: 'register',
        component: RegisterComponent,
        data: { title: 'Registrar'}
      }
    ]
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
