drop table Person;
drop table Passport;

-- First case without id
CREATE TABLE Person(
                       id int primary key generated by default as identity,
                       name varchar(100) not null,
                       age int check ( age < 100 )
);

CREATE TABLE Passport(
                         person_id int primary key references  Person(id) on delete cascade ,
                         pasport_number int not null
);

drop table Person;
drop table Passport;


-- Second case with id
CREATE TABLE Person
(
    id   int primary key generated by default as identity,
    name varchar(100) not null,
    age  int check ( age < 100 )
);

CREATE TABLE Passport
(
    id             int primary key generated by default as identity,
    person_id      int unique references Person(id) on delete cascade,
    passport_number int not null
);

select * from Person;
