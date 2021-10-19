create table users(
	id_user uuid NOT NULL default random_uuid() primary key ,
	name varchar(255),
	email varchar(255) unique,
	password varchar(255),	
	create_date date default sysdate,
	update_date date,
	last_login date ,
	tokend varchar(255) default random_uuid(),
	isactive int default 1	
);


create table phone(
	id_phone uuid NOT NULL default random_uuid() primary key,
	number varchar(100),
	citycode varchar(100),
	contrycode varchar(100),
	id_user uuid,
	CONSTRAINT id_usuario_fk
    FOREIGN KEY (id_user)
    REFERENCES users (id_user)
);