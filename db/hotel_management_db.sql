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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `adminemployeeuser` */

insert  into `adminemployeeuser`(`id`,`name`,`email`,`password`,`type`) values 
(1,'Admin hotel','admin@gmail.com','Admin123','admin'),
(2,'First User','user@gmail.com','User123','user'),
(6,'Second User','secondUser@gmail.com','User123','user');

/*Table structure for table `employee_information` */

DROP TABLE IF EXISTS `employee_information`;

CREATE TABLE `employee_information` (
  `employeeId` int(11) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(50) NOT NULL,
  `hotelLicense` varchar(9) NOT NULL,
  `hotelId` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(10) NOT NULL,
  PRIMARY KEY (`employeeId`),
  UNIQUE KEY `UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `employee_information` */

insert  into `employee_information`(`employeeId`,`hotelName`,`hotelLicense`,`hotelId`,`name`,`email`,`password`) values 
(1,'Qwerty Hotel','H00000001',1,'Employee One','employee123@qwerty.com','Qwerty123');

/*Table structure for table `hotel_information` */

DROP TABLE IF EXISTS `hotel_information`;

CREATE TABLE `hotel_information` (
  `hotelId` int(10) NOT NULL AUTO_INCREMENT,
  `hotelName` varchar(50) NOT NULL,
  `licenseNumber` varchar(9) NOT NULL,
  `address` varchar(50) NOT NULL,
  `contactNumber` varchar(10) NOT NULL,
  `imgUrl` varbinary(255) DEFAULT NULL,
  PRIMARY KEY (`hotelId`),
  UNIQUE KEY `UNIQUE` (`licenseNumber`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `hotel_information` */

insert  into `hotel_information`(`hotelId`,`hotelName`,`licenseNumber`,`address`,`contactNumber`,`imgUrl`) values 
(1,'Qwerty Hotel','H00000001','Pune','7654567890','https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789__480.jpg'),
(2,'Taj Hotel','H00000002','Mumbai','7890123456','https://cdn.pixabay.com/photo/2012/11/21/10/24/building-66789__480.jpg');

/*Table structure for table `room_information` */

DROP TABLE IF EXISTS `room_information`;

CREATE TABLE `room_information` (
  `roomId` int(11) NOT NULL AUTO_INCREMENT,
  `hotelLicense` varchar(9) NOT NULL,
  `hotelName` varchar(50) NOT NULL,
  `hotelId` int(11) NOT NULL,
  `roomCount` int(11) NOT NULL,
  `roomType` varchar(10) NOT NULL,
  `roomCapacity` varchar(15) NOT NULL,
  `amount` int(11) NOT NULL,
  `status` varchar(15) NOT NULL,
  PRIMARY KEY (`roomId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `room_information` */

insert  into `room_information`(`roomId`,`hotelLicense`,`hotelName`,`hotelId`,`roomCount`,`roomType`,`roomCapacity`,`amount`,`status`) values 
(1,'H00000001','Qwerty Hotel',1,10,'AC','Single Bed',200,'Available'),
(2,'H00000001','Qwerty Hotel',1,10,'Non-AC','Single Bed',100,'Available');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
