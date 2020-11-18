create database PCSDB
use PCSDB

CREATE TABLE Employee (
	EmployeeID int identity(1,1) constraint empid_pk1 primary key,
	FirstName varchar(20) not null,
	LastName varchar(20) not null,
	UserID varchar(20) not null,
	Password varchar(18) not null,
	Gender char(1) constraint chk_gd check(Gender in ('M','F')) not null,
	Role varchar(15),
	Active char(3) constraint chk_act1 check(Active in ('Yes', 'No')) not null
)

CREATE TABLE Skill (
	SkillID int identity(101, 1) constraint skillid_pk2 primary key,
	SkillName varchar(20) not null,
	SkillDescription varchar(250) not null,
	Active char(3) constraint chk_act2 check(Active in ('Yes', 'No')) not null
)

CREATE TABLE Job (
	JobID int identity(201, 1) constraint jobid_pk3 primary key,
	JobDescription varchar(250) not null,
	CompanyName varchar(20) not null,
	Location geography not null,
	KeySkill varchar(20) not null,
	Salary int constraint chk_sal check(Salary >= 15000) not null,
	Active char(3) constraint chk_act3 check(Active in ('Yes', 'No')) not null 
)

CREATE TABLE EmpSkill (
	ESId int identity(301, 1) constraint esid_pk4 primary key,
	EmployeeID int constraint empid_eskill foreign key references Employee(EmployeeID),
	SkillID int constraint skillid_eskill foreign key references Skill(SkillID),
	ExpYear int constraint chk_expyear check(ExpYear>1) not null
)

CREATE TABLE EmpJob (
	EJID int identity(401, 1) constraint ejid_pk5 primary key,
	JobID int constraint jobid_ej foreign key references Job(JobID),
	Recruited char(3) constraint chk_rec check(Recruited in ('Yes', 'No')) not null
)



