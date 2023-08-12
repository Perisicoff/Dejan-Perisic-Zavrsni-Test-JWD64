INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');

              
              
INSERT INTO festival (naziv) VALUES ('Exit');
INSERT INTO festival (naziv) VALUES ('WDF');
INSERT INTO festival (naziv) VALUES ('Toomorowland');

INSERT INTO izvodjac (ime, zanr, drzava, broj_clanova) VALUES ('Izvodjac 1', 'Metal', 'Srbija', '5');
INSERT INTO izvodjac (ime, zanr, drzava, broj_clanova) VALUES ('Izvodjac 2', 'Pop', 'Malsta', '5');
INSERT INTO izvodjac (ime, zanr, drzava, broj_clanova) VALUES ('Izvodjac 3', 'Hip Hop', 'Srbija', '4');
INSERT INTO izvodjac (ime, zanr, drzava, broj_clanova) VALUES ('Izvodjac 4', 'Dzez', 'Norveska', '3');

INSERT INTO nastup (festival_id, izvodjac_id) VALUES (1,2);
INSERT INTO nastup (festival_id, izvodjac_id) VALUES (1,1);
INSERT INTO nastup (festival_id, izvodjac_id) VALUES (2,3);
INSERT INTO nastup (festival_id, izvodjac_id) VALUES (3,4);