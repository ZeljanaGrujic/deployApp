insert  into USER values
(1,'Srecko','Grujic','sreki','srecko'),
(2,'Biljana','Grujic','bilja','biljana'),
(3,'Radmilo','Stojanovic','rasa','radmilo'),
(4,'Zeljana','Grujic','zeljana','zeljana'),
(5,'Zeljko','Grujic','gruja','zeki'),
(6,'Vladimir','Vidic','vlaki','vlaki'),
(8,'Mileva','Stojanovic','milevka','milevka'),
(9,'Branko','Brankovic','brane','brane'),
(10,'Biljana','Garic','123biljaa','bilja');

INSERT  INTO COUNTRY VALUES 
(4,'Valjevo','+381/014','Kolubarski okrug'),
(3,'Pancevo','+381/013','Juznbanatski okrug'),
(2,'Smederevo','+381/026','Podunavski okrug'),
(1,'Beograd','+381/011','Srbija'),
(5,'Kraljevo','+381/020','Raski okrug');

insert  into LOCATION values 
(1,'I srpskog ustanka 29a','Smederevska Palanka',2,'Lokacija butika BILVA'),
(2,'Ulica Bore Stankovica 12','Pancevo',3,'Lokacija gde se nalazi veleprodaja kosulja'),
(3,'Ulica Bore Stankovica 32','Pancevo',3,'Lokacija gde se nalazi veleprodaja farmerica G-star'),
(4,'Stevana Nemanje 21a','Novi Pazar',5,'Nabavka farmerica');


INSERT  INTO EMPLOYEE_TYPE VALUES 
(1,'Puno radno vreme','Podrazumeva rad u I(8-14h) ili II(14-16) smeni, u trajanju od 8 sati. Ukupno radno vreme na nedeljnom nivou je izmedju 38 i 40 sati, a plata je fiksna.'),
(4,'Zaposleni po ugovoru','Zaposleni odradjuje odredjeni broj sati (menja odredjenog zaposlenog na odsustvu) ili moze biti angazovan za realizovanje jednokratnog projekta. Visina plate se obracunava u zavisnosti od broja radnih sati i/ili tezine projekta'),
(3,'Zaposleni na odredjeno vreme','Zaposleni moze raditi sa punim ili nepunim radnim vremenom, plata se obracunava prema broju odradjenih sati, kao i prema tezini posla koji se obavlja'),
(2,'Nepuno radno vreme','Podrazumeva rad u I ili II smeni, prosecna duzina trajanja smene je 7 sati dnevno. Ukupno radno vreme na nedeljnom nivou je manje od 38 sati, a plata se obracunava prema broju odradjenih sati');


INSERT  INTO CONTACT VALUES (2,'fiorajeans@gmail.com','Husein','Jahic','064-3334-334','Potencijalni dobavljac za famerice brenda FIORA, Novi Pazar.');

insert  into SUPLIER values 
(2,'ESBI','Farmerice za mlade, marke ESBI. Radno vreme ponedeljak 9-17, sreda-petak 9-17, vikendom ne primaju narudzbine!','farmericef@gmail.com','Faris Faric123',4,'062-0222-111'),
(3,'SELTEX','Za nabavku farmerica i kosulja..','seltex@yahoo.com','Sneza T.',2,'063-3333-222'),
(5,'t','novi detalj','t@t','test1123',1,'123');

insert  into CLIENT values 
(6,'','kl2@gmail.com','Klijent 2 Prezime 2',4,'061-0001-110'),
(1,'IZMENA klijenta','client1@gmail.com','Klijent 1 Prezime 1',2,'060-0000-011');

INSERT  INTO INVOICE_STATUS values 
(1,'Obradjena','Izabrati ovaj tip statusa ukoliko je faktura za klijente uradjena/poslata ili ako je faktura za dobavljace uradjena/poslata'),
(2,'Neobradjena','Izabrati ovaj status fakture ako faktura za klijente jos nije uradjena/poslata ili ako faktura za dobavljace jos nije uradjena/poslata');


insert  into JOB_TITLE values 
(1,'Izvrsni direktor','Glavni nadredjeni za sve poslove. Tata Srecko'),
(2,'Izvrsni asistent','Pronalazi nove klijente i dobavljace. Organizuje nabavku i isporuku robe. Podnosi izvestaje izvrsnom direktoru'),
(3,'Saradnik u prodaji','Brine se o urednosti robe i objekta. Prati status prozivoda i podnosi izvestaj izvrsnom asistentu. Resava probleme kupaca i vodi racuna o tome da su svi kupci zadovoljni.'),
(4,'Knjigovodja/racunovodja','Obavlja administrativne poslove. Vodi knjige i knjizi sve poslovne dokumentacije u skladu sa racunovodstvenim propisima'),
(5,'Programer','Angazovanje za izradu administrativnog sistema');



insert  into INVOICE_BUYING values 
(11,'2023-02-21 23:00:00',1,'Pozvati da potvrdis licno pre nego sto zvanicno posaljes nalog. Srecko Grujic',3),
(12,'2023-02-10 23:00:00',2,'Serija pantalona, boja: teget, jedinstveni broj Cr23RtW',2),
(13,'2023-02-11 23:00:00',2,'Naruceno i preuzeto 2 serije pantalona',5);


