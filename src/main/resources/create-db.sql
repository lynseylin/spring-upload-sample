--创建user表
CREATE TABLE IF NOT EXISTS `user`(
   `id` INT,
   `name` VARCHAR(20),
   `password` VARCHAR(20),
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
