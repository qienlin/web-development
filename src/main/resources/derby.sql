CREATE SCHEMA library;
use library;
CREATE TABLE book(id  BIGINT not null generated by default as identity,name varchar(50),price varchar(50),isbn varchar(40))
INSERT INTO book VALUES(1,'Effective Java','30','3232543353')
INSERT INTO book VALUES(2,'Thinking in Java','98','235454455')

INSERT INTO book VALUES(3,'Core Java','45','546456546')
INSERT INTO book VALUES(4,'Oracle','72','54654')
INSERT INTO book VALUES(5,'Deep into JVM','43','234234')
INSERT INTO book VALUES(6,'Spring MVC','12','234324324')
INSERT INTO book VALUES(7,'Lucene in Action','42','234324234')