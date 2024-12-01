Insert into Category (id,label) values (1,'Categorie 1');

Insert into Question (id,label,CATEGORY_ID) values (1,'Test de question 1 ?',1);
Insert into Question (id,label,CATEGORY_ID) values (2,'Test de question 2 ?',1);


Insert into Proposal(id,label,correct,QUESTION_ID) values (1,'reponse 1',1,1);
Insert into Proposal(id,label,correct,QUESTION_ID) values (2,'reponse 2',0,1);
Insert into Proposal(id,label,correct,QUESTION_ID) values (3,'reponse 3',1,2);
Insert into Proposal(id,label,correct,QUESTION_ID) values (4,'reponse 4',0,2);