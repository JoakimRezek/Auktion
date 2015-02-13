use Auktion;


insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('927467-0293', 'Jeans&Co', 0, 'Emil i Lönneberga', 'Friggenboa@hotmail.com', '070-1928764');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('836748-2874', 'Johnson&Johnson', 10, 'Mysig Kille', 'Yeah@hotmail.com', '070-8759903');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('875889-3645', 'Awesome...Really Awesom', 70, 'Johnny Bravo', 'HuhshwischhiiYAa@hotmail.com', '070-7785993');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('857849-2934', 'McDonald´s', 30, 'Ronald McDonald', 'BigMac@hotmail.com', '070-3984995');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('394839-1938', 'Myrorna', 50, 'Karl Edwalsson', 'KarlE@myrorna.se', '070-3904850');

insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('960726-3645', 'Harald', 'Troiter', 'Femgatan 6', '17782', 'Gnesta', '0734558991', 'haraldtroiter@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('950312-2286', 'Kalle', 'Patriksson', 'Karlvägen 16', '17782', 'Järfälla', '0748365911', 'kallepatriksson@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('950123-5792', 'Thomas', 'Farez', 'Gemgatan 43', '13353', 'Spånga', '0733888491', 'thomasfarez@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('911224-2985', 'Linda', 'Troiter', 'Femgatan 6', '17782', 'Stockholm', '0799556632', 'lindatroiter@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('901007-9898', 'Johan', 'Adolfsson', 'Hanserhuldsvägen 21', '17713', 'Nässjö', '0788473628', 'figgan80@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('960122-0274', 'Karl', 'Harald', 'Fyravägen 6', '17342', 'Söresta', '0711662273', 'heromyfan@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('910322-0978', 'Joakim', 'Christiansson', 'Femgatan 36', '17782', 'Hipposta', '0765778492', 'joakim12345@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('920524-0763', 'Hans', 'Trogen', 'Hallinegatan 21', '17438', 'Kalmar', '0748365683', 'hanskungen@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('900301-0142', 'Annika', 'Typsnitt', 'Hammargatan 2', '11127', 'Karlstad', '0766668493', 'annika90@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('900209-2937', 'Ylva', 'Albertsson', 'Femgatan 56', '17782', 'Yxeholm', '0765888392', 'ylvaalbertsson@hotmail.com');
insert into Kund (PersonNummer, Förnamn, Efternamn, Adress, Postnummer, Ort, Telefonnummer, Email) values ('940226-8879', 'Johnny', 'Bravo', 'Lil´Street Woooh 666', '13384', 'BravoTown', '0766748391', 'OooohYeah@bravo.com');

insert into Kategori (Kategorinamn) values ('Byxor');
insert into Kategori (Kategorinamn) values ('Kläder');
insert into Kategori (Kategorinamn) values ('Dryck');
insert into Kategori (Kategorinamn) values ('Bilar');
insert into Kategori (Kategorinamn) values ('Motor');
insert into Kategori (Kategorinamn) values ('Verktyg');
insert into Kategori (Kategorinamn) values ('Resor');
insert into Kategori (Kategorinamn) values ('Annat');

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2013-02-01', 900.00, 1600.00, '2015-06-14', 'Cheap Monkey', 1, 1, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2013-04-11', 100.00, 25000.00, '2013-11-24', 'YeahSkor', 2, 1, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2013-01-10', 400.00, 700.00, '2015-02-10', 'Coca Cola Statue', 3, 1, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2013-07-23', 1900.00, 2100.00, '2015-12-24', 'Trasig Skjorta', 2, 1, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2013-02-28', 900000.00, 1600000.00, '2013-06-30', 'KärleksBåten Charmine', 5, 1, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2013-02-01', 100.00, 1600.00, '2015-06-14', 'TEST Stuff', 8, 1, '927467-0293');

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2014-02-11', 200.00, 4000.00, '2015-06-14', 'Levis', 1, 1, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2014-04-21', 100.00, 2000.00, '2015-11-24', 'Awesome Sneakers', 2, 1, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2014-01-20', 500.00, 7300.00, '2014-02-10', 'FANTA POOL', 3, 1, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2014-07-13', 11900.00, 122100.00, '2015-12-24', 'Gröna Skor', 2, 1, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2014-02-08', 700000.00, 1600000.00, '2015-06-30', 'Charger Motor', 5, 0, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2014-02-11', 1500.00, 12600.00, '2014-06-14', 'UTAH County', 1, 1, '927467-0293');

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-21', 100.00, 1100.00, '2015-02-14', 'Tommy Hilfiger', 1, 0, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-01', 600.00, 15000.00, '2015-05-24', 'Tuxedose', 2, 1, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-11', 4400.00, 7700.00, '2015-04-10', 'CanCan', 3, 0, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-27', 19000.00, 32100.00, '2015-11-24', 'Kavaj', 2, 1, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-21', 2000000.00, 11600000.00, '2016-06-30', 'RollsRoyce', 5, 0, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-21', 11100.00, 133600.00, '2015-11-04', 'CoolAid', 8, 0, '927467-0293');

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-11', 1900.00, 5600.00, '2015-04-24', 'Brazkor', 1, 0, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-21', 1700.00, 9000.00, '2015-12-15', 'Cool Stuffs', 8, 0, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-30', 1400.00, 2700.00, '2015-12-16', 'SPRITECANS!!!', 3, 0, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-28', 11900.00, 22100.00, '2015-06-12', 'Trasiga glasögon', 2, 0, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-18', 50000.00, 100000.00, '2016-11-20', 'LyxYacht', 5, 0, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-11', 15000.00, 61600.00, '2015-12-13', 'Resident Evil byxor', 1, 0, '927467-0293');

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-30', 2900.00, 6600.00, '2015-12-04', 'HulaHulaRing', 1, 0, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-31', 2100.00, 4000.00, '2015-12-04', 'HuuHaaaJeans', 2, 0, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-20', 2400.00, 3700.00, '2015-07-01', 'Juice', 3, 0, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-13', 21900.00, 32100.00, '2015-12-04', 'Häftiga skosnören', 2, 0, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-08', 60000.00, 1000000.00, '2016-12-02', 'KärleksBåten Hulda', 5, 0, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-11', 11100.00, 21600.00, '2015-12-24', 'RemoteControll', 8, 0, '927467-0293');

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-01', 91100.00, 200600.00, '2015-08-24', 'Jeans', 1, 0, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-11', 12000.00, 125000.00, '2015-12-04', 'Skor', 2, 0, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-10', 1400.00, 7300.00, '2015-09-11', 'Staty', 8, 1, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-23', 31900.00, 72100.00, '2015-11-21', 'Trasig sak', 2, 0, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-01-28', 94000.00, 1600000.00, '2016-04-23', 'Båt', 5, 0, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, AvslutadAuktion, Leverantör) values ('2015-02-01', 24100.00, 71600.00, '2015-03-12', 'TEST', 8, 0, '927467-0293');

