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
('john@example.com', 'john123', 'John Baker', 'RR'),
('admin@example.com', 'admin123', 'Admin Person', 'Manager'),
('landlord@example.com', 'll1', 'Kenny Kenith', 'Landlord'),
('tom@example.com', 'tom123', 'Tom Sawyer', 'RR'),
('landlord2@example.com', 'll2', 'Bob Mawyer', 'Landlord'),
('landlord3@example.com', 'll3', 'Matt Lawyer', 'Landlord'),
('landlord4@example.com', 'll4', 'Rob Bowyer', 'Landlord'),
('landlord5@example.com', 'll5', 'Jim Rawyer', 'Landlord'),
('ll6@example.com', 'll6', 'Rick Mawyer', 'Landlord'),
('rr1@example.com', 'rr1', 'Gale Nawyer', 'RR'),
('rr2@example.com', 'rr2', 'Rob Fawyer', 'RR'),
('rr3@example.com', 'rr3', 'Mary Lamb', 'RR'),
('rr4@example.com', 'rr4', 'Sam Sammy', 'RR');

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
PostedDate      timestamp,
ExpDate         timestamp,
RentedDate 		timestamp,
primary key (ID),
foreign key (LandlordEmail) references USER(Email) ON UPDATE CASCADE
);

INSERT INTO property (LandlordEmail, Status, Quadrant, Address, Furnished, numBathrooms, numBedrooms, Type, PostedDate, ExpDate, RentedDate) VALUES
('landlord@example.com', 'Active', 'NE', '402 Elmo Street NE', 'Y', 2, 4, 'Detached', '2021-11-24', '2021-12-30', NULL),
('landlord@example.com', 'Active', 'NW', '123 Baker Street NW', 'Y', 1, 3, 'Dormitory', '2021-11-24', '2022-12-30', NULL),
('landlord2@example.com', 'Active', 'SW', '123 Grover Street N', 'N', 1, 3, 'Apartment', '2021-11-29', '2021-12-29', NULL),
('landlord2@example.com', 'Active', 'SW', '500 Orange Drive N', 'N', '1', 3, 'Apartment', '2021-11-29', '2022-12-29', NULL),
('landlord@example.com', 'Suspended', 'SE', '421 University Drive SE', 'Y', '2', '1', 'Dormitory', '2021-10-30', '2021-11-30', NULL),
('landlord4@example.com', 'Active', 'SE', '421 Maple Drive SE', 'Y', '2', '1', 'Apartment', '2021-10-30', '2021-11-30', NULL),
('landlord4@example.com', 'Cancelled', 'SE', '300 Maple Drive SE', 'Y', '2', '1', 'Apartment', '2021-11-30', '2021-11-30', NULL ),
('landlord4@example.com', 'Cancelled', 'NW', '405 Maple Drive SW', 'N', '4', '4', 'Apartment', '2021-09-30', '2021-11-30' , NULL),
('landlord@example.com', 'Suspended', 'SW', '123 Garbage Street SW', 'Y', 2, 4, 'Dormitory', '2021-12-01', '2022-1-30', '2021-12-05'),
('landlord@example.com', 'Rented', 'SE', '123 Pororidge Drive SE', 'Y', 3, 3, 'Apartment', '2021-12-06', '2022-1-30', '2021-12-09'),
('landlord3@example.com', 'Rented', 'NE', '232 Whitehaven Crescent NE', 'N', 1, 1, 'Apartment', '2021-12-06', '2022-1-30', '2021-12-09'),
('landlord3@example.com', 'Cancelled', 'NW', '415 Elmo Street SW', 'N', 1, 1, 'Apartment', '2021-10-20', '2021-11-20', NULL),
('landlord3@example.com', 'Active', 'NE', '100 Crow Street NE', 'Y', 1, 1, 'Apartment', '2021-10-20', '2022-1-30', NULL),
('landlord3@example.com', 'Rented', 'NE', '100 Banana Street NE', 'Y', 1, 1, 'Apartment', '2021-10-20', '2022-1-30', '2021-12-09'),
('ll6@example.com', 'Suspended', 'NE', '333 SanFran Drive NE', 'Y', 3,1, 'Penthouse', '2020-11-19', '2022-3-12', NULL),
('landlord5@example.com', 'Rented', 'SE', '444 Jacob Ave SE', 'N', 1,1, 'Townhouse', '2021-05-10', '2022-11-15', '2021-08-11'),
('landlord5@example.com', 'Active', 'NW', '678 Koop Street NW', 'Y', 4,4, 'Detached', '2021-02-07', '2022-10-25', NULL),
('ll6@example.com', 'Active', 'SW', '999 Jingle Avenue SW', 'N', 1,2, 'Attached', '2021-04-09', '2022-7-26', NULL),
('landlord5@example.com', 'Cancelled', 'NE', '233 Excalibur Street NE', 'N', 1,1, 'Attached', '2021-09-13', '2022-2-20', NULL),
('landlord4@example.com', 'Active', 'SE', '100 Northway SE', 'N', 2,2, 'Detached', '2021-12-09', '2022-1-30', NULL);

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
('john@example.com', 'NW', 'Y', 1, 3, 'Dormitory'),
('tom@example.com', 'SW', 'N', 1, 3, 'Apartment'),
('rr2@example.com', 'SE', 'N', 1, 1, 'Dormitory'),
('rr2@example.com', 'SE', 'Y', 2, 1, 'Apartment'),
('rr3@example.com', 'NW', 'Y', 9, 9, 'Townhouse'),
('rr3@example.com', 'NE', 'Y', 2, 4, 'Detached' ),
('rr3@example.com', 'NW', 'N', 2, 7, 'Detached'),
('tom@example.com', 'NW', 'N', 2, 7, 'Detached'),
('tom@example.com', 'SE', 'Y', 3, 3, 'Apartment'),
('tom@example.com', 'NW', 'N', 1, 1, 'Apartment'),
('rr2@example.com', 'SE', 'N', 2,  2, 'Detached'),
('tom@example.com', 'NE', 'N', 1, 1, 'Attached'),
('tom@example.com', 'SW', 'N', 1, 2, 'Attached'),
('rr1@example.com', 'NW', 'Y', 4, 4, 'Detached'),
('rr1@example.com', 'NE', 'Y', 3, 1, 'Penthouse'),
('rr1@example.com', 'SE', 'N', 1, 1, 'Townhouse'),
('john@example.com', 'SE', 'N', 2,  2, 'Detached');

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

