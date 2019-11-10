import {DietDetail} from './diet-detail';
import {MealSchedule} from '../components/diets/meal-schedule';
import {DietDay} from './diet-day';

export interface Diet {
  id: number;
  nutritionistId: number;
  stateId: number;
  duration: number;
  starDate: Date;
  dietDays: DietDay[];
}
