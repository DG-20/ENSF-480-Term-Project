# Rent'R'Us

Rent'R'Us is an Online Rental Property Management System designed to allow renters, landlords, and managers to rent, manage, and register properties

## Pre-Requisites

 - MySQL
 - Java Version 11


## Instructions
First create a user in MySQL with the following details:
|  Connection Name| Username |	Password	|
|--|--|--|
| localhost | ORPMS |	ensf480|

The rest of the login information can be found in ORPMS.sql


## To compile & Run on Windows

```bash
cd ENSF-480-Term-Project/src
javac -cp ".;./lib/mysql-connector-java-8.0.23.jar" User_Interface_Layer/StartUp.java
java -cp ".;./lib/mysql-connector-java-8.0.23.jar" User_Interface_Layer/StartUp
```

## To compile & Run on Mac
```bash
cd ENSF-480-Term-Project/src
javac -cp .:lib/mysql-connector-java-8.0.23.jar:. User_Interface_Layer/StartUp.java
java  -cp .:lib/mysql-connector-java-8.0.23.jar:. User_Interface_Layer.StartUp
```

## UML diagrams
![UML Diagram](https://github.com/DG-20/ENSF-480-Term-Project/blob/main/uml.png?raw=true)
![Class DIagram](https://github.com/DG-20/ENSF-480-Term-Project/blob/main/Class_Diagram.jpg?raw=true)


## Contributors
<a href="https://github.com/DG-20/ENSF-480-Term-Project/graphs/contributors">
  <img src="https://contrib.rocks/image?repo=DG-20/ENSF-480-Term-Project" />
</a>

Made with [contrib.rocks](https://contrib.rocks).

