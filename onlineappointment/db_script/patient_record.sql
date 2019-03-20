drop table patient_details;

create table patient_details(
p_email varchar2(30) not null primary key,
p_fname varchar2(30) not null,
p_lname varchar2(30) not null,
p_password varchar2(20) not null,
p_age number(3) not null,
p_contact varchar2(10) not null,
p_gender varchar(7) not null
);
insert into patient_details
values('sjain@gmail.com','Suresh','Jain','sjain_207',35,'8516802849','M');
insert into patient_details
values('s.arora@gmail.com','Saina','Arora','saina_208',30,'9516930249','F');
insert into patient_details
values('abhibainerji@gmail.com','Abhishek','Bainerji','abhi#',35,'8516802849','M');


drop table patient_appointment;

create table patient_appointment(
p_id number(8) not null primary key,
p_email varchar2(30) not null,
d_id varchar2(10) not null,
doa date not null,
dept_id varchar2(3) not null,
diagnosed varchar(3) not null,
constraint f1 foreign key(p_email) references patient_details(p_email),
constraint f2 foreign key(dept_id) references department(dept_id),
constraint f3 foreign key(d_id) references doctor(d_id)
);


insert into patient_appointment
values(10000001,'sjain@gmail.com','doc1','22-FEB-2019','d1','NO'); 
insert into patient_appointment
values(10000002,'s.arora@gmail.com','doc2','22-FEB-2019','d2','NO'); 
insert into patient_appointment
values(10000003,'abhibainerji@gmail.com','doc3','22-FEB-2019','d3','NO'); 