insert into Bud (Auktion, Kund, Pris) values (1, '960726-3645', 900.00);
insert into Bud (Auktion, Kund, Pris) values (1, '950312-2286', 920.50);
insert into Bud (Auktion, Kund, Pris) values (1, '950123-5792', 1600.00);
insert into Bud (Auktion, Kund, Pris) values (2, '911224-2985', 100.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 120.00);
insert into Bud (Auktion, Kund, Pris) values (2, '950123-5792', 130.00);
insert into Bud (Auktion, Kund, Pris) values (2, '901007-9898', 140.00);
insert into Bud (Auktion, Kund, Pris) values (2, '960726-3645', 150.00);
insert into Bud (Auktion, Kund, Pris) values (2, '911224-2985', 160.00);
insert into Bud (Auktion, Kund, Pris) values (2, '900301-0142', 170.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 180.00);
insert into Bud (Auktion, Kund, Pris) values (2, '911224-2985', 190.00);
insert into Bud (Auktion, Kund, Pris) values (3, '960122-0274', 400.00);
insert into Bud (Auktion, Kund, Pris) values (3, '950312-2286', 700.00);
insert into Bud (Auktion, Kund, Pris) values (4, '950123-5792', 1900.00);
insert into Bud (Auktion, Kund, Pris) values (4, '901007-9898', 1950.00);
insert into Bud (Auktion, Kund, Pris) values (4, '911224-2985', 2100.00);
insert into Bud (Auktion, Kund, Pris) values (5, '940226-8879', 900000.00);


insert into Bud (Auktion, Kund, Pris) values (5, '960726-3645', 900100.00);
insert into Bud (Auktion, Kund, Pris) values (5, '950312-2286', 920000.50);
insert into Bud (Auktion, Kund, Pris) values (5, '950123-5792', 950000.00);
insert into Bud (Auktion, Kund, Pris) values (5, '940226-8879', 950100.00);
insert into Bud (Auktion, Kund, Pris) values (5, '911224-2985', 970000.00);
insert into Bud (Auktion, Kund, Pris) values (5, '950123-5792', 1600000.00);
insert into Bud (Auktion, Kund, Pris) values (6, '940226-8879', 100.00);
insert into Bud (Auktion, Kund, Pris) values (6, '960726-3645', 160.00);
insert into Bud (Auktion, Kund, Pris) values (6, '911224-2985', 170.00);
insert into Bud (Auktion, Kund, Pris) values (6, '940226-8879', 180.00);
insert into Bud (Auktion, Kund, Pris) values (6, '901007-9898', 190.00);
insert into Bud (Auktion, Kund, Pris) values (6, '940226-8879', 1600.00);
insert into Bud (Auktion, Kund, Pris) values (7, '900301-0142', 200.00);
insert into Bud (Auktion, Kund, Pris) values (7, '960122-0274', 430.00);
insert into Bud (Auktion, Kund, Pris) values (7, '911224-2985', 1950.00);
insert into Bud (Auktion, Kund, Pris) values (7, '920524-0763', 2000.00);
insert into Bud (Auktion, Kund, Pris) values (7, '910322-0978', 3000.00);
insert into Bud (Auktion, Kund, Pris) values (7, '940226-8879', 4000.00);

