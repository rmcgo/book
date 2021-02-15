/*
SQLyog Ultimate v12.14 (64 bit)
MySQL - 5.7.19 : Database - book
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `book`;

/*Table structure for table `t_book` */

DROP TABLE IF EXISTS `t_book`;

CREATE TABLE `t_book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `price` decimal(11,2) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_book` */

insert  into `t_book`(`id`,`name`,`author`,`price`,`sales`,`stock`,`img_path`) values 
(1,'java','rmc','80.00',10026,17,'static/img/java.jpg'),
(3,'c++','hkf','68.00',100023,28,'static/img/c++.jpg'),
(4,'JS','ljf','16.00',1018,32,'static/img/JS.jpg'),
(5,'vue','psh','45.50',22,87,'static/img/vue.jpg'),
(6,'蛋炒饭','周星星','9.90',12,53,'static/img/default.jpg'),
(7,'赌神','龙伍','66.50',125,535,'static/img/default.jpg'),
(8,'Java编程思想','阳哥','99.50',47,36,'static/img/default.jpg'),
(9,'JavaScript从入门到精通','婷姐','9.90',85,95,'static/img/default.jpg'),
(10,'cocos2d-x游戏编程入门','国哥','49.00',52,62,'static/img/default.jpg'),
(11,'C语言程序设计','谭浩强','28.00',52,74,'static/img/default.jpg'),
(12,'Lua语言程序设计','雷丰阳','51.50',48,82,'static/img/default.jpg'),
(13,'西游记','罗贯中','12.00',19,9999,'static/img/default.jpg'),
(15,'操作系统原理','刘优','133.05',122,188,'static/img/default.jpg'),
(16,'数据结构 java版','封大神','173.15',21,81,'static/img/default.jpg'),
(17,'UNIX高级环境编程','乐天','99.15',210,810,'static/img/default.jpg'),
(18,'javaScript高级编程','国哥','69.15',210,810,'static/img/default.jpg'),
(19,'大话设计模式','国哥','89.15',20,10,'static/img/default.jpg'),
(20,'人月神话','刚哥','88.15',20,80,'static/img/default.jpg'),
(21,'1','1','1.00',1,1,'static/img/default.jpg'),
(24,'java','2','2.00',2,2,'static/img/default.jpg'),
(25,'s','2','23.00',1,2,'static/img/c++.jpg');

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `order_id` varchar(50) NOT NULL,
  `create_time` datetime NOT NULL,
  `total_money` decimal(11,2) NOT NULL,
  `status` int(11) NOT NULL DEFAULT '0',
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`order_id`,`create_time`,`total_money`,`status`,`user_id`) values 
('16101765390571','2021-01-09 15:15:39','80.00',0,1);

/*Table structure for table `t_order_item` */

DROP TABLE IF EXISTS `t_order_item`;

CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `price` decimal(11,2) DEFAULT NULL,
  `total_money` decimal(11,2) DEFAULT NULL,
  `count` int(11) NOT NULL,
  `order_id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_order_item` */

insert  into `t_order_item`(`id`,`name`,`price`,`total_money`,`count`,`order_id`) values 
(4,'JS','16.00','80.00',5,'16101765390571');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(32) CHARACTER SET latin1 NOT NULL,
  `email` varchar(200) CHARACTER SET latin1 DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`) values 
(1,'admin','admin','admin@qq.com'),
(3,'hkf','123456','123456@qq.com'),
(4,'rmc','123456','123456@qq.com'),
(8,'xiaocai','123','123@qq.com'),
(9,'daniao','123','123@qq.com'),
(10,'yyk','123','1470218730@qq.com'),
(11,'xiaoqi','123','1470218730@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
