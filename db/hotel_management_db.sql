/*
SQLyog Trial v13.1.5  (64 bit)
MySQL - 5.5.27 : Database - hotel_management_system
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel_management_system` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `hotel_management_system`;

/*Table structure for table `adminemployeeuser` */

DROP TABLE IF EXISTS `adminemployeeuser`;

CREATE TABLE `adminemployeeuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(11) NOT NULL,
  `type` varchar(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `adminemployeeuser` */

insert  into `adminemployeeuser`(`id`,`name`,`email`,`password`,`type`) values 
(1,'Admin hotel','admin@gmail.com','Admin123','admin'),
(2,'First User','user@gmail.com','User123','user');

/*Table structure for table `hotel_information` */

DROP TABLE IF EXISTS `hotel_information`;

CREATE TABLE `hotel_information` (
  `hotelId` int(10) NOT NULL,
  `hotelName` varchar(50) NOT NULL,
  `licenseNumber` varchar(9) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contactNumber` int(10) NOT NULL,
  PRIMARY KEY (`hotelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hotel_information` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
