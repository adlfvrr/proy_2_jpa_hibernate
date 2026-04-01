--Nos aseguramos que no existan las tables

<<<<<<< HEAD
SET search_path TO public;


=======
>>>>>>> c842f9e630ef5396da312a667cd964e5fcb29d83
drop table if exists Vehiculos;
drop table if exists Motos;
drop table if exists Autos;


--creamos

create table Vehiculos(
id SERIAL,
marca VARCHAR(50) not NULL,
precio DECIMAL(18,2) not NULL,
anio INT not null,
primary KEY(id)
);

create table Motos(
id SERIAL,
marca VARCHAR(50) not null,
precio DECIMAL(18,2) not null,
anio INT not null,
cilindrada INT not null,
primary key(id)
);

create table Autos(
 id SERIAL,
 marca VARCHAR(50) NOT NULL,
 precio DECIMAL(18,2) NOT NULL,
 anio INT not null,
 cant_puertas INT NOT NULL,
 PRIMARY KEY(id)
);

--verificamos

select * 
from Vehiculos;
select * 
from Autos;
select * 
from Motos;
