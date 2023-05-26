CREATE DATABASE  IF NOT EXISTS `tfg` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `tfg`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: tfg
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categorias` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (13,'Categoria1','123456789'),(14,'Categoria2','123456789'),(15,'Categoria3','123456789'),(16,'Categoria4','123456789');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Titulo` varchar(45) DEFAULT NULL,
  `Mensaje` varchar(255) DEFAULT NULL,
  `Puntuacion` int DEFAULT NULL,
  `Productos_Id` int DEFAULT NULL,
  `Usuarios_Id` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `comentarios_ibfk_1` (`Productos_Id`),
  KEY `comentarios_ibfk_2` (`Usuarios_Id`),
  CONSTRAINT `comentarios_ibfk_1` FOREIGN KEY (`Productos_Id`) REFERENCES `productos` (`Id`),
  CONSTRAINT `comentarios_ibfk_2` FOREIGN KEY (`Usuarios_Id`) REFERENCES `usuarios` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (1,NULL,'Excelente producto. Rápido y eficiente.',5,10,21),(2,NULL,'El ordenador es muy potente y cumple con todas mis expectativas.',4,10,22),(3,NULL,'Buena relación calidad-precio. Recomendado.',4,10,23),(4,NULL,'El ordenador es muy silencioso y el envío fue rápido.',4,10,24),(5,NULL,'El diseño del ordenador es elegante y moderno.',5,10,25),(6,NULL,'El producto llegó en perfectas condiciones. Muy satisfecho.',5,10,26),(7,NULL,'aaaaaaaaaaaaaaaaaaaaaaaaaa',10,17,22);
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direcciones`
--

DROP TABLE IF EXISTS `direcciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `direcciones` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Ciudad` varchar(45) NOT NULL,
  `Direccion` varchar(255) NOT NULL,
  `Usuarios_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Direcciones_Usuarios1_idx` (`Usuarios_Id`),
  CONSTRAINT `fk_Direcciones_Usuarios1` FOREIGN KEY (`Usuarios_Id`) REFERENCES `usuarios` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direcciones`
--