insert into Bud (Auktion, Kund, Pris) values (8, '960726-3645', 100.00);
insert into Bud (Auktion, Kund, Pris) values (8, '950312-2286', 220.50);
insert into Bud (Auktion, Kund, Pris) values (8, '950123-5792', 350.00);
insert into Bud (Auktion, Kund, Pris) values (8, '940226-8879', 450.00);
insert into Bud (Auktion, Kund, Pris) values (8, '940226-8879', 570.00);
insert into Bud (Auktion, Kund, Pris) values (8, '911224-2985', 690.00);
insert into Bud (Auktion, Kund, Pris) values (8, '901007-9898', 2000.00);
insert into Bud (Auktion, Kund, Pris) values (9, '960726-3645', 1960.00);
insert into Bud (Auktion, Kund, Pris) values (9, '911224-2985', 570.00);
insert into Bud (Auktion, Kund, Pris) values (9, '910322-0978', 580.00);
insert into Bud (Auktion, Kund, Pris) values (9, '940226-8879', 590.00);
insert into Bud (Auktion, Kund, Pris) values (9, '960122-0274', 600.00);
insert into Bud (Auktion, Kund, Pris) values (9, '900301-0142', 750.00);
insert into Bud (Auktion, Kund, Pris) values (10, '950312-2286', 11900.00);
insert into Bud (Auktion, Kund, Pris) values (10, '950123-5792', 11910.00);
insert into Bud (Auktion, Kund, Pris) values (10, '940226-8879', 11920.00);
insert into Bud (Auktion, Kund, Pris) values (10, '920524-0763', 11930.00);
insert into Bud (Auktion, Kund, Pris) values (10, '940226-8879', 122100.00);

insert into Bud (Auktion, Kund, Pris) values (11, '960726-3645', 700000.00);
insert into Bud (Auktion, Kund, Pris) values (11, '950312-2286', 710000.50);
insert into Bud (Auktion, Kund, Pris) values (11, '950123-5792', 720000.00);
insert into Bud (Auktion, Kund, Pris) values (11, '940226-8879', 730000.00);
insert into Bud (Auktion, Kund, Pris) values (11, '911224-2985', 740000.00);
insert into Bud (Auktion, Kund, Pris) values (12, '950123-5792', 1500.00);
insert into Bud (Auktion, Kund, Pris) values (12, '920524-0763', 1600.00);
insert into Bud (Auktion, Kund, Pris) values (12, '960726-3645', 1700.00);
insert into Bud (Auktion, Kund, Pris) values (12, '910322-0978', 12600.00);
insert into Bud (Auktion, Kund, Pris) values (13, '901007-9898', 100.00);
insert into Bud (Auktion, Kund, Pris) values (13, '940226-8879', 110.00);
insert into Bud (Auktion, Kund, Pris) values (13, '960122-0274', 120.00);
insert into Bud (Auktion, Kund, Pris) values (13, '900209-2937', 130.00);
insert into Bud (Auktion, Kund, Pris) values (14, '950312-2286', 600.00);
insert into Bud (Auktion, Kund, Pris) values (14, '960122-0274', 650.00);
insert into Bud (Auktion, Kund, Pris) values (14, '900301-0142', 660.00);
insert into Bud (Auktion, Kund, Pris) values (14, '910322-0978', 680.00);
insert into Bud (Auktion, Kund, Pris) values (14, '940226-8879', 15000.00);

