CREATE TABLE IF NOT EXISTS Users (
userid VARCHAR(64) NOT NULL , UNIQUE  (userId),
username VARCHAR(64) NOT NULL ,
email VARCHAR(64)  NOT NULL , UNIQUE  (email),
age INT,
gender VARCHAR(64),
orderscount INT
);

CREATE TABLE IF NOT EXISTS Orders (
orderid VARCHAR(64) NOT NULL ,
userid VARCHAR(64) NOT NULL ,
userName VARCHAR(64) NOT NULL ,
articles VARCHAR(64) NOT NULL ,
price INT,
date TIMESTAMP
);

CREATE TABLE IF NOT EXISTS Articles (
articleId VARCHAR(64) NOT NULL , UNIQUE  (articleId),
articleName VARCHAR(64) NOT NULL , UNIQUE  (articleName),
articlePrice INT
);




