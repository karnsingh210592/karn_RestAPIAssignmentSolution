use employeedb;
insert into users values(1,'$2a$12$vVVREq8hxEmBUK65zEZJoO6dHOQfXqJSTqpmVI4VokCTdA1EeWZ5a','Lakshmi');
insert into users values(2,'$2a$12$vVVREq8hxEmBUK65zEZJoO6dHOQfXqJSTqpmVI4VokCTdA1EeWZ5a','Prasanna');

insert into roles values(1,'ADMIN');
insert into roles values(2,'USER');

insert into users_roles values(1,1);
insert into users_roles values(2,2);