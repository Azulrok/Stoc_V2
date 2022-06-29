-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: stoc
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documento` (
  `id_documento` int NOT NULL AUTO_INCREMENT,
  `descricao` varchar(455) NOT NULL,
  PRIMARY KEY (`id_documento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id_fornecedor` int NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `nome` varchar(455) NOT NULL,
  `email` varchar(455) NOT NULL,
  `empresa` varchar(455) NOT NULL,
  PRIMARY KEY (`id_fornecedor`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (6,965993568,'eduardo','eduardomoraes@bratec.com','bratec'),(7,965993568,'Guilherme Neves','guilhermeneves@nubank.com','Nubank'),(8,940028922,'Davi Santana','davisantana@suselinux.org','SUSE Linux Enterprise');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int NOT NULL AUTO_INCREMENT,
  `cpf_funcionario` int NOT NULL,
  `tipo_funcionario` varchar(45) NOT NULL,
  `nome_funcionario` varchar(45) NOT NULL,
  `email_funcionario` varchar(45) NOT NULL,
  `senha_funcionario` varchar(455) NOT NULL,
  PRIMARY KEY (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `id_item` int NOT NULL AUTO_INCREMENT,
  `quantidade_min` int NOT NULL,
  `descricao` varchar(455) NOT NULL,
  `localizar` varchar(455) NOT NULL,
  `nome` varchar(455) NOT NULL,
  PRIMARY KEY (`id_item`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (4,86,'Pilhas recarregáveis padrão AA','Balcão A02','Pilhas Recarregáveis AA'),(5,120,'Pendrives de 64gb Kingston','Balcão B21','Pendrive 64gb'),(6,20,'Caderno Paper C','Balcão B22','Caderno Paper');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movimentacao`
--

DROP TABLE IF EXISTS `movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movimentacao` (
  `id_movimentacao` int NOT NULL AUTO_INCREMENT,
  `id_item` int NOT NULL,
  `quantidade` int NOT NULL,
  `data_cadastro` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_tipo_movimentacao` int NOT NULL,
  `id_setor` int NOT NULL,
  PRIMARY KEY (`id_movimentacao`),
  KEY `fk_id_tipo_movimentacao_idx` (`id_tipo_movimentacao`),
  KEY `fk_id_setor_idx` (`id_setor`),
  KEY `fk_id_item_idx` (`id_item`),
  CONSTRAINT `fk_id_item` FOREIGN KEY (`id_item`) REFERENCES `item` (`id_item`),
  CONSTRAINT `fk_id_setor` FOREIGN KEY (`id_setor`) REFERENCES `setor` (`id_setor`),
  CONSTRAINT `fk_id_tipo_movimentacao` FOREIGN KEY (`id_tipo_movimentacao`) REFERENCES `tipo_movimentacao` (`id_tipo_movimentacao`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movimentacao`
--

LOCK TABLES `movimentacao` WRITE;
/*!40000 ALTER TABLE `movimentacao` DISABLE KEYS */;
INSERT INTO `movimentacao` VALUES (1,4,1,'2022-06-23 20:32:25',1,1),(2,4,1,'2022-06-23 20:32:25',1,1),(3,4,1,'2022-06-23 20:32:25',1,1),(4,5,1,'2022-06-23 20:32:25',1,1),(5,5,1,'2022-06-23 20:32:25',1,1),(6,5,1,'2022-06-23 20:32:25',1,1),(7,5,5,NULL,2,1);
/*!40000 ALTER TABLE `movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `id_pedido` int NOT NULL AUTO_INCREMENT,
  `cod_cliente` varchar(45) NOT NULL,
  `cod_funcionario` varchar(45) NOT NULL,
  `cod_categoria` varchar(45) NOT NULL,
  `cod_item` varchar(45) NOT NULL,
  `cod_subcategoria` varchar(45) NOT NULL,
  PRIMARY KEY (`id_pedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permissao`
--

DROP TABLE IF EXISTS `permissao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permissao` (
  `id_permissao` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(455) NOT NULL,
  PRIMARY KEY (`id_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permissao`
--

LOCK TABLES `permissao` WRITE;
/*!40000 ALTER TABLE `permissao` DISABLE KEYS */;
INSERT INTO `permissao` VALUES (1,'ROLE_ALMOXARIFE'),(2,'ROLE_ADMINISTRADOR');
/*!40000 ALTER TABLE `permissao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setor`
--

DROP TABLE IF EXISTS `setor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `setor` (
  `id_setor` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_setor`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setor`
--

LOCK TABLES `setor` WRITE;
/*!40000 ALTER TABLE `setor` DISABLE KEYS */;
INSERT INTO `setor` VALUES (1,'TI'),(2,'Radares');
/*!40000 ALTER TABLE `setor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_movimentacao`
--

DROP TABLE IF EXISTS `tipo_movimentacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_movimentacao` (
  `id_tipo_movimentacao` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_movimentacao`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_movimentacao`
--

LOCK TABLES `tipo_movimentacao` WRITE;
/*!40000 ALTER TABLE `tipo_movimentacao` DISABLE KEYS */;
INSERT INTO `tipo_movimentacao` VALUES (1,'Entrada'),(2,'Saída');
/*!40000 ALTER TABLE `tipo_movimentacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `cpf` varchar(11) NOT NULL,
  `email` varchar(455) NOT NULL,
  `senha` varchar(455) DEFAULT NULL,
  `nome` varchar(455) NOT NULL,
  `sexo` varchar(45) NOT NULL,
  `quantidade_min` int NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'11111111111','edvaldo1239@gmail.com','$2a$10$WIOihzAik6/T6fBsIl5y0OhmBBEqXMfU0styMTj5KIJ2TZwwfriyu','Edvaldo','Masculino',0),(2,'22222222222','davi.lourenco@aluno.etejk.faetec.rj.gov.br','$2a$10$WIOihzAik6/T6fBsIl5y0OhmBBEqXMfU0styMTj5KIJ2TZwwfriyu','Davi','Masculino',0),(11,'11111111113','eduardomoraes@bratecnicas.com','$2a$10$WIOihzAik6/T6fBsIl5y0OhmBBEqXMfU0styMTj5KIJ2TZwwfriyu','Eduardo ','Masculino',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios_permissoes`
--

DROP TABLE IF EXISTS `usuarios_permissoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios_permissoes` (
  `id_usuario_permissao` int NOT NULL AUTO_INCREMENT,
  `usuarios_id_usuario` int NOT NULL,
  `permissoes_id_permissao` int NOT NULL,
  PRIMARY KEY (`id_usuario_permissao`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios_permissoes`
--

LOCK TABLES `usuarios_permissoes` WRITE;
/*!40000 ALTER TABLE `usuarios_permissoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios_permissoes` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-28 21:39:18
