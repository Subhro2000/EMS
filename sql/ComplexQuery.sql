select z.Name, c.Zone_Id, c.Name, r.Room_No, r.Capacity from ExamZone z, ExamCenter c, CenterRoom r where r.Center_Id = c.Center_Id and c.Zone_Id = z.Zone_Id;
+--------------+---------+---------------------------------+---------+----------+
| Name         | Zone_Id | Name                            | Room_No | Capacity |
+--------------+---------+---------------------------------+---------+----------+
| Bidhan Nagar |       6 | Adarsha Vidyapith               | AV1     |        2 |
| Bidhan Nagar |       6 | Adarsha Vidyapith               | AV2     |        4 |
| DumDum       |      15 | Kumar Asutosh Institution       | KAI1    |        3 |
| DumDum       |      15 | Kumar Asutosh Institution       | KAI3    |        2 |
| Central      |      11 | Jayaswal Vidyamandir for Girls  | JVG1    |        1 |
| Central      |      11 | Jayaswal Vidyamandir for Girls  | JVG2    |        2 |
| Central      |      11 | Bowbazar Training High School   | BTS1    |        1 |
| Central      |      11 | Bowbazar Training High School   | BTS2    |        2 |
| Tollygaunge  |       7 | A.K. Ghosh Memorial High School | AKGMHS1 |        3 |
| Tollygaunge  |       7 | Tollygaunge Bangur High School  | TBHS1   |        2 |
| Central      |      11 | Bethune Collegiate School       | BCS1    |        3 |
| Central      |      11 | Bethune Collegiate School       | BCS2    |        1 |
+--------------+---------+---------------------------------+---------+----------+

select z.Name, c.Name, c.Zone_id from ExamZone z, ExamCenter c where c.Zone_id = z.Zone_Id;
+--------------+--------------------------------------------+---------+
| Name         | Name                                       | Zone_id |
+--------------+--------------------------------------------+---------+
| Bidhan Nagar | Adarsha Vidyapith                          |       6 |
| DumDum       | Kumar Asutosh Institution                  |      15 |
| DumDum       | North End Girls High School                |      15 |
| Shyambazar   | Shyambazar Vidyamandir                     |      12 |
| Maidan       | Chowringhee High School                    |       9 |
| Central      | Jayaswal Vidyamandir for Girls             |      11 |
| Central      | Bowbazar Training High School              |      11 |
| Maidan       | St Micheael's Academy                      |       9 |
| Tollygaunge  | A.K. Ghosh Memorial High School            |       7 |
| Tollygaunge  | Bani Bhaban High School                    |       7 |
| Jadavpur     | Kasba Chittaranjan High School             |      21 |
| Jadavpur     | Jadavpur Bagha Jatin Balika Vidyalaya      |      21 |
| Khidirpur    | Sarat Chandra Pal Girls High School        |      17 |
| Tollygaunge  | Tollygaunge Bangur High School             |       7 |
| Jadavpur     | R D Memorial School                        |      21 |
| Joka         | Alipore Girls' & Boys' High School         |      20 |
| Behala       | Behala Aryya Vidyamandir                   |      19 |
| Barasat      | Barasat Indira Gandhi Memorial High School |       1 |
| Central      | Bethune Collegiate School                  |      11 |
| DumDum       | Dum Dum Kishore Bharati High School        |      15 |
+--------------+--------------------------------------------+---------+


SELECT SUM(capacity) AS total_sum from centerroom;
+-----------+
| total_sum |
+-----------+
|        26 |
+-----------+

select name, EPref_Zone1_Id, EPref_Zone2_Id from student;

select count(EPref_Zone1_Id) from student where EPref_Zone1_Id = 7;


 SELECT r.Center_Id, r.Room_No, r.Capacity, c.Zone_Id FROM CenterRoom r, ExamCenter c WHERE c.Center_Id = r.Center_Id;
+-----------+---------+----------+---------+
| Center_Id | Room_No | Capacity | Zone_Id |
+-----------+---------+----------+---------+
|         1 | AV1     |        2 |       6 |
|         1 | AV2     |        4 |       6 |
|         2 | KAI1    |        3 |      15 |
|         2 | KAI3    |        2 |      15 |
|         6 | JVG1    |        1 |      11 |
|         6 | JVG2    |        2 |      11 |
|         7 | BTS1    |        1 |      11 |
|         7 | BTS2    |        2 |      11 |
|         9 | AKGMHS1 |        3 |       7 |
|        14 | TBHS1   |        2 |       7 |
|        19 | BCS1    |        3 |      11 |
|        19 | BCS2    |        1 |      11 |
+-----------+---------+----------+---------+

