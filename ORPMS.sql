DROP DATABASE IF EXISTS orpms;
CREATE DATABASE orpms;
USE orpms;

DROP TABLE IF EXISTS user;
CREATE TABLE user (
    Email                  varchar(255) NOT NULL,
    Password               varchar(25) NOT NULL,
    Name                   varchar(25) NOT NULL,
    Type                   varchar(10) NOT NULL,
    primary key (Email)
);

INSERT INTO user (Email, Password, Name, Type) VALUES
('john@example.com', 'pass', 'John', 'RR'),
('admin@example.com', 'superpassword', 'admin', 'Manager'),
('landlord@example.com', 'slumlord', 'Kenny', 'Landlord'),
('tom@example.com', 'pass', 'Tom', 'RR'),
('landlord2@example.com', 'pass', 'Bob', 'Landlord'),
('landlord3@example.com', 'pass', 'Matt', 'Landlord'),
('landlord4@example.com', 'pass', 'Rob', 'Landlord'),
('landlord5@example.com', 'pass', 'Jim', 'Landlord'),
('rr1@example.com', 'pass', 'Gale', 'RR'),
('rr2@example.com', 'pass', 'Rob', 'RR'),
('rr3@example.com', 'pass', 'Mary', 'RR'),
('rr4@example.com', 'pass', 'Sam', 'RR');

DROP TABLE IF EXISTS property;
CREATE TABLE property (
ID              int NOT NULL AUTO_INCREMENT,
LandlordEmail   varchar(255),
Status 			varchar(10),
Quadrant        char(2) ,
Address         varchar(100), 
Furnished       char(1),
numBathrooms    TINYINT,
numBedrooms     TINYINT,
Type           varchar(25),
PostedDate      DATE,
ExpDate         DATE,
primary key (ID),
foreign key (LandlordEmail) references USER(Email) ON UPDATE CASCADE
);

INSERT INTO property (LandlordEmail, Status, Quadrant, Address, Furnished, numBathrooms, numBedrooms, Type, PostedDate, ExpDate) VALUES
('landlord@example.com', 'Active', 'NE', '402 Elmo Street NE', 'Y', 2, 4, 'Detached', '2021-11-24', '2021-12-24'),
('landlord2@example.com', 'Active', 'SW', '123 Grover Street SW', 'N', 1, 3, 'Apartment', '2021-11-29', '2021-12-29'),
('landlord@example.com', 'Suspended', 'SE', '421 University Drive SE', 'Y', '2', '1', 'Dormitory', '2021-10-30', '2021-11-30'),
('landlord4@example.com', 'Active', 'SE', '421 Maple Drive SE', 'Y', '2', '1', 'Apartment', '2021-10-30', '2021-11-30'),
('landlord4@example.com', 'Rented', 'SE', '300 Maple Drive SE', 'Y', '2', '1', 'Apartment', '2021-11-30', '2021-11-30'),
('landlord3@example.com', 'Cancelled', 'NW', '415 Elmo Street SW', 'N', 1, 1, 'Apartment', '2021-10-20', '2021-11-20');

DROP TABLE IF EXISTS subscription;
CREATE TABLE subscription (
RREmail         varchar(255),
Quadrant        char(2),
Furnished       char(1),
numBathrooms    TINYINT,
numBedrooms     TINYINT,
Type            varchar(25),
foreign key (RREmail) references USER(Email) ON UPDATE CASCADE    
);

INSERT INTO subscription(RREmail, Quadrant, Furnished, numBathrooms, numBedrooms, Type) VALUES
('john@example.com', 'NE', 'Y', 2, 4, 'Detached'),
('tom@example.com', 'SW', 'N', 1, 3, 'Apartment'),
('rr2@example.com', 'SE', 'N', 1, 1, 'Dormitory'),
('rr2@example.com', 'SE', 'Y', 2, 1, 'Apartment');

DROP TABLE IF EXISTS fee;
CREATE TABLE fee (
    restriction ENUM(' ') NOT NULL,
    Fee int NOT NULL,
    PRIMARY KEY(restriction)
);

DROP TABLE IF EXISTS period;
CREATE TABLE period (
    restriction ENUM(' ') NOT NULL,
    Period int NOT NULL,
    PRIMARY KEY (Period)
);

INSERT INTO FEE(Fee) VALUES (60);
INSERT INTO PERIOD(Period) VALUES (30);

