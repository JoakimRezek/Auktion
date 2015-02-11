DROP DATABASE AUKTION;

CREATE DATABASE AUKTION;

USE AUKTION;

CREATE TABLE Leverantör(
  Organisationsnummer VARCHAR(15) NOT NULL,
  Företagsnamn VARCHAR(45) NULL,
  Provision INT NULL,
  Kontaktperson VARCHAR(45) NULL,
  Email VARCHAR(45) NULL,
  Telefonnummer VARCHAR(15) NULL,
  
  PRIMARY KEY (Organisationsnummer));

CREATE TABLE Kund(
  PersonNummer varchar(14) NOT NULL,
  Förnamn VARCHAR(20) NULL,
  Efternamn VARCHAR(30) NULL,
  Adress VARCHAR(45) NULL,
  Postnummer VARCHAR(5) NULL,
  Ort VARCHAR(25) NULL,
  Telefonnummer VARCHAR(15) NULL,
  Email VARCHAR(45) NULL,
  
  PRIMARY KEY (PersonNummer));

CREATE TABLE Kategori(
  KategoriID INT NOT NULL AUTO_INCREMENT,
  Kategorinamn VARCHAR(45) NULL,
  
  PRIMARY KEY (KategoriID));

CREATE TABLE Auktion(
  AuktionsID INT NOT NULL AUTO_INCREMENT,
  Startdatum DATETIME NULL,
  Utgångspris DOUBLE NULL,
  Acceptpris DOUBLE NULL,
  Slutdatum DATETIME NULL,
  Produktnamn VARCHAR(45) NULL,
  Produktkategori INT NULL,
  AvslutadAuktion BOOL NOT NULL DEFAULT FALSE,
  Leverantör VARCHAR(15) NOT NULL,
  
  PRIMARY KEY (AuktionsID),
  
  CONSTRAINT Auktion_Leverantör_fk FOREIGN KEY(Leverantör) REFERENCES Leverantör(Organisationsnummer) ON DELETE CASCADE,
  CONSTRAINT Auktion_Katerogi_fk FOREIGN KEY(Produktkategori) REFERENCES Kategori(KategoriID) ON DELETE SET NULL
  );


CREATE TABLE  Bud(
  Auktion INT NOT NULL,
  Kund varchar(14) NOT NULL,
  Pris DOUBLE NULL,
  
  PRIMARY KEY (Auktion, Kund, Pris),
  
  CONSTRAINT Bud_Auktion_fk FOREIGN KEY(Auktion) REFERENCES Auktion(AuktionsID) ON DELETE CASCADE,
  CONSTRAINT Bud_Kund_fk FOREIGN KEY(Kund) REFERENCES Kund(PersonNummer) ON DELETE CASCADE);


create view hogstaBud as select b1.pris, b1.kund, b1.auktion from bud as b1
left join bud as b2 on b1.auktion = b2.auktion and b1.pris < b2.pris
where b2.pris is null;

create view PågåendeAuktioner
as select AuktionsID, Produktnamn, kategorinamn as kategori, StartDatum, Slutdatum, Utgångspris, hogstabud.Pris as Maxbud, Acceptpris, 
	      Företagsnamn, Provision, Kontaktperson, Leverantör.Email as Email, Leverantör.Telefonnummer as Telefonnummer, 
          hogstabud.Kund, Leverantör.Organisationsnummer, AvslutadAuktion as Avslutad
from Auktion
inner join Leverantör on Auktion.leverantör = Leverantör.Organisationsnummer
left join hogstabud on hogstabud.auktion = auktion.auktionsid
left join Kund on hogstaBud.Kund = Kund.PersonNummer
left join Kategori on Auktion.produktkategori = Kategori.kategoriid
group by AuktionsId;

create view Budhistorik
as select Bud.Auktion, Produktnamn,  Förnamn, Efternamn, Pris, bud.kund
from bud
inner join Kund on Bud.Kund = Kund.Personnummer
inner join Auktion on Bud.Auktion = Auktion.AuktionsID
order by pris desc;