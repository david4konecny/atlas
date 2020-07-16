drop table if exists users;

create table users (
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(256) not null,
    enabled boolean not null
);

drop table if exists authorities;

create table authorities (
    username varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    foreign key (username) references users (username)
);