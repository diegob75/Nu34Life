import {RecipeStep} from './recipe-step';
import {Ingredient} from './ingredient';
import {NutritionFact} from './nutrition-fact';



export class Recipe {
  id: number;
  name: string;
  servings: number;
  steps: RecipeStep[];
  ingredients: Ingredient[];
  nutritionFact: NutritionFact;
  image: string;
}
