DELIMITER $$
DROP TRIGGER IF EXISTS before_insert_personne $$
CREATE TRIGGER before_insert_personne 
BEFORE INSERT ON personne 
FOR EACH ROW
BEGIN
	SET NEW.nom = UPPER(NEW.nom);
	SET NEW.prenom = CONCAT(UPPER(LEFT(NEW.prenom, 1)), LOWER(SUBSTR(NEW.prenom, 2)));
	SET NEW.tel = TRIM(NEW.tel);
END $$
DELIMITER ;