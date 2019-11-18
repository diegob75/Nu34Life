import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FoodsComponent } from './foods/foods.component';
import { IngredientsComponent } from './ingredients/ingredients.component';
import { NutritionFactsComponent } from './nutritionfacts/nutritionfacts.component';
import { PlanRecipesComponent } from './plan-recipes/plan-recipes.component';
import { RecipesComponent } from './recipes/recipes.component';
import { StepsComponent } from './steps/steps.component';

import { DietsComponent} from './components/diets/diets.component';
import { DishComponent } from './components/dish/dish.component';
import { NavigationComponent } from './components/navigation/navigation.component';

import {HttpClientModule} from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import {DragDropModule} from '@angular/cdk/drag-drop';
import {FlexLayoutModule} from '@angular/flex-layout';

import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { InMemoryDataService } from './mocks/in-memory-data.service';

import {
  MatButtonModule,
  MatCardModule,
  MatCheckboxModule, MatDatepickerModule,
  MatFormFieldModule, MatIconModule, MatInputModule,
  MatListModule,
  MatMenuModule, MatNativeDateModule, MatPaginatorModule, MatSelectModule, MatSidenavModule, MatSortModule, MatTableModule,
  MatToolbarModule, NativeDateModule
} from '@angular/material';
import { FoodAddComponent } from './food-add/food-add.component';
import { RecipeAddComponent } from './recipe-add/recipe-add.component';
import { HomeComponent} from './components/home/home.component';
import { LocationStrategy, PathLocationStrategy } from '@angular/common';
import { AvatarModule } from 'ngx-avatar';
import { PatientsComponent } from './components/patients/patients.component';
import { AccountComponent } from './components/account/account.component';
import { PaymentComponent } from './components/payment/payment.component';
import { EditAccountComponent } from './components/account/edit-account/edit-account.component';
import { EditPaymentComponent } from './components/account/edit-payment/edit-payment.component';
import { CloseAccountComponent } from './components/account/close-account/close-account.component';
import { EditProfileComponent } from './components/account/edit-profile/edit-profile.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { RecipeDetailComponent } from './recipe-detail/recipe-detail.component';
import { RegisterComponent } from './components/auth/register/register.component';
import { Recipes2Component } from './components/recipes/recipes.component';
import { FactsComponent } from './components/facts/facts.component';
import {ModalComponent} from './components/dish/modal/modal.component';
import { AffiliateComponent } from './components/patients/affiliate/affiliate.component';
import { LoginFormComponent } from './components/auth/login/login-form/login-form.component';
import { MatRadioModule } from '@angular/material/radio';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    DietsComponent,
    ModalComponent,
    DishComponent,
    FoodsComponent,
    IngredientsComponent,
    NutritionFactsComponent,
    PlanRecipesComponent,
    RecipesComponent,
    StepsComponent,
    FoodAddComponent,
    RecipeAddComponent,
    HomeComponent,
    PatientsComponent,
    AccountComponent,
    PaymentComponent,
    EditAccountComponent,
    EditPaymentComponent,
    CloseAccountComponent,
    EditProfileComponent,
    NotFoundComponent,
    RecipeDetailComponent,
    RegisterComponent,
    FactsComponent,
    Recipes2Component,
    AffiliateComponent,
    LoginFormComponent
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
    FlexLayoutModule,
    AvatarModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, {apiBase: '/', dataEncapsulation: false}
    ),
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatRadioModule
  ],
  providers: [
      { provide: LocationStrategy, useClass: PathLocationStrategy }
    ],
  entryComponents: [
    AffiliateComponent,
    ModalComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
