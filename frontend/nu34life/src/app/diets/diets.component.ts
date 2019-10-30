import {Component, OnInit} from '@angular/core';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {DietDetail} from '../model/diet-detail';
import {Meal} from '../model/meal';
import {ApiService} from '../shared/api-service';
import {Recipe} from '../model/recipe';
import {MealSchedule} from '../model/meal-schedule';
import {DietPlanner} from '../model/diet-planner';

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
  stash: { index: number; arr: DietDetail[]; detail: DietDetail }[];

  constructor(private apiService: ApiService) {
  }

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
      schedule: [[], [], [], [], [], [], []]
    };
    this.getDayNameList();
    this.loadMeals();
    this.getRecipes(null);
    for (let i = 0; i < this.dietPlan.diet.duration; i++) {
      this.dietPlan.diet.dietDays.push({id: null, day: i + 1, details: []});
    }

    this.selected = this.dietPlan.schedule[0][0];

    this.stash = [];
  }

  loadMeals() {
    this.meals = this.apiService.getAllMeals();

    this.meals.forEach(m => {
      this.dietPlan.schedule.forEach(x => x.push({id: m.id, name: m.name, detail: new Array<DietDetail>()}));
    });
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
    // this.stash.push({ index, arr: meal.detail, detail: meal[index]});
    meal.detail.splice(index, 1);
  }

  mapDiet() {
    const diet = this.dietPlan.diet;
    for (let i = 0; i < diet.duration; i++) {
      const dailySch = this.dietPlan.schedule[i];
      const details = dailySch.map(x => x.detail).reduce((acc, val) => acc.concat(val));
      diet.dietDays[i] = {id: null, day: i + 1, details: [...details]};
    }
  }

  // undoRemove() {
  //   const { index, arr, detail } = this.stash.pop();
  //   arr.splice(index, 0, detail);
  // }


  selectMeal(mealSch: MealSchedule) {
    this.selected = mealSch;
  }

  getRecipes(query: string) {
    this.recipesList = this.apiService.getAllRecipes();
  }

  createDiet() {
    this.mapDiet();
    this.apiService.postDiet(this.dietPlan.diet);
  }

  toggleMeals(event) {
    const element = event.option.value;

    if (event.option.selected) {
      this.dietPlan.schedule.forEach(x => x.push({id: element.id, name: element.name, detail: new Array<DietDetail>()}));
      console.log(JSON.stringify(this.dietPlan.schedule));
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
