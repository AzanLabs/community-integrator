create database if not exists test;
use test;
create table user(
	id int PRIMARY KEY AUTO_INCREMENT,
	identifier varchar(250) NOT NULL UNIQUE,
	password varchar(250) NOT NULL,
	type varchar(1) NOT NULL,
	belongs_to int
);
insert into user (identifier, password, type) values('admin', 'admin', 'admin');


create table if not exists church_info(
	church_id int PRIMARY KEY AUTO_INCREMENT,
	church_name varchar(255) NOT NULL,
	church_door_no varchar(10) NOT NULL,
	church_street varchar(255) NOT NULL,
	church_village varchar(255) NOT NULL,
	church_taluk varchar(255),
	church_district varchar(255) NOT NULL,
	church_state varchar(255) NOT NULL,
	church_country varchar(255) NOT NULL,
	church_pincode int NOT NULL,
	church_diocese varchar(255) NOT NULL,
	church_telephone_no bigint NOT NULL,
	church_mobile_no bigint NOT NULL,
	church_email_id varchar(100) NOT NULL,
	church_is_active boolean NOT NULL
);

create table if not exists church_add_info(
	church_id int PRIMARY KEY AUTO_INCREMENT,
	church_info varchar(1024)
);

create table if not exists priest_info(
	priest_id int PRIMARY KEY AUTO_INCREMENT,
	priest_name varchar(255) NOT NULL,
	priest_dob date NOT NULL,
	priest_education varchar(200) NOT NULL,
	priest_specialization varchar(200) NOT NULL,
	priest_birth_place varchar(200) NOT NULL,
	priest_educated_university varchar(200) NOT NULL,
	priest_door_no varchar(10) NOT NULL,
	priest_street varchar(255) NOT NULL,
	priest_village varchar(255) NOT NULL,
	priest_taluk varchar(255),
	priest_district varchar(255) NOT NULL,
	priest_state varchar(255) NOT NULL,
	priest_country varchar(255) NOT NULL,
	priest_pincode int NOT NULL,	
	priest_telephone_no bigint,
	priest_mobile_no bigint NOT NULL,
	priest_email_id varchar(100),
	priest_diocese varchar(100) NOT NULL,
	priest_additional_position varchar(255),
	church_id int NOT NULL,
	priest_is_active boolean,
	CONSTRAINT fk_current_church FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table if not exists priest_add_info(
	priest_id int PRIMARY KEY AUTO_INCREMENT,
	priest_info varchar(1024)
);
