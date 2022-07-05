CREATE TABLE Actor
(
    id   int generated by default as identity primary key,
    name varchar(100) not null unique,
    age  int check ( age > 0 )
);

CREATE TABLE Movie
(
    id                 int generated by default as identity primary key,
    name               varchar(200) not null unique,
    year_of_production int check ( year_of_production > 1900 )
);

CREATE TABLE Actor_Movie
(
    actor_id int references Actor (id),
    movie_id int references Movie (id),
    PRIMARY KEY (actor_id, movie_id)
);

select * from Actor;
select * from Movie;
select * from Actor_Movie;