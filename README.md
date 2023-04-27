<h1 align="center"> A Library Management System </h1>

The author has design and developed a Library Management System. 

Tech Stack utilised in the building of this project are as follows :

*  _Spring MVC architecture_
*  _Hibernate ORM_
*  _SQL_ 
*  _REST API's_ 

<p align="justify"> The project intends to create an easy-to-use Library Management System, wherein *issue* of books, available in the Library, to the students, their *return*, and subsequent management of such data in the form of *transactions* (entity), in the database, is facilitated to the user with much ease. The project utilizes industry-level framewok and software development techniques. </p>

<p align="justify"> REST-Full API's are created for creation of library card of a particular student, and its updating based on book issue and returns. Also, an API has been built using "JavaMailSender" to send automatic email to the students upon issuance of books. </p>

**Database** : MySQL

**Project executed in** : MySQL and PostgreSQL

**CRUD ops** : To update data in DB using JPA/Hibernate (ORM) and verification via hardcoded SQL queries.

**Client** : DBeaver used for visual representation of database

<h2 align="left"> Development Stages </h2>

1. *Create a Spring Boot Application*

2. *Project Structure*

3. *Pom Dependencies*

4. *Java Bean - Student.java*

5. *Create REST Controller - StudentController.java*

6. *Run Application - Application.java*

7. *Testing from Postman Client*

<h2 align="left"> Port and Configuration </h2>

Run the application on Port : 8080 

The project can be viewed by accessing the url : [Library-Management-System](http://localhost:8080/swagger-ui/index.html  "Library-Management-System")

> In case the application is run on a different port, the new-port has to be reflected in the above url as well.

**Configuration for PostgreSQL** : Incorporate the below code in application.properties

> spring.datasource.url = jdbc:postgresql://localhost:5432/database_name?createTableIfNotExists=true

> spring.datasource.username = postgres

> spring.datasource.password = <enter_your_password>

> spring.datasource.driver-class-name = org.postgresql.Driver

> spring.jpa.hibernate.ddl-auto = update

<h2 align="left"> Database Schema </h2>

ER Model / Parent-Child Mapping representation

White small squares : _Parent_ 

Dark solid circle : _Child_

<p align="center"> 
    <img width="536" alt="image" src="https://github.com/po-strikes25/Library-Management-System/blob/master/src/main/java/com/example/LibraryManagementSystem/images/ER_diagram_lms_april.png">
</p>

<h2 align="left"> Swagger </h2>

Swagger is used to build, document, test and consume the APIs created for this project. Swagger primarily helps to design, document and manage these APIs.

<h3 align="center"> HomePage </h3>

To access the project in a browser hit this url post running the Spring Boot application : http://localhost:8080/swagger-ui/index.html

<p align="center"> 
    <img width="536" alt="image" src="https://github.com/po-strikes25/Library-Management-System/blob/master/src/main/java/com/example/LibraryManagementSystem/images/swagger-ui.png">
</p>
