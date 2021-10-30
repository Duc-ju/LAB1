CREATE TABLE Customer (ID int(10) NOT NULL AUTO_INCREMENT, Nickname varchar(255) NOT NULL, AccountID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Adress (ID int(10) NOT NULL AUTO_INCREMENT, Fullname varchar(255), PhoneNumber varchar(255) NOT NULL, FullAddress varchar(1023) NOT NULL, CustomerID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Account (ID int(10) NOT NULL AUTO_INCREMENT, UserName varchar(255) NOT NULL, Password varchar(255) NOT NULL, IsAdmin int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Cart (ID int(10) NOT NULL AUTO_INCREMENT, IsOrdered int(10) NOT NULL, CustomerID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Payment (ID int(10) NOT NULL AUTO_INCREMENT, Method varchar(255) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Shipment (ID int(10) NOT NULL AUTO_INCREMENT, Fee float NOT NULL, AdressID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE BookItem (ID int(10) NOT NULL AUTO_INCREMENT, CurrentPrice float NOT NULL, Quantity int(10) NOT NULL, BookID int(10) NOT NULL, CartID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Category (ID int(10) NOT NULL AUTO_INCREMENT, CategoryName varchar(255) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE Book (ID int(10) NOT NULL AUTO_INCREMENT, Title varchar(1023) NOT NULL, Image varchar(511), Author varchar(255), Price float NOT NULL, Description varchar(2047), AvaiableQuantity int(10) NOT NULL, CategoryID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
CREATE TABLE `Order` (ID int(10) NOT NULL AUTO_INCREMENT, OrderTime date NOT NULL, ShipmentID int(10) NOT NULL, PaymentID int(10) NOT NULL, CartID int(10) NOT NULL, PRIMARY KEY (ID)) ENGINE=InnoDB CHARACTER SET UTF8;
ALTER TABLE Adress ADD CONSTRAINT FKAdress122847 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);
ALTER TABLE Shipment ADD CONSTRAINT FKShipment209280 FOREIGN KEY (AdressID) REFERENCES Adress (ID);
ALTER TABLE Cart ADD CONSTRAINT FKCart195823 FOREIGN KEY (CustomerID) REFERENCES Customer (ID);
ALTER TABLE Book ADD CONSTRAINT FKBook738236 FOREIGN KEY (CategoryID) REFERENCES Category (ID);
ALTER TABLE BookItem ADD CONSTRAINT FKBookItem659810 FOREIGN KEY (CartID) REFERENCES Cart (ID);
ALTER TABLE BookItem ADD CONSTRAINT FKBookItem474144 FOREIGN KEY (BookID) REFERENCES Book (ID);
ALTER TABLE Customer ADD CONSTRAINT FKCustomer95365 FOREIGN KEY (AccountID) REFERENCES Account (ID);
ALTER TABLE `Order` ADD CONSTRAINT FKOrder751924 FOREIGN KEY (ShipmentID) REFERENCES Shipment (ID);
ALTER TABLE `Order` ADD CONSTRAINT FKOrder92191 FOREIGN KEY (PaymentID) REFERENCES Payment (ID);
ALTER TABLE `Order` ADD CONSTRAINT FKOrder795597 FOREIGN KEY (CartID) REFERENCES Cart (ID);