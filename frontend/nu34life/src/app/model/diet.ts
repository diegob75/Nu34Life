import {DietDetail} from './diet-detail';
import {MealSchedule} from './meal-schedule';
import {DietDay} from './diet-day';

export class Diet {
  id: number;
  nutritionistId: number;
  stateId: number;
  duration: number;
  starDate: Date;
  dietDays: DietDay[];
}
