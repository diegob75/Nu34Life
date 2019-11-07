INSERT INTO users (username,password_hash,email_validated,first_name,last_name,email) VALUES ('Dra.Soto','$2a$10$VzsBpvJXVkXaAy29XooHZORsE6IzF.2ZZMB1drnURqbCyhWEazkdK',1,'Maria','Soto','msoto@n34life.com');
INSERT INTO users (username,password_hash,email_validated,first_name,last_name,email)VALUES ('Henry','$2a$10$R8CUVucLB2B7omTl8H0CPuSPqxquNKR2JuUAIcg.kquUT3xxnROdi',1,'Henry','Mendoza','hmendo81@gmail.com');


INSERT INTO roles (first_name) VALUES ('ROLE_NUTRITIONIST');
INSERT INTO roles (first_name) VALUES ('ROLE_PATIENT');


INSERT INTO user_roles (user_id,role_id) VALUES (1,1);
INSERT INTO user_roles (user_id,role_id) VALUES (1,2);
INSERT INTO user_roles (user_id,role_id) VALUES (2,1);
