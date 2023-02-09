CREATE DATABASE  IF NOT EXISTS `directorio_empleados`;
USE `directorio_empleados`;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;

CREATE TABLE `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `apellido` varchar(45) DEFAULT NULL,
  `correo` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `empleado`
--

INSERT INTO `empleado` VALUES 
	(1,'Leslie','Andrews','leslie@hotmail.com'),
	(2,'Emma','Baumgarten','emma@hotmail.com'),
	(3,'Avani','Gupta','avani@hotmail.com'),
	(4,'Yuri','Petrov','yuri@hotmail.com'),
	(5,'Juan','Vega','juan@hotmail.com'),
    (6,'Olivia','Johnson','olivia@hotmail.com'),
	(7,'Mia','Williams','mia@hotmail.com'),
	(8,'Ava','Jones','ava@hotmail.com'),
	(9,'Isabella','Brown','isabella@hotmail.com'),
	(10,'Sophia','Davis','sophia@hotmail.com'),
    (11,'Emily','Smith','emily1@hotmail.com'),
	(12,'Abigail','Johnson','abigail1@hotmail.com'),
	(13,'Madison','Williams','madison1@hotmail.com'),
	(14,'Elizabeth','Jones','elizabeth1@hotmail.com'),
	(15,'Avery','Brown','avery1@hotmail.com');

