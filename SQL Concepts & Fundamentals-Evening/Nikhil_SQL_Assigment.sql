/*creating database of cricketworldcup*/
create database cricketwordlcup;
use cricketworldcup;


/* creating a table of Players which stores the information about each player like name, playerid, Team Name
Runs scored and wickets taken in the world cup*/

create table Players (
	Pid int,
    Pname varchar(50) NOT NULL,
    TeamName varchar(20) NOT NULL,
    RunsScored int NOT NULL,
    WicketsTaken int NOT NULL,
    Primary key (Pid)
    );

/*(a) creating another table of Teams assuming that there are total 6 teams that are participating in the world cup,  */    

 create table Teams (
	Matchno int,
    Teamname varchar(20),
    Totalscore int NOT NULL,
    primary key (Matchno, Teamname)
 );
 
 /* creating sample data of the Players table*/
 
 /*Team Australia*/
INSERT INTO Players Values (1,'David Warner','AUS',225,0);
INSERT INTO Players Values (2,'Shane Watson','AUS',136,0);
INSERT INTO Players Values (3,'Steven Smith','AUS',234,0);
INSERT INTO Players Values (4,'Aaron Finch','AUS',169,0);
INSERT INTO Players Values (5,'John Hastings','AUS',268,0);
INSERT INTO Players Values (6,'Glenn Maxwell','AUS',165,4);
INSERT INTO Players Values (7,'Peter Nevill','AUS',126,9);
INSERT INTO Players Values (8,'Andrew Tye','AUS',14,14);
INSERT INTO Players Values (9,'Ashton Agar','AUS',16,7);
INSERT INTO Players Values (10,'James Faulkner ','AUS',6,9);
INSERT INTO Players Values (11,'Adam Zampa','AUS',9,4);    

/*Team India*/
INSERT INTO Players Values (12,'Shikhar Dhawan','IND',220,0);
INSERT INTO Players Values (13,'Virat Kohli','IND',380,0);
INSERT INTO Players Values (14,'Rohit Sharma','IND',350,0);
INSERT INTO Players Values (15,'KL Rahul','IND',320,0);
INSERT INTO Players Values (16,'Mahendra Singh Dhoni','IND',360,0);
INSERT INTO Players Values (17,'Ravindra Jadeja','IND',150,8);
INSERT INTO Players Values (18,'Hardik Pandya','IND',200,6);
INSERT INTO Players Values (19,'Bhuvaneshwar Kumar','IND',30,12);
INSERT INTO Players Values (20,'Mohammad Shami','IND',17,9);
INSERT INTO Players Values (21,'Ashish Nehra ','IND',6,7);
INSERT INTO Players Values (22,'Jasprit Bumrah','IND',12,10);

/*Team England*/
INSERT INTO Players Values (23,'Sam Billings','ENG',140,0);
INSERT INTO Players Values (24,'Alex Hales','ENG',250,0);
INSERT INTO Players Values (25,'Eoin Morgan','ENG',341,0);
INSERT INTO Players Values (26,'Jos Buttler','ENG',264,0);
INSERT INTO Players Values (27,'Jason Roy','ENG',341,0);
INSERT INTO Players Values (28,'Joe Root','ENG',249,1);
INSERT INTO Players Values (29,'Ben Stokes','ENG',143,2);
INSERT INTO Players Values (30,'Reece Topley','ENG',20,15);
INSERT INTO Players Values (31,' Chris Jordan','ENG',47,11);
INSERT INTO Players Values (32,'Liam Plunkett','ENG',63,17);
INSERT INTO Players Values (33,'James Vince','ENG',22,8);

/*Team New Zealand*/
INSERT INTO Players Values (34,'Martin Guptill','NZ',160,0);
INSERT INTO Players Values (35,'Luke Ronchi ','NZ',234,0);
INSERT INTO Players Values (36,'Kane Williamson','NZ',371,0);
INSERT INTO Players Values (37,'Colin Munro','NZ',223,0);
INSERT INTO Players Values (38,'Henry Nicholls','NZ',163,1);
INSERT INTO Players Values (39,'Ross Taylor','NZ',145,13);
INSERT INTO Players Values (40,'Corey Anderson','NZ',256,12);
INSERT INTO Players Values (41,'Nathan McCullum','NZ',13,4);
INSERT INTO Players Values (42,'Ish Sodhi','NZ',74,4);
INSERT INTO Players Values (43,'Tim Southee','NZ',66,14);
INSERT INTO Players Values (44,'Trent Boult','NZ',19,10);

