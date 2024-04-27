DROP SCHEMA IF EXISTS `movies`;

CREATE SCHEMA `movies`;

use `movies`;

SET FOREIGN_KEY_CHECKS = 0;



CREATE TABLE `movie` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(128) DEFAULT NULL,
  `director` varchar(128) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  
  PRIMARY KEY (`id`)
  
  
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;