drop table teacher;
drop table workload;

create table teacher(t_id int primary key, t_name varchar(50));

create table workload(subject_code int primary key, subject varchar(20), date_ date, time_ time , class varchar(20), t_id int references teacher(t_id) on delete cascade);

