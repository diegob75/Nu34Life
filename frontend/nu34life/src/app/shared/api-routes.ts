const BASE_URL_DIET = 'http://localhost:8090/service-diets';
const BASE_URL_RECIPE = 'http://localhost:8090/service-recipes';
// ROUTE
export const API_ROUTES: ApiRoutes = {
  diets: {
    GET_DIETS: `${BASE_URL_DIET}/diets`,
    POST_DIET: `${BASE_URL_DIET}/diets`,
    PUT_DIET: `${BASE_URL_DIET}/diets`,
    DELETE_DIET: `${BASE_URL_DIET}/diets/`,
    GET_MEALS: `${BASE_URL_DIET}/diets/meals`
  },
  recipes: {
    GET_RECIPES: `${BASE_URL_RECIPE}/recipes`
  }
};

export interface ApiRoutes {
  diets: {
    GET_DIETS: string;
    POST_DIET: string;
    PUT_DIET: string;
    DELETE_DIET: string;
    GET_MEALS: string;
  };
  recipes: {
    GET_RECIPES: string;
  };
}
