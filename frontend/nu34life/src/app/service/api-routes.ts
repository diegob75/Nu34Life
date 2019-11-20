const BASE_URL_DIET = 'http://localhost:8090/api/service-diets';
const BASE_URL_RECIPE = 'http://localhost:8090/api/service-recipes';
// ROUTE
export const API_ROUTES: ApiRoutes = {
  affiliations: {},
  foods: {
    GET_FOODS: `${BASE_URL_RECIPE}/foods`,
    GET_FOOD_BY_ID: `${BASE_URL_RECIPE}/foods`,
    PAGE_FOOD: `${BASE_URL_RECIPE}/foods/pageable`,
    POST_FOOD: `${BASE_URL_RECIPE}/foods`},
  nutritionists: {},
  oauth: {},
  users: {},
  diets: {
    GET_DIETS: `${BASE_URL_DIET}/diets`,
    POST_DIET: `${BASE_URL_DIET}/diets`,
    PUT_DIET: `${BASE_URL_DIET}/diets`,
    DELETE_DIET: `${BASE_URL_DIET}/diets/`,
    GET_MEALS: `${BASE_URL_DIET}/diets/meals`
  },
  recipes: {
    GET_RECIPES: `${BASE_URL_RECIPE}/recipes`,
    PAGE_RECIPES: `${BASE_URL_RECIPE}/recipes/pageable`,
    GET_RECIPE: `${BASE_URL_RECIPE}/recipes`,
    POST_RECIPE: `${BASE_URL_RECIPE}/recipes`
  },
  patients: {
    GET_PATIENTS: ``
  }
};

export interface ApiRoutes {
  oauth: {};
  users: {};
  nutritionists: {};
  patients: {
    GET_PATIENTS: string;
  };
  affiliations: {};
  diets: {
    GET_DIETS: string;
    POST_DIET: string;
    PUT_DIET: string;
    DELETE_DIET: string;
    GET_MEALS: string;
  };
  recipes: {
    GET_RECIPES: string;
    PAGE_RECIPES: string;
    GET_RECIPE: string;
    POST_RECIPE: string;
  };
  foods: {
    POST_FOOD: string;
    GET_FOODS: string;
    PAGE_FOOD: string;
    GET_FOOD_BY_ID: string;
  };
}
