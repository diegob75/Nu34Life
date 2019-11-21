import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {DietDetail} from '../../model/diet-detail';
import {Meal} from '../../model/meal';
import {ApiService} from '../../service/api.service';
import {Recipe} from '../../model/recipe';
import {MatDialog} from '@angular/material';
import {ModalComponent} from '../recipe/dish/modal/modal.component';
import {DietPlanner, mapDiet, MealSchedule} from './diet-planner';
import {Patient} from '../../model/patient';
import {FormControl} from '@angular/forms';

@Component({
  selector: 'app-diets',
  templateUrl: './diets.component.html',
  styleUrls: ['./diets.component.scss']
})
export class DietsComponent implements OnInit {

  dayList: string[];
  meals: Meal[];
  dietPlanner: DietPlanner;
  selected: MealSchedule;

  myControl = new FormControl();
  patients: Patient[];

  // REMOVE?
  recipesList: Recipe[];

  constructor(private apiService: ApiService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.dietPlanner = {
      duration: 7,
      fromDate: new Date(),
      schedule: []
    };

    for (let i = 0; i < this.dietPlanner.duration; i++) {
      this.dietPlanner.schedule[i] = [];
    }

    this.getDayNameList();
    this.loadMeals();
    this.loadRecipes(null);
    this.loadPatients();
  }

  selectMeal(mealSch: MealSchedule) {
    this.selected = mealSch;
  }

  loadPatients() {
    const id = 0;
    this.apiService.getAffiliatedPatients(id).subscribe(res => {
      this.patients = res;
    }, err => {
      console.log(err);
    });
  }

  loadMeals() {
    this.apiService.getAllMeals().subscribe(
      res => {
        this.meals = res;
        this.meals.forEach(m => {
          this.dietPlanner.schedule.forEach(x => x.push({id: m.id, name: m.name, detail: new Array<DietDetail>()}));
          this.selected = this.dietPlanner.schedule[0][0];
        });
      },
      err => {
        console.log(err);
      }
    );
  }

  getDayNameList() {
    const weekdays = ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'];
    const day = this.dietPlanner.fromDate;
    this.dayList = [];
    for (let i = 0; i < this.dietPlanner.duration; i++) {
      const newDate = new Date();
      newDate.setDate(day.getDate() + i);
      this.dayList.push(`${weekdays[newDate.getDay()]} ${newDate.getDate()}`);
    }
  }

  addRecipe(recipe: Recipe) {
    this.selected.detail.push({id: null, recipe, meal: { id: this.selected.id, name: this.selected.name }});
  }

  removeRecipe(index: number, meal: MealSchedule) {
    meal.detail.splice(index, 1);
  }

  viewRecipeDetails(recipe): void {
    const dialogRef = this.dialog.open(ModalComponent, {
      width: '800px',
      panelClass: 'card-dialog',
      data: recipe
    });

    dialogRef.afterClosed().subscribe(result => {

    });
  }

  loadRecipes(query: string) {
    this.apiService.getAllRecipes().subscribe(
      res => {
        this.recipesList = res;
      },
      err => {
        console.log(err);
      }
    );
  }

  createDiet() {
    const diet = mapDiet(this.dietPlanner);
    console.log(diet);
    this.apiService.postDiet(diet).subscribe(res => {
      console.log('Exito!', res);
    }, err => {
      console.log('Error!', err);
    });
  }

  toggleMeals(event) {
    const element = event.option.value;

    if (event.option.selected) {
      this.dietPlanner.schedule.forEach(x => x.push({id: element.id, name: element.name, detail: new Array<DietDetail>()}));
    } else {
      this.dietPlanner.schedule.forEach(x => {
        const index = x.findIndex(m => m.id === element.id);
        if (index > -1) {
          x.splice(index, 1);
        }
      });
    }
  }

  drop(event: CdkDragDrop<DietDetail[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }
}

