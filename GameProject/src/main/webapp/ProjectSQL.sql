CREATE DATABASE ProjectDB;
GRANT ALL PRIVILEGES ON ProjectDB.* TO indef@localhost IDENTIFIED BY '1111' WITH GRANT OPTION;
FLUSH PRIVILEGES;
USE ProjectDB;

CREATE TABLE signUp
	( 
	  email VARCHAR(150),
	  uname VARCHAR(50),
	  pwd VARCHAR(50),
	  infor VARCHAR(300)
	);
CREATE TABLE game
	(
		gnum INTEGER(11),
		gname VARCHAR(100),
		gprice INTEGER(10)
	);

INSERT INTO game VALUES(1, 'Dark Souls™ lll', 49800);
INSERT INTO game VALUES(2, 'Elden Ring', 64800);
INSERT INTO game VALUES(3, 'BattleField 1™', 11000);
INSERT INTO game VALUES(4, 'EscapeFromTarkov', 55800);
INSERT INTO game VALUES(5, 'CS:GO', 0);
INSERT INTO game VALUES(6, 'War Thunder', 0);
INSERT INTO game VALUES(7, 'Warframe', 0);
INSERT INTO game VALUES(8, 'Deceit', 0);
INSERT INTO game VALUES(9, 'Tom Clancys The Division', 33000);
INSERT INTO game VALUES(10, 'H1Z1', 0);

ALTER TABLE signup
 ADD (
 	PRIMARY KEY (email)
);
ALTER TABLE game
 ADD (
 	PRIMARY KEY (gprice)
);
CREATE TABLE cart (
	gprice INT(10)
);
ALTER TABLE cart
	ADD (
		UNIQUE (gnum)
);
ALTER TABLE cart 
	ADD (
	FOREIGN KEY (gprice)
	REFERENCES game(gnum)
);
ALTER TABLE game
	ADD(
		gtag VARCHAR(200)
	);
	
UPDATE game SET gtag='액션RPG, 액션, 멀티플레이, 인기게임' WHERE gnum=1;
UPDATE game SET gtag='액션RPG, 액션, 멀티플레이, 인기게임' WHERE gnum=2;
UPDATE game SET gtag='1인칭 슈팅, 액션, 멀티플레이, 인기게임' WHERE gnum=3;
UPDATE game SET gtag='1인칭 슈팅, 액션, 멀티플레이, 인기게임' WHERE gnum=4;
UPDATE game SET gtag='1인칭 슈팅, 액션, 멀티플레이, 무료게임' WHERE gnum=5;
UPDATE game SET gtag='전략, 멀티플레이, 무료게임' WHERE gnum=6;
UPDATE game SET gtag='액션RPG, 액션, 멀티플레이, 무료게임' WHERE gnum=7;
UPDATE game SET gtag='1인칭, 공포, 멀티플레이, 무료게임' WHERE gnum=8;
UPDATE game SET gtag='3인칭, 액션RPG, 멀티플레이' WHERE gnum=9;
UPDATE game SET gtag='3인칭, 액션, 멀티플레이, 무료게임' WHERE gnum=10;