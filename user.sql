create database web1992;

create table web1992.`t_user`(
    `id` bigint(20) primary key auto_increment,
    `name` varchar(18),
    `birth_day` datetime
);

insert  into web1992.`t_user` (name,birth_day) values('test1',now());
insert  into web1992.`t_user` (name,birth_day) values('test2',now());

select  * from web1992.`t_user`;