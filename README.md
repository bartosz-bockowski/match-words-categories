create database "categories"
start application to let hibernate create tables
use those querys to insert data for testing:

INSERT INTO keyword (keyword) VALUES ('mouse'),('keyboard'),('screen'),('dog'),('cat'),('pants'),('shirts'),('shoes')

INSERT INTO category (title) VALUES ('computers'),('animals'),('clothing')

INSERT INTO category_keywords (categories_id, keywords_id) VALUES (1,1),(1,2),(1,3),(2,1),(2,4),(2,5),(3,6),(3,7),(3,8)
