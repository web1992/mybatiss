create database web1992;

create table web1992.`t_user`(
    `id` bigint(20) primary key auto_increment,
    `name` varchar(18),
    `birth_day` datetime,
     age int default 0
);

insert  into web1992.`t_user` (name,birth_day) values('test1',now());
insert  into web1992.`t_user` (name,birth_day) values('test2',now());
insert  into web1992.`t_user` (name,birth_day) values('test3',now());
insert  into web1992.`t_user` (name,birth_day) values('test4',now());
insert  into web1992.`t_user` (name,birth_day) values('test5',now());
insert  into web1992.`t_user` (name,birth_day) values('test6',now());
insert  into web1992.`t_user` (name,birth_day) values('test7',now());

select  * from web1992.`t_user`;

update web1992.t_user set age =age+1 where id =1;

SET [GLOBAL | SESSION] TRANSACTION ISOLATION LEVEL
  {
       REPEATABLE READ
     | READ COMMITTED
     | READ UNCOMMITTED
     | SERIALIZABLE
   }


SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
SET SESSION TRANSACTION ISOLATION LEVEL REPEATABLE READ;

show variables like '%isolation%';