/*Team Pakistan*/
INSERT INTO Players Values (45,'Ahmed Shehzad','PAK',114,0);
INSERT INTO Players Values (46,'Khalid Latif','PAK',136,0);
INSERT INTO Players Values (47,'Mohammed Hafeez','PAK',250,1);
INSERT INTO Players Values (48,'Umar Akmal','PAK',142,0);
INSERT INTO Players Values (49,'Sarfraz Ahmed','PAK',72,0);
INSERT INTO Players Values (50,'Mohammad Nawaz','PAK',63,11);
INSERT INTO Players Values (51,'Imad Wasim','PAK',94,8);
INSERT INTO Players Values (52,'Shahid Afridi','PAK',240,2);
INSERT INTO Players Values (53,'Wahab Riaz','PAK',43,9);
INSERT INTO Players Values (54,'Sharjeel Khan','PAK',20,8);
INSERT INTO Players Values (55,'Mohammad Irfan','PAK',41,6);

/*Team South Africa*/
INSERT INTO Players Values (56,'Quinton de Kock','SA',220,0);
INSERT INTO Players Values (57,'Hashim Amla','SA',320,0);
INSERT INTO Players Values (58,'Faf du Plessis','SA',236,0);
INSERT INTO Players Values (59,'AB de Villiers','SA',321,2);
INSERT INTO Players Values (60,'JP Duminy','SA',163,1);
INSERT INTO Players Values (61,'Aaron Phangiso','274',63,6);
INSERT INTO Players Values (62,'Kyle Abbott','SA',263,9);
INSERT INTO Players Values (63,'David Miller','SA',142,4);
INSERT INTO Players Values (64,'Chris Morris','SA',16,4);
INSERT INTO Players Values (65,'Kagiso Rabada','SA',36,12);
INSERT INTO Players Values (66,'Imran Tahir','SA',32,7);

/* Inserting values in Teams table which has attributes such as Match number(Matchno.) 
which represents the Match number where two teams are participating in each match
Assuming there are total 9 matches played and each team played 3 Matches*/
 
INSERT INTO Teams Values (1,'AUS', 320);
INSERT INTO Teams Values (1,'ENG', 279);
INSERT INTO Teams Values (2,'PAK', 256);
INSERT INTO Teams Values (2,'SA', 259);
INSERT INTO Teams Values (3,'IND', 370);
INSERT INTO Teams Values (3,'NZ', 288);
INSERT INTO Teams Values (4,'AUS', 220);
INSERT INTO Teams Values (4,'IND', 224);
INSERT INTO Teams Values (5,'SA', 245);
INSERT INTO Teams Values (5,'NZ', 250);
INSERT INTO Teams Values (6,'PAK', 150);
INSERT INTO Teams Values (6,'ENG', 152);
INSERT INTO Teams Values (7,'SA', 223);
INSERT INTO Teams Values (7,'ENG', 225);
INSERT INTO Teams Values (8,'AUS', 274);
INSERT INTO Teams Values (8,'PAK', 120);
INSERT INTO Teams Values (9,'IND', 370);
INSERT INTO Teams Values (9,'NZ', 242);




/* (b)Query to Fetch the top 5 batsmen who scored the maximum runs.*/
select Pname, RunsScored from Players order by RunsScored desc limit 5;

/* (c) Fetch the top 5 bowlers who has taken the maximum wickets.*/
select Pname, WicketsTaken from Players order by WicketsTaken desc limit 5;

/* (d) Fetch the average score scored by each team considering the matches played.*/
select Teamname, sum(Totalscore)/count(Matchno) as Average from Teams group by Teamname;

/*for removing the error code 1175 */ 
SET SQL_SAFE_UPDATES = 0;

/* (e) Increase the scores of each batsmen in the team, which has the least average computed in Step d, by 10 runs.*/
Update Players set RunsScored = RunsScored + 10 where TeamName = (Select Teamname from Teams group by Teamname order by sum(Totalscore)/count(Matchno) limit 1);

/* (f) Create a procedure which takes country as the input and gives the highest score of the country up to date, as output*/

DELIMITER $$
drop procedure if exists highest$$
create procedure highest(team_name varchar(20), out score int)
begin
	select max(Totalscore) into score from Teams where Teamname = team_name;
end$$

DELIMITER ;
call highest('NZ',@highest);
select @highest;


