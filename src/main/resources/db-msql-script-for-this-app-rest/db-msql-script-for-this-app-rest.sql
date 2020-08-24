-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: spring_rest_praksa
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created` date DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `description` varchar(2048) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `zone_id` varchar(128) DEFAULT NULL,
  `started` int DEFAULT NULL,
  `organizer_id` int DEFAULT NULL,
  `venue_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `venue_id_idx` (`venue_id`),
  KEY `organizer_id_idx` (`organizer_id`),
  CONSTRAINT `organizer_id` FOREIGN KEY (`organizer_id`) REFERENCES `organizer` (`id`),
  CONSTRAINT `venue_id` FOREIGN KEY (`venue_id`) REFERENCES `venue` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'2020-03-22','it conference','meeting it world','2020-03-22','2020-03-23','Europe',5,1,1),(2,'2020-03-23','meeting','catch up','2020-03-23','2020-03-24','Europe',5,2,2),(3,'2020-03-24','solutions','some ideas','2020-03-24','2020-03-25','Europe',5,3,3),(4,'2020-05-06','proba','proba','2020-05-06','2020-05-07','Europe',5,4,1),(23,'2020-05-11','it conference','proba1','2020-05-06','2020-05-07','Europe',5,5,2);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event_list_participant`
--

DROP TABLE IF EXISTS `event_list_participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `event_list_participant` (
  `event_id` int NOT NULL,
  `list_participant_id` int NOT NULL,
  UNIQUE KEY `UK_aqt641f0v0jnmbbu3pcyjp237` (`list_participant_id`),
  KEY `FKhy7qen2k2m4y81l55xjkvjqvk` (`event_id`),
  CONSTRAINT `FKauj5h1g75e1teikc5n8hwu2vb` FOREIGN KEY (`list_participant_id`) REFERENCES `participant` (`id`),
  CONSTRAINT `FKhy7qen2k2m4y81l55xjkvjqvk` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event_list_participant`
--

LOCK TABLES `event_list_participant` WRITE;
/*!40000 ALTER TABLE `event_list_participant` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_list_participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log_event`
--

DROP TABLE IF EXISTS `log_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `log_event` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `date_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log_event`
--

LOCK TABLES `log_event` WRITE;
/*!40000 ALTER TABLE `log_event` DISABLE KEYS */;
INSERT INTO `log_event` VALUES (1,'user has added new organizer','add new','successful','2020-05-05 19:32:55'),(2,'user has added new organizer','add new','successful','2020-05-05 19:33:31'),(3,'user has added new organizer','add new','successful','2020-05-06 01:54:50'),(4,'user has added new organizer','add new','successful','2020-05-06 01:54:50'),(5,'user has added new organizer','add new','successful','2020-05-06 02:13:02'),(6,'user has added new organizer','add new','successful','2020-05-06 12:47:10'),(7,'user has added new event','add new','successful','2020-05-06 14:46:55'),(8,'user has added new event','add new','successful','2020-05-06 14:50:40'),(9,'user has added new event','add new','successful','2020-05-06 14:53:15'),(10,'user has added new event','add new','successful','2020-05-06 14:58:35'),(11,'user has added new event','add new','successful','2020-05-06 14:59:00'),(12,'user has added new event','add new','successful','2020-05-06 14:59:45'),(13,'user has added new event','add new','successful','2020-05-06 15:02:01'),(14,'user has added new event','add new','successful','2020-05-06 15:02:29'),(15,'user has added new event','add new','successful','2020-05-06 15:03:00'),(16,'user has added new event','add new','successful','2020-05-06 15:05:15'),(17,'user has added new participant','add new','successful','2020-05-06 15:17:18'),(18,'user has added new venue','add new','successful','2020-05-06 15:30:32'),(19,'user has added new event','add new','successful','2020-05-07 13:53:02'),(20,'user has added new event','add new','successful','2020-05-07 13:57:21'),(21,'user has added new event','add new','successful','2020-05-07 14:00:46'),(22,'user has added new event','add new','successful','2020-05-07 14:06:52'),(23,'user has added new event','add new','failed','2020-05-10 23:44:37'),(24,'user has added new event','add new','failed','2020-05-11 16:16:25'),(25,'user has added new event','add new','failed','2020-05-11 16:28:40'),(26,'user has added new event','add new','failed','2020-05-11 16:36:38'),(27,'user has added new event','add new','failed','2020-05-11 16:38:22'),(28,'user has added new event','add new','failed','2020-05-11 16:39:53'),(29,'user has added new event','add new','failed','2020-05-11 16:40:30'),(30,'user has added new event','add new','failed','2020-05-11 18:09:40'),(31,'user has added new event','add new','failed','2020-05-11 18:29:44'),(32,'user has added new event','add new','successful','2020-05-11 18:30:45');
/*!40000 ALTER TABLE `log_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer`
--

DROP TABLE IF EXISTS `organizer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `created` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer`
--

LOCK TABLES `organizer` WRITE;
/*!40000 ALTER TABLE `organizer` DISABLE KEYS */;
INSERT INTO `organizer` VALUES (1,'no name 1 a.d.','2020-03-20'),(2,'no name 2 a.d.','2020-03-25'),(3,'no name 3 a.d.','2020-03-30'),(4,'proba1','2020-05-05'),(5,'proba2','2020-05-05'),(6,'proba3','2020-05-05'),(7,'proba4','2020-05-05'),(8,'proba5','2020-05-05');
/*!40000 ALTER TABLE `organizer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organizer_event`
--

DROP TABLE IF EXISTS `organizer_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `organizer_event` (
  `organizer_id` int NOT NULL,
  `event_id` int NOT NULL,
  UNIQUE KEY `UK_pj5p6p9gek9hafntja28pvkfo` (`event_id`),
  KEY `FKkdsti1eiifdrlsqpvggids60t` (`organizer_id`),
  CONSTRAINT `FKahm04s3405fqypp312k99go8n` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `FKkdsti1eiifdrlsqpvggids60t` FOREIGN KEY (`organizer_id`) REFERENCES `organizer` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organizer_event`
--

LOCK TABLES `organizer_event` WRITE;
/*!40000 ALTER TABLE `organizer_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `organizer_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participant`
--

DROP TABLE IF EXISTS `participant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `email` varchar(256) DEFAULT NULL,
  `checked_in` int DEFAULT NULL,
  `event_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKojeqkvv72xcx0ytdqkik7objq` (`event_id`),
  CONSTRAINT `FKojeqkvv72xcx0ytdqkik7objq` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participant`
--

LOCK TABLES `participant` WRITE;
/*!40000 ALTER TABLE `participant` DISABLE KEYS */;
INSERT INTO `participant` VALUES (1,'Milan','milan@gmail.com',1,1),(2,'Stevan',NULL,1,1),(3,'Antonije','antonije@gmail.com',1,2),(4,'Sava','sava@gmail.com',0,3),(5,'Ostoja','ostoja@gmail.com',1,3),(6,'proba','proba@gmail.com',1,1),(7,'proba1','proba@gmail.com',1,1);
/*!40000 ALTER TABLE `participant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venue`
--

DROP TABLE IF EXISTS `venue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venue` (
  `id` int NOT NULL AUTO_INCREMENT,
  `created` date DEFAULT NULL,
  `name` varchar(256) DEFAULT NULL,
  `street_address` varchar(256) DEFAULT NULL,
  `street_address2` varchar(256) DEFAULT NULL,
  `city` varchar(256) DEFAULT NULL,
  `country` varchar(256) DEFAULT NULL,
  `postal_code` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venue`
--

LOCK TABLES `venue` WRITE;
/*!40000 ALTER TABLE `venue` DISABLE KEYS */;
INSERT INTO `venue` VALUES (1,'2020-03-22','arena','Beogradska 12','no name 1','Beograd','Srbija','11000'),(2,'2020-03-26','pionir','Beogradska 15','no name 2','Beograd','Srbija','11000'),(3,'2020-03-27','arena','Beogradska 12','no name 3','Beograd','Srbija','11000'),(4,'2020-05-06','proba','proba','no name proba','Beograd','Srbija','11000'),(5,'2020-05-06','proba1','proba1','no name proba','Beograd','Srbija','11000');
/*!40000 ALTER TABLE `venue` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-08-24 17:15:09
