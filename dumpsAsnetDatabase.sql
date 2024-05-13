-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: red_social
-- ------------------------------------------------------
-- Server version	8.0.36

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
-- Table structure for table `friendship`
--

DROP TABLE IF EXISTS `friendship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `friendship` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id_1` int DEFAULT NULL,
  `user_id_2` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk3k1l918srpkjtgxe6gb82ebn` (`user_id_1`),
  KEY `FKl8h2d7sqag2dcnb77kkn72gxh` (`user_id_2`),
  CONSTRAINT `FKk3k1l918srpkjtgxe6gb82ebn` FOREIGN KEY (`user_id_1`) REFERENCES `user` (`id`),
  CONSTRAINT `FKl8h2d7sqag2dcnb77kkn72gxh` FOREIGN KEY (`user_id_2`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `friendship`
--

LOCK TABLES `friendship` WRITE;
/*!40000 ALTER TABLE `friendship` DISABLE KEYS */;
INSERT INTO `friendship` VALUES (1,1,2),(2,1,3);
/*!40000 ALTER TABLE `friendship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `post_type` varchar(31) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `published_at` datetime(6) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `reward_description` varchar(255) DEFAULT NULL,
  `reward_name` varchar(255) DEFAULT NULL,
  `win_description` varchar(255) DEFAULT NULL,
  `win_name` varchar(255) DEFAULT NULL,
  `profile_id` int DEFAULT NULL,
  `reward_id` int DEFAULT NULL,
  `wins_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk5e5q6qsbobb7sst3h99kjr50` (`profile_id`),
  KEY `FK14bun028xtj8w8alcgu8sphx8` (`reward_id`),
  KEY `FKrn9byiw4smmkt89vo379cdk6i` (`wins_id`),
  CONSTRAINT `FK14bun028xtj8w8alcgu8sphx8` FOREIGN KEY (`reward_id`) REFERENCES `rewards` (`id`),
  CONSTRAINT `FKk5e5q6qsbobb7sst3h99kjr50` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`),
  CONSTRAINT `FKrn9byiw4smmkt89vo379cdk6i` FOREIGN KEY (`wins_id`) REFERENCES `wins` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES ('Post',1,'perro',NULL,'eric',NULL,NULL,NULL,NULL,NULL,NULL,NULL),('Post',2,'mundo',NULL,'hola',NULL,NULL,NULL,NULL,1,NULL,NULL),('Post',3,'La gloriosa líder del equipo unicornio',NULL,'Slava Shere',NULL,NULL,NULL,NULL,3,NULL,NULL),('Post',4,'Hoy he vencido en el juego del mentiroso',NULL,'Campeón de Metiroso',NULL,NULL,NULL,NULL,2,NULL,NULL),('Post',5,'Pagarás por tus crimenes Griffith.','2024-05-07 15:36:58.531801','GRIFFITH!',NULL,NULL,NULL,NULL,5,NULL,NULL),('rewards',6,'Gorra fachera','2024-05-07 16:09:03.643091','Gorra',NULL,NULL,NULL,NULL,5,2,NULL),('rewards',7,'Viaje a Tailandia','2024-05-07 16:10:56.482619','Super Viaje',NULL,NULL,NULL,NULL,1,1,NULL),('wins',8,'Recoger Basura','2024-05-07 16:47:51.229498','Reciclaje',NULL,NULL,NULL,NULL,2,NULL,1);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_likes`
--

