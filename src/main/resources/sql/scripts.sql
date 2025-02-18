--use {bcrypt} before passwords only when using PasswordEncoderFactories

CREATE TABLE `customers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(45) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `role` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
);

INSERT  INTO `customers` (`email`, `pwd`, `role`) VALUES ('user@gmail.com', '$2a$12$GLB5x/Lc/SIQEvUf7RVPxO7cStZWnkwL/pKoVmMk.25ApCWU6IlDC', 'read'); --#Usr<min>$
INSERT  INTO `customers` (`email`, `pwd`, `role`) VALUES ('admin@gmail.com', '$2a$12$SFPw28NBqCkgGNmJuJDDZutoE7CePfiZnkguSBsL3jaz/pitqli5m', 'admin'); --#Adm<max>$