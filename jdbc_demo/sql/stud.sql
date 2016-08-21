/*建立数据库*/
CREATE DATABASE jdbc1 CHARACTER SET UTF8;
USE jdbc1
CREATE TABLE stud(
   id INT,
   NAME VARCHAR(20),
   les VARCHAR(20),
   score INT
);
INSERT INTO stud VALUES(1,'Tom','Java',33),(2,'Tom','SQL',44),(3,'Jack','Java',66),(4,'Jack','SQL',88);

SELECT * FROM stud;


CREATE TABLE users(
  id INT PRIMARY KEY,
  NAME VARCHAR(20)
);

CREATE TABLE users2(
  id INT PRIMARY KEY,
  NAME VARCHAR(20),
  birth1 DATETIME,
  birth2 VARCHAR(19)
);
INSERT INTO users2 VALUES('1','tom','2011-09-09 12:09:09','2011-09-09 12:09:09');

SHOW TABLES;
SELECT * FROM users2;


CREATE TABLE ldata(
  txt VARCHAR(8000)
);

CREATE TABLE ldata2(
 img BLOB
);
CREATE TABLE student(
   id INT,
   sname VARCHAR(20),
   les VARCHAR(20),
   score INT
);
INSERT INTO student VALUES(1,'Tom','Java',33),(2,'Tom','SQL',44),(3,'Jack','Java',66),(4,'Jack','SQL',88);