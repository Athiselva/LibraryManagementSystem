SHOW databases;
USE sql12369938;

DROP TABLE AUTHORS;
DROP TABLE BOOKS;
DROP TABLE LIBRARIANS;
DROP TABLE MEMBERS;
DROP TABLE TRANSACTIONS;
DROP TABLE LICENSES;

CREATE TABLE AUTHORS(
AUTHOR_ID NUMERIC(30),
AUTHOR_NAME VARCHAR(200) NOT NULL,
SECTION_CODE VARCHAR(50) NOT NULL,
CREATED_ON NUMERIC(30) NOT NULL,
CREATED_BY NUMERIC(30) NOT NULL,
LAST_MODIFIED_ON NUMERIC(30) NOT NULL,
LAST_MODIFIED_BY NUMERIC(30) NOT NULL,
CONSTRAINT AUTHOR_ID_PK PRIMARY KEY (AUTHOR_ID) 
);

CREATE TABLE BOOKS(
BOOK_ID NUMERIC(30),
AUTHOR_ID NUMERIC(30),
BOOK_NAME VARCHAR(200) NOT NULL,
AUTHOR_NAME VARCHAR(200) NOT NULL,
PRICE DECIMAL(30,2) NOT NULL,
SECTION_CODE VARCHAR(50) NOT NULL,
RACK_CODE VARCHAR(10) NOT NULL,
STATUS VARCHAR(20) NOT NULL,
EDITION VARCHAR(50) NOT NULL,
DATE_OF_PURCHASE DATE NOT NULL,
LAST_MODIFIED_ON NUMERIC(30) NOT NULL,
LAST_MODIFIED_BY NUMERIC(30) NOT NULL,
CREATED_ON NUMERIC(30) NOT NULL,
CREATED_BY NUMERIC(30) NOT NULL,
CONSTRAINT BOOK_ID_PK PRIMARY KEY (BOOK_ID),
CONSTRAINT AUTHOR_ID_FK FOREIGN KEY (AUTHOR_ID)
REFERENCES AUTHORS(AUTHOR_ID) ON DELETE CASCADE
);

CREATE TABLE LIBRARIANS(
LIBRARIAN_ID NUMERIC(30),
LIBRARIAN_NAME VARCHAR(200) NOT NULL,
EMAIL_ID VARCHAR(100) UNIQUE NOT NULL,
PHONE_NUMBER NUMERIC(30),
USER_NAME VARCHAR(100),
PASSWORD VARCHAR(100),
LICENSE_KEY VARCHAR(100),
LAST_MODIFIED_ON NUMERIC(30) NOT NULL,
LAST_MODIFIED_BY NUMERIC(30) NOT NULL,
CONSTRAINT LIBRARIAN_ID_PK PRIMARY KEY (LIBRARIAN_ID)
);

CREATE TABLE MEMBERS(
MEMBER_ID NUMERIC(30),
MEMBER_TYPE VARCHAR(50) NOT NULL,
MEMBER_NAME VARCHAR(200) NOT NULL,
ADDRESS VARCHAR(1000) NOT NULL,
PHONE_NUMBER NUMERIC(30) UNIQUE NOT NULL,
EMAIL VARCHAR(100) UNIQUE NOT NULL,
DATE_OF_MEMBERSHIP DATE NOT NULL,
NUMBER_OF_BOOKS_ISSUED NUMERIC(30) NOT NULL,
NUMBER_OF_BOOKS_RETURNED NUMERIC(30) NOT NULL,
NUMBER_OF_BOOKS_INPENDING NUMERIC(30) NOT NULL,
MAXIMUM_BOOK_LIMIT NUMERIC(30) NOT NULL,
CREATED_ON NUMERIC(30) NOT NULL,
CREATED_BY NUMERIC(30) NOT NULL,
LAST_MODIFIED_ON NUMERIC(30) NOT NULL,
LAST_MODIFIED_BY NUMERIC(30) NOT NULL,
CONSTRAINT MEMBER_ID_PK PRIMARY KEY (MEMBER_ID)
);

CREATE TABLE TRANSACTIONS(
TRANSACTION_ID NUMERIC(30),
MEMBER_ID NUMERIC(30),
MEMBER_NAME VARCHAR(200),
BOOK_ID NUMERIC(30),
AUTHOR_ID NUMERIC(30),
BOOK_NAME VARCHAR(100) NOT NULL,
DATE_OF_ISSUE DATE NOT NULL,
DUE_DATE DATE NOT NULL,
DATE_OF_RETURN DATE,
STATUS VARCHAR(100) NOT NULL,
TRANSACTION_ON NUMERIC(30),
CONSTRAINT TRANSACTION_ID_PK PRIMARY KEY (TRANSACTION_ID),
CONSTRAINT BOOK_ID_FK_2 FOREIGN KEY (BOOK_ID) REFERENCES BOOKS(BOOK_ID) ON DELETE CASCADE,
CONSTRAINT AUTHOR_ID_FK_2 FOREIGN KEY (AUTHOR_ID) REFERENCES AUTHORS(AUTHOR_ID) ON DELETE CASCADE
);

CREATE TABLE LICENSES(
LICENSE_ID NUMERIC(30) NOT NULL,
LICENSE_KEY  VARCHAR(100) NOT NULL,
CREATED_ON  NUMERIC(30) NOT NULL,
CREATED_BY  NUMERIC(30) NOT NULL,
LAST_MODIFIED_ON  NUMERIC(30) NOT NULL,
LAST_MODIFIED_BY  NUMERIC(30) NOT NULL
);

INSERT INTO LICENSES (LICENSE_ID,LICENSE_KEY,CREATED_ON,CREATED_BY,LAST_MODIFIED_ON,LAST_MODIFIED_BY)
VALUES (1,'NLI-LIC-001',1602401497869,1,1602401497869,1);

COMMIT;