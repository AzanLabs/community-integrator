create database if not exists test;
use test;

create table if not exists church_info(
	church_id int PRIMARY KEY,
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
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL
);

create table if not exists church_add_info(		
	id int PRIMARY KEY AUTO_INCREMENT,	
	church_id int,
	church_info TEXT,
	CONSTRAINT fk_church FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table if not exists priest_info(
	priest_id int PRIMARY KEY,
	priest_name varchar(255) NOT NULL,
	priest_dob date NOT NULL,
	priest_birth_place varchar(200) NOT NULL,
	priest_education varchar(200) NOT NULL,
	priest_specialization varchar(200),
	priest_educated_university varchar(200),
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
	priest_email_id varchar(100) NOT NULL,
	priest_diocese varchar(100) NOT NULL,
	priest_additional_position varchar(255),
	priest_image_name varchar(100),
	church_id int NOT NULL,
	is_active boolean,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_current_church FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table if not exists priest_add_info(
	id int PRIMARY KEY AUTO_INCREMENT,	
	priest_id int NOT NULL,	
	priest_info TEXT,
	CONSTRAINT fk_priest FOREIGN KEY(priest_id) REFERENCES priest_info(priest_id)
);

create table user(
	user_id int PRIMARY KEY AUTO_INCREMENT,
	user_identifier varchar(250) NOT NULL UNIQUE,
	user_password varchar(250) NOT NULL,
	user_type varchar(10) NOT NULL,
	priest_id int,
	church_id int,
	is_default_pwd boolean NOT NULL,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL
);


create table if not exists church_events(
	event_id int PRIMARY KEY AUTO_INCREMENT,
	event_name varchar(300) NOT NULL,
	event_start_date timestamp,
	event_end_date timestamp,
	event_description varchar(300) NOT NULL,	
	event_details varchar(1024) NOT NULL,
	is_active boolean NOT NULL,
	church_id int NOT NULL,	
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_event FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table church_gallery(
	image_id int PRIMARY KEY AUTO_INCREMENT,
	image_name varchar(255) NOT NULL,
	imageType varchar(20) NOT NULL,
	church_id int NOT NULL,
	is_active boolean NOT NULL,
	CONSTRAINT fk_gallery FOREIGN KEY(church_id) REFERENCES church_info(church_id)	
);

create table bible_verses(
	verse_id int PRIMARY KEY AUTO_INCREMENT,
	verse varchar(100) NOT NULL,
	chapter varchar(100) NOT NULL,
	words TEXT NOT NULL,
	type varchar(2) NOT NULL,
	church_id int,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL
);

create table church_updates(
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(255),
	description varchar(255) NOT NULL,
	details varchar(1024) NOT NULL,
	church_id int NOT NULL,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_updates FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table priest_mam(
	mam_id int PRIMARY KEY AUTO_INCREMENT,
	requestor_name varchar(255) NOT NULL,
	meeting_date timestamp NOT NULL,
	description varchar(255) NOT NULL,
	reason varchar(1024) NOT NULL,
	status varchar(20) NOT NULL,
	comments varchar(1024),
	priest_id int NOT NULL,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_priest_mam FOREIGN KEY(priest_id) REFERENCES priest_info(priest_id)
);

create table church_facilities (
	id int PRIMARY KEY AUTO_INCREMENT,
	name varchar(255) NOT NULL,
	used_for varchar(1024) NOT NULL,
	features varchar(1024),
	can_be_booked boolean NOT NULL,
	is_active boolean NOT NULL,
	image_group_id int UNIQUE NOT NULL,
	church_id int NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL,
	CONSTRAINT fk_church_facility FOREIGN KEY(church_id) REFERENCES church_info(church_id)
);

create table church_images(
	image_id int PRIMARY KEY AUTO_INCREMENT,
	image_name varchar(255) NOT NULL,
	image_type varchar(10) NOT NULL,
	entity varchar(100) NOT NULL,
	image_size int,
	is_active boolean NOT NULL,
	image_group_id int NOT NULL,
	created_on timestamp NOT NULL,
	created_by int NOT NULL,
	last_modified_on timestamp NOT NULL,
	last_modified_by int NOT NULL
);

create table email_archive(
	email_id int PRIMARY KEY AUTO_INCREMENT,
	send_to varchar(100) NOT NULL,
	subject varchar(255) NOT NULL,
	message varchar(1024) NOT NULL,
	email_status varchar(10) NOT NULL,
	is_active boolean NOT NULL,
	created_on timestamp NOT NULL,
	user_id int NOT NULL,
	CONSTRAINT fk_user_email FOREIGN KEY(user_id) REFERENCES user(user_id)
);

insert into user values(1001,'admin','admin','P',2001,3001,true,true,now(), 0, now(), 0);