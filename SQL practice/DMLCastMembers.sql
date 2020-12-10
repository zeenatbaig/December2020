
USE Movies;

INSERT INTO Actor  VALUES ( 1,'Bill','Murray','1950/09/21');
INSERT INTO Actor  VALUES ( 2,'Dan','Aykroyd','1952/07/01');
INSERT INTO Actor  VALUES ( 3,'John','Candy','1950/10/31');
INSERT INTO Actor  VALUES ( 4,'Steve','Martin',NULL);
INSERT INTO Actor  VALUES ( 5,'Sylvester','Stallone',NULL);

INSERT INTO Director VALUES(1,'Ivan','Reitman','1946/10/27');
INSERT INTO Director VALUES(2, 'Ted', 'Kotcheff',NULL);


INSERT INTO Rating VALUES(1,'G');
INSERT INTO Rating VALUES(2,'PG');
INSERT INTO Rating VALUES(3,'PG-13');
INSERT INTO Rating VALUES(4,'R');

INSERT INTO Genre VALUES(1,'Action');
INSERT INTO Genre VALUES(2,'Comedy');
INSERT INTO Genre VALUES(3,'Drama');
INSERT INTO Genre VALUES(4,'Horror');

INSERT INTO Movie VALUES(1,1,2,4,'Rambo: First Blood','1982/10/22');
INSERT INTO Movie VALUES(2,2,NULL,4,'Planes, Trains & Automobiles','1987/11/25');
INSERT INTO Movie VALUES(3,2,1,2,'Ghostbusters',NULL);
INSERT INTO Movie VALUES(4,2,NULL,2,'The Great Outdoors','1988/06/17');

INSERT INTO CastMembers VALUES(1,5,1,'John Rambo');
INSERT INTO CastMembers VALUES(2,4,2,'Neil Page');
INSERT INTO CastMembers VALUES(3,3,2,'Del Griffith');
INSERT INTO CastMembers VALUES(4,1,3,'Dr. Peter Venkman');
INSERT INTO CastMembers VALUES(5,2,3,'Dr. Raymond Stanz');
INSERT INTO CastMembers VALUES(6,2,4,'Roman Craig');
INSERT INTO CastMembers VALUES(7,3,4,'Chet Ripley');
