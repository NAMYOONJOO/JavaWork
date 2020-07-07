
/* Drop Tables */

DROP TABLE authorities CASCADE CONSTRAINTS;
DROP TABLE users CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE authorities
(
   username varchar2(50) NOT NULL,
   authority varchar2(50) NOT NULL
);


CREATE TABLE users
(
   username varchar2(50) NOT NULL,
   password varchar2(50) NOT NULL,
   enabled char(1) DEFAULT 1,
   PRIMARY KEY (username)
);



/* Create Foreign Keys */

ALTER TABLE authorities
   ADD FOREIGN KEY (username)
   REFERENCES users (username)
;



/* 데이터 DML */
INSERT INTO users (username, password) VALUES ('user00', '1234');
INSERT INTO users (username, password) VALUES ('member00', '1234');
INSERT INTO users (username, password) VALUES ('admin00', '1234');

INSERT INTO authorities VALUES ('user00', 'ROLE_USER');
INSERT INTO authorities VALUES ('member00', 'ROLE_MANAGER');
INSERT INTO authorities VALUES ('admin00', 'ROLE_MANAGER');
INSERT INTO authorities VALUES ('admin00', 'ROLE_ADMIN');

-- 확인
SELECT u.username, u.password ,u.enabled, a.authority
FROM users u, authorities a
WHERE u.username = a.username;





