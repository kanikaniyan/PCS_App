create database PCSDB;
use PCSDB;

CREATE TABLE Employee (
	EmployeeID int auto_increment, constraint empid_pk1 primary key (EmployeeID),
	FirstName varchar(20) not null,
	LastName varchar(20) not null,
	UserID varchar(20) not null,
	Password varchar(18) not null,
	Gender char(1) constraint chk_gd check(Gender in ('M','F')) not null,
	Role varchar(15),
	Active char(3) constraint chk_act1 check(Active in ('Yes', 'No')) not null
);

alter table employee auto_increment=101;
alter table  `Employee` add column `Role` varchar(3) not null after `Gender`;
alter table  `Employee` add column Gender varchar(6) constraint chk_gd check(Gender in ('Male','Female')) not null after password;

CREATE TABLE Skill (
	SkillID int auto_increment, constraint skillid_pk2 primary key (SkillID),
	SkillName varchar(20) not null,
	SkillDescription varchar(250) not null,
	Active char(3) constraint chk_act2 check(Active in ('Yes', 'No')) not null
);
alter table employee auto_increment=201;

CREATE TABLE Job (
	JobID int auto_increment, constraint jobid_pk3 primary key (JobID),
	JobDescription varchar(250) not null,
	CompanyName varchar(20) not null,
	Location geometry not null,
	KeySkill varchar(20) not null,
	Salary int constraint chk_sal check(Salary >= 15000) not null,
	Active char(3) constraint chk_act3 check(Active in ('Yes', 'No')) not null 
);
alter table job auto_increment=301;

CREATE TABLE EmpSkill (
	ESId int auto_increment, constraint esid_pk4 primary key(ESId),
	EmployeeID int, constraint empid_eskill foreign key(EmployeeID) references Employee(EmployeeID),
	SkillID int, constraint skillid_eskill foreign key(SkillID) references Skill(SkillID),
	ExpYear int constraint chk_expyear check(ExpYear>1) not null
);
alter table EmpSkill auto_increment=401;

CREATE TABLE EmpJob (
	EJID int auto_increment, constraint ejid_pk5 primary key (EJID),
	JobID int, constraint jobid_ej foreign key(JobID) references Job(JobID),
	Recruited char(3) constraint chk_rec check(Recruited in ('Yes', 'No')) not null
);
alter table EmpJob auto_increment=501;


