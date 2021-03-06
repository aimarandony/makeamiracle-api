insert into user (name, last_name, username, password, status) values ('Aimar Andony', 'Berrocal Coaquira', 'admin01', 'admin123', true)

insert into country (name) values ('Perú')
insert into country (name) values ('USA')

insert into city (name, country_id) values ('Lima', 1)
insert into city (name, country_id) values ('Georgia', 2)
insert into city (name, country_id) values ('Miami', 2)

insert into district (name, city_id) values ('San Juan de Lurigancho', 1)
insert into district (name, city_id) values ('San Borja', 1)
insert into district (name, city_id) values ('La Victoria', 1)

insert into sponsor (passport, name, last_name, phone, email, status, city_id ) values ('0000000000', 'Make a', 'Miracle', '000000000', 'makeamiracle@gmail.com', true, 2)
insert into sponsor (passport, name, last_name, phone, email, status, city_id ) values ('1234567891', 'Jack', 'Canouse', '123456781', 'jack@gmail.com', true, 2)
insert into sponsor (passport, name, last_name, phone, email, status, city_id ) values ('1234567892', 'Ernan', 'Sanchez', '123456782', 'ernan@gmail.com', true, 2)
insert into sponsor (passport, name, last_name, phone, email, status, city_id ) values ('1234567893', 'Frederick', 'Castro', '123456783', 'frederick@gmail.com', true, 2)

insert into school_type (name) values ('UNIVERSIDAD');
insert into school_type (name) values ('INSTITUTO');

insert into school (name, school_type_id) values ('Uni. Tecnológica del Perú', 1)
insert into school (name, school_type_id) values ('Uni. Privada del Norte', 1)
insert into school (name, school_type_id) values ('Uni. de Lima', 1)
insert into school (name, school_type_id) values ('Uni. Cesar Vallejo', 1)
insert into school (name, school_type_id) values ('IDAT', 2)
insert into school (name, school_type_id) values ('Senati', 2)
insert into school (name, school_type_id) values ('Cibertec', 2)

insert into degree (name) values ('Ingeniería de Sistemas')
insert into degree (name) values ('Ingeniería de Software')
insert into degree (name) values ('Ingeniería Civil')
insert into degree (name) values ('Ingeniería Química')
insert into degree (name) values ('Derecho')
insert into degree (name) values ('Medicina Humana')
insert into degree (name) values ('Administración de Empresas')
insert into degree (name) values ('Computación e Informática')
insert into degree (name) values ('Contabilidad')
insert into degree (name) values ('Diseño Gráfico')
insert into degree (name) values ('Diseño de Interiores')

insert into school_degrees (school_id, degrees_id) values (1, 1)
insert into school_degrees (school_id, degrees_id) values (1, 2)
insert into school_degrees (school_id, degrees_id) values (1, 3)
insert into school_degrees (school_id, degrees_id) values (1, 4)
insert into school_degrees (school_id, degrees_id) values (1, 7)
insert into school_degrees (school_id, degrees_id) values (1, 9)
insert into school_degrees (school_id, degrees_id) values (1, 10)

insert into school_degrees (school_id, degrees_id) values (2, 5)
insert into school_degrees (school_id, degrees_id) values (2, 6)
insert into school_degrees (school_id, degrees_id) values (2, 11)
insert into school_degrees (school_id, degrees_id) values (2, 4)
insert into school_degrees (school_id, degrees_id) values (2, 7)
insert into school_degrees (school_id, degrees_id) values (2, 9)
insert into school_degrees (school_id, degrees_id) values (2, 10)

insert into school_degrees (school_id, degrees_id) values (3, 1)
insert into school_degrees (school_id, degrees_id) values (3, 2)
insert into school_degrees (school_id, degrees_id) values (3, 3)
insert into school_degrees (school_id, degrees_id) values (3, 4)
insert into school_degrees (school_id, degrees_id) values (3, 7)
insert into school_degrees (school_id, degrees_id) values (3, 9)
insert into school_degrees (school_id, degrees_id) values (3, 10)

insert into school_degrees (school_id, degrees_id) values (4, 7)
insert into school_degrees (school_id, degrees_id) values (4, 8)
insert into school_degrees (school_id, degrees_id) values (4, 10)

insert into student (dni, name, last_name, gender, date_of_birth, address, phone, email, status, created_at, district_id) values ('74982111', 'Aimar Andony', 'Berrocal Coaquira', 'M', '2000-07-08', 'Bayobar Ref. Mercado Unión', '924630111', 'aimar@gmail.com', true, '2020-01-09', 1)
insert into student (dni, name, last_name, gender, date_of_birth, address, phone, email, status, created_at, district_id) values ('74982122', 'Jhon Elvis', 'Apaza Larico', 'M', '1998-02-27', 'Mariscal', '924630222', 'jhon@gmail.com', true, '2020-04-10', 1)
insert into student (dni, name, last_name, gender, date_of_birth, address, phone, email, status, created_at, district_id) values ('74982133', 'Jasson Kevin', 'Caceres Villar', 'M', '1995-05-14', 'Canto Grande', '924630333', 'jasson@gmail.com', true, '2020-05-09', 2)
insert into student (dni, name, last_name, gender, date_of_birth, address, phone, email, status, created_at, district_id) values ('74982144', 'Jean Pierre', 'Vereau Robles', 'M', '1995-01-13', 'Huascar', '924630444', 'jean@gmail.com', false, '2020-08-10', 1)
insert into student (dni, name, last_name, gender, date_of_birth, address, phone, email, status, created_at, district_id) values ('74982155', 'Craig Kem', 'Castro Pairazaman', 'M', '1995-08-10', 'Electra', '924630555', 'craig@gmail.com', true, '2020-08-09', 3)
insert into student (dni, name, last_name, gender, date_of_birth, address, phone, email, status, created_at, district_id) values ('74982166', 'Carla Elliane', 'Galvez Tenorio', 'F', '1999-10-22', 'Las Flores 22', '924630666', 'carla@gmail.com', true, '2020-09-22', 3)

insert into scholarship (comment, code_student, created_at, finished_date, status, student_id, sponsor_id, school_id, degree_id) values ('Culminó sus estudios en IDAT.', 'A18105321', '2020-07-02', '2021-05-12', 'CULMINADO', 1, 2, 4, 8)
insert into scholarship (comment, code_student, created_at, finished_date, status, student_id, sponsor_id, school_id, degree_id) values (null, 'A18105482', '2020-02-04', null, 'ACTIVO', 2, 2, 4, 10)
insert into scholarship (comment, code_student, created_at, finished_date, status, student_id, sponsor_id, school_id, degree_id) values ('Culminó sus estudios con éxito.', 'A18101648', '2019-03-12', '2021-04-02', 'CULMINADO', 3, 2, 4, 8)
insert into scholarship (comment, code_student, created_at, finished_date, status, student_id, sponsor_id, school_id, degree_id) values (null, null, '2019-02-22', null, 'ACTIVO', 4, 1, 4, 8)
insert into scholarship (comment, code_student, created_at, finished_date, status, student_id, sponsor_id, school_id, degree_id) values (null, null, '2020-08-13', null, 'ACTIVO', 5, 3, 4, 7)