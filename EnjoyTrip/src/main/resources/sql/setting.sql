create database enjoytrip;
use enjoytrip;
CREATE table members (
  `userId` VARCHAR(16) NOT NULL,
  `userName` VARCHAR(20) NOT NULL,
  `userPassword` VARCHAR(500) NOT NULL,
  `emailId` VARCHAR(20) NULL DEFAULT NULL,
  `emailDomain` VARCHAR(45) NULL DEFAULT NULL,
  `joinDate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`));

  create table login_try(
  `idx` int auto_increment not null,
  `user_id` varchar(16),
  `retry` int default 0,
  `last_try_date` timestamp default current_timestamp,
  `last_try_time` timestamp default current_timestamp,
  `client_ip` varchar(15) not null,
  primary key(`idx`)
  );
  create table board(
	`article_no` int auto_increment not null,
    `user_id` varchar(16) not null,
    `subject` varchar(100) not null,
    `content` varchar(2000) not null,
    `hit` int not null default 0,
    `register_time` timestamp default current_timestamp not null,
    primary key(`article_no`),
    foreign key(`user_id`) references enjoytrip.members(`user_id`)
  );
create table id_info(
`id` varchar(16) not null,
`salt` varchar(500) not null,
primary key(`id`)); 

create table key_info(
`hashed_id` varchar(500) not null,
`salt` varchar(500) not null,
`key` varchar(500) not null,
primary key(`hashed_id`));

create table comment_list(
`idx` int auto_increment not null,
`comment` varchar(1000) not null, 
`user_name` varchar(20) not null,
`article_no` int not null,
primary key(`idx`),
foreign key(`article_no`) references enjoytrip.board(`article_no`)
);