select s.student_id, a.name, s.Center_Id, c.Name, s.room_no, c.Zone_id, a.EPref_zone1_id, a.EPref_zone2_id 
from seatalloc s, examcenter c, student a where s.center_id = c.center_id and s.student_id = a.student_id;
+------------+------+-----------+---------------------------------+---------+---------+----------------+----------------+
| student_id | name | Center_Id | Name                            | room_no | Zone_id | EPref_zone1_id | EPref_zone2_id |
+------------+------+-----------+---------------------------------+---------+---------+----------------+----------------+
|          1 | A    |         1 | Adarsha Vidyapith               | AV1     |       6 |              6 |              7 |
|          2 | B    |         9 | A.K. Ghosh Memorial High School | AKGMHS1 |       7 |              7 |             15 |
|          3 | C    |         9 | A.K. Ghosh Memorial High School | AKGMHS1 |       7 |              7 |             11 |
|          4 | D    |         6 | Jayaswal Vidyamandir for Girls  | JVG1    |      11 |             11 |              7 |
|          5 | E    |         2 | Kumar Asutosh Institution       | KAI1    |      15 |             15 |             11 |
|          6 | F    |         6 | Jayaswal Vidyamandir for Girls  | JVG2    |      11 |             11 |             15 |
|          7 | G    |         6 | Jayaswal Vidyamandir for Girls  | JVG2    |      11 |             11 |              6 |
|          8 | H    |         1 | Adarsha Vidyapith               | AV1     |       6 |              6 |             15 |
|          9 | I    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |             15 |
|         10 | J    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |              7 |
|         11 | K    |         9 | A.K. Ghosh Memorial High School | AKGMHS1 |       7 |              7 |             11 |
|         12 | L    |         7 | Bowbazar Training High School   | BTS1    |      11 |             11 |             15 |
|         13 | M    |         2 | Kumar Asutosh Institution       | KAI1    |      15 |             15 |             11 |
|         14 | N    |         2 | Kumar Asutosh Institution       | KAI1    |      15 |             15 |              6 |
|         15 | O    |         7 | Bowbazar Training High School   | BTS2    |      11 |             11 |              7 |
|         16 | P    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |             11 |
|         17 | Q    |         2 | Kumar Asutosh Institution       | KAI3    |      15 |             15 |             11 |
|         18 | R    |         7 | Bowbazar Training High School   | BTS2    |      11 |             11 |              7 |
|         19 | S    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |             15 |
|         20 | T    |         2 | Kumar Asutosh Institution       | KAI3    |      15 |             15 |             11 |
|         21 | U    |        19 | Bethune Collegiate School       | BCS1    |      11 |             11 |              7 |
|         22 | V    |        19 | Bethune Collegiate School       | BCS1    |      11 |             15 |             11 |
|         23 | W    |        19 | Bethune Collegiate School       | BCS1    |      11 |             11 |              6 |
|         24 | X    |        19 | Bethune Collegiate School       | BCS2    |      11 |              6 |             11 |
|         25 | Y    |        14 | Tollygaunge Bangur High School  | TBHS1   |       7 |             15 |              6 |
|         26 | Z    |        14 | Tollygaunge Bangur High School  | TBHS1   |       7 |             15 |             11 |
+------------+------+-----------+---------------------------------+---------+---------+----------------+----------------+


 select s.student_id, a.name, s.Center_Id, c.Name, s.room_no, c.Zone_id, a.EPref_zone1_id, a.EPref_zone2_id, z.Name 
 from seatalloc s, examcenter c, student a, ExamZone z where s.center_id = c.center_id and s.student_id = a.student_id and c.Zone_Id = z.Zone_id;
