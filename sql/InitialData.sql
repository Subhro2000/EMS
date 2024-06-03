USE EMS;

DELETE FROM SeqQuestion;
INSERT INTO SeqQuestion VALUES(1,'What is your favourite food?');
INSERT INTO SeqQuestion VALUES(2,'Which is your favourite color?');
INSERT INTO SeqQuestion VALUES(3,'What is your childhood name?');
INSERT INTO SeqQuestion VALUES(4,'What is your first school name?');

DELETE FROM Qualification;
INSERT INTO Qualification SET Name = '8th';
INSERT INTO Qualification SET Name = '10th';
INSERT INTO Qualification SET Name = '12th';
INSERT INTO Qualification SET Name = 'Graduate';
INSERT INTO Qualification SET Name = 'Post-Graduate';
INSERT INTO Qualification SET Name = 'Phd.';

DELETE FROM Preferences;
INSERT INTO Preferences VALUES('SG Talent Search Exam', '2024-08-07', '09:30 A.M', '10:00 A.M', '10:30 A.M - 12:00 P.M');