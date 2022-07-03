Spring Data JDBC is a persistence framework simpler than Spring Data JPA. 

It doesn't provide cache, lazy loading or many other features of JPA. 
BUT it has  it's own ORM and provides most of the features of Spring Data JPA like mapped entities, repositories, query annotations, and JdbcTemplate.

IMPORTANT :  Spring Data JDBC doesn't offer schema generation.We are responsible for explicitly creating the schema.(i.e no automatic table creation!)
No support for auto ID generation.

1.  Adding Spring Data JDBC to the Project
Add spring data jdbc dependency , at the time of creation of spring boot project & then this gets auto added under pom.xml
<dependency>
 <groupId>org.springframework.boot</groupId>
 <artifactId>spring-boot-starter-data-jdbc</artifactId>
</dependency>

2. The layers changed will be only POJO n DAO
No @Table , @GeneratedValue support.

Additional reference
https://ordina-jworks.github.io/java/2020/01/02/Spring-Data-Jdbc.html

How to run ?
create table emps (empid int primary key auto_increment,name varchar(20),salary double);
insert into emps values(default,'Riya',10000);
insert into emps values(default,'Rutu',20000);
insert into emps values(default,'Anish',30000);
insert into emps values(default,'Riya',40000);