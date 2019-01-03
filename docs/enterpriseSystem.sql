CREATE DATABASE  IF NOT EXISTS `enterprisesystem` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `enterprisesystem`;
-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: enterprisesystem
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `detalleplanillas`
--

DROP TABLE IF EXISTS `detalleplanillas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `detalleplanillas` (
  `idDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `idplanilla` int(11) DEFAULT NULL,
  `idempleado` int(11) DEFAULT NULL,
  `salarioBase` decimal(8,2) DEFAULT NULL,
  `bono` decimal(8,2) DEFAULT NULL,
  `isss` decimal(8,2) DEFAULT NULL,
  `renta` decimal(8,2) DEFAULT NULL,
  `afp` decimal(8,2) DEFAULT NULL,
  `salarioNeto` decimal(8,2) DEFAULT NULL,
  `horasExtras` decimal(8,2) DEFAULT NULL,
  `anticipos` decimal(8,2) DEFAULT NULL,
  `aguinaldo` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idDetalle`),
  KEY `kf2_idx` (`idempleado`),
  KEY `kf1_idx` (`idplanilla`),
  CONSTRAINT `kf1` FOREIGN KEY (`idplanilla`) REFERENCES `planillas` (`idplanillas`),
  CONSTRAINT `kf2` FOREIGN KEY (`idempleado`) REFERENCES `empleados` (`idempleado`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleplanillas`
--

LOCK TABLES `detalleplanillas` WRITE;
/*!40000 ALTER TABLE `detalleplanillas` DISABLE KEYS */;
INSERT INTO `detalleplanillas` VALUES (1,1,1,0.10,0.10,0.10,0.10,0.10,0.10,0.10,0.10,0.20),(3,1,1,0.03,0.02,0.04,0.05,0.01,0.01,0.01,0.01,0.01),(5,1,1,999.99,999.99,999.99,999.99,999.99,999.99,999.99,999.99,999.99),(6,1,1,500.00,100.00,50.25,36.23,10.00,600.00,100.00,300.00,800.00);
/*!40000 ALTER TABLE `detalleplanillas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleados` (
  `idempleado` int(11) NOT NULL AUTO_INCREMENT,
  `idsucursal` int(11) DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `codigoEmpleado` varchar(10) DEFAULT NULL,
  `nombres` varchar(20) DEFAULT NULL,
  `apellidos` varchar(20) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `fechaNacimiento` date DEFAULT NULL,
  `sexo` varchar(45) DEFAULT NULL,
  `estadoCivil` varchar(45) DEFAULT NULL,
  `DUI` varchar(45) DEFAULT NULL,
  `NIT` varchar(45) DEFAULT NULL,
  `NUP` varchar(45) DEFAULT NULL,
  `afiliacionISSS` varchar(45) DEFAULT NULL,
  `cargo` varchar(45) DEFAULT NULL,
  `salario` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idempleado`),
  KEY `fk5_idx` (`idsucursal`),
  CONSTRAINT `fk5` FOREIGN KEY (`idsucursal`) REFERENCES `sucursales` (`idsucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
INSERT INTO `empleados` VALUES (1,1,'fdh','dfg','dfg','df','dg','dgf','dfg','2018-11-04','rgf','gfd','bg','gf','fg','fg','bf',0.80),(5,1,'Hombre','sp16001','Manuel Enrique ','Suarez Palacios','San Salvador, Soyapango','2222-8888','manuel@gmail.com','1996-10-17','Hombre','Solter@','78787878-7','8582-558585-858-5','969696969696','325564145414','Programador',900.00),(7,1,'Activo','qw7842265','William Ernesto','Rosales Pineda','San Salvador','7878-7878','william@gmail.com','2018-11-12','Hombre','Casad@','85858585-8','9696-969696-969-6','656565656565','14253698745','Empleado',800.00),(8,2,'Inactivo','po7845','Pablo','Orellana','Tegucigalpa','2598-7747','pablo@gmail.com','1994-12-20','Hombre','Casad@','89748554-5','8561-224142-123-6','961512324585','8978165168','ordenanza',600.00);
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresas`
--

DROP TABLE IF EXISTS `empresas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empresas` (
  `idempresa` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `nit` varchar(18) DEFAULT NULL,
  `direccion` varchar(200) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idempresa`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (1,'VHR','1013-091189-101-7','San Marcos, San Salvador','2222-2222','vhr@vhr.com.sv'),(2,'dsf','fdsf','fsdf','dfsf','fds'),(3,'El quesito','0125-314201-542-1','San Salvador','7585-4565','@QuesitoBuengusto.com'),(4,'Miguelito','0151-054456-015-4','Soya','2484-2564','@Soya.Migel.123.com'),(5,'CASS','7845-452125-689-7','Gavidia','7845-1254','cass@mail.com'),(6,'Grupo GD','8547-412121-548-4','Paseo general escalon','2254-5748','grupogd@mail.com');
/*!40000 ALTER TABLE `empresas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresosmensuales`
--

DROP TABLE IF EXISTS `ingresosmensuales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ingresosmensuales` (
  `idIngresoMensual` int(11) NOT NULL AUTO_INCREMENT,
  `idSucursal` int(11) DEFAULT NULL,
  `mes` int(12) DEFAULT NULL,
  `anio` int(12) DEFAULT NULL,
  `ingreso` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idIngresoMensual`),
  KEY `fk_su_idx` (`idSucursal`),
  CONSTRAINT `fk_su` FOREIGN KEY (`idSucursal`) REFERENCES `sucursales` (`idsucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresosmensuales`
--

LOCK TABLES `ingresosmensuales` WRITE;
/*!40000 ALTER TABLE `ingresosmensuales` DISABLE KEYS */;
INSERT INTO `ingresosmensuales` VALUES (5,2,11,2018,999.99),(6,1,12,2011,999.99),(7,3,12,2018,999.99),(8,3,75,2018,999.99),(9,1,3,2009,333.33),(10,1,1,2008,96673.87);
/*!40000 ALTER TABLE `ingresosmensuales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planillas`
--

DROP TABLE IF EXISTS `planillas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `planillas` (
  `idplanillas` int(11) NOT NULL AUTO_INCREMENT,
  `fechaInicio` date DEFAULT NULL,
  `fechaFin` date DEFAULT NULL,
  `estado` varchar(10) DEFAULT NULL,
  `tipoPlanilla` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idplanillas`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planillas`
--

LOCK TABLES `planillas` WRITE;
/*!40000 ALTER TABLE `planillas` DISABLE KEYS */;
INSERT INTO `planillas` VALUES (1,'2018-11-03','2018-11-03','abierto','sc'),(2,'2018-11-14','2018-12-21','Aperturada','Semanal'),(3,'2018-11-09','2018-11-16','ñ-liuh','ñluhb'),(4,'2018-11-08','2018-11-30','Aperturada','Mensual'),(7,'2018-11-23','2018-11-28','Cerrada','Anual'),(8,'2018-11-07','2018-11-15','PS4','hola'),(9,'2018-11-23','2018-11-28','PS4','Wii U'),(13,'2018-11-15','2018-11-10','Cerrada','Quinsenal'),(14,'2018-11-15','2018-11-15','Aperturada','Quinsenal'),(15,'2018-11-14','2018-12-21','Aperturada','Quinsenal'),(16,'2018-10-09','2019-03-09','Cerrada','Mensual');
/*!40000 ALTER TABLE `planillas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sucursales`
--

DROP TABLE IF EXISTS `sucursales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `sucursales` (
  `idSucursal` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `encargado` int(11) DEFAULT NULL,
  `idempresa` int(11) DEFAULT NULL,
  `latitud` double DEFAULT NULL,
  `longitud` double DEFAULT NULL,
  `image` mediumblob,
  PRIMARY KEY (`idSucursal`),
  KEY `fk4_idx` (`idempresa`),
  KEY `fk8_idx` (`encargado`),
  CONSTRAINT `emple` FOREIGN KEY (`encargado`) REFERENCES `empleados` (`idempleado`),
  CONSTRAINT `fk4` FOREIGN KEY (`idempresa`) REFERENCES `empresas` (`idempresa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursales`
--

LOCK TABLES `sucursales` WRITE;
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
INSERT INTO `sucursales` VALUES (1,'fran','kjhga','lnhkj',1,1,NULL,NULL,NULL),(2,'fd','vf','af',1,1,NULL,NULL,NULL),(3,'Las Juaquinas','Apopa','2545-8754',1,1,NULL,NULL,NULL),(4,'Ciudad Delgado','Ciudad Delgado','8695-4744',1,1,NULL,NULL,NULL),(5,'Reparaciones Jeremy','Aqui','8754-5123',1,3,NULL,NULL,NULL);
/*!40000 ALTER TABLE `sucursales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuarios` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(20) DEFAULT NULL,
  `apellidos` varchar(20) DEFAULT NULL,
  `username` varchar(10) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `idempresa` int(11) DEFAULT NULL,
  `password2` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk3_idx` (`idempresa`),
  CONSTRAINT `fk3` FOREIGN KEY (`idempresa`) REFERENCES `empresas` (`idempresa`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'gdfg','sdf','ñh','sdf',1,NULL),(2,'Gerson','Ruiz','Gruiz','gruiz',1,NULL),(3,'df','svd','dsv','ggg',1,'gss'),(4,'gg','gg','gg','ggg',1,'ggg'),(10,'manuel','suarez','man','123456',1,'123456');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-03  8:38:20
