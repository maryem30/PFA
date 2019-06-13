INSERT INTO user (id, cin,  email, nom, prenom,type_user) VALUES
(1, '11111111', 'ghazoua.hsairi@enis.tn', 'ghazoua', 'hsairi','stagiaire'),
(2, '12345678', 'mohamed.ellouze@enis.tn', 'mohamed', 'ellouze','stagiaire'),
(3, '12131415', 'ahmed.lehyani@enis.tn', 'ahmed', 'lehyani','stagiaire'),
(4, '12365478', 'werda.rim@enis.tn', 'werda', 'rim','stagiaire'),
(5, '74125893', 'maryem.bensalem@enis.tn', 'maryem', 'bensalem','stagiaire'),
(6, '74563021', 'leader1@enis.tn', 'leader1', 'leader1','scrum'),
(7, '55744235', 'leader2@enis.tn', 'leader2', 'leader2','scrum'),
(8, '85478258', 'leader3@enis.tn', 'leader3', 'leader3','scrum'),
(9, '32569874', 'admin@enis.tn', 'admin', 'admin','admin');
INSERT INTO administrator (id,  tel, role) VALUES(9, '78965412','CEO');
INSERT INTO Team_leader (id,  tel) VALUES
(6, '78965412'),(7, '75321456'),(8, '74123568');
INSERT INTO team (id , team_leader_id, team_name) VALUES (1, 6, 'java'), (2, 7, 'php'), (3, 8, 'DevOpps');
INSERT INTO stagiaire (id,  tel) VALUES
(1, '25074800'),(2, '25574800'),(3, '29734800'),(4, '23574800'),(5, '25077700');
INSERT INTO internship (id,date_debut, date_fin, stagiaire_id, team_id,dtype) VALUES 
(1, '2019-05-01', '2019-05-30', 1, 2,"True"), (2, '2019-05-09', '2019-06-13', 3, 1,"True"),(3, '2019-05-01', '2019-05-30', 2, 1,"False"), (4, '2019-05-09', '2019-06-13', 4, 3,"False");
INSERT INTO leave1 (id, date_debut, date_fin,  user_id,step) VALUES (2, '2019-05-01', '2019-05-16',  1,0);
UPDATE user SET sexe=0 , lieucin = 'Tunis', lieu_nes = 'Sfax', adresse = 'Route Taniour Sfax', cin = '11079897', datecin = '2014-06-02', date_nes = '1996-04-21', email = 'ahmed.lehyani@ieee.org', nom = 'Ahmed', password = '********', prenom = 'LEHYANI' WHERE id = 3;