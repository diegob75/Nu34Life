import {DietDay} from './diet-day';

export class Diet {
  id: number;
  nutritionistId: number;
  patientId: number;
  duration: number;
  starDate: string;
  dietDays: DietDay[];
}