+------------+------+-----------+---------------------------------+---------+---------+----------------+----------------+--------------+
| student_id | name | Center_Id | Name                            | room_no | Zone_id | EPref_zone1_id | EPref_zone2_id | Name         |
+------------+------+-----------+---------------------------------+---------+---------+----------------+----------------+--------------+
|          1 | A    |         1 | Adarsha Vidyapith               | AV1     |       6 |              6 |              7 | Bidhan Nagar |
|          2 | B    |         9 | A.K. Ghosh Memorial High School | AKGMHS1 |       7 |              7 |             15 | Tollygaunge  |
|          3 | C    |         9 | A.K. Ghosh Memorial High School | AKGMHS1 |       7 |              7 |             11 | Tollygaunge  |
|          4 | D    |         6 | Jayaswal Vidyamandir for Girls  | JVG1    |      11 |             11 |              7 | Central      |
|          5 | E    |         2 | Kumar Asutosh Institution       | KAI1    |      15 |             15 |             11 | DumDum       |
|          6 | F    |         6 | Jayaswal Vidyamandir for Girls  | JVG2    |      11 |             11 |             15 | Central      |
|          7 | G    |         6 | Jayaswal Vidyamandir for Girls  | JVG2    |      11 |             11 |              6 | Central      |
|          8 | H    |         1 | Adarsha Vidyapith               | AV1     |       6 |              6 |             15 | Bidhan Nagar |
|          9 | I    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |             15 | Bidhan Nagar |
|         10 | J    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |              7 | Bidhan Nagar |
|         11 | K    |         9 | A.K. Ghosh Memorial High School | AKGMHS1 |       7 |              7 |             11 | Tollygaunge  |
|         12 | L    |         7 | Bowbazar Training High School   | BTS1    |      11 |             11 |             15 | Central      |
|         13 | M    |         2 | Kumar Asutosh Institution       | KAI1    |      15 |             15 |             11 | DumDum       |
|         14 | N    |         2 | Kumar Asutosh Institution       | KAI1    |      15 |             15 |              6 | DumDum       |
|         15 | O    |         7 | Bowbazar Training High School   | BTS2    |      11 |             11 |              7 | Central      |
|         16 | P    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |             11 | Bidhan Nagar |
|         17 | Q    |         2 | Kumar Asutosh Institution       | KAI3    |      15 |             15 |             11 | DumDum       |
|         18 | R    |         7 | Bowbazar Training High School   | BTS2    |      11 |             11 |              7 | Central      |
|         19 | S    |         1 | Adarsha Vidyapith               | AV2     |       6 |              6 |             15 | Bidhan Nagar |
|         20 | T    |         2 | Kumar Asutosh Institution       | KAI3    |      15 |             15 |             11 | DumDum       |
|         21 | U    |        19 | Bethune Collegiate School       | BCS1    |      11 |             11 |              7 | Central      |
|         22 | V    |        19 | Bethune Collegiate School       | BCS1    |      11 |             15 |             11 | Central      |
|         23 | W    |        19 | Bethune Collegiate School       | BCS1    |      11 |             11 |              6 | Central      |
|         24 | X    |        19 | Bethune Collegiate School       | BCS2    |      11 |              6 |             11 | Central      |
|         25 | Y    |        14 | Tollygaunge Bangur High School  | TBHS1   |       7 |             15 |              6 | Tollygaunge  |
|         26 | Z    |        14 | Tollygaunge Bangur High School  | TBHS1   |       7 |             15 |             11 | Tollygaunge  |
+------------+------+-----------+---------------------------------+---------+---------+----------------+----------------+--------------+


