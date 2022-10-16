-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: adverse_reaction
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `adverse_reactions`
--

DROP TABLE IF EXISTS `adverse_reactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adverse_reactions` (
  `id` int NOT NULL AUTO_INCREMENT,
  `report_date` date DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `suspected_drug` varchar(255) DEFAULT NULL,
  `criteria_name` varchar(255) DEFAULT NULL,
  `outcome_name` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `causal_relationship_company` varchar(255) DEFAULT NULL,
  `causal_relationship_reporter` varchar(255) DEFAULT NULL,
  `time_relationship` varchar(255) DEFAULT NULL,
  `withdrawal_result` varchar(255) DEFAULT NULL,
  `reintroduction_result` varchar(255) DEFAULT NULL,
  `other_explanation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adverse_reactions`
--

LOCK TABLES `adverse_reactions` WRITE;
/*!40000 ALTER TABLE `adverse_reactions` DISABLE KEYS */;
INSERT INTO `adverse_reactions` VALUES (1,'2009-10-20','bla','bla','death','death',1,'unclassifiable',NULL,NULL,NULL,NULL,NULL),(2,'2027-09-20','alb','alb','hospitalisation','recovered',2,'unlikely',NULL,NULL,NULL,NULL,NULL),(3,'2022-10-10','oho','hoho','DISABILITY_OR_INCAPACITY','RECOVERED',3,'CONDITIONAL',NULL,NULL,NULL,NULL,NULL),(9,'2022-10-12','hi','bonjorno','LIFE_THREATENING','UNKNOWN',3,'PROBABLE',NULL,NULL,NULL,NULL,NULL),(12,'2022-10-12','afg','afg','CONGENITAL_ANOMALY','UNKNOWN',1,'UNCLASSIFIABLE',NULL,NULL,NULL,NULL,NULL),(13,'2022-10-12','sdf','asdf','DEATH','DEATH',1,'UNCLASSIFIABLE',NULL,NULL,NULL,NULL,NULL),(14,'2022-10-13','sdf','fds','DEATH','DEATH',1,'UNCLASSIFIABLE',NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `adverse_reactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `active` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'bla@bla.com','bla',1),(2,'alb@alb.com','alb',0),(3,'test1@test1.com','test1',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-16 15:57:13
