-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: cis175.cdw3fjnwfjyt.us-east-2.rds.amazonaws.com    Database: votingbooth
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `affiliations`
--

DROP TABLE IF EXISTS `affiliations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `affiliations` (
  `AFFILIATION_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AFFILIATION_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`AFFILIATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affiliations`
--

LOCK TABLES `affiliations` WRITE;
/*!40000 ALTER TABLE `affiliations` DISABLE KEYS */;
INSERT INTO `affiliations` VALUES (18,'Democrat'),(19,'Republican'),(20,'Independent');
/*!40000 ALTER TABLE `affiliations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate_affiliations`
--

DROP TABLE IF EXISTS `candidate_affiliations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate_affiliations` (
  `CANDIDATE_ID` int(11) NOT NULL,
  `AFFILIATION_ID` int(11) NOT NULL,
  KEY `AFFILIATION_ID` (`AFFILIATION_ID`),
  KEY `CANDIDATE_ID` (`CANDIDATE_ID`),
  CONSTRAINT `candidate_affiliations_ibfk_1` FOREIGN KEY (`AFFILIATION_ID`) REFERENCES `affiliations` (`AFFILIATION_ID`),
  CONSTRAINT `candidate_affiliations_ibfk_2` FOREIGN KEY (`CANDIDATE_ID`) REFERENCES `candidates` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate_affiliations`
--

LOCK TABLES `candidate_affiliations` WRITE;
/*!40000 ALTER TABLE `candidate_affiliations` DISABLE KEYS */;
INSERT INTO `candidate_affiliations` VALUES (34,19),(36,20),(38,18),(39,18);
/*!40000 ALTER TABLE `candidate_affiliations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidates`
--

DROP TABLE IF EXISTS `candidates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidates` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) NOT NULL,
  `VOTES` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidates`
--

LOCK TABLES `candidates` WRITE;
/*!40000 ALTER TABLE `candidates` DISABLE KEYS */;
INSERT INTO `candidates` VALUES (34,'Donald Trump',2),(36,'Jill Stein',1),(38,'Bernie Sanders',1),(39,'Joe Biden',1);
/*!40000 ALTER TABLE `candidates` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voters`
--

DROP TABLE IF EXISTS `voters`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `voters` (
  `VOTER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LAST_NAME` varchar(30) DEFAULT NULL,
  `FIRST_NAME` varchar(30) DEFAULT NULL,
  `AFFILIATION_ID` int(11) DEFAULT NULL,
  `REGISTRATION_DATE` date DEFAULT NULL,
  PRIMARY KEY (`VOTER_ID`),
  KEY `AFFILIATION_ID` (`AFFILIATION_ID`),
  CONSTRAINT `voters_ibfk_1` FOREIGN KEY (`AFFILIATION_ID`) REFERENCES `affiliations` (`AFFILIATION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voters`
--

LOCK TABLES `voters` WRITE;
/*!40000 ALTER TABLE `voters` DISABLE KEYS */;
INSERT INTO `voters` VALUES (12,'Plumbington','John',19,'2020-02-27'),(13,'Anthony','Mary',20,'2020-02-27'),(14,'Sidie','Wade',18,'2020-02-27'),(15,'Hayes','Zachary',18,'2020-02-27');
/*!40000 ALTER TABLE `voters` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 21:50:51
