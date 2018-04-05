DELIMITER $$

DROP PROCEDURE IF EXISTS agriotes2018_reset $$
CREATE PROCEDURE agriotes2018_reset(date_effet DATETIME)
BEGIN
   IF date_effet IS NULL THEN
      SET date_effet = now();
   END IF;

   SET FOREIGN_KEY_CHECKS=0;
      TRUNCATE TABLE candidature;
      TRUNCATE TABLE echange;
      TRUNCATE TABLE etat_candidature;
      TRUNCATE TABLE evaluation;
      TRUNCATE TABLE evenement;
      TRUNCATE TABLE formateur;
      TRUNCATE TABLE formation;
      TRUNCATE TABLE invitation;
      TRUNCATE TABLE module;
      TRUNCATE TABLE note;
      TRUNCATE TABLE personne;
      TRUNCATE TABLE presence;
      TRUNCATE TABLE projet;
      TRUNCATE TABLE seance;
      TRUNCATE TABLE session_formation;
   SET FOREIGN_KEY_CHECKS=1;
    
    INSERT INTO personne(id_personne, nom, prenom, mail, tel, adresse, code_postal, ville, mot_de_passe) VALUES
    (1,"Callahan","Quincy","metus@odioa.net","0960458869","Ap #649-4330 Suscipit Avenue","70651","Casablanca","gravida"),
    (2,"Haley","Avye","vestibulum.Mauris@ornarefacilisiseget.com","0845694707","Ap #822-9800 Erat Rd.","48943","Greater Sudbury","ante"),
    (3,"Sawyer","Venus","ligula@Nuncquis.com","0510602483","679-5855 Sem Avenue","35957","Acosse","faucibus"),
    (4,"Stevenson","Eaton","augue@afeugiat.com","0546971033","5431 Mauris Road","12159","Kisi","pede"),
    (5,"Silva","Price","vitae.risus@mollis.edu","0248369680","P.O. Box 897, 3249 Curabitur St.","11206","Moradabad","risus"),
    (6,"Head","Briar","Integer.vulputate.risus@egetmetuseu.com","0387396561","Ap #937-519 Nunc Street","91300","Pınarbaşı","ultricies"),
    (7,"Peck","Tyler","Cum@ligulaeu.com","0383484403","Ap #475-7358 Quis Rd.","68543","Reno","Sed"),
    (8,"Montoya","Lester","Fusce.aliquam.enim@sitamet.edu","0282954239","9713 Molestie Street","12506","Sangerhausen","lorem"),
    (9,"Figueroa","Christian","elit.Etiam@variusNamporttitor.org","0124629593","Ap #886-3467 Enim Rd.","02040","Calco","dictum"),
    (10,"Wolfe","Burke","Cras.convallis.convallis@dapibusquamquis.com","0558645819","9053 Nam Road","65340","Santo Domingo","risus"),
    (11,"Justice","Charles","at.pretium.aliquet@sapiencursusin.org","0531323259","7041 Mollis Av.","71884","Colchester","pede"),
    (12,"Gardner","Kylynn","pretium.neque.Morbi@sit.org","0333847860","P.O. Box 252, 2276 Scelerisque St.","44330","Westmeerbeek","venenatis"),
    (13,"Baker","Channing","taciti.sociosqu@Classaptenttaciti.edu","0771775852","P.O. Box 857, 3771 Proin Ave","44962","Bursa","risus"),
    (14,"Baxter","Wallace","massa.lobortis@pede.edu","0342156271","654 Sit Av.","34850","Racine","sed"),
    (15,"Kelly","Lyle","ac@eutempor.org","0303946453","972-3256 Purus, Rd.","50280","Vorst","ligula"),
    (16,"Riddle","Doris","cubilia.Curae@purusac.net","0742542658","631-9977 Ac Street","87970","Herstappe","nisl"),
    (17,"Sherman","Graiden","Duis.mi.enim@duinec.com","0300155826","P.O. Box 859, 3456 In Avenue","49070","Ibadan","tempor"),
    (18,"Blevins","Yuli","justo@insodaleselit.co.uk","0141434990","Ap #827-9792 Nonummy. Avenue","97517","Reinbek","Integer"),
    (19,"Casey","Cole","diam@adui.edu","0213304936","P.O. Box 570, 2006 Amet, Avenue","14663","Muiden","Integer"),
    (20,"Dejesus","Germaine","nisl.elementum@dolorFusce.com","0543978310","4198 Ac St.","39857","Darlington","Mauris"),
    (21,"Hughes","Zachary","accumsan.convallis@scelerisque.com","0646791441","663-8962 Mi Street","59919","Chiusa/Klausen","parturient"),
    (22,"Lowery","Mira","mi.enim@eget.ca","0623765886","7126 Cras Rd.","16920","Çaldıran","Etiam"),
    (23,"Horton","Coby","horton.coby@free.fr","0617098852","Ap #836-190 Eleifend Avenue","48560","Lieferinge","luctus"),
    (24,"Perry","Risa","vehicula.et.rutrum@vestibulumnec.ca","0244675879","349-3030 Quis St.","75013","Belgaum","rutrum"),
    (25,"Salas","Dawn","suscipit.nonummy@nuncnullavulputate.com","0906234912","3575 Sed, Rd.","69390","Slijpe","velit"),
    (26,"Mack","Jamalia","est.Nunc.ullamcorper@eratin.net","0686512886","740-7306 Pellentesque Road","33310","Sarreguemines","dolor"),
    (27,"Hurley","Sydnee","facilisis.eget@tricesiaculis.com","0423930467","P.O. Box 411, 3268 Eu St.","86635","Nanded","ac");
    
    INSERT INTO formation(id_formation, nom, description) VALUES
    (1, "SIO SLAM", "BTS SIO option programmation"),
    (2, "SIO SISR", "BTS SIO option réseaux");
    
    INSERT INTO session_formation(id_session_formation, id_formation, date_debut, date_fin, est_ouverte) VALUES
    (1, 1, date_effet - INTERVAL 2 YEAR, date_effet - INTERVAL 1 YEAR, false), -- passé
    (2, 1, date_effet - INTERVAL 8 MONTH, date_effet + INTERVAL 6 MONTH, false), -- en cours
    (3, 2, date_effet - INTERVAL 2 MONTH, date_effet + INTERVAL 1 YEAR, false), -- en cours
    (4, 2, date_effet + INTERVAL 6 MONTH, date_effet + INTERVAL 2 YEAR, true); -- ouverte a candidature
    
    INSERT INTO etat_candidature(id_etat_candidature, libelle) VALUES
    (1, 'non traitée'),
    (2, 'refusé'),
    (3, 'reçu'),
    (4, 'liste d''attente'),
    (5, 'accepté'),
    (6, 'inscrit'),
    (7, 'desisté');
    
    INSERT INTO candidature(id_personne, id_session_formation, id_etat_candidature) VALUES
    (1, 1, 6),
    (2, 1, 6),
    (3, 1, 6),
    (4, 1, 6),
    (5, 1, 6),
    (6, 2, 6),
    (7, 2, 6),
    (8, 2, 6),
    (9, 2, 6),
    (10, 2, 6),
    (11, 2, 6),
    (12, 2, 3),
    (13, 3, 6),
    (14, 3, 6),
    (15, 3, 6),
    (16, 3, 6),
    (17, 3, 3),
    (18, 4, 6),
    (19, 4, 6),
    (20, 4, 6),
    (21, 4, 4),
    (22, 4, 3),
    (1, 2, 6),
    (2, 4, 1);
    
    INSERT INTO formateur(id_formateur) VALUES
    (23),
    (24),
    (25);
    
    INSERT INTO module(id_module, nom) VALUES
    (1, 'Math'),
    (2, 'Réseau');
    
    INSERT INTO seance(id_seance, id_session_formation, id_formateur, id_module, jour, creneau) VALUES
    (1, 1, 23, 1, date_effet - INTERVAL 2 YEAR + INTERVAL 4 MONTH, 1),
    (2, 2, 23, 1, date_effet - INTERVAL 2 YEAR + INTERVAL 4 MONTH, 2),
    (3, 3, 24, 2, date_effet - INTERVAL 2 YEAR + INTERVAL 4 MONTH, 4),
    (4, 1, 23, 1, date_effet - INTERVAL 2 YEAR + INTERVAL 4 MONTH, 2),
    (5, 2, 23, 1, date_effet - INTERVAL 2 YEAR + INTERVAL 4 MONTH, 3),
    (6, 3, 24, 2, date_effet - INTERVAL 2 YEAR + INTERVAL 4 MONTH, 1),
    (7, 1, 23, 1, date_effet - INTERVAL 1 YEAR, 2),
    (8, 1, 24, 2, date_effet - INTERVAL 1 YEAR, 4),
    (9, 2, 24, 2, date_effet, 2),
    (10, 3, 24, 2, date_effet + INTERVAL 3 MONTH, 4),
    (11, 3, 23, 1, date_effet, 2),
    (12, 3, 23, 1, date_effet + INTERVAL 3 MONTH + INTERVAL 1 DAY, 1);
    
    INSERT INTO evaluation(id_evaluation, id_module, id_formateur, date_debut, nb_minutes, titre) VALUES
    (1, 1, 23, date_effet - INTERVAL 1 YEAR - INTERVAL 4 MONTH, 120, 'Evaluation finale de mathématique'),
    (2, 2, 24, date_effet - INTERVAL 1 YEAR - INTERVAL 4 MONTH, 240, 'Evaluation mise en place d''un serveur LAMP'),
    (3, 2, 24, date_effet, 60, 'Evaluation réseau 2'),
    (4, 2, 24, date_effet + INTERVAL 4 MONTH, 60, 'Evaluation réseau 3'),
    (5, 1, 23, date_effet, 60, 'Math 2'),
    (6, 1, 23, date_effet + INTERVAL 4 MONTH, 120, 'Math 3');
    
    INSERT INTO note(id_personne, id_session_formation, id_evaluation, note) VALUES
    (1, 1, 1, 14),
    (2, 1, 1, 8),
    (3, 1, 1, 11),
    (4, 1, 1, null),
    (5, 1, 1, null),
    (1, 1, 2, null),
    (2, 1, 2, null),
    (3, 1, 2, 3),
    (4, 1, 2, null),
    (5, 1, 2, 18),
    (6, 2, 3, null),
    (7, 2, 3, null),
    (8, 2, 3, null),
    (9, 2, 3, null),
    (10, 2, 3, null),
    (11, 2, 3, null),
    (13, 3, 4, null),
    (14, 3, 4, null),
    (15, 3, 4, null),
    (16, 3, 4, null),
    (13, 3, 5, null),
    (14, 3, 5, null),
    (15, 3, 5, null),
    (16, 3, 5, null),
    (13, 3, 6, null),
    (14, 3, 6, null),
    (15, 3, 6, null),
    (16, 3, 6, null);
    
    INSERT INTO presence(id_personne, id_session_formation, id_seance, est_present) VALUES
    (1, 1, 1, true),
    (2, 1, 1, true),
    (3, 1, 1, true),
    (4, 1, 1, true),
    (5, 1, 1, false),
    (6, 2, 2, true),
    (7, 2, 2, true),
    (8, 2, 2, false),
    (9, 2, 2, false),
    (10, 2, 2, true),
    (11, 2, 2, true),
    (13, 3, 3, false),
    (14, 3, 3, true),
    (15, 3, 3, true),
    (16, 3, 3, true),
    (1, 1, 4, false),
    (2, 1, 4, false),
    (3, 1, 4, true),
    (4, 1, 4, true),
    (5, 1, 4, false),
    (6, 2, 5, true),
    (7, 2, 5, true),
    (8, 2, 5, true),
    (9, 2, 5, true),
    (10, 2, 5, false),
    (11, 2, 5, true),
    (13, 3, 6, false),
    (14, 3, 6, true),
    (15, 3, 6, true),
    (16, 3, 6, false),
    (1, 1, 7, false),
    (2, 1, 7, false),
    (3, 1, 7, true),
    (4, 1, 7, false),
    (5, 1, 7, false),
    (1, 1, 8, false),
    (2, 1, 8, false),
    (3, 1, 8, true),
    (4, 1, 8, false),
    (5, 1, 8, true),
    (13, 3, 9, null),
    (14, 3, 9, null),
    (15, 3, 9, null),
    (16, 3, 9, null),
    (13, 3, 10, null),
    (14, 3, 10, null),
    (15, 3, 10, null),
    (16, 3, 10, null),
    (13, 3, 11, null),
    (14, 3, 11, null),
    (15, 3, 11, null),
    (16, 3, 11, null);
    
    INSERT INTO projet(id_projet, id_formateur, id_session_formation, titre) VALUES
    (1, 23, 1, 'Maintient d''un site web'),
    (2, 24, 1, 'Calcule de matrice');
    
    INSERT INTO echange(id_echange, id_personne, instant, texte) VALUES
    (1, 2, date_effet - INTERVAL 2 YEAR + INTERVAL 5 MONTH, 'Demande d''information concernant la formation'),
    (2, 2, date_effet - INTERVAL 2 YEAR + INTERVAL 7 MONTH, 'Demande d''inscription'),
    (3, 2, date_effet - INTERVAL 2 YEAR + INTERVAL 7 MONTH, 'Confirmation de l''invitation a la journée d\information'),
    (4, 22, date_effet - INTERVAL 2 YEAR + INTERVAL 7 MONTH + INTERVAL 1 DAY, 'Contact 1'),
    (5, 22, date_effet - INTERVAL 2 YEAR + INTERVAL 7 MONTH + INTERVAL 3 DAY, 'Contact 2'),
    (6, 22, date_effet - INTERVAL 2 YEAR + INTERVAL 7 MONTH + INTERVAL 5 DAY, 'Contact 3'),
    (7, 22, date_effet - INTERVAL 2 YEAR + INTERVAL 8 MONTH, 'Contact 4'),
    (8, 22, date_effet - INTERVAL 2 YEAR + INTERVAL 8 MONTH + INTERVAL 1 DAY, 'Contact 5'),
    (9, 2, date_effet - INTERVAL 2 DAY, 'Demande d''information'),
    (10, 2, date_effet, 'Demande d''annulation d''inscription');
    
    INSERT INTO evenement(id_evenement, nom, date_effet) VALUES
    (1, 'Remise des Diplome', date_effet - INTERVAL 1 YEAR),
    (2, 'Réunion d''inscription', date_effet - INTERVAL 1 MONTH);
    
    INSERT INTO invitation(id_personne, id_evenement) VALUES
    (1, 1),
    (2, 1),
    (2, 2),
    (22, 2);

END$$
