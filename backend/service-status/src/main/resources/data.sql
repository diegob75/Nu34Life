insert into goals(description) values('Bajar de peso');
insert into goals(description) values('Aumentar peso');
insert into goals(description) values('Regular niveles de glucosa');

insert into medical_conditions(name,description) values('diabetes','diabetes');
insert into medical_conditions(name,description) values('gastritis','gastritis');
insert into medical_conditions(name,description) values('asma','asma');
insert into medical_conditions(name,description) values('presion alta','presion alta');

insert into drugs(name) values('ibuprofeno');
insert into drugs(name) values('paracetamol');
insert into drugs(name) values('clorfenamina');
insert into drugs(name) values('morfina');

insert into drug_categories(name) values('anestésico');
insert into drug_categories(name) values('antiinflamatorio');
insert into drug_categories(name) values('medicamento');
insert into drug_categories(name) values('suplemento');
insert into drug_categories(name) values('analgesico');
insert into drug_categories(name) values('antipiretico');
insert into drug_categories(name) values('anithistaminico');

insert into drug_drug_categories(category_id,drug_id) values(1,2);
insert into drug_drug_categories(category_id,drug_id) values(1,3);
insert into drug_drug_categories(category_id,drug_id) values(2,1);
insert into drug_drug_categories(category_id,drug_id) values(2,2);
insert into drug_drug_categories(category_id,drug_id) values(2,3);
insert into drug_drug_categories(category_id,drug_id) values(3,7);
insert into drug_drug_categories(category_id,drug_id) values(3,3);
insert into drug_drug_categories(category_id,drug_id) values(4,3);
insert into drug_drug_categories(category_id,drug_id) values(4,1);

insert into physical_activities(name,description) values('Yoga','Yoga');
insert into physical_activities(name,description) values('Cardio','Cardio');
insert into physical_activities(name,description) values('Areobicos','Areobicos');
insert into physical_activities(name,description) values('Pesas','Pesas');
insert into physical_activities(name,description) values('Deporte','Deporte');