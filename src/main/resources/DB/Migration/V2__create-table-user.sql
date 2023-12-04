create table usuario (
   id INTEGER PRIMARY KEY AUTOINCREMENT,
   usuario varchar(100) not null unique,
   senha varchar(100) not null
   );

