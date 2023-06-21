show databases;
create database gradedproject5;
use gradedproject5;

CREATE TABLE `gradedproject5`.`login` (
  `emailid` VARCHAR(50) NOT NULL,
  `password` VARCHAR(45) NULL,
  PRIMARY KEY (`emailid`));
  
CREATE TABLE contact (
  id INT PRIMARY KEY AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  phone VARCHAR(20) NOT NULL
);

INSERT INTO `gradedproject5`.`contact` (`id`, `name`, `email`, `phone`) VALUES ('1', 'admin', 'admin@gmail.com', '123456789');


  
  SELECT * FROM gradedproject5.login;
  
INSERT INTO `gradedproject5`.`login` (`emailidloginlogin`, `password`) VALUES ('admin@gmail.com', 'admin123');
DELETE FROM `gradedproject5`.`login` WHERE (`emailid` = 'admin@gmail.com');
