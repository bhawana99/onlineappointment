drop table feedback_table;

create table feedback_table(
f_id number(10) not null primary key,
user_name varchar2(30) not null,
email varchar2(50) not null,
review_text varchar2(300) not null,
dof date not null,
available varchar2(6) not null
);

insert into feedback_table 
values(1,'Dinesh Sharma','dineshsharma@gmail.com','Nice Infrastructure and friendly service. Hygeine are too good','26-FEB-2019','false');

insert into feedback_table 
values(2,'Rohit Aryan','rohit001@gmail.com','Nice doctors and services are too good.','27-FEB-2019','false');

insert into feedback_table 
values(3,'Simran Mahajan','simran123@gmail.com','Very Bad Service.Doctors are never on time','28-FEB-2019','false');

insert into feedback_table 
values(4,'Rohit Aryan','rohit001@gmail.com','Overall hospital service is good but hospital cantin is really bad','28-FEB-2019','false');

insert into feedback_table 
values(5,'Dolly Thakur','dolly001@gmail.com','Nice doctors and services are too good.','28-FEB-2019','false');

insert into feedback_table 
values(6,'Raj Malhotra','raj@gmail.com','Nice doctors and services are too good.','03-MAR-2019','true');


select review_text from feedback_table;
select review_text from feedback_table  where available='true';
