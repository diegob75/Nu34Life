import {DietDay} from './diet-day';

export interface Diet {
  id: number;
  nutritionistId: number;
  stateId: number;
  duration: number;
  starDate: Date;
  dietDays: DietDay[];
}
