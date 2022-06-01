-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: medical_store_management_system
-- ------------------------------------------------------
-- Server version	8.0.29-0ubuntu0.20.04.3

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
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales` (
  `id` int NOT NULL,
  `amount` int DEFAULT NULL,
  `date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `customer_id` int DEFAULT NULL,
  `medicine_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customer_id` (`customer_id`),
  KEY `medicine_id` (`medicine_id`),
  CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
  CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
INSERT INTO `sales` VALUES (1,2,'2021-06-10',1,1,2),(2,2,'2021-06-10',1,2,3),(3,85,'2021-06-10',1,3,4),(5,5,'2021-06-11',1,1,1),(6,5,'2021-06-11',1,1,1),(7,12,'2021-06-11',4,5,6),(8,220,'2021-06-12',2,5,7),(9,220,'2021-06-12',2,1,7);
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-01  9:16:33
