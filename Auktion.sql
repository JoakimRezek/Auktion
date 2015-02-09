CREATE DATABASE AUKTION;


CREATE TABLE Leverantör(
  Organisationsnummer VARCHAR(15) NOT NULL,
  Företagsnamn VARCHAR(45) NULL,
  Provision INT NULL,
  Kontaktperson VARCHAR(45) NULL,
  Email VARCHAR(45) NULL,
  Telefonnummer VARCHAR(15) NULL,
  
  PRIMARY KEY (Organisationsnummer));

CREATE TABLE Kund(
  PersonNummer INT NOT NULL,
  Förnamn VARCHAR(20) NULL,
  Efternamn VARCHAR(30) NULL,
  Adress VARCHAR(45) NULL,
  Postnummer INT NULL,
  Ort VARCHAR(25) NULL,
  Telefonnummer VARCHAR(15) NULL,
  Email VARCHAR(45) NULL,
  
  PRIMARY KEY (PersonNummer));


CREATE TABLE Auktion(
  AuktionsID INT NOT NULL AUTO_INCREMENT,
  Startdatum DATETIME NULL,
  Utgångspris DOUBLE NULL,
  Acceptpris DOUBLE NULL,
  Slutdatum DATETIME NULL,
  Produktnamn VARCHAR(45) NULL,
  Produktkategori VARCHAR(45) NULL,
  Leverantör VARCHAR(15) NOT NULL,
  
  PRIMARY KEY (AuktionsID),
  
  CONSTRAINT Auktion_Leverantör_fk FOREIGN KEY(Leverantör) REFERENCES Leverantör(Organisationsnummer) ON DELETE CASCADE);


CREATE TABLE Kategori(
  KategoriID INT NOT NULL AUTO_INCREMENT,
  Kategorinamn VARCHAR(45) NULL,
  
  PRIMARY KEY (KategoriID));


CREATE TABLE AuktionsKategori(
  Auktion INT NOT NULL,
  Kategori INT NOT NULL,
  
  PRIMARY KEY (Auktion, Kategori),
  
  CONSTRAINT AuktionsKategori_Auktion_fk FOREIGN KEY(Auktion) REFERENCES Auktion(AuktionsID) ON DELETE CASCADE,
  CONSTRAINT AuktionsKategori_Kategori_fk FOREIGN KEY(Kategori) REFERENCES Kategori(KategoriID) ON DELETE CASCADE);


CREATE TABLE  Bud(
  Auktion INT NOT NULL,
  Kund INT NOT NULL,
  Pris DOUBLE NULL,
  
  PRIMARY KEY (Auktion, Kund),
  
  CONSTRAINT Bud_Auktion_fk FOREIGN KEY(Auktion) REFERENCES Auktion(AuktionsID) ON DELETE CASCADE,
  CONSTRAINT Bud_Kund_fk FOREIGN KEY(Kund) REFERENCES Kund(PersonNummer) ON DELETE CASCADE);
