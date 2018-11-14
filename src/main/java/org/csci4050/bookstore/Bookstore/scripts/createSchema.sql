-- ****************** BookstoreDB table generation ******************;
-- ******************************************************************;


-- ************************************** `bookstoreDB`.`User`
USE bookstoreDB;


CREATE TABLE IF NOT EXISTS `bookstoreDB`.`User`
(
 `username` varchar(45) NOT NULL ,
 `password` varchar(45) NOT NULL unique ,
 `email`    varchar(45) NOT NULL ,
 `role`     varchar(20) NOT NULL ,
 `image_url` varchar(144),
PRIMARY KEY (`username`)
) COMMENT='Client, Vendor, and Customer tables ''inherit'' from this table';






-- ************************************** `bookstoreDB`.`Vendor`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Vendor`
(
 `v_username` varchar(45) NOT NULL ,
 `company`    varchar(45) NOT NULL ,
 `address`    varchar(45) NOT NULL ,
PRIMARY KEY (`v_username`),
KEY `vendor_username_fk` (`v_username`),
CONSTRAINT `FK_137` FOREIGN KEY `vendor_username_fk` (`v_username`)
REFERENCES `bookstoreDB`.`User` (`username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);






-- ************************************** `bookstoreDB`.`Customer`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Customer`
(
 `c_username` varchar(45) NOT NULL ,
 `first_name` varchar(45) NOT NULL ,
 `address`    varchar(144) NOT NULL ,
 `minit`      char NOT NULL ,
 `last_name`  varchar(45) NOT NULL ,
 `birth_date` date NOT NULL ,
 `verified`   bit NOT NULL ,
 `newsletter` bit NOT NULL ,
PRIMARY KEY (`c_username`),
KEY `customer_username_fk` (`c_username`),
CONSTRAINT `FK_128`
FOREIGN KEY `customer_username_fk` (`c_username`)
REFERENCES `bookstoreDB`.`User` (`username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);






-- ************************************** `bookstoreDB`.`Client`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Client`
(
 `client_username` varchar(45) NOT NULL ,
 `name`            varchar(45) NOT NULL ,
 `company`         varchar(45) NOT NULL ,
 `address`         varchar(144) NOT NULL ,
PRIMARY KEY (`client_username`),
KEY `client_username_fk` (`client_username`),
CONSTRAINT `FK_259`
FOREIGN KEY `client_username_fk` (`client_username`)
REFERENCES `bookstoreDB`.`User` (`username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);


