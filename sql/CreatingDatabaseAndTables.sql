DROP DATABASE IF EXISTS EMS;

CREATE DATABASE EMS;
USE EMS;


CREATE TABLE Users
(
	Id int PRIMARY KEY AUTO_INCREMENT, 
	Name varchar(50), 
	User_Name varchar(20), 
	Password char(64), 
	Mob_No char(10),
	Email varchar(50), 
	Address varchar(256),
	Role char(1),
	Seq_Q_Id int,
	Seq_Q_Ans char(64)
);


CREATE TABLE Student
(
	Student_Id int PRIMARY KEY AUTO_INCREMENT, 
	Name varchar(50), 
	Roll_No char(12), 
	DOB date, 
	Gender char(1),
	Gurdian_Name varchar(50), 
	Mob_No char(10), 
	Email varchar(50), 
	Address varchar(256),  
	Transction_Id varchar(10),
	Transction_Date date, 
	EPref_Zone1_id int,
	EPref_Zone2_id int,
	Pic longblob, 
	Sig longblob,  
	Qual_Id int,
	Qual_Year int, 
	Marks int
);


CREATE TABLE Qualification
(
	Qual_Id int PRIMARY KEY AUTO_INCREMENT, 
	Name varchar(30)
);


CREATE TABLE ExamCenter
(
	Center_Id int PRIMARY KEY AUTO_INCREMENT, 
	Name varchar(50), 
	Address varchar(256), 
	Zone_id int, 
	Center_No varchar(10)
);


CREATE TABLE CenterRoom
(
	Center_Id int, 
	Room_No varchar(20), 
	Capacity int,
	PRIMARY KEY(Center_Id,Room_No)
);


CREATE TABLE ExamZone
(
	Zone_id int PRIMARY KEY AUTO_INCREMENT, 
	Name varchar(50)	
);


CREATE TABLE SeatAlloc
(
	Student_Id int, 
	Center_Id int, 
	Room_No varchar(20),
	PRIMARY KEY(Student_Id,Center_Id,Room_No)
);


CREATE TABLE SeqQuestion
(
	Seq_Q_Id int PRIMARY KEY AUTO_INCREMENT,
	Seq_Question varchar(100)
);