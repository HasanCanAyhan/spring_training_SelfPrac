
drop table if exists employees;

create table Employees(
    id bigint not null,
    name varchar(255),
    primary key (id)
);