DELIMITER $$

DROP TRIGGER IF EXISTS before_insert_personne $$
CREATE TRIGGER before_insert_personne 
BEFORE INSERT ON personne 
FOR EACH ROW
BEGIN
	DECLARE i INT DEFAULT 1;
	DECLARE tel VARCHAR(10) DEFAULT '';

	SET NEW.nom := UPPER(NEW.nom);
	SET NEW.prenom := CONCAT(UPPER(LEFT(NEW.prenom, 1)), LOWER(SUBSTR(NEW.prenom, 2)));

	WHILE i < LENGTH(NEW.tel)+1 DO
		BEGIN
			IF SUBSTR(NEW.tel, i, 1) != ' ' THEN
				SET tel := TRIM(CONCAT(tel, SUBSTR(NEW.tel, i, 1)));
			END IF;
			SET i := i+1;
		END;
	END WHILE;

	SET NEW.tel := tel;

END $$

DELIMITER ;