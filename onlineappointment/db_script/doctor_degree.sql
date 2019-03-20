drop table doctor_degree;

create table doctor_degree(
id number(2) primary key,
d_id varchar2(10) not null,
degree_id varchar2(10) not null,
CONSTRAINT unique1 UNIQUE (d_id, degree_id)
);

insert into doctor_degree values(1,'doc1','1');
insert into doctor_degree values(2,'doc1','2');
insert into doctor_degree values(3,'doc1','3');
insert into doctor_degree values(4,'doc2','1');
insert into doctor_degree values(5,'doc2','4');
insert into doctor_degree values(6,'doc3','5');
insert into doctor_degree values(7,'doc4','1');
insert into doctor_degree values(8,'doc5','2');
insert into doctor_degree values(9,'doc6','3');
insert into doctor_degree values(10,'doc7','5');
insert into doctor_degree values(11,'doc8','6');
insert into doctor_degree values(12,'doc9','2');
insert into doctor_degree values(13,'doc10','1');
insert into doctor_degree values(14,'doc11','1');
insert into doctor_degree values(15,'doc12','6');
insert into doctor_degree values(16,'doc13','6');
insert into doctor_degree values(17,'doc14','5');
insert into doctor_degree values(18,'doc15','1');
insert into doctor_degree values(19,'doc16','4');
insert into doctor_degree values(20,'doc17','1');
insert into doctor_degree values(21,'doc18','2');
insert into doctor_degree values(22,'doc18','3');
insert into doctor_degree values(23,'doc18','4');
insert into doctor_degree values(24,'doc17','2');
insert into doctor_degree values(25,'doc15','5');
insert into doctor_degree values(26,'doc10','4');
insert into doctor_degree values(27,'doc12','4');
