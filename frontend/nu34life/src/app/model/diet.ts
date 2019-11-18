import {DietDay} from './diet-day';

export class Diet {
  id: number;
  nutritionistId: { id: number };
  patientId: { id: number };
  duration: number;
  starDate: Date;
  dietDays: DietDay[];
}
