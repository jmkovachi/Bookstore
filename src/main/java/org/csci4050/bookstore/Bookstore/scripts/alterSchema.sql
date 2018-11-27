-- If you don't want to drop and recreate all your tables, run this script to alter your schema.
-- When inserting books and vendors I found some of these columns had to be changed

ALTER TABLE `bookstoredb`.`book`
CHANGE COLUMN `image_url` `image_url` VARCHAR(144) NULL DEFAULT NULL,
CHANGE COLUMN `rating` `rating` FLOAT NULL DEFAULT NULL,
CHANGE COLUMN `summary` `summary` TEXT NOT NULL ;

ALTER TABLE `bookstoredb`.`user`
CHANGE COLUMN `email` `email` VARCHAR(144) NOT NULL ;

ALTER TABLE `bookstoredb`.`verification`
DROP FOREIGN KEY `FK_302`;
ALTER TABLE `bookstoredb`.`verification`
ADD CONSTRAINT `FK_302`
  FOREIGN KEY (`c_username`)
  REFERENCES `bookstoredb`.`customer` (`c_username`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


ALTER TABLE `bookstoredb`.`promotion`
CHANGE COLUMN `expire_date` `expire_date` DATE NULL ;

ALTER TABLE `order` AUTO_INCREMENT = 1000000;

ALTER TABLE `bookstoredb`.`orderitem`
ADD COLUMN `quantity` INT NOT NULL AFTER `final_price`;