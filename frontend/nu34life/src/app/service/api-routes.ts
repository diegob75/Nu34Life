const BASE_URL_DIET = 'http://localhost:8090/api/service-diets';
const BASE_URL_RECIPE = 'http://localhost:8090/api/service-recipes';
const BASE_URL_PROFILE = 'http://localhost:8090/api/service-profiles';
const BASE_URL_USER = 'http://localhost:8090/api/service-users';


// ROUTE
export const API_ROUTES: ApiRoutes = {
  affiliations: {
    AFFILIATION_REQUEST: `${BASE_URL_PROFILE}/patients/affiliate/request`,
    AFFILIATION_CONFIRM: `${BASE_URL_PROFILE}/patients/affiliate/confirm`,
    AFFILIATION_DEACTIVATE: `${BASE_URL_PROFILE}/patients/affiliate/deactivate`,
  },
  foods: {
    GET_FOODS: `${BASE_URL_RECIPE}/foods`,
    GET_FOOD_BY_ID: `${BASE_URL_RECIPE}/foods`,
    PAGE_FOOD: `${BASE_URL_RECIPE}/foods/pageable`,
    POST_FOOD: `${BASE_URL_RECIPE}/foods`,
    PUT_FOOD: `${BASE_URL_RECIPE}/foods`,
    DEACTIVATE_FOOD:`${BASE_URL_RECIPE}/foods`},
  nutritionists: {
    GET_NUTRITIONIST_BY_ID: `${BASE_URL_PROFILE}/nutritionist`, 
    POST_NUTRITIONIST: `${BASE_URL_PROFILE}/nutritionist`,
    PUT_NUTRITIONIST: `${BASE_URL_PROFILE}/nutritionist`,
    GET_NUTRITIONISTS: `${BASE_URL_PROFILE}/nutritionist`,
  },
  oauth: {},
  users: {
    REGISTER_NUTRITIONIST: `${BASE_URL_USER}/registerNutritionist`,
    REGISTER_PATIENT: `${BASE_URL_USER}/registerPatient`   
  },
  diets: {
    GET_DIETS: `${BASE_URL_DIET}/diets`,
    POST_DIET: `${BASE_URL_DIET}/diets`,
    PUT_DIET: `${BASE_URL_DIET}/diets`,
    DELETE_DIET: `${BASE_URL_DIET}/diets/`,
    GET_MEALS: `${BASE_URL_DIET}/diets/meals`,
    GET_DIET_PATIENT: `${BASE_URL_DIET}/diets/patient`,
  },
  recipes: {
    GET_RECIPES: `${BASE_URL_RECIPE}/recipes`,
    PAGE_RECIPES: `${BASE_URL_RECIPE}/recipes/pageable`,
    GET_RECIPE_BY_ID: `${BASE_URL_RECIPE}/recipes`,
    POST_RECIPE: `${BASE_URL_RECIPE}/recipes`,
    PUT_RECIPE: `${BASE_URL_RECIPE}/recipes`,
    DEACTIVATE_RECIPE: `${BASE_URL_RECIPE}/recipes`,

  },
  patients: {
    GET_PATIENTS: `${BASE_URL_PROFILE}/patients`,
    PUT_PATIENT: `${BASE_URL_PROFILE}/patients`,
    GET_PATIENTS_AFFILIATED: `${BASE_URL_PROFILE}/patients/byNutritionist`,
    POST_PATIENT: `${BASE_URL_PROFILE}/patients`,
    GET_PATIENT_BY_ID:`${BASE_URL_PROFILE}/patients`

  }
};

export interface ApiRoutes {
  oauth: {};
  users: {
    REGISTER_NUTRITIONIST: string;
    REGISTER_PATIENT: string;
  };
  nutritionists: {
    GET_NUTRITIONIST_BY_ID: string;
    POST_NUTRITIONIST: string;
    PUT_NUTRITIONIST: string;
    GET_NUTRITIONISTS: string;
  };
  patients: {
    GET_PATIENTS: string;
    PUT_PATIENT: string;
    GET_PATIENTS_AFFILIATED: string;
    POST_PATIENT: string;
    GET_PATIENT_BY_ID: string;
  };
  affiliations: {
    AFFILIATION_REQUEST: string;
    AFFILIATION_CONFIRM: string;
    AFFILIATION_DEACTIVATE: string;
  };
  diets: {
    GET_DIETS: string;
    POST_DIET: string;
    PUT_DIET: string;
    DELETE_DIET: string;
    GET_MEALS: string;
    GET_DIET_PATIENT: string;
  };
  recipes: {
    GET_RECIPES: string;
    PAGE_RECIPES: string;
    GET_RECIPE_BY_ID: string;
    POST_RECIPE: string;
    PUT_RECIPE: string;
    DEACTIVATE_RECIPE: string;
  };
  foods: {
    POST_FOOD: string;
    GET_FOODS: string;
    PAGE_FOOD: string;
    GET_FOOD_BY_ID: string;
    DEACTIVATE_FOOD: string;
    PUT_FOOD: string;
  };
}
