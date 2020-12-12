create database PCSDB;
use PCSDB;

CREATE TABLE Employee (
	EmployeeID int auto_increment, constraint empid_pk1 primary key (EmployeeID),
	FirstName varchar(20) not null,
	LastName varchar(20) not null,
	UserID varchar(50) not null,
	Password varchar(18) not null,
	Gender varchar(6)  not null, constraint chk_gd check(Gender in ('Male','Female')),
    PhoneNumber long not null,
	Role varchar(3) not null,
	Active char(3) not null, constraint chk_act1 check(Active in ('Yes', 'No')) 
);
select * from Employee;
show variables like "max_connections";
alter table employee auto_increment=101;
alter table employee modify column UserID varchar(50) not null;
alter table Employee modify column PhoneNumber long not null;
alter table  `Employee` add column Gender varchar(6) check(Gender in ('Male','Female')) not null after password;
update employee set Active="YES" where employeeid=106;

CREATE TABLE Skill (
	SkillID int auto_increment, constraint skillid_pk2 primary key (SkillID),
	SkillName varchar(20) not null,
	SkillDescription varchar(250) not null,
	Active char(3) not null, constraint chk_act2 check(Active in ('Yes', 'No'))
);

alter table Skill auto_increment=201;
select * from skill;
delete from skill where SkillName="hellooo";

CREATE TABLE Job (
	JobID int auto_increment, constraint jobid_pk3 primary key (JobID),
	JobTitle varchar(20) not null,
    JobDescription varchar(250) not null,
	CompanyName varchar(50) not null,
	Location varchar(20) not null,
	KeySkill varchar(30) not null,
	Salary numeric(6,0) not null,
	Active varchar(4) not null, constraint chk_act3 check(Active in ('Yes', 'No'))  
);
alter table Job auto_increment=301;
select * from job;
alter table job modify column Salary numeric(6,0) not null after keyskill;

CREATE TABLE EmpSkill (
	ESId int auto_increment, constraint esid_pk4 primary key(ESId),
	EmployeeID int, constraint empid_eskill foreign key(EmployeeID) references Employee(EmployeeID),
	SkillID int, constraint skillid_eskill foreign key(SkillID) references Skill(SkillID),
	ExpYear int constraint chk_expyear check(ExpYear>1) not null
);
alter table EmpSkill auto_increment=401;
select * from EmpSkill;
CREATE TABLE EmpJob (
	EJID int auto_increment, constraint ejid_pk5 primary key (EJID),
    EmpID int not null, foreign key(EmpID) references Employee(EmployeeID),
	JobID int, constraint jobid_ej foreign key(JobID) references Job(JobID),
	Recruited char(3) not null, constraint chk_rec check(Recruited in ('Yes', 'No')) 
);
alter table EmpJob auto_increment=501;
select * from empJob;
select * from job where keyskill like '%java%';

CREATE TABLE ApplyJob (
	ApplicationID int auto_increment, constraint aplID_pk6 primary key (ApplicationID),
    JobID int, constraint jobid_aj foreign key(JobID) references Job(JobID),
	employeeID int not null, constraint empid_6 foreign key(employeeID) references Employee(EmployeeID),
    Status varchar(10) not null	
);
select * from ApplyJob;

create view appliedlist as
select a.applicationid, a.employeeid, e.firstname, a.jobid, j.jobtitle, a.status from ApplyJob a inner join job j on a.jobid=j.jobid
inner join employee e on a.employeeid=e.employeeid;

select * from appliedlist;
--------------------------------------------------------------------

