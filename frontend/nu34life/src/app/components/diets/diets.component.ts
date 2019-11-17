import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {DietDetail} from '../../model/diet-detail';
import {Meal} from '../../model/meal';
import {ApiService} from '../../shared/api.service';
import {Recipe} from '../../model/recipe';
import {MatDialog} from '@angular/material';
import {Diet} from '../../model/diet';
import {DishComponent} from '../dish/dish.component';
import {ModalComponent} from '../dish/modal/modal.component';

@Component({
  selector: 'app-diets',
  templateUrl: './diets.component.html',
  styleUrls: ['./diets.component.scss']
})
export class DietsComponent implements OnInit {

  daysNumber: number;
  dayList: string[];
  meals: Meal[];
  dietPlan: DietPlanner;
  selected: MealSchedule;

  // REMOVE?
  recipesList: Recipe[];

  constructor(private apiService: ApiService,
              private dialog: MatDialog) { }

  ngOnInit() {
    this.daysNumber = 7;
    this.dietPlan = {
      diet: {
        id: null,
        starDate: new Date(),
        duration: this.daysNumber,
        nutritionistId: 0,
        stateId: 0,
        dietDays: []
      },
      schedule: []
    };

    for (let i = 0; i < this.daysNumber; i++) {
      this.dietPlan.schedule[i] = [];
    }

    this.getDayNameList();
    this.loadMeals();
    this.loadRecipes(null);

    for (let i = 0; i < this.dietPlan.diet.duration; i++) {
      this.dietPlan.diet.dietDays.push({id: null, day: i + 1, details: []});
    }
  }

  selectMeal(mealSch: MealSchedule) {
    this.selected = mealSch;
  }

  loadMeals() {
    this.apiService.getAllMeals().subscribe(
      res => {
        this.meals = res;
        this.meals.forEach(m => {
          this.dietPlan.schedule.forEach(x => x.push({id: m.id, name: m.name, detail: new Array<DietDetail>()}));
          this.selected = this.dietPlan.schedule[0][0];
        });
      },
      err => {
      }
    );
  }

  getDayNameList() {
    const weekdays = ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'];
    const day = this.dietPlan.diet.starDate;
    this.dayList = [];
    for (let i = 0; i < this.daysNumber; i++) {
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

  mapDiet() {
    const diet = this.dietPlan.diet;
    for (let i = 0; i < diet.duration; i++) {
      const dailySch = this.dietPlan.schedule[i];
      const details = dailySch.map(x => x.detail).reduce((acc, val) => acc.concat(val));
      diet.dietDays[i] = {id: null, day: i + 1, details: [...details]};
    }
  }

  loadRecipes(query: string) {
    this.apiService.getAllRecipes().subscribe(
      res => {
        this.recipesList = res;
      },
      err => {
      }
    );
  }

  createDiet() {
    this.mapDiet();
    this.apiService.postDiet(this.dietPlan.diet);
  }

  toggleMeals(event) {
    const element = event.option.value;

    if (event.option.selected) {
      this.dietPlan.schedule.forEach(x => x.push({id: element.id, name: element.name, detail: new Array<DietDetail>()}));
    } else {
      this.dietPlan.schedule.forEach(x => {
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

interface  DietPlanner {
  diet: Diet;
  schedule: MealSchedule[][];
}

interface MealSchedule {
  id: number;
  name: string;
  detail: DietDetail[];
}
