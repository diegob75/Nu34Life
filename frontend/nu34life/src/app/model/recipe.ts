import {RecipeStep} from './recipe-step';
import {Ingredient} from './ingredient';
import {NutritionFact} from './nutrition-fact';



export class Recipe {
  id: number;
  name: string;
  createdBy: number;
  servings: number;
  steps: RecipeStep[];
  ingredients: Ingredient[];
  nutrFact: NutritionFact;
  image: string;
}
