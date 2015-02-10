use Auktion;


insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('927467-0293', 'Jeans&Co', 0, 'Emil i Lönneberga', 'Friggenboa@hotmail.com', '070-1928764');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('836748-2874', 'Johnson&Johnson', 10, 'Mysig Kille', 'Yeah@hotmail.com', '070-8759903');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('875889-3645', 'Awesome...Really Awesom', 70, 'Johnny Bravo', 'HuhshwischhiiYAa@hotmail.com', '070-7785993');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('857849-2934', 'McDonald´s', 0, 'Ronald McDonald', 'BigMac@hotmail.com', '070-3984995');
insert into Leverantör (Organisationsnummer, Företagsnamn, Provision, Kontaktperson, Email, Telefonnummer) values ('394839-1938', 'Myrorna', 0, 'Karl Edwalsson', 'KarlE@myrorna.se', '070-3904850');

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

insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverantör) values ('2015-02-01', 900.00, 1600.00, '2015-06-14', 'Cheap Monkey', 1, '927467-0293');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverantör) values ('2015-04-11', 100.00, 25000.00, '2015-11-24', 'YeahSkor', 2, '875889-3645');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverantör) values ('2015-01-10', 400.00, 700.00, '2015-02-10', 'Coca Cola Statue', 3, '857849-2934');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverantör) values ('2015-07-23', 1900.00, 2100.00, '2015-12-24', 'Trasig Skjorta', 2, '394839-1938');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverantör) values ('2015-02-28', 900000.00, 1600000.00, '2016-06-30', 'KärleksBåten Charmine', 5, '836748-2874');
insert into Auktion (Startdatum, Utgångspris, Acceptpris, Slutdatum, Produktnamn, Produktkategori, Leverantör) values ('2015-02-01', 100.00, 1600.00, '2015-06-14', 'TEST Stuff', 1, '927467-0293');

insert into Bud (Auktion, Kund, Pris) values (1, '960726-3645', 900.00);
insert into Bud (Auktion, Kund, Pris) values (1, '911224-2985', 920.50);
insert into Bud (Auktion, Kund, Pris) values (1, '960726-3645', 950.00);

insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 950.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 970.00);
insert into Bud (Auktion, Kund, Pris) values (2, '950123-5792', 990.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 1950.00);
insert into Bud (Auktion, Kund, Pris) values (2, '960726-3645', 1960.00);
insert into Bud (Auktion, Kund, Pris) values (2, '911224-2985', 1970.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 22950.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 23950.00);
insert into Bud (Auktion, Kund, Pris) values (2, '940226-8879', 25000.00);

insert into Bud (Auktion, Kund, Pris) values (3, '900209-2937', 400.00);
insert into Bud (Auktion, Kund, Pris) values (3, '950312-2286', 430.00);

insert into Bud (Auktion, Kund, Pris) values (4, '950123-5792', 1950.00);

insert into Bud (Auktion, Kund, Pris) values (5, '940226-8879', 950000.00);
insert into Bud (Auktion, Kund, Pris) values (5, '910322-0978', 1100000.00);
insert into Bud (Auktion, Kund, Pris) values (5, '940226-8879', 5950000.00);












