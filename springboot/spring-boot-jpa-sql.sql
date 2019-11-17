create database spring_boot_jpa_db;

drop table spring_boot_jpa_db.employee;
CREATE TABLE spring_boot_jpa_db.employee(id integer not null auto_increment, first_name varchar(255), last_name varchar(255), salary  integer, primary key(id));

insert into spring_boot_jpa_db.employee(first_name,last_name,salary) values('ankush','raheja',20000000);