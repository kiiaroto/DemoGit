CREATE VIEW stagiaire AS
	SELECT p.*, sf.*
	FROM 
		personne p
			INNER JOIN
		candidature c ON p.id_personne = c.id_personne
			INNER JOIN
		session_formation sf ON c.id_session_formation = sf.id_session_formation
	WHERE 
		c.id_etat_candidature = 6;