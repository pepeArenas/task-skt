use ManagementProduct;

CREATE TABLE `PRODUCT` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `price` DECIMAL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


DELIMITER $$
CREATE DEFINER=`myuser`@`%` PROCEDURE `getAllProducts`()
BEGIN
  SELECT * FROM PRODUCT;
END$$
DELIMITER ;


DELIMITER $$
CREATE DEFINER=`myuser`@`%` PROCEDURE `insertProd`(IN productName varchar (30),
													IN model varchar(30),
                                                    IN price DECIMAL)
BEGIN
INSERT INTO  PRODUCT (name,model,price) VALUES (productName, model, price);
END$$
DELIMITER ;

