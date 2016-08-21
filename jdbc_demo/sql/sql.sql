/*创建数据库*/
create database day19 character set UTF8;
/*建表*/
create table test(
 id int,
 name varchar(20)
);
insert into test values(1,'王健');
select * from test;
delete from test;
/*事务的简单操作*/
start transaction;
insert into test values(2,'Jack');
commit;

/*用户表*/
create table users(
   id int primary key,
   name varchar(20),
   money numeric(10,2)
);
/*明细表*/
create table detail(
  id int primary key,
  u_id int,
  type char(1),   /*0:查询，1：ck,2:qk,3:zz*/
  money numeric(10,2),
  dt varchar(19)
);
alter table detail
  add constraint d_fk foreign key(u_id) references users(id);

delete from users;
select * from users;
delete from detail;
select * from detail;
insert into users values(1,'Jack',100.00);

/*创建过程,接收两个输入参数和两个输出参数*/
DROP PROCEDURE abc if exists;
DELIMITER$$
CREATE PROCEDURE abc(IN id INT,IN nm VARCHAR(30),OUT ct INT,OUT a VARCHAR(30))
BEGIN
 INSERT INTO users VALUES(id,nm,99);
 SELECT COUNT(*) INTO ct FROM users;
 SET a='kkkk';
END$$
DELIMITER ;

SELECT * FROM users;
/*调用存储过程*/
CALL abc(177,'ROm',@a,@k);
SELECT @a,@k;

DROP TABLE stud;
/*创建一个学生表,指定主键是自动增长的*/
CREATE TABLE stud(
  id INT PRIMARY KEY AUTO_INCREMENT,
  NAME VARCHAR(30)
);
INSERT INTO stud(NAME) VALUES('Jack');
SELECT * FROM stud;

/*创建写入学生表信息的存存存储过程*/
DELIMITER$$
CREATE PROCEDURE pstud(OUT id INT,IN nm VARCHAR(30))
BEGIN
 INSERT INTO stud(NAME) VALUES(nm);
 SELECT LAST_INSERT_ID() INTO id; /*设置刚生成 的新值*/
END$$
DELIMITER ;
/*调用并输出*/
CALL pstud(@a,'aaaa');
SELECT @a;






