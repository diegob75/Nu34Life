import {Diet} from '../../model/diet';
import {DietDetail} from '../../model/diet-detail';
import * as moment from 'moment';


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
  const date = dietPlanner.fromDate == null ? new Date() : dietPlanner.fromDate;

  const diet: Diet =  {
    id: undefined,
    nutritionistId: undefined,
    patientId: undefined,
    starDate: moment(date).format('YYYY-MM-DD'),
    duration: dietPlanner.duration,
    dietDays: []
  };
  for (let i = 0; i < diet.duration; i++) {
    const dailySch = dietPlanner.schedule[i];
    const details = dailySch.map(x => x.detail).reduce((acc, val) => acc.concat(val));
    diet.dietDays[i] = {id: null, day: i + 1, details: [...details]};
  }
  return diet;
};

