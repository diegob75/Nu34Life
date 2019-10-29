import {Component, OnInit} from '@angular/core';
import {Diet} from '../model/diet';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {DietDetail} from '../model/diet-detail';
import {Meal} from '../model/meal';
import {ApiService} from '../shared/api-service';

@Component({
  selector: 'app-diets',
  templateUrl: './diets.component.html',
  styleUrls: ['./diets.component.scss']
})
export class DietsComponent implements OnInit {

  daysNumber: number;
  dayList: string[];
  meals: Meal[];
  diet: Diet;

  constructor(private apiService: ApiService) { }

  ngOnInit() {
    this.daysNumber = 7;
    this.diet = {
      id: null,
      starDate: new Date(),
      duration: this.daysNumber,
      nutritionistId: 0,
      stateId: 0,
      schedule: [[], [], [], [], [], [], []]
    };
    this.getDayNameList();
    this.loadMeals();
  }

  loadMeals()  {
    this.meals = this.apiService.getAllMeals();

    this.meals.forEach(m => {
      this.diet.schedule.forEach(x => x.push({ id: m.id, name: m.name, detail: new Array<DietDetail>() }));
    });
  }

getDayNameList() {
    const weekdays = [ 'Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'];
    const day = this.diet.starDate;
    this.dayList = [];
    for (let i = 0; i < this.daysNumber; i++) {
      const newDate = new Date();
      newDate.setDate(day.getDate() + i);
      this.dayList.push(`${weekdays[newDate.getDay()]} ${newDate.getDate()}`);
    }
  }

  addRecipe() {
    const recipes = this.apiService.getAllRecipes();
    this.diet.schedule[0][0].detail = recipes.map(x => ({id: null, recipe: x}));
  }

  createDiet() {
    console.log(JSON.stringify(this.diet, null, 2));
  }

  toggleMeals(event) {
    const element = event.option.value;

    if (event.option.selected) {
      this.diet.schedule.forEach(x => x.push({ id: element.id, name: element.name, detail: new Array<DietDetail>() }));
      console.log(JSON.stringify(this.diet.schedule));
    } else {
      this.diet.schedule.forEach(x => {
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