LOCK TABLES `direcciones` WRITE;
/*!40000 ALTER TABLE `direcciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `direcciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplares`
--

DROP TABLE IF EXISTS `ejemplares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ejemplares` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Serie` varchar(45) DEFAULT NULL,
  `Venta` date DEFAULT NULL,
  `Compra` date DEFAULT NULL,
  `Unidades` int NOT NULL,
  `Productos_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `NumSerie_UNIQUE` (`Serie`),
  KEY `fk_Ejemplares_Productos1_idx` (`Productos_Id`),
  CONSTRAINT `fk_Ejemplares_Productos1` FOREIGN KEY (`Productos_Id`) REFERENCES `productos` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplares`
--

LOCK TABLES `ejemplares` WRITE;
/*!40000 ALTER TABLE `ejemplares` DISABLE KEYS */;
/*!40000 ALTER TABLE `ejemplares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `facturas`
--

DROP TABLE IF EXISTS `facturas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `facturas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Observaciones` varchar(255) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `Usuarios_Id` int NOT NULL,
  `Direcciones_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Facturas_Usuarios1_idx` (`Usuarios_Id`),
  KEY `fk_Facturas_Direcciones1_idx` (`Direcciones_Id`),
  CONSTRAINT `fk_Facturas_Direcciones1` FOREIGN KEY (`Direcciones_Id`) REFERENCES `direcciones` (`Id`),
  CONSTRAINT `fk_Facturas_Usuarios1` FOREIGN KEY (`Usuarios_Id`) REFERENCES `usuarios` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `facturas`
--

LOCK TABLES `facturas` WRITE;
/*!40000 ALTER TABLE `facturas` DISABLE KEYS */;
/*!40000 ALTER TABLE `facturas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formaspagos`
--

DROP TABLE IF EXISTS `formaspagos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `formaspagos` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Tipo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formaspagos`
--

LOCK TABLES `formaspagos` WRITE;
/*!40000 ALTER TABLE `formaspagos` DISABLE KEYS */;
/*!40000 ALTER TABLE `formaspagos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fpusuarios`
--

DROP TABLE IF EXISTS `fpusuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fpusuarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Datos` varchar(255) DEFAULT NULL,
  `Usuarios_Id` int NOT NULL,
  `Formaspagos_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_F.P.Usuarios_Usuarios1_idx` (`Usuarios_Id`),
  KEY `fk_FormasPagosUsuarios_FormasPagos1_idx` (`Formaspagos_Id`),
  CONSTRAINT `fk_F.P.Usuarios_Usuarios1` FOREIGN KEY (`Usuarios_Id`) REFERENCES `usuarios` (`Id`),
  CONSTRAINT `fk_FormasPagosUsuarios_FormasPagos1` FOREIGN KEY (`Formaspagos_Id`) REFERENCES `formaspagos` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fpusuarios`
--

LOCK TABLES `fpusuarios` WRITE;
/*!40000 ALTER TABLE `fpusuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `fpusuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineasfactura`
--

DROP TABLE IF EXISTS `lineasfactura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineasfactura` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `IVA` double DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Unidades` int DEFAULT NULL,
  `Serie` varchar(45) DEFAULT NULL,
  `Facturas_Id` int NOT NULL,
  `Productos_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_LineasPedidos_Productos1_idx` (`Productos_Id`),
  KEY `fk_LineasPedidos_Facturas1_idx` (`Facturas_Id`),
  CONSTRAINT `fk_LineasPedidos_Facturas1` FOREIGN KEY (`Facturas_Id`) REFERENCES `facturas` (`Id`),
  CONSTRAINT `fk_LineasPedidos_Productos1` FOREIGN KEY (`Productos_Id`) REFERENCES `productos` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineasfactura`
--

LOCK TABLES `lineasfactura` WRITE;
/*!40000 ALTER TABLE `lineasfactura` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineasfactura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lineaspedido`
--

DROP TABLE IF EXISTS `lineaspedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lineaspedido` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Unidades` int DEFAULT NULL,
  `IVA` double DEFAULT NULL,
  `Precio` double DEFAULT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `Pedidos_Id` int NOT NULL,
  `Productos_Id` int NOT NULL,
  `Facturas_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_LineasPedido_Productos1_idx` (`Productos_Id`),
  KEY `fk_LineasPedido_Pedidos1_idx` (`Pedidos_Id`),
  KEY `fk_LineasPedido_Facturas1_idx` (`Facturas_Id`),
  CONSTRAINT `fk_LineasPedido_Facturas1` FOREIGN KEY (`Facturas_Id`) REFERENCES `facturas` (`Id`),
  CONSTRAINT `fk_LineasPedido_Pedidos1` FOREIGN KEY (`Pedidos_Id`) REFERENCES `pedidos` (`Id`),
  CONSTRAINT `fk_LineasPedido_Productos1` FOREIGN KEY (`Productos_Id`) REFERENCES `productos` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lineaspedido`
--

LOCK TABLES `lineaspedido` WRITE;
/*!40000 ALTER TABLE `lineaspedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `lineaspedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `marcas`
--

DROP TABLE IF EXISTS `marcas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `marcas` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Descripcion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `marcas`
--

LOCK TABLES `marcas` WRITE;
/*!40000 ALTER TABLE `marcas` DISABLE KEYS */;
INSERT INTO `marcas` VALUES (17,'Marca1','123456789'),(18,'Marca2','123456789'),(19,'Marca3','123456789'),(20,'Marca4','123456789');
/*!40000 ALTER TABLE `marcas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedidos` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Fechaentrega` date DEFAULT NULL,
  `Usuarios_Id` int NOT NULL,
  `Direcciones_Id` int NOT NULL,
  `Formaspagos_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Pedidos_Usuarios1_idx` (`Usuarios_Id`),
  KEY `fk_Pedidos_Direcciones1_idx` (`Direcciones_Id`),
  KEY `fk_Pedidos_FormasPagos1_idx` (`Formaspagos_Id`),
  CONSTRAINT `fk_Pedidos_Direcciones1` FOREIGN KEY (`Direcciones_Id`) REFERENCES `direcciones` (`Id`),
  CONSTRAINT `fk_Pedidos_FormasPagos1` FOREIGN KEY (`Formaspagos_Id`) REFERENCES `formaspagos` (`Id`),
  CONSTRAINT `fk_Pedidos_Usuarios1` FOREIGN KEY (`Usuarios_Id`) REFERENCES `usuarios` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Precio` double NOT NULL,
  `IVA` double DEFAULT NULL,
  `Descripcion` varchar(1000) DEFAULT NULL,
  `Marcas_Id` int NOT NULL,
  `Categorias_Id` int NOT NULL,
  PRIMARY KEY (`Id`),
  KEY `fk_Productos_Marcas1_idx` (`Marcas_Id`),
  KEY `fk_Productos_Categorias1_idx` (`Categorias_Id`),
  CONSTRAINT `fk_Productos_Categorias1` FOREIGN KEY (`Categorias_Id`) REFERENCES `categorias` (`Id`),
  CONSTRAINT `fk_Productos_Marcas1` FOREIGN KEY (`Marcas_Id`) REFERENCES `marcas` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (9,'Producto1',19.99,21,'123456789',17,13),(10,'Producto2',19.99,21,'123456789',17,13),(11,'Producto3',19.99,21,'123456789',17,13),(12,'Producto4',19.99,21,'123456789',17,13),(13,'Producto5',19.99,21,'123456789',17,13),(14,'Producto6',19.99,21,'123456789',17,13),(15,'Producto7',19.99,21,'123456789',17,13),(16,'Producto8',19.99,21,'123456789',17,13),(17,'Producto9',19.99,21,'123456789',17,13),(18,'Producto10',19.99,21,'123456789',17,13),(19,'Producto11',19.99,21,'123456789',17,13),(20,'Producto12',19.99,21,'123456789',17,13),(21,'Producto13',19.99,21,'123456789',17,13),(22,'Producto14',19.99,21,'123456789',17,13),(23,'Producto15',19.99,21,'123456789',17,13),(24,'Producto16',19.99,21,'123456789',18,14),(25,'Producto17',19.99,21,'123456789',18,14),(26,'Producto18',19.99,21,'123456789',18,14),(27,'Producto19',19.99,21,'123456789',18,14),(28,'Producto20',19.99,21,'123456789',18,14),(29,'Producto21',19.99,21,'123456789',18,14),(30,'Producto22',19.99,21,'123456789',18,14),(31,'Producto23',19.99,21,'123456789',18,14),(32,'Producto24',19.99,21,'123456789',18,14),(33,'Producto25',19.99,21,'123456789',18,14),(34,'Producto26',19.99,21,'123456789',18,14),(35,'Producto27',19.99,21,'123456789',18,14),(36,'Producto28',19.99,21,'123456789',18,14),(37,'Producto29',19.99,21,'123456789',18,14),(38,'Producto30',19.99,21,'123456789',18,14),(39,'Producto31',19.99,21,'123456789',19,15),(40,'Producto32',19.99,21,'123456789',19,15),(41,'Producto33',19.99,21,'123456789',19,15),(42,'Producto34',19.99,21,'123456789',19,15),(43,'Producto35',19.99,21,'123456789',19,15),(44,'Producto36',19.99,21,'123456789',19,15),(45,'Producto37',19.99,21,'123456789',19,15),(46,'Producto38',19.99,21,'123456789',19,15),(47,'Producto39',19.99,21,'123456789',19,15),(48,'Producto40',19.99,21,'123456789',19,15),(49,'Producto41',19.99,21,'123456789',19,15),(50,'Producto42',19.99,21,'123456789',19,15),(51,'Producto43',19.99,21,'123456789',19,15),(52,'Producto44',19.99,21,'123456789',19,15),(53,'Producto45',19.99,21,'123456789',19,15),(54,'Producto41',19.99,21,'123456789',20,16),(55,'Producto42',19.99,21,'123456789',20,16),(56,'Producto43',19.99,21,'123456789',20,16),(57,'Producto44',19.99,21,'123456789',20,16),(58,'Producto45',19.99,21,'123456789',20,16),(59,'Producto46',19.99,21,'123456789',20,16),(60,'Producto47',19.99,21,'123456789',20,16),(61,'Producto48',19.99,21,'123456789',20,16),(62,'Producto49',19.99,21,'123456789',20,16),(63,'Producto50',19.99,21,'123456789',20,16),(64,'Producto',19.99,21,'123456789',19,13),(65,'Producto',19.99,21,'123456789',19,13),(66,'Producto',19.99,21,'123456789',19,14),(67,'Producto',19.99,21,'123456789',19,14),(68,'Producto',19.99,21,'123456789',19,14),(69,'Producto',19.99,21,'123456789',19,15),(70,'Producto',19.99,21,'123456789',19,15),(71,'Producto',19.99,21,'123456789',19,15),(72,'Producto',19.99,21,'123456789',19,16),(73,'Producto',19.99,21,'123456789',19,16),(74,'Producto',19.99,21,'123456789',19,16),(75,'Producto',19.99,21,'123456789',17,16),(76,'Producto',19.99,21,'123456789',17,16),(77,'Producto',19.99,21,'123456789',17,16),(78,'Producto',19.99,21,'123456789',17,15),(79,'Producto',19.99,21,'123456789',17,15),(80,'Producto',19.99,21,'123456789',17,15),(81,'Producto',19.99,21,'123456789',17,14),(82,'Producto',19.99,21,'123456789',17,14),(83,'Producto',19.99,21,'123456789',17,14),(84,'Producto',19.99,21,'123456789',17,13),(85,'Producto',19.99,21,'123456789',17,13),(86,'Producto',19.99,21,'123456789',17,13),(87,'Producto',19.99,21,'123456789',18,13),(88,'Producto',19.99,21,'123456789',18,13),(89,'Producto',19.99,21,'123456789',18,14),(90,'Producto',19.99,21,'123456789',18,14),(91,'Producto',19.99,21,'123456789',18,14),(92,'Producto',19.99,21,'123456789',18,15),(93,'Producto',19.99,21,'123456789',18,15),(94,'Producto',19.99,21,'123456789',18,15),(95,'Producto',19.99,21,'123456789',18,16),(96,'Producto',19.99,21,'123456789',18,16),(97,'Producto',19.99,21,'123456789',18,16),(98,'Producto',19.99,21,'123456789',19,16),(99,'Producto',19.99,21,'123456789',19,14),(100,'Producto',19.99,21,'123456789',20,14),(101,'Producto',19.99,21,'123456789',20,14),(102,'Producto',19.99,21,'123456789',20,14),(103,'Producto',19.99,21,'123456789',20,13),(104,'Producto',19.99,21,'123456789',20,13),(105,'Producto',19.99,21,'123456789',20,13),(106,'Producto',19.99,21,'123456789',20,15),(107,'Producto',19.99,21,'123456789',20,15),(108,'Producto',19.99,21,'123456789',20,15),(109,'Producto',19.99,21,'123456789',20,15);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Rol` varchar(45) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (11,'Rol1'),(12,'Rol2'),(13,'Rol3');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Email` varchar(45) DEFAULT NULL,
  `Telefono` varchar(45) DEFAULT NULL,
  `Password` varchar(1000) DEFAULT NULL,
  `Cesta` varchar(20000) DEFAULT NULL,
  `Roles_Id` int DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `Email_UNIQUE` (`Email`),
  KEY `fk_Usuarios_Roles1_idx` (`Roles_Id`),
  CONSTRAINT `fk_Usuarios_Roles1` FOREIGN KEY (`Roles_Id`) REFERENCES `roles` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (19,'Usuario10','Usuario10@gmail.com','123456789','$2a$08$wVoJfMBnOkaeuKGc181CgOl5zsuR3j8vn3vzS42oX9qqGvyaHDAzK',NULL,11),(21,'Usuario11','Usuario11@gmail.com','123456789','$2a$08$adJ5A0qYNsK7SxnZGiUGEOEB8b0sK9YBIQsHrn3dykFt2ZNqj5BjK',NULL,11),(22,'Usuario12','Usuario12@gmail.com','123456789','$2a$08$apP6JvdSGe84u0rr8iESl.kI9uyV6sGL6uCAGJqFz7tDtFpcy0NwS',NULL,11),(23,'Usuario13','Usuario13@gmail.com','123456789','$2a$08$btPN60B8HDRPXvAaBJEyr.OAr0svmbTZAR34vSnEoxG4Abd32AHn2',NULL,11),(24,'Usuario14','Usuario14@gmail.com','123456789','$2a$08$M0uJGwtjhCMlCpYTOlkyQOn2vcFmTCZ9dxCrGLn/OlvSqW0LX.Gea',NULL,12),(25,'Usuario15','Usuario15@gmail.com','123456789','$2a$08$SwkSKYJIElRSQfygmtDRy.T61qfjkLzdXvgOLBEkxjohbZiUPuyHa',NULL,12),(26,'Usuario16','Usuario16@gmail.com','123456789','$2a$08$B.5HRnUS4./zdRXsLKmvmuUA.w/QoyZerdTzqhjepv/Ik5.dt0K0a',NULL,13),(27,'Javier','javdez32@gmail.com','693018044','$2a$08$hzZdoym16JBIZQnMDXTBNumoyXlI3Fl8XqxCLk/QggI9JmUc7kunO',NULL,NULL);
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

-- Dump completed on 2023-05-24 19:26:16
