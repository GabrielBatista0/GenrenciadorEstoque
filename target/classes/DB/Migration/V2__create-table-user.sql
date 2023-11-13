create table usuario (
   id int not null primary key auto_increment,
   usuario varchar(100) not null unique,
   senha varchar(100) not null
   );

