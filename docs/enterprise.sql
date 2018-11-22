-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: enterprisesystem
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleplanillas`
--

LOCK TABLES `detalleplanillas` WRITE;
/*!40000 ALTER TABLE `detalleplanillas` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresas`
--

LOCK TABLES `empresas` WRITE;
/*!40000 ALTER TABLE `empresas` DISABLE KEYS */;
INSERT INTO `empresas` VALUES (1,'VHR','1013-091189-101-7','San Marcos, San Salvador','2222-2222','vhr@vhr.com.sv'),(2,'dsf','fdsf','fsdf','dfsf','fds');
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
  `mes` varchar(45) DEFAULT NULL,
  `anio` int(11) DEFAULT NULL,
  `ingreso` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`idIngresoMensual`),
  KEY `fk_su_idx` (`idSucursal`),
  CONSTRAINT `fk_su` FOREIGN KEY (`idSucursal`) REFERENCES `sucursales` (`idsucursal`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresosmensuales`
--

LOCK TABLES `ingresosmensuales` WRITE;
/*!40000 ALTER TABLE `ingresosmensuales` DISABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planillas`
--

LOCK TABLES `planillas` WRITE;
/*!40000 ALTER TABLE `planillas` DISABLE KEYS */;
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
  `giro` varchar(20) DEFAULT NULL,
  `idempresa` int(11) DEFAULT NULL,
  PRIMARY KEY (`idSucursal`),
  KEY `fk4_idx` (`idempresa`),
  CONSTRAINT `fk4` FOREIGN KEY (`idempresa`) REFERENCES `empresas` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursales`
--

LOCK TABLES `sucursales` WRITE;
/*!40000 ALTER TABLE `sucursales` DISABLE KEYS */;
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
  PRIMARY KEY (`idusuario`),
  KEY `fk3_idx` (`idempresa`),
  CONSTRAINT `fk3` FOREIGN KEY (`idempresa`) REFERENCES `empresas` (`idempresa`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
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

-- Dump completed on 2018-11-22 14:29:53
