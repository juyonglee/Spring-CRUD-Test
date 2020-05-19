# ************************************************************
# Sequel Pro SQL dump
# Version 4541
#
# http://www.sequelpro.com/
# https://github.com/sequelpro/sequelpro
#
# Host: 127.0.0.1 (MySQL 5.5.5-10.4.13-MariaDB-1:10.4.13+maria~bionic)
# Database: NSHC
# Generation Time: 2020-05-18 14:06:02 +0000
# ************************************************************


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table tbl_board
# ------------------------------------------------------------

DROP TABLE IF EXISTS `tbl_board`;

CREATE TABLE `tbl_board` (
  `bno` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '',
  `content` varchar(2000) NOT NULL DEFAULT '',
  `writer` varchar(50) NOT NULL DEFAULT '',
  `regdate` datetime DEFAULT current_timestamp(),
  `updatedate` datetime DEFAULT current_timestamp(),
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `tbl_board` WRITE;
/*!40000 ALTER TABLE `tbl_board` DISABLE KEYS */;

INSERT INTO `tbl_board` (`bno`, `title`, `content`, `writer`, `regdate`, `updatedate`)
VALUES
	(1,'코로나19','게이새끼들','XXX','2020-05-18 12:29:25','2020-05-18 12:29:25'),
	(2,'코로나19 이태원','개새끼들','이태원','2020-05-18 12:30:13','2020-05-18 12:30:13'),
	(3,'코로나19 홍대','개새끼들','홍대','2020-05-18 12:30:23','2020-05-18 12:30:23'),
	(4,'CRUD 테스트입니다.','CRUD XX 같구먼!!!','Tony','2020-05-18 12:45:36','2020-05-18 12:45:36'),
	(5,'CRUD 테스트입니다.','CRUD ...','Jone','2020-05-18 12:59:44','2020-05-18 12:59:44'),
	(6,'Test','Service Test','Juyong Lee','2020-05-18 13:14:13','2020-05-18 13:14:13'),
	(7,'Test','Service Test','JYL','2020-05-18 13:16:49','2020-05-18 13:16:49'),
	(8,'Hello','CRUD Test....','JYL','2020-05-18 13:19:47','2020-05-18 14:01:41');

/*!40000 ALTER TABLE `tbl_board` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
