import {DietDetail} from './diet-detail';
import {MealSchedule} from './meal-schedule';

export class Diet {
  id: number;
  nutritionistId: number;
  stateId: number;
  duration: number;
  starDate: Date;
  schedule: MealSchedule[][];
}
