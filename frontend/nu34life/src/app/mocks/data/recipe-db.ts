import {Recipe} from '../../model/recipe';
import {MockResources} from '../mock-resources';

export const recipeDb = new Array<Recipe>();
recipeDb.push({
  id: 9,
  name: 'Ensalada de atun',
  servings: 1,
  steps: null,
  ingredients: [
    { id: null, food: { id: 1, name: 'ssdfsdf'}, quantity: 3}
  ],
  nutritionFact: { id: 1},
  image: MockResources.recipePicture(),
});
recipeDb.push({
  id: 10,
  name: 'Pan con pollo',
  servings: 1,
  steps: null,
  ingredients: [
    { id: null, food: { id: 3, name: 'gdfgdfg'}, quantity: 4}
  ],
  nutritionFact: null,
  image: MockResources.recipePicture()
});

