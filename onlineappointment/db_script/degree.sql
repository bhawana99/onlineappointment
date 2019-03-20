drop table degree;

create table degree(
degree_id number not null primary key,
degree varchar2(10) not null unique
);

insert into degree values(1,'MBBS');
insert into degree values(2,'BMBS');
insert into degree values(3,'MD');
insert into degree values(4,'MD(Res)');
insert into degree values(5,'Dr.Med');
insert into degree values(6,'DS');