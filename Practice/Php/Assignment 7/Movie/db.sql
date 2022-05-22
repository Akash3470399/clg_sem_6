drop table actor;
drop table movie;

create table actor(actor_no int primary key, name varchar(50));
create table  movie(movie_no int primary key, movie_name varchar(50), release_year int);

create table actor_movie(actor_no int references actor(actor_no) on delete cascade, movie_no int references on delete cascade, rate int);