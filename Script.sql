CREATE DATABASE pruebaxaldigital;

CREATE TABLE pruebaxaldigital.tbaerolineas (
  `id_aerolinea` bigint NOT NULL AUTO_INCREMENT,
  `nombre_aerolinea` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_aerolinea`)
) ;

CREATE TABLE pruebaxaldigital.tbaeropuertos (
  `id_aeropuerto` bigint NOT NULL AUTO_INCREMENT,
  `nombre_aeropuerto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_aeropuerto`)
);

CREATE TABLE pruebaxaldigital.tbmovimientos (
  `id_movimiento` bigint NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_movimiento`)
);

CREATE TABLE pruebaxaldigital.tbvuelos (
  `id_vuelos` bigint NOT NULL AUTO_INCREMENT,
  `dia` datetime(6) DEFAULT NULL,
  `tbaerolineas` bigint DEFAULT NULL,
  `tbaeropuertos` bigint DEFAULT NULL,
  `tbmovimientos` bigint DEFAULT NULL,
  PRIMARY KEY (`id_vuelos`),
  KEY `FK12eev7p28cetuu27le1kta38t` (`tbaerolineas`),
  KEY `FK9tj3l5i87586bgwov8tj9sagb` (`tbaeropuertos`),
  KEY `FKgl2hwoguea7vl0qseuiniumw2` (`tbmovimientos`),
  CONSTRAINT `FK12eev7p28cetuu27le1kta38t` FOREIGN KEY (`tbaerolineas`) REFERENCES `tbaerolineas` (`id_aerolinea`),
  CONSTRAINT `FK9tj3l5i87586bgwov8tj9sagb` FOREIGN KEY (`tbaeropuertos`) REFERENCES `tbaeropuertos` (`id_aeropuerto`),
  CONSTRAINT `FKgl2hwoguea7vl0qseuiniumw2` FOREIGN KEY (`tbmovimientos`) REFERENCES `tbmovimientos` (`id_movimiento`)
);

insert into pruebaxaldigital.tbaerolineas values (1,'Volaris');
insert into pruebaxaldigital.tbaerolineas values (2,'Aeromar');
insert into pruebaxaldigital.tbaerolineas values (3,'Interjet');
insert into pruebaxaldigital.tbaerolineas values (4,'Aeromexico');

insert into pruebaxaldigital.tbaeropuertos values (1,'Benito  Juarez');
insert into pruebaxaldigital.tbaeropuertos values (2,'Guanajuato');
insert into pruebaxaldigital.tbaeropuertos values (3,'La Paz');
insert into pruebaxaldigital.tbaeropuertos values (4,'Oaxaca');

insert into pruebaxaldigital.tbmovimientos values(1,'Salida');
insert into pruebaxaldigital.tbmovimientos values(2,'Llegada');

insert into pruebaxaldigital.tbvuelos values(1,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),1,1,1);
insert into pruebaxaldigital.tbvuelos values(2,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),2,1,1);
insert into pruebaxaldigital.tbvuelos values(3,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),3,2,2);
insert into pruebaxaldigital.tbvuelos values(4,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),2,1,1);
insert into pruebaxaldigital.tbvuelos values(5,STR_TO_DATE('2022-05-03', '%Y-%m-%d*'),2,1,1);
insert into pruebaxaldigital.tbvuelos values(6,STR_TO_DATE('2022-05-03', '%Y-%m-%d*'),2,1,1);
insert into pruebaxaldigital.tbvuelos values(7,STR_TO_DATE('2022-05-03', '%Y-%m-%d*'),2,1,1);
insert into pruebaxaldigital.tbvuelos values(8,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),1,1,1);
insert into pruebaxaldigital.tbvuelos values(9,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),1,1,1);
insert into pruebaxaldigital.tbvuelos values(10,STR_TO_DATE('2022-05-02', '%Y-%m-%d*'),1,1,1);