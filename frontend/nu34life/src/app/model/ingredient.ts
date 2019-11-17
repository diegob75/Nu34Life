import {Food} from './food';

export interface Ingredient {
  id: number;
  quantity: number;
  food: Food;
}
