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
-- Table structure for table `medicine`
--

DROP TABLE IF EXISTS `medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicine` (
  `medicine_id` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `company_name` varchar(255) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `medicine_name` varchar(255) DEFAULT NULL,
  `price_per_unit` int DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  PRIMARY KEY (`medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicine`
--

LOCK TABLES `medicine` WRITE;
/*!40000 ALTER TABLE `medicine` DISABLE KEYS */;
INSERT INTO `medicine` VALUES (1,'fever','cipla','2022-07-22','benydryl',5,54),(2,'Fever','Paracetmol','2022-12-26','aspirin',2,62),(3,'Fever','Paracetmol','2022-02-02','Dolo650',2,55),(4,'Dermitology','Micro Labs','2021-06-25','Itraconazole',85,0),(6,'Cold','Cipla','2022-02-02','Cold Act',3,136),(7,'Dermitology','Diwis','2022-12-26','colbetasol',110,16),(8,'ANTIBIOTIC','AZICIP','2021-06-25','AZITHROMYCIN',10,0),(9,'ANTIBIOTIC','AZOMYCIN','2023-06-07','AZITHROMYCIN',15,45),(10,'ANTIBIOTIC','CEFASYN','2021-08-08','CEFUROXIME AXETIL',6,190),(12,'ANTIBIOTIC','CEFTAZIDIME','2021-06-25','CEFTAZ',8,78),(13,'ANTIBIOTIC','CEFRAX DS 30 ML','2022-02-02','CEFIXIME IP 50 MG',3,167),(15,'ANTIBIOTIC','CEPHADEX 500','2023-06-07','CEPHALEXIN 500 MG',10,100),(16,'Covid-19','Bharath Biotech','2022-02-02','covaxin',250,50),(17,'Dermitology','MicroSun','2021-12-09','Dexoderm',70,10),(18,'ANTIBIOTIC','CIPMOX 250 R-W 15','2023-06-07','AMOXYCILLIN TRIHYDRATE',5,170),(19,'ANTIBIOTIC','CIPMOX 250 R-W 15','2021-12-09','AMOXYCILLIN TRIHYDRATE I.P. 250MG',9,90),(20,'ANTIBIOTIC','L QUIN 250','2021-06-25','LEVOFLOXACIN HEMIHYDRATE I.P. 250MG',2,125),(21,'Covid-19','Bharath Biotech','2021-12-09','Covisheild',1250,50),(22,'Covid-19','Remedis','2023-06-07','Remedisivar',1250,20);
/*!40000 ALTER TABLE `medicine` ENABLE KEYS */;
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
