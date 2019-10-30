INSERT INTO public.foods( name) VALUES ('pescado');
INSERT INTO public.foods( name) VALUES ('zanahoria');
INSERT INTO public.foods( name) VALUES ('lechuga');
INSERT INTO public.foods( name) VALUES ('tomate');
INSERT INTO public.foods( name) VALUES ('pollo');
INSERT INTO public.foods( name) VALUES ('palta');
INSERT INTO public.foods( name) VALUES ('apio');
INSERT INTO public.foods( name) VALUES ('aceite de oliva');

INSERT INTO public.meals( name) VALUES ('desayuno');
INSERT INTO public.meals( name) VALUES ('almuerzo');
INSERT INTO public.meals( name) VALUES ('merienda');
INSERT INTO public.meals( name) VALUES ('cena');

INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (3, 120, 24, 7, 0,  0, 1);
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (14, 50, 2, 0, 0,  0, 0);	
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (1, 70, 1, 0, 0,  0, 0);
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (16, 63, 2, 0, 0,  0, 0);
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (3, 113, 27, 4, 0,  0, 1);
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (3, 102, 2, 7, 2,  0, 18);
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (8, 20, 4, 0, 0,  0, 0);
INSERT INTO public.nutrition_facts( carbohydrates, energetic_value, protein, salt, saturated_fats, sugars, total_fat) VALUES (0, 100, 0, 7, 4,  0, 20);

INSERT INTO public.recipes(name, servings) VALUES ( 'Ensalada mediterranea', 1);
INSERT INTO public.recipes(name, servings) VALUES ( 'Pescado al olivo', 1);
INSERT INTO public.recipes(name, servings) VALUES ( 'Ensalada cesar', 1);

INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (2, 1, 60, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (3, 1, 120, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (4, 1, 90, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (6, 1, 50,'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (7, 1, 20, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (8, 1, 2, 'cu');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (3, 3, 120, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (5, 3, 111, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (6, 3, 50,'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (7, 3, 20, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (8, 3, 2, 'cu');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (1, 2, 20, 'g');
INSERT INTO public.ingredients(food_id, recipe_id, quantity, unit) VALUES (8, 2, 2, 'cu');

INSERT INTO public.steps(instruction, step_number, recipe_id) VALUES ( 'Pasos a seguir: ...', 3, 1);
INSERT INTO public.steps(instruction, step_number, recipe_id) VALUES ( 'Pasos a seguir: ...', 5, 3);
INSERT INTO public.steps(instruction, step_number, recipe_id) VALUES ( 'Pasos a seguir: ...', 2, 2);