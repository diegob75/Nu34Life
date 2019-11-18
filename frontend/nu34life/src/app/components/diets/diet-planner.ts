import {Diet} from '../../model/diet';
import {DietDetail} from '../../model/diet-detail';

export interface  DietPlanner {
  fromDate: Date;
  duration: number;
  schedule: MealSchedule[][];
}

export interface MealSchedule {
  id: number;
  name: string;
  detail: DietDetail[];
}

export const mapDiet = (dietPlanner: DietPlanner): Diet => {
  const diet: Diet =  {
    id: undefined,
    nutritionistId: undefined,
    patientId: undefined,
    starDate: dietPlanner.fromDate,
    duration: dietPlanner.duration,
    dietDays: []
  };
  for (let i = 0; i < diet.duration; i++) {
    const dailySch = dietPlanner.schedule[i];
    const details = dailySch.map(x => x.detail).reduce((acc, val) => acc.concat(val));
    diet.dietDays[i] = {id: null, day: i + 1, details: [...details]};
  }
  return diet;
}
