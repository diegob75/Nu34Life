import {Recipe} from './recipe';
import {Meal} from './meal';

export interface DietDetail {
  id: number;
  recipe: Recipe;
  meal: Meal;
}
