USE EMS;

DELETE FROM Users;
INSERT INTO Users VALUES(1,'Subhro Ghosh','SBOND007','Sghosh@0708','7003038959','subhroghosh56@gmail.com','Kona Tentultala, Howrah');
INSERT INTO Users VALUES(2,'Swapan Ghosh','Swapan@1967','Subhro@2000','9836983530','ghosh.swapan1967@gmail.com','Kona Tentultala, Howrah');

DELETE FROM Student;
INSERT INTO Student (Student_Id,Name,Roll_No,DOB,Gender,Gurdian_Name,Mob_No,Address) 
			VALUES(1,'Subhro Ghosh','21-45-000501','2000-08-07','M','Swapan Ghosh','7003038959','Kona Tentultala, Howrah');
INSERT INTO Student (Student_Id,Name,Roll_No,DOB,Gender,Gurdian_Name,Mob_No,Address)
			VALUES(2,'Soubarna Mahinder','21-45-000502','2000-04-16','M','Montunath Mahinder','7003224302','Annapurna, Howrah Maidan');


DELETE FROM Qualification;
INSERT INTO Qualification VALUES(1,'Higher Secondary');
INSERT INTO Qualification VALUES(2,'Secondary');

DELETE FROM ExamCenter;
INSERT INTO ExamCenter VALUES(1,'Kona High School','Kona Howrah',1,'1211A');
INSERT INTO ExamCenter VALUES(2,'Howrah Vivekananda Institution','Shibpur Howrah',5,'200014B');

DELETE FROM CenterRoom;
INSERT INTO CenterRoom VALUES(1,'2A',50);
INSERT INTO CenterRoom VALUES(2,'5C',100);

DELETE FROM ExamZone;
INSERT INTO ExamZone VALUES(1,'North');
INSERT INTO ExamZone VALUES(2,'South');

DELETE FROM SeatAlloc;
INSERT INTO SeatAlloc VALUES(1,2,'2A');
INSERT INTO SeatAlloc VALUES(2,2,'5C');