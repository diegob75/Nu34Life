import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {AppRoutingModule} from './app-routing.module';

import {AppComponent} from './app.component';

import {DietsComponent} from './components/diets/diets.component';
import {NavigationComponent} from './components/navigation/navigation.component';

import {HttpClientModule} from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {DragDropModule} from '@angular/cdk/drag-drop';
import {FlexLayoutModule} from '@angular/flex-layout';

import {RecipeAddComponent} from './components/recipe/recipe-add/recipe-add.component';
import {HomeComponent} from './components/home/home.component';
import {DatePipe, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {AvatarModule} from 'ngx-avatar';
import {AccountComponent} from './components/account/account.component';
import {PaymentComponent} from './components/payment/payment.component';
import {EditAccountComponent} from './components/account/edit-account/edit-account.component';
import {EditPaymentComponent} from './components/account/edit-payment/edit-payment.component';
import {CloseAccountComponent} from './components/account/close-account/close-account.component';
import {EditProfileComponent} from './components/account/edit-profile/edit-profile.component';
import {NotFoundComponent} from './components/not-found/not-found.component';
import {RegisterComponent} from './components/auth/register/register.component';
import {DishComponent} from './components/recipe/dish/dish.component';
import {PatientsComponent} from './components/patient/patients/patients.component';
import {FactsComponent} from './components/recipe/facts/facts.component';
import {Recipes2Component} from './components/recipe/recipes/recipes.component';
import {AffiliateComponent} from './components/patient/affiliate/affiliate.component';
import {ModalComponent} from './components/recipe/dish/modal/modal.component';
import {LoginComponent} from './components/auth/login/login.component';
import {PatientCreateComponent} from './components/patient/patient-create/patient-create.component';
import {FoodCreateComponent} from './components/food/food-create/food-create.component';
import {FoodsComponent} from './components/food/foods/foods.component';
import {ClientsComponent} from './components/patient/clients/clients.component';
import {AppMaterialModule} from './app-material.module';


@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    DietsComponent,
    ModalComponent,
    DishComponent,
    FoodsComponent,
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
    RegisterComponent,
    FactsComponent,
    Recipes2Component,
    AffiliateComponent,
    LoginComponent,
    PatientCreateComponent,
    FoodCreateComponent,
    ClientsComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    DragDropModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    AvatarModule,
    AppMaterialModule
  ],
  providers: [
    DatePipe,
    {provide: LocationStrategy, useClass: PathLocationStrategy}
  ],
  entryComponents: [
    AffiliateComponent,
    ModalComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
