USE bookstoreDB;

ALTER table users
ADD column email VARCHAR(100),
ADD column address VARCHAR(255),
ADD column birth_date DATE;

