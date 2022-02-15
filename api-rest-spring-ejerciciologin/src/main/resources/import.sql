INSERT INTO departamentos(nombre,ubicacion) VALUES ("Informatica","Madrid");
INSERT INTO departamentos(nombre,ubicacion) VALUES ("Seguridad","Parla");

INSERT INTO empleados(id_dep,dni,nombre,salario,telefono) VALUES (1,"54286211R","Daniel",1500,600938754);
INSERT INTO empleados(id_dep,dni,nombre,salario,telefono) VALUES (2,"63399177T","Alex",900,625755506);


INSERT INTO jefes(id_dep,dni,nombre,salario,telefono) VALUES (1,"31231G","Cota",1500,600938754);
INSERT INTO jefes(id_dep,dni,nombre,salario,telefono) VALUES (2,"9123964j","Juan",1500,600938754);

INSERT INTO usuarios(user,password) VALUES("54286211R","123abc");