select s.name, s.Gurdian_Name, s.DOB, s.Gender, s.Roll_no, c.Name, c.Address from seatalloc a, student s, examcenter c 
where s.Student_Id = a.Student_Id AND a.Center_id = c.Center_Id;
+------+--------------+------------+--------+-----------------+---------------------------------+--------------------------------------------------------+
| name | Gurdian_Name | DOB        | Gender | Roll_no         | Name                            | Address                                                |
+------+--------------+------------+--------+-----------------+---------------------------------+--------------------------------------------------------+
| A    | AA           | 2000-08-07 | M      | 240100AV1001001 | Adarsha Vidyapith               | 15/1C/H/8 Muraripukur Road, Manicktala - 700067        |
| C    | CC           | 2002-02-02 | M      | 2409AMHS1003002 | A.K. Ghosh Memorial High School | 164/A/6, Prince Anwar Shah Road, Lake Gardens - 700045 |
| D    | DD           | 2001-05-15 | M      | 24060JVG1004003 | Jayaswal Vidyamandir for Girls  | 172 A Vivekananda Road, Maniktala - 700006             |
| F    | FF           | 2000-05-25 | M      | 24060JVG2006004 | Jayaswal Vidyamandir for Girls  | 172 A Vivekananda Road, Maniktala - 700006             |
| G    | GG           | 2004-05-14 | M      | 24060JVG2007005 | Jayaswal Vidyamandir for Girls  | 172 A Vivekananda Road, Maniktala - 700006             |
| H    | HH           | 2000-08-07 | M      | 240100AV1008006 | Adarsha Vidyapith               | 15/1C/H/8 Muraripukur Road, Manicktala - 700067        |
| J    | JJ           | 2002-09-18 | M      | 240100AV2010007 | Adarsha Vidyapith               | 15/1C/H/8 Muraripukur Road, Manicktala - 700067        |
| K    | KK           | 2003-05-23 | M      | 2409AMHS1011008 | A.K. Ghosh Memorial High School | 164/A/6, Prince Anwar Shah Road, Lake Gardens - 700045 |
| M    |              | 2000-05-14 | M      | 24020KAI1013009 | Kumar Asutosh Institution       | 6/1 Dum Dum Road, Sinthee - 700030                     |
| N    | NN           | 2002-05-13 | M      | 24020KAI1014010 | Kumar Asutosh Institution       | 6/1 Dum Dum Road, Sinthee - 700030                     |
| O    |              | 2001-05-31 | M      | 24070BTS1015011 | Bowbazar Training High School   | 17 Dhiren Dhar Sarani, Bowbazar - 700012               |
| P    |              | 2004-09-09 | M      | 240100AV2016012 | Adarsha Vidyapith               | 15/1C/H/8 Muraripukur Road, Manicktala - 700067        |
| S    |              | 2002-05-14 | M      | 240100AV2019013 | Adarsha Vidyapith               | 15/1C/H/8 Muraripukur Road, Manicktala - 700067        |
| T    |              | 2001-11-13 | M      | 24020KAI1020014 | Kumar Asutosh Institution       | 6/1 Dum Dum Road, Sinthee - 700030                     |
| U    |              | 2003-05-16 | M      | 24070BTS2021015 | Bowbazar Training High School   | 17 Dhiren Dhar Sarani, Bowbazar - 700012               |
| W    |              | 2003-07-15 | M      | 24070BTS2023016 | Bowbazar Training High School   | 17 Dhiren Dhar Sarani, Bowbazar - 700012               |
| X    |              | 2004-05-20 | M      | 240100AV2024017 | Adarsha Vidyapith               | 15/1C/H/8 Muraripukur Road, Manicktala - 700067        |
| Z    |              | 2002-05-15 | M      | 24020KAI3026018 | Kumar Asutosh Institution       | 6/1 Dum Dum Road, Sinthee - 700030                     |
+------+--------------+------------+--------+-----------------+---------------------------------+--------------------------------------------------------+

select z.Name, c.Zone_Id, c.Name, r.Center_id, r.Room_No, r.Capacity from ExamZone z, ExamCenter c, CenterRoom r where r.Center_Id = c.Center_Id and
c.Zone_Id = z.Zone_Id;
+--------------+---------+---------------------------------+-----------+---------+----------+
| Name         | Zone_Id | Name                            | Center_id | Room_No | Capacity |
+--------------+---------+---------------------------------+-----------+---------+----------+
| Bidhan Nagar |       6 | Adarsha Vidyapith               |         1 | AV1     |        2 |
| Bidhan Nagar |       6 | Adarsha Vidyapith               |         1 | AV2     |        4 |
| DumDum       |      15 | Kumar Asutosh Institution       |         2 | KAI1    |        3 |
| DumDum       |      15 | Kumar Asutosh Institution       |         2 | KAI3    |        2 |
| Central      |      11 | Jayaswal Vidyamandir for Girls  |         6 | JVG1    |        1 |
| Central      |      11 | Jayaswal Vidyamandir for Girls  |         6 | JVG2    |        2 |
| Central      |      11 | Bowbazar Training High School   |         7 | BTS1    |        1 |
| Central      |      11 | Bowbazar Training High School   |         7 | BTS2    |        2 |
| Tollygaunge  |       7 | A.K. Ghosh Memorial High School |         9 | AMHS1   |        3 |
| Tollygaunge  |       7 | Tollygaunge Bangur High School  |        14 | TBHS1   |        2 |
| Jadavpur     |      21 | R D Memorial School             |        15 | RDS1    |        5 |
| Central      |      11 | Bethune Collegiate School       |        19 | BCS1    |        3 |
| Central      |      11 | Bethune Collegiate School       |        19 | BCS2    |        1 |
+--------------+---------+---------------------------------+-----------+---------+----------+