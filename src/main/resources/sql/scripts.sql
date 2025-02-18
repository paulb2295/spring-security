create table users(username varchar(50) not null primary key,password varchar(500) not null,enabled boolean not null);
create table authorities (username varchar(50) not null,authority varchar(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);


INSERT IGNORE INTO `users` VALUES ('user', '{bcrypt}$2a$12$GLB5x/Lc/SIQEvUf7RVPxO7cStZWnkwL/pKoVmMk.25ApCWU6IlDC', '1'); --#Usr<min>$
INSERT IGNORE INTO `authorities` VALUES ('user', 'read');

INSERT IGNORE INTO `users` VALUES ('admin', '{bcrypt}$2a$12$GLB5x/Lc/SIQEvUf7RVPxO7cStZWnkwL/pKoVmMk.25ApCWU6IlDC', '1'); --#Adm<max>$
INSERT IGNORE INTO `authorities` VALUES ('admin', 'admin');

--use {bcrypt} before passwords only when using PasswordEncoderFactories