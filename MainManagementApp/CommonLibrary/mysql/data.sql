
CREATE DATABASE `ManagementProduct` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

use ManagementProduct;

CREATE TABLE `PRODUCT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DELIMITER $$
CREATE DEFINER=`jarenas`@`%` PROCEDURE `getAllProducts`()
BEGIN
  SELECT * FROM PRODUCT;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`jarenas`@`%` PROCEDURE `insertProd`(IN productName varchar (30),
													IN model varchar(30),
                                                    IN price varchar(30))
BEGIN
INSERT INTO  PRODUCT (name,model,price) VALUES (productName, model, price);
END$$
DELIMITER ;

