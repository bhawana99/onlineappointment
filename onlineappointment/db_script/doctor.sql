drop table doctor;

create table doctor(
    d_id varchar2(10) primary key,
    d_name varchar2(40)not null,
    dept_id varchar2(3)not null,
	d_email varchar2(30) not null, 
	d_password varchar2(20) not null,
	d_contact varchar2(12) not null,
	d_img blob,
	constraint fk1 foreign key (dept_id)
    references department(dept_id)
    );
	
insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc1','Dr.Vartika mishra','d1','vartika@gmail.com','vartika123','9826121732');
insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc2','Dr.Sandeep pandey','d2','sandeep@gmail.com','sandeep123','7000100966');
insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact)
values('doc3','Dr.Sunil srivastav','d3','sunil@gmail.com','sunil123','8959992382');
insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc4','Dr.Archana mittal','d4','archana@gmail.com','archna123','9826121512');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc5','Dr.Rashmi Upadhyay','d5','rashmiupadhyay@gmail.com','drRasmi','7458961230');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc6','Dr.Ramanjan Sinha','d6','sinharamanjan@gmail.com','Rama789','8516802789');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc7','Dr.Manisha Sinha','d1','sinhamanisha@gmail.com','Mani@123','9516930228');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc8','Dr. Avinash Ingle','d2','avinashingle999@gmail.com','Avi@908','9085162039');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc9','Dr. Ekta Khandelwal','d3','khandelwal.ekta@gmail.com','K@ekta','7895612034');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc10','Dr.Jayshri Ghate','d1','jghate856@gmail.com','#Ghate5','7851236940');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc11','Dr.Jessy Abraham','d2','jessy.abraham@gmail.com','Jessy$58','9993249502');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc12','Dr.Rachita Nanda','d5','nanda.rachita@gmail.com','208Nanda','7693880413');

insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc13','Dr.Abhiruchi Galhotra','d3','abhiruchi999@gmail.com','ruchi999','9994932802');


insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc14','Dr.Anjali Pal','d4','pal.anjali@gmail.com','Annju_845','8456239710');


insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc15','Dr.Geetesh Malhotra','d6','malhotrageetesh@gmail.com','geetesh_999','9516905858');


insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc16','Dr.Nitin Gaikwad','d6','gaikwadnitin@gmail.com','nitin#dr','9516905858');


insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc17','Dr.Nitin Sharma Malhotra','d6','malhotrageetesh@gmail.com','sharma@45','8596231470');


insert into doctor(d_id,d_name,dept_id,d_email,d_password,d_contact) 
values('doc18','Dr.Aditya Jain','d6','malhotrageetesh@gmail.com','jain@890','7895412603');
