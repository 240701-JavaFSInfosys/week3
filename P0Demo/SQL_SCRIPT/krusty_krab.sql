--This schema will model a Krusty Krab employee management system (a viable option for P0)

--This will be a one-to-many relationship which is probably what you'll need for P0.

--DROP TABLE roles; <- Drop table syntax. May run into issues if there are dependent tables, so you need to add "cascade"


CREATE TABLE roles (
	role_id serial PRIMARY KEY,
	role_title TEXT NOT null,
	role_salary int CHECK(role_salary > 2)
);

INSERT INTO roles (role_title, role_salary)
VALUES ('Manager', 100000), ('Fry Cook', 50000), ('Cashier', 40000), ('Marketing Director', 100000);

SELECT * FROM roles;


CREATE TABLE employees (
	employee_id serial PRIMARY KEY,
	first_name TEXT NOT null,
	last_name TEXT NOT null,
	role_id_fk int REFERENCES roles (role_id)
);

INSERT INTO employees (first_name, last_name, role_id_fk)
VALUES ('Eugene', 'Krabs', 1),
	   ('Spongebob', 'Squarepants', 2),
	   ('Squidward', 'Tentacles', 3),
	   ('Patrick', 'Star', 4);

SELECT * FROM employees;



--Trying out a unique index, so that only one manager can exist at a time
CREATE UNIQUE INDEX unique_manager_role
ON employees (role_id_fk)
WHERE role_id_fk = 1;
