insert into Blogger (id,age,name) VALUES (1,21, 'Gyula');
insert into Blogger (id,age,name) VALUES (2,26, 'Krisz');
insert into STORY (id,title,content,posted,blogger_id) values (1,'Teszt cím','Teszt tartalom', CURRENT_DATE(), (select id FROM BLOGGER where name = 'Gyula') );
insert into STORY (id,title,content,posted,blogger_id) values (2,'Teszt2 cím','Teszt2 tartalom2', CURRENT_DATE(), (select id FROM BLOGGER where name = 'Gyula') );
insert into STORY (id,title,content,posted,blogger_id) values (3,'Krisz cím','Krisz tartalom', CURRENT_DATE(), (select id FROM BLOGGER where name = 'Krisz') );
insert into STORY (id,title,content,posted,blogger_id) values (4,'Krisz2 cím','Krisz2 tartalom2', CURRENT_DATE(), (select id FROM BLOGGER where name = 'Krisz') );
insert into STORY (id,title,content,posted,blogger_id) values (5,'szia','Szia tartalom2', CURRENT_DATE(), (select id FROM BLOGGER where name = 'Krisz') );