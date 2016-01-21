-- MySQL dump 10.13  Distrib 5.7.10, for osx10.9 (x86_64)
--
-- Host: localhost    Database: db_restaurant
-- ------------------------------------------------------
-- Server version	5.7.10

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservations` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `reserveDate` date NOT NULL,
  `reserveTime` varchar(25) DEFAULT NULL,
  `noOfPeople` int(11) NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  `tableNo` int(11) DEFAULT NULL,
  `customerName` varchar(75) NOT NULL,
  `customerPhone` varchar(20) NOT NULL,
  `customerEmail` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userId_idx` (`customerName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'2016-01-10','7:30 PM',4,'Done',2,'Ron Richard','999-909-9878','r@sh.com'),(2,'2015-12-28','7:00 PM',6,'closed',2,'Joshua Karnel','333-909-0989',NULL),(3,'2015-11-27','8:15 PM',8,'reserved',6,'Joshua Karnel','333-909-0989','jker@sd.com'),(4,'2016-01-10','8:30 PM',4,'Done',2,'John Groppe','232-898-2828','jg@yah.com'),(5,'2016-01-10','9:00 PM',2,'Active',2,'Eran Lowen','353-898-0909','er@gma.com'),(6,'2016-01-25','8:00 PM',4,'Pending',2,'Dan Garret','676-909-6656','dgarret@yah.com'),(7,'2016-01-28','9:00 PM',6,'Pending',6,'Monica Mancao','343-998-7777',NULL),(8,'2016-01-28','8:00 PM',6,'Pending',4,'Ron Richard','999-909-9878','shk@sh.com'),(9,'2016-01-20','7:00 PM',6,NULL,NULL,'Hritika Dave','898-987-8987',NULL),(10,'2016-01-20','7:30 PM',6,'Reserved',4,'Ronit Sen','879-909-9878','ronit@sh.com'),(11,'2016-01-20','7:30 PM',6,'Reserved',5,'Anushka Patil','229-909-9878','ani@sh.com'),(12,'2016-01-20','7:30 PM',10,'Pending',NULL,'Ankita Rai','337-929-9878','ankita@sh.com');
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `restaurant_profile_settings`
--

DROP TABLE IF EXISTS `restaurant_profile_settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `restaurant_profile_settings` (
  `restId` int(11) NOT NULL AUTO_INCREMENT,
  `restName` varchar(45) DEFAULT NULL,
  `tagLine` varchar(45) DEFAULT NULL,
  `addrLine1` varchar(45) DEFAULT NULL,
  `addrLine2` varchar(45) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `zipCode` varchar(20) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `autoAssign` tinyint(1) DEFAULT NULL,
  `openCloseDetails` varchar(200) DEFAULT NULL,
  `mon` tinyint(1) DEFAULT '0',
  `monStart` varchar(45) DEFAULT NULL,
  `monEnd` varchar(45) DEFAULT NULL,
  `tues` tinyint(1) DEFAULT '0',
  `tuesStart` varchar(45) DEFAULT NULL,
  `tuesEnd` varchar(45) DEFAULT NULL,
  `wed` tinyint(1) DEFAULT '0',
  `wedStart` varchar(45) DEFAULT NULL,
  `wedEnd` varchar(45) DEFAULT NULL,
  `thur` tinyint(1) DEFAULT '0',
  `thurStart` varchar(45) DEFAULT NULL,
  `thurEnd` varchar(45) DEFAULT NULL,
  `fri` tinyint(1) DEFAULT '0',
  `friStart` varchar(45) DEFAULT NULL,
  `friEnd` varchar(45) DEFAULT NULL,
  `sat` tinyint(1) DEFAULT '0',
  `satStart` varchar(45) DEFAULT NULL,
  `satEnd` varchar(45) DEFAULT NULL,
  `sun` tinyint(1) DEFAULT '0',
  `sunStart` varchar(45) DEFAULT NULL,
  `sunEnd` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`restId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `restaurant_profile_settings`
--

LOCK TABLES `restaurant_profile_settings` WRITE;
/*!40000 ALTER TABLE `restaurant_profile_settings` DISABLE KEYS */;
INSERT INTO `restaurant_profile_settings` VALUES (1,'Draksha - Bar & Grill','the sizzling way....','4250 Fox Valley Cente',NULL,'Aurora','IL','60504','998-091-9829','draksha@gmail.com',1,NULL,0,'','',1,'7.00 PM','10.00 PM',1,'7.00 PM','10.00 PM',1,'7.00 PM','10.00 PM',1,'6.00 PM','11.00 PM',1,'12.00 PM','11.00 PM',1,'12.00 PM','11.00 PM');
/*!40000 ALTER TABLE `restaurant_profile_settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `table_details`
--

DROP TABLE IF EXISTS `table_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `table_details` (
  `table_id` int(11) NOT NULL,
  `capacity` int(11) DEFAULT NULL,
  PRIMARY KEY (`table_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `table_details`
--

LOCK TABLES `table_details` WRITE;
/*!40000 ALTER TABLE `table_details` DISABLE KEYS */;
INSERT INTO `table_details` VALUES (1,2),(2,4),(3,4),(4,6),(5,6),(6,8),(7,8),(8,2),(9,4),(10,6);
/*!40000 ALTER TABLE `table_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `timings`
--

DROP TABLE IF EXISTS `timings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `timings` (
  `day` varchar(10) NOT NULL,
  `open` tinyint(1) DEFAULT NULL,
  `startTime` time(1) DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  PRIMARY KEY (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `timings`
--

LOCK TABLES `timings` WRITE;
/*!40000 ALTER TABLE `timings` DISABLE KEYS */;
/*!40000 ALTER TABLE `timings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(30) DEFAULT NULL,
  `lastName` varchar(30) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `address` varchar(80) DEFAULT NULL,
  `userType` varchar(20) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'shama','bhosale','388-090-9889','sk@y.com',NULL,'owner','owner'),(2,'Jessie','Buck','776-098-9121','jb@yahoo.com',NULL,'customer',NULL),(3,'John','Groppe','123-323-3343','jgroppe@yahoo.com',NULL,'customer',NULL),(4,'Ron','Richards','454-5676-9087','rrichard@mac.com',NULL,'customer',NULL),(5,'Krista','Burndine','898-333-2322',NULL,NULL,'customer',NULL),(6,NULL,NULL,NULL,NULL,NULL,'customer',NULL),(7,'shama','bhosale','388-090-9889','sk@hjd.com',NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-01-20 10:07:42
