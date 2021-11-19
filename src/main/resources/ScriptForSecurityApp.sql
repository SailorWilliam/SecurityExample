INSERT INTO my_db.role VALUES(1, "ROLE_USER");
INSERT INTO my_db.role VALUES(2, "ROLE_ADMIN");

INSERT INTO my_db.user VALUES(1, TRUE, "$2a$10$86jn1A0qj.QPGZ9AY2Rkz.sLAxEXy0DAQRufX28aqfT0GGbGXzT4.", "admin");

INSERT INTO my_db.user_roles VALUES(1, 1);
INSERT INTO my_db.user_roles VALUES(1, 2);