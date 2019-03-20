drop table department;

create table department(
dept_id varchar(3) primary key,
dept_name varchar(20) unique not null
);

insert into department values('d1','Dermatology');
insert into department values('d2','Pediatrics');
insert into department values('d3','Cardiologist');
insert into department values('d4','General Medicine');
insert into department values('d5','Gynecology');
insert into department values('d6','Neurology');


alter table department
add diseases varchar2(200);

update department
set diseases='skin cancer,skin diseases, eczemas,hair fall,skin dryness' where dept_id='d1';


update department
set diseases='anemia, asthma, chickenpox, diphtheria, 
leukemia, measles, mumps, pneumonia, polio, tuberculosis, 
whooping cough, lyme disease, dental caries, cystic fibrosis'
where dept_id='d2';




update department
set diseases='chest pain, chest tightness,shortness of breath
,numbness, weakness or coldness in your legs or arms 
,pain in the neck, jaw, throat, upper abdomen or back'
where dept_id='d3';


update department
set diseases='fever,cold and cough,stomach ache,loose motion,vomiting,eye infection,ear infection,hypertension
headache,high blood pressure,diabetis,body pain,dizziness'
where dept_id='d4';


update department
set diseases='General gynecologic exams, procedures and treatments, 
including pelvic examinations and Pap Smears, breast exams and Breast Self-Examination
Pregnancy care,Miscarriage,Abnormal bleeding,Menopause'
where dept_id='d5';


update department
set diseases='paralysis, muscle weakness, poor coordination, loss of sensation, seizures, confusion, pain and
 altered levels of consciousness'
where dept_id='d6';


update department 
set dept_name='abc',diseases='12345' where dept_id='d7';