insert into Bud (Auktion, Kund, Pris) values (15, '960726-3645', 4400.00);
insert into Bud (Auktion, Kund, Pris) values (15, '950312-2286', 4500.50);
insert into Bud (Auktion, Kund, Pris) values (15, '950123-5792', 4600.00);
insert into Bud (Auktion, Kund, Pris) values (16, '940226-8879', 19000.00);
insert into Bud (Auktion, Kund, Pris) values (16, '940226-8879', 19200.00);
insert into Bud (Auktion, Kund, Pris) values (16, '911224-2985', 32100.00);
insert into Bud (Auktion, Kund, Pris) values (17, '940226-8879', 2000000.00);
insert into Bud (Auktion, Kund, Pris) values (17, '901007-9898', 2002000.00);
insert into Bud (Auktion, Kund, Pris) values (18, '911224-2985', 11100.00);
insert into Bud (Auktion, Kund, Pris) values (18, '910322-0978', 11200.00);
insert into Bud (Auktion, Kund, Pris) values (18, '940226-8879', 11300.00);
insert into Bud (Auktion, Kund, Pris) values (19, '960122-0274', 1900.00);
insert into Bud (Auktion, Kund, Pris) values (19, '911224-2985', 1950.00);
insert into Bud (Auktion, Kund, Pris) values (19, '950312-2286', 1980.00);
insert into Bud (Auktion, Kund, Pris) values (20, '950123-5792', 1730.00);
insert into Bud (Auktion, Kund, Pris) values (20, '940226-8879', 1770.00);
insert into Bud (Auktion, Kund, Pris) values (21, '910322-0978', 1400.00);
insert into Bud (Auktion, Kund, Pris) values (21, '920524-0763', 1470.00);

insert into Bud (Auktion, Kund, Pris) values (22, '960726-3645', 11900.00);
insert into Bud (Auktion, Kund, Pris) values (23, '950312-2286', 50000.50);
insert into Bud (Auktion, Kund, Pris) values (23, '950123-5792', 50200.00);
insert into Bud (Auktion, Kund, Pris) values (23, '911224-2985', 50300.00);
insert into Bud (Auktion, Kund, Pris) values (24, '940226-8879', 15000.00);
insert into Bud (Auktion, Kund, Pris) values (24, '900209-2937', 15400.00);
insert into Bud (Auktion, Kund, Pris) values (25, '940226-8879', 2900.00);
insert into Bud (Auktion, Kund, Pris) values (26, '960726-3645', 2100.00);
insert into Bud (Auktion, Kund, Pris) values (27, '911224-2985', 2400.00);
insert into Bud (Auktion, Kund, Pris) values (27, '940226-8879', 2430.00);
insert into Bud (Auktion, Kund, Pris) values (27, '910322-0978', 2450.00);
insert into Bud (Auktion, Kund, Pris) values (27, '900209-2937', 2470.00);
insert into Bud (Auktion, Kund, Pris) values (28, '900209-2937', 21900.00);
insert into Bud (Auktion, Kund, Pris) values (28, '911224-2985', 21950.00);
insert into Bud (Auktion, Kund, Pris) values (28, '960122-0274', 21980.00);
insert into Bud (Auktion, Kund, Pris) values (29, '901007-9898', 60500.00);
insert into Bud (Auktion, Kund, Pris) values (29, '910322-0978', 60600.00);
insert into Bud (Auktion, Kund, Pris) values (30, '940226-8879', 11100.00);

insert into Bud (Auktion, Kund, Pris) values (30, '960726-3645', 11200.00);
insert into Bud (Auktion, Kund, Pris) values (30, '950312-2286', 21600.50);
insert into Bud (Auktion, Kund, Pris) values (31, '950123-5792', 91100.00);
insert into Bud (Auktion, Kund, Pris) values (31, '911224-2985', 91400.00);
insert into Bud (Auktion, Kund, Pris) values (32, '940226-8879', 12000.00);
insert into Bud (Auktion, Kund, Pris) values (32, '950123-5792', 12400.00);
insert into Bud (Auktion, Kund, Pris) values (32, '910322-0978', 12500.00);
insert into Bud (Auktion, Kund, Pris) values (32, '960726-3645', 12600.00);
insert into Bud (Auktion, Kund, Pris) values (32, '911224-2985', 12700.00);
insert into Bud (Auktion, Kund, Pris) values (33, '940226-8879', 1400.00);
insert into Bud (Auktion, Kund, Pris) values (33, '900209-2937', 7300.00);
insert into Bud (Auktion, Kund, Pris) values (34, '901007-9898', 31900.00);
insert into Bud (Auktion, Kund, Pris) values (34, '900209-2937', 32900.00);
insert into Bud (Auktion, Kund, Pris) values (35, '911224-2985', 94000.00);
insert into Bud (Auktion, Kund, Pris) values (35, '950123-5792', 94400.00);
insert into Bud (Auktion, Kund, Pris) values (35, '940226-8879', 94600.00);
insert into Bud (Auktion, Kund, Pris) values (36, '910322-0978', 24100.00);
insert into Bud (Auktion, Kund, Pris) values (36, '920524-0763', 24400.00);












