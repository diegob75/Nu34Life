import {DietDetail} from '../../model/diet-detail';

export interface MealSchedule {
  id: number;
  name: string;
  detail: DietDetail[];
}