DROP TABLE IF EXISTS `post_likes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_likes` (
  `profile_id` int NOT NULL,
  `post_id` int NOT NULL,
  KEY `FKmxmoc9p5ndijnsqtvsjcuoxm3` (`post_id`),
  KEY `FK68c6ywl3pt2ahpp579efjx9o0` (`profile_id`),
  CONSTRAINT `FK68c6ywl3pt2ahpp579efjx9o0` FOREIGN KEY (`profile_id`) REFERENCES `profile` (`id`),
  CONSTRAINT `FKmxmoc9p5ndijnsqtvsjcuoxm3` FOREIGN KEY (`post_id`) REFERENCES `post` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_likes`
--

LOCK TABLES `post_likes` WRITE;
/*!40000 ALTER TABLE `post_likes` DISABLE KEYS */;
INSERT INTO `post_likes` VALUES (2,2),(1,4),(2,7),(3,7);
/*!40000 ALTER TABLE `post_likes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profile`
--

DROP TABLE IF EXISTS `profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profile` (
  `id` int NOT NULL AUTO_INCREMENT,
  `lastname` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `profile_image` tinyblob,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profile`
--

LOCK TABLES `profile` WRITE;
/*!40000 ALTER TABLE `profile` DISABLE KEYS */;
INSERT INTO `profile` VALUES (1,'Fernandez','Albert',NULL),(2,'Alcantara','Eric',NULL),(3,'Gomez','Sheherezade',NULL),(5,'Bernabe','Daniel',NULL),(6,'Baeza','David',NULL),(7,'Robles','Sergio',NULL),(8,'Didouh','Sara',NULL),(9,'Millan','Adrian',NULL),(10,'Florensa','Sergi',NULL),(11,'Kebdani ','Mohammed',NULL),(12,'Ladin','Aitor',NULL);
/*!40000 ALTER TABLE `profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rewards`
--

DROP TABLE IF EXISTS `rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rewards` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` text,
  `name` varchar(100) DEFAULT NULL,
  `price_points` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rewards`
--

LOCK TABLES `rewards` WRITE;
/*!40000 ALTER TABLE `rewards` DISABLE KEYS */;
INSERT INTO `rewards` VALUES (1,'Viaje a Tailandia','Super Viaje',99),(2,'Gorra fachera','Gorra',19),(3,'Pin del Fary','Pin',68),(4,'Pin del Fary','Pin',68),(5,'Pin del Fary','Pin',68);
/*!40000 ALTER TABLE `rewards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `points` double DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `id_wins` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7x7nrnhp0k3s3nuo2qdh5xp36` (`id_wins`),
  CONSTRAINT `FK7x7nrnhp0k3s3nuo2qdh5xp36` FOREIGN KEY (`id_wins`) REFERENCES `wins` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'albert.unicornio@gmail.com','12345',0,'albert',NULL),(2,'eric.unicornio@gmail.es','12345',219,'eric',NULL),(3,'shere.unicornio@gmail.com','$2a$10$5EeNAhkcm0xdJV.dVgDkAOR6qQc7ouF8QCSabEQhBPgh.bHuhkz1S',13,'shere',NULL),(4,'user@example.com','$2a$10$fxVmtXliPzkxr9ZUfcECJeroRSJeXWtXsPPGd.o1Xx9hY1hNj8sfS',0,'user',NULL),(5,'dani.unicornio@gmail.com','$2a$10$rnv3tICDx7ILR7znrL/miOo8sN52V/CdrbnP8/fo2oYu8oyYozmsC',131,'dani',NULL),(6,'david.unicornio@gmail.com','12345',0,'david',NULL),(7,'sergio.unicornio@gmail.com','12345',50,'sergio',NULL),(8,'sara.unicornio@gmail.com','12345',100,'sara',NULL),(9,'adri.unicornio@gmail.com','12345',0,'adri',NULL),(10,'sergi.unicornio@gmail.com','12345',0,'sergi',NULL),(11,'moha.unicornio@gmail.com','12345',0,'moha',NULL),(12,'aitor.unicornio@gmail.es','12345',0,'aitor',NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_friends`
--

DROP TABLE IF EXISTS `user_friends`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_friends` (
  `user_id` int NOT NULL,
  `friend_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`friend_id`),
  KEY `FKdsfpy7xu775p69uewav35mqrq` (`friend_id`),
  CONSTRAINT `FK9i7cldnk7cx2g47qex8ovm2ah` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKdsfpy7xu775p69uewav35mqrq` FOREIGN KEY (`friend_id`) REFERENCES `friendship` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_friends`
--

LOCK TABLES `user_friends` WRITE;
/*!40000 ALTER TABLE `user_friends` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_friends` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_reward`
--

DROP TABLE IF EXISTS `user_reward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_reward` (
  `user_id` int NOT NULL,
  `reward_id` int NOT NULL,
  PRIMARY KEY (`user_id`,`reward_id`),
  KEY `FK32afgvp1b8d64llvvu61dd70t` (`reward_id`),
  CONSTRAINT `FK32afgvp1b8d64llvvu61dd70t` FOREIGN KEY (`reward_id`) REFERENCES `rewards` (`id`),
  CONSTRAINT `FKaipr0um0a8q2w6kie0rapkjkv` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_reward`
--

LOCK TABLES `user_reward` WRITE;
/*!40000 ALTER TABLE `user_reward` DISABLE KEYS */;
INSERT INTO `user_reward` VALUES (2,2),(3,2),(5,2),(3,4);
/*!40000 ALTER TABLE `user_reward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_rewards`
--

DROP TABLE IF EXISTS `user_rewards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_rewards` (
  `reward_id` int NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`reward_id`,`user_id`),
  KEY `FKlsnfdvcb0joads5hv1yhju44t` (`user_id`),
  CONSTRAINT `FKj53yk8gtooowu02nlq4isx5dd` FOREIGN KEY (`reward_id`) REFERENCES `rewards` (`id`),
  CONSTRAINT `FKlsnfdvcb0joads5hv1yhju44t` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_rewards`
--

LOCK TABLES `user_rewards` WRITE;
/*!40000 ALTER TABLE `user_rewards` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_rewards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_wins`
--

DROP TABLE IF EXISTS `user_wins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_wins` (
  `user_id` int NOT NULL,
  `wins_id` int NOT NULL,
  `verified` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`user_id`,`wins_id`),
  KEY `FKk7esbqrn4r3kkyd3doncyxkvq` (`wins_id`),
  CONSTRAINT `FKj5cycev3cjrxyiydkquwf1xxy` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKk7esbqrn4r3kkyd3doncyxkvq` FOREIGN KEY (`wins_id`) REFERENCES `wins` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_wins`
--

LOCK TABLES `user_wins` WRITE;
/*!40000 ALTER TABLE `user_wins` DISABLE KEYS */;
INSERT INTO `user_wins` VALUES (2,1,1),(2,2,1),(2,4,1),(3,1,1),(3,2,0),(5,1,0),(5,2,1),(7,1,1),(8,2,1);
/*!40000 ALTER TABLE `user_wins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wins`
--

DROP TABLE IF EXISTS `wins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `wins` (
  `id` int NOT NULL AUTO_INCREMENT,
  `description` text,
  `name` varchar(100) DEFAULT NULL,
  `rewards_points` double DEFAULT NULL,
  `verified` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wins`
--

LOCK TABLES `wins` WRITE;
/*!40000 ALTER TABLE `wins` DISABLE KEYS */;
INSERT INTO `wins` VALUES (1,'Recoger Basura','Reciclaje',50,NULL),(2,'Plantar arbol','Arbol',100,NULL),(4,'Ir a un refugio de animales de voluntario','Voluntariado',69,NULL),(5,NULL,NULL,0,NULL),(6,NULL,NULL,0,NULL);
/*!40000 ALTER TABLE `wins` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-13 15:17:03
