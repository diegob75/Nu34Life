import {NutritionFact} from './nutrition-fact';

export class Food {
  id: number;
  name: string;
  image: string;
  createdBy: number;
  nutrFact: NutritionFact;
}
