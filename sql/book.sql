/*
SQLyog v10.2 
MySQL - 8.0.19 : Database - book
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `author` varchar(100) DEFAULT NULL,
  `sales` int DEFAULT NULL,
  `stock` int DEFAULT NULL,
  `img_path` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`name`,`price`,`author`,`sales`,`stock`,`img_path`) values (1,'海贼王','18.80','尾田荣一郎',9999,100000,'static/img/op.jpg'),(2,'BLEACH','18.80','久保带人',5000,50000,'static/img/bleach.jpg'),(3,'Riddle Joker','99.00','Yuzusoft',2018,9999,'static/img/Riddle_Joker.jpg'),(4,'辉夜大小姐想让我告白','99.00','赤坂アカ',99999,50,'static/img/kaguya.jpg'),(5,'鬼灭之刃','18.80','吾峠呼世晴',14,95,'static/img/guimie.jpg'),(6,'福尔摩斯探案集','9.90','柯南道尔',12,53,'static/img/default.jpg'),(7,'乌兹，永远的神！','21.00','乌兹',21,6,'static/img/default.jpg'),(8,'Java编程思想','99.50','Eckel',47,36,'static/img/default.jpg'),(11,'C语言程序设计','28.00','谭浩强',52,74,'static/img/default.jpg'),(13,'西游记','12.00','罗贯中',19,9999,'static/img/default.jpg'),(14,'水浒传','33.05','施耐庵',22,88,'static/img/default.jpg'),(15,'操作系统原理','133.05','刘优',122,188,'static/img/default.jpg'),(17,'UNIX高级环境编程','99.15','乐天',210,810,'static/img/default.jpg'),(18,'javaScript高级编程','69.15','马老师',210,810,'static/img/default.jpg'),(19,'OK起飞','89.15','大司',20,10,'static/img/default.jpg'),(20,'李在赣神魔','88.15','大司',20,80,'static/img/default.jpg'),(27,'星光咖啡馆与死神之蝶','99.00','yuzusoft',9999,1,'static/img/cafe.jpg'),(29,'美少女万华镜','99.00','ωstar',9999,9999,'static/img/default.jpg'),(30,'1','1.00','1',1,1,'static/img/default.jpg'),(31,'2','2.00','2',2,2,'static/img/default.jpg'),(33,'进击的巨人','18.80','谏山创',9999,9999,'static/img/default.jpg'),(34,'挪威的森林','29.80','村上春树',9999,9999,'static/img/default.jpg'),(35,'1Q84','99.00','村上春树',9990,1000,'static/img/default.jpg');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(32) NOT NULL,
  `email` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`) values (1,'admin','admin','admin@atguigu.com'),(2,'frenkie','123456','15059347956@163.com'),(3,'Dejong','123456','123456@123.com'),(4,'frenkie1','123456','123@456.com'),(5,'Messi','123456','15059347956@163.com'),(6,'Messi10','123456','15059347956@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
USE book;

CREATE TABLE t_order(
	`order_id` VARCHAR(50) PRIMARY KEY,
	`create_time` DATETIME,
	`price` DECIMAL(11,2),
	`status` INT,
	`user_id` INT,
	FOREIGN KEY(`user_id`) REFERENCES t_user(`id`)
);

CREATE TABLE t_order_item(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(100),
	`count` INT,
	`price` DECIMAL(11,2),
	`total_price` DECIMAL(11,2),
	`order_id` VARCHAR(50),
	FOREIGN KEY(`order_id`) REFERENCES t_order(`order_id`)
);