insert  into INVOICE_SELLING values 
(3,1,'2023-02-09 23:00:00',1,'Hitna posiljka 20 komada odela'),
(4,6,'2023-02-15 23:00:00',2,'Posiljka 50 majica dugih rukava. Licno proveriti da li je to stiglo.');


INSERT  INTO EMPLOYEE VALUES(17,2,'2023-02-04 23:00:00','miki@gmail.com','Mileva','12347890','Stojanovic',1,'Miksii','060-0311-552','default.jpg',2,'2023-02-04 23:00:00',2,'milevka'),
(7,2,'2023-02-06 23:00:00','rasa@gmail.com','Radmilo','1234567891011','Stojanovic',1,'Rasa','060-0000-001','1.jpg',1,'2023-02-06 23:00:00',2,'radmilo'),
(1,2,'1971-11-02 23:00:00','grujicBiljana@gmail.com','Biljana','1311971000016','Grujic',1,'Biljkaaa','060-0113-116','avatar-2.jpg',1,'1996-12-21 23:00:00',3,'biljana'),
(9,2,'2023-02-03 23:00:00','brane@gmail.com','Branko','1230957688','Brankovic',1,'Brane','063-1933-320','avatar-4.jpg',2,'2023-02-03 23:00:00',4,NULL),
(6,2,'2023-02-09 23:00:00','zeljanagrujic2199@gmail.com','Srecko','123','Grujic',1,'Sreki','0600323058','avatar-3.jpg',1,'2023-02-14 23:00:00',1,'srecko');


insert  into TEXTILE_MAKE values 
(1,'ESBI','Skuplja marka, za mladje'),
(2,'G-Star','Po nekada se ne moze nabaviti na trzistu');

insert  into TEXTILE_MODEL values 
(1,'Slim fit','Model poprilicno uskog kroja'),
(2,'Regular fit','Modeli normalnog kroja'),
(3,'Baggy fit','Model opustenog kroja'),
(4,'Straight fit','Model ravno secenog kroja');

insert  into TEXTILE_STATUS values 
(1,'Dovoljna kolicina prozivoda','Nije potrebno uskoro narucivanje. Broj dostupnih proizvoda izmedju 70-130 komada'),
(2,'Kriticna kolicina proizvoda','Uskoro ce biti potrebno naruciti nove serije. Broj dostupnih proizvoda izmedju 10-60 '),
(3,'Nedovoljne kolicina proizvoda','Potrebno je naruciti nove serije proizvoda. Broj dostupnih proizvoda manje od 10 komada'),
(4,'Hitno porucivanje','Za slucaj velike potraznje, ili porudzbine bitnog klijenta');

insert  into TEXTILE_TYPE values 
(1,'Majica - kratak rukav','Kolekcija prolece/leto, jesen/zima, raspolozive velicine u seriji S, M, L, XL, 2XL, 3XL, 4XL'),
(2,'Majica - dug rukav','Kolekcija prolece/jesen/zima, raspolozive velicine u seriji S, M, L, XL'),
(3,'Dukserica - zip','Kolekcija jesen/zima, raspolozive velicine u seriji S, M, L, XL'),
(4,'Dukserica - sa kapuljacom','Kolekcija jesen/zima, raspolozive velicine u seriji S, M, L, XL, 2XL'),
(5,'Kosulja','Raspolozive velicine u seriji XS, S, M, L, XL'),
(6,'Majica - batal','Raspolozive velicine u seriji od XL do 6XL'),
(7,'Pantalone','Raspolozive velicine u seriji 28, 30, 32, 34, 36, 38, 40'),
(8,'Farmerice','Raspolozive velicine u seriji 28, 30, 32, 34, 36, 38, 40'),
(9,'Odelo','Raspolozive velicine u seriji 48, 50, 52, 56, 58, 60, 62'),
(10,'Punjena jakna','Kolekcija jesen/zima, raspolozive velicine u seriji S, M, L, XL, 2XL'),
(11,'Kaput','Kolekcija prolece/jesen/zima, raspolozive velicine u seriji S, M, L, XL');


insert  into TEXTILE values 
(16,'2023-01-29 23:00:00',120,1,'t-shirt.jpg',1200,'Gornji deo','ne za sad',2,1,1,1,1,'as234ERtz'),
(18,'2023-02-02 23:00:00',120,1,'sweatshirt-zipp.jpg',1200,'Gornji deo','izmena23',3,2,1,1,3,'as234EEE'),
(19,'2023-01-30 23:00:00',50,1,'jeans.jpg',1200,'Donji deo','izmena',2,1,2,2,8,'as234'),
(23,'2023-01-26 23:00:00',45,7,'sweatshirt.jpg',1700,'Gornji deo','',3,2,2,3,4,'Fr45tTyI'),
(24,'2023-01-21 23:00:00',20,6,'long-sleeve-shirt.jpg',1500,'Gornji deo','Uskoro je potrebno izvrsiti nabavku',3,2,4,3,2,'wE37oO'),
(25,'2022-12-01 23:00:00',50,1,'suit-icon.jpg',12000,'Gornji deo','',3,2,1,2,9,'123Zzz'),
(26,'2023-02-09 23:00:00',20,7,'coat.jpg',7500,'Gornji deo','',2,1,2,3,11,'QeStzI12');


insert  into INVOICE_ITEM values 
(1,3,2,25,20000),
(2,3,2,26,18000);

insert  into INVOICEB_ITEM values 
(1,11,10,16,12000);