-- ************************************** `bookstoreDB`.`ShippingAddress`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`ShippingAddress`
(
 `address_id` int unsigned NOT NULL AUTO_INCREMENT ,
 `c_username` varchar(45) NOT NULL ,
 `address`    varchar(144) NOT NULL ,
 `city`       varchar(45) NOT NULL ,
 `state`      varchar(20) NOT NULL ,
 `zip`        int NOT NULL ,
PRIMARY KEY (`address_id`),
KEY `customer_username_fk` (`c_username`),
CONSTRAINT `FK_220`
FOREIGN KEY `customer_username_fk` (`c_username`)
REFERENCES `bookstoreDB`.`Customer` (`c_username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

-- ************************************** `bookstoreDB`.`Promotion`

CREATE TABLE `bookstoreDB`.`Promotion`
(
 `promo_id`    int unsigned NOT NULL AUTO_INCREMENT ,
 `promo_code`  varchar(20) ,
 `percent_off` int NOT NULL ,
 `expire_date` date NOT NULL ,
PRIMARY KEY (`promo_id`),
KEY `promo_code_index` (`promo_code`)
);

-- ************************************** `bookstoreDB`.`Book`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Book`
(
 `isbn`            char(13) NOT NULL ,
 `title`           varchar(144) NOT NULL ,
 `date_published`  date NOT NULL ,
 `author`          varchar(45) NOT NULL ,
 `category`        varchar(45) NOT NULL ,
 `price`           double NOT NULL ,
 `total_inventory` int NOT NULL ,
 `promo_id`        int unsigned ,
 `image_url`	   varchar(45) ,
 `rating`          float(1,1) ,
 `summary`         varchar(1000) NOT NULL ,
 `pages`           smallint NOT NULL ,
 `v_username`      varchar(45) NOT NULL ,
PRIMARY KEY (`isbn`),
KEY `author` (`author`) USING BTREE,
KEY `category` (`category`) USING BTREE,
KEY `promo_id_fk` (`promo_id`),
CONSTRAINT `FK_172`
FOREIGN KEY `promo_id_fk` (`promo_id`)
REFERENCES `bookstoreDB`.`Promotion` (`promo_id`)
ON DELETE SET NULL
ON UPDATE CASCADE,
KEY `vendor_username_fk` (`v_username`),
CONSTRAINT `FK_164` FOREIGN KEY `vendor_username_fk` (`v_username`) REFERENCES `bookstoreDB`.`Vendor` (`v_username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);

-- ************************************** `bookstoreDB`.`PaymentInfo`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`PaymentInfo`
(
 `payment_id`    int unsigned NOT NULL AUTO_INCREMENT ,
 `c_username`    varchar(45) NOT NULL ,
 `card_num`      varchar(20) NOT NULL ,
 `exp_date`      date NOT NULL ,
 `security_code` int NOT NULL ,
PRIMARY KEY (`payment_id`),
KEY `c_username_fk` (`c_username`),
CONSTRAINT
`FK_200`
FOREIGN KEY `c_username_fk` (`c_username`)
REFERENCES `bookstoreDB`.`Customer` (`c_username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);






-- ************************************** `bookstoreDB`.`ClientVendors`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`ClientVendors`
(
 `client_username` varchar(45) NOT NULL ,
 `v_username`      varchar(45) NOT NULL ,
PRIMARY KEY (`client_username`, `v_username`),
KEY `client_username_fk` (`client_username`),
CONSTRAINT `FK_264`
FOREIGN KEY `client_username_fk` (`client_username`)
REFERENCES `bookstoreDB`.`Client` (`client_username`)
ON DELETE CASCADE
ON UPDATE CASCADE,
KEY `vendor_username_fk` (`v_username`),
CONSTRAINT `FK_267`
FOREIGN KEY `vendor_username_fk` (`v_username`)
REFERENCES `bookstoreDB`.`Vendor` (`v_username`)
ON DELETE CASCADE
ON UPDATE CASCADE
) COMMENT='Vendors that belong to a client. Used to generate business reports';






-- ************************************** `bookstoreDB`.`Cart`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Cart`
(
 `isbn`     char(13) NOT NULL ,
 `c_username`  varchar(45) NOT NULL ,
 `quantity`    int NOT NULL ,
 `final_price` double NOT NULL ,
PRIMARY KEY (`isbn`, `c_username`),
KEY `isbn_fk` (`isbn`),
CONSTRAINT `FK_189`
FOREIGN KEY `isbn_fk` (`isbn`)
REFERENCES `bookstoreDB`.`Book` (`isbn`)
ON DELETE CASCADE
ON UPDATE CASCADE,
KEY `client_username_fk` (`c_username`),
CONSTRAINT
`FK_204`
FOREIGN KEY `client_username_fk` (`c_username`)
REFERENCES `bookstoreDB`.`Customer` (`c_username`)
ON DELETE CASCADE
ON UPDATE CASCADE
);


-- ************************************** `bookstoreDB`.`Order`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Order`
(
 `order_id`     int unsigned NOT NULL AUTO_INCREMENT ,
 `c_username`   varchar(45) NOT NULL ,
 `date`         datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ,
 `total`        double NOT NULL ,
 `payment_type` varchar(10) NOT NULL ,
 `payment_id`   int unsigned ,
 `address_id`   int unsigned ,
PRIMARY KEY (`order_id`),
KEY `c_username_fk` (`c_username`),
CONSTRAINT `FK_order_cusername_customer` FOREIGN KEY `c_username_fk` (`c_username`) REFERENCES `bookstoreDB`.`Customer` (`c_username`)
ON DELETE CASCADE
ON UPDATE CASCADE,
KEY `payment_id_fk` (`payment_id`),
CONSTRAINT `FK_243` FOREIGN KEY `payment_id_fk` (`payment_id`) REFERENCES `bookstoreDB`.`PaymentInfo` (`payment_id`)
ON DELETE CASCADE
ON UPDATE CASCADE,
KEY `address_id_fk` (`address_id`),
CONSTRAINT `FK_276` FOREIGN KEY `address_id_fk` (`address_id`) REFERENCES `bookstoreDB`.`ShippingAddress` (`address_id`)
ON DELETE CASCADE
ON UPDATE CASCADE
);






-- ************************************** `bookstoreDB`.`OrderItem`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`OrderItem`
(
 `item_id`     int unsigned NOT NULL AUTO_INCREMENT ,
 `order_id`    int unsigned NOT NULL ,
 `isbn`        char(13) NOT NULL ,
 `final_price` double NOT NULL ,
PRIMARY KEY (`item_id`),
KEY `isbn_fk` (`isbn`),
CONSTRAINT `FK_234` FOREIGN KEY `isbn_fk` (`isbn`) REFERENCES `bookstoreDB`.`Book` (`isbn`)
ON DELETE CASCADE
ON UPDATE CASCADE,
KEY `order_id_fk` (`order_id`),
CONSTRAINT `FK_228` FOREIGN KEY `order_id_fk` (`order_id`) REFERENCES `bookstoreDB`.`Order` (`order_id`)
ON DELETE CASCADE
ON UPDATE CASCADE
);



-- ************************************** `bookstoreDB`.`Verification`

CREATE TABLE IF NOT EXISTS `bookstoreDB`.`Verification`
(
 `verification_code` int NOT NULL AUTO_INCREMENT ,
 `c_username`        varchar(45) NOT NULL ,
 `email`             varchar(45) NOT NULL ,
PRIMARY KEY (`verification_code`),
KEY `c_username_fk` (`c_username`),
CONSTRAINT `FK_302` FOREIGN KEY `c_username_fk` (`c_username`) REFERENCES `bookstoreDB`.`Customer` (`c_username`)
) AUTO_INCREMENT=1000;
