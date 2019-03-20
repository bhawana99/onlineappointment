drop table admin;

create table admin(
admin_id number(2) primary key not null,
admin_email varchar2(40) unique not null,
admin_password varchar2(20) not null
);


insert into admin values(1,'admin123@gmail.com','#admin123');
