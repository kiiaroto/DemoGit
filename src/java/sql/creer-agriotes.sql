DROP SCHEMA IF EXISTS agriotes2018 ;

CREATE SCHEMA agriotes2018 DEFAULT CHARACTER SET utf8 ;
USE agriotes2018 ;

CREATE TABLE personne (
  id_personne INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  prenom VARCHAR(45) NOT NULL,
  mail VARCHAR(45) NOT NULL,
  tel VARCHAR(10) NOT NULL,
  adresse VARCHAR(45) NULL,
  code_postal VARCHAR(5) NULL,
  ville VARCHAR(45) NULL,
  mot_de_passe VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_personne),
  UNIQUE INDEX id_personne_UNIQUE (id_personne ASC),
  UNIQUE INDEX personne_mail_UNIQUE (mail ASC))
ENGINE = InnoDB;


CREATE TABLE formation (
  id_formation INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  description VARCHAR(250) NOT NULL,
  PRIMARY KEY (id_formation),
  UNIQUE INDEX id_candidature_UNIQUE (id_formation ASC),
  UNIQUE INDEX formation_nom_UNIQUE (nom ASC)
)
ENGINE = InnoDB;


CREATE TABLE session_formation (
  id_session_formation INT NOT NULL AUTO_INCREMENT,
  id_formation INT NOT NULL,
  date_debut DATETIME NOT NULL,
  date_fin DATETIME NOT NULL,
  est_ouverte TINYINT(1) NOT NULL,
  PRIMARY KEY (id_session_formation),
  UNIQUE INDEX id_session_formation_UNIQUE (id_session_formation ASC),
  INDEX fk_session_formation_formation_idx (id_formation ASC),
  CONSTRAINT fk_session_formation_formation
    FOREIGN KEY (id_formation)
    REFERENCES formation (id_formation)
  )ENGINE = InnoDB;


CREATE TABLE etat_candidature (
  id_etat_candidature INT NOT NULL AUTO_INCREMENT,
  libelle VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_etat_candidature),
  UNIQUE INDEX id_etat_candidature_UNIQUE (id_etat_candidature ASC))
ENGINE = InnoDB;


CREATE TABLE candidature (
  id_personne INT NOT NULL,
  id_session_formation INT NOT NULL,
  id_etat_candidature INT NOT NULL,
  PRIMARY KEY (id_personne, id_session_formation),
  INDEX fk_candidature_personne_idx (id_personne ASC),
  INDEX fk_candidature_session_formation_idx (id_session_formation ASC),
  CONSTRAINT fk_candidature_etat_candidature
    FOREIGN KEY (id_etat_candidature)
    REFERENCES etat_candidature (id_etat_candidature),
  CONSTRAINT fk_candidature_personne
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne),
  CONSTRAINT fk_candidature_session_formation
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation)
  )ENGINE = InnoDB;


CREATE TABLE formateur (
  id_formateur INT NOT NULL,
  PRIMARY KEY (id_formateur),
  CONSTRAINT fk_formateur_personne
    FOREIGN KEY (id_formateur)
    REFERENCES personne (id_personne)
  )ENGINE = InnoDB;


CREATE TABLE module (
  id_module INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_module),
  UNIQUE INDEX nom_UNIQUE (nom ASC))
ENGINE = InnoDB;


CREATE TABLE seance (
  id_seance INT NOT NULL AUTO_INCREMENT,
  id_session_formation INT NOT NULL,
  id_formateur INT NOT NULL,
  id_module INT NOT NULL,
  jour DATE NOT NULL,
  creneau TINYINT NOT NULL COMMENT 'matin : 1, après-midi : 2',
  PRIMARY KEY (id_seance),
  INDEX fk_seance_session_formation_idx (id_session_formation ASC),
  INDEX fk_seance_formateur_idx (id_formateur ASC),
  INDEX fk_seance_module_idx (id_module ASC),
  CONSTRAINT fk_seance_session_formation
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation),
  CONSTRAINT fk_seance_formateur
    FOREIGN KEY (id_formateur)
    REFERENCES formateur (id_formateur),
  CONSTRAINT fk_seance_module
    FOREIGN KEY (id_module)
    REFERENCES module (id_module)
  )
ENGINE = InnoDB;


CREATE TABLE presence (
  id_personne INT NOT NULL,
  id_session_formation INT NOT NULL,
  id_seance INT NOT NULL,
  est_present TINYINT(1) NULL,
  PRIMARY KEY (id_personne, id_session_formation, id_seance),
  INDEX fk_candidature_has_seance_seance_idx (id_seance ASC),
  INDEX fk_candidature_has_seance_candidature_idx (id_personne ASC, id_session_formation ASC),
  CONSTRAINT fk_candidature_has_seance_candidature
    FOREIGN KEY (id_personne , id_session_formation)
    REFERENCES candidature (id_personne , id_session_formation),
  CONSTRAINT fk_candidature_has_seance_seance
    FOREIGN KEY (id_seance)
    REFERENCES seance (id_seance)
  )
ENGINE = InnoDB;


CREATE TABLE evaluation (
  id_evaluation INT NOT NULL AUTO_INCREMENT,
  id_module INT NOT NULL,
  id_formateur INT NOT NULL,
  date_debut DATETIME NOT NULL,
  nb_minutes INT NULL,
  titre VARCHAR(45) NULL,
  PRIMARY KEY (id_evaluation),
  INDEX fk_evaluation_module_idx (id_module ASC),
  INDEX fk_evaluation_formateur_idx (id_formateur ASC),
  CONSTRAINT fk_evaluation_module
    FOREIGN KEY (id_module)
    REFERENCES module (id_module),
  CONSTRAINT fk_evaluation_formateur
    FOREIGN KEY (id_formateur)
    REFERENCES formateur (id_formateur)
  )ENGINE = InnoDB;


CREATE TABLE note (
  id_personne INT NOT NULL,
  id_session_formation INT NOT NULL,
  id_evaluation INT NOT NULL,
  note DECIMAL(3,1) NULL,
  PRIMARY KEY (id_personne, id_session_formation, id_evaluation),
  INDEX fk_candidature_has_evaluation_evaluation_idx (id_evaluation ASC),
  INDEX fk_candidature_has_evaluation_candidature_idx (id_personne ASC, id_session_formation ASC),
  CONSTRAINT fk_candidature_has_evaluation_candidature
    FOREIGN KEY (id_personne , id_session_formation)
    REFERENCES candidature (id_personne , id_session_formation),
  CONSTRAINT fk_candidature_has_evaluation_evaluation
    FOREIGN KEY (id_evaluation)
    REFERENCES evaluation (id_evaluation)
  )ENGINE = InnoDB;


CREATE TABLE evenement (
  id_evenement INT NOT NULL AUTO_INCREMENT,
  nom VARCHAR(45) NOT NULL,
  date_effet DATE NOT NULL,
  PRIMARY KEY (id_evenement))
ENGINE = InnoDB;


CREATE TABLE echange (
  id_echange INT NOT NULL AUTO_INCREMENT,
  id_personne INT NOT NULL,
  instant DATETIME NOT NULL,
  texte TEXT NOT NULL,
  PRIMARY KEY (id_echange),
  INDEX fk_echange_personne_idx (id_personne ASC),
  CONSTRAINT fk_echange_personne
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne)
  )ENGINE = InnoDB;


CREATE TABLE invitation (
  id_personne INT NOT NULL,
  id_evenement INT NOT NULL,
  PRIMARY KEY (id_personne, id_evenement),
  INDEX fk_personne_has_evenement_evenement_idx (id_evenement ASC),
  INDEX fk_personne_has_evenement_personne_idx (id_personne ASC),
  CONSTRAINT fk_personne_has_evenement_personne
    FOREIGN KEY (id_personne)
    REFERENCES personne (id_personne),
  CONSTRAINT fk_personne_has_evenement_evenement
    FOREIGN KEY (id_evenement)
    REFERENCES evenement (id_evenement)
  )ENGINE = InnoDB;


CREATE TABLE projet (
  id_projet INT NOT NULL AUTO_INCREMENT,
  id_formateur INT NOT NULL,
  id_session_formation INT NOT NULL,
  titre VARCHAR(45) NOT NULL,
  PRIMARY KEY (id_projet),
  INDEX fk_projet_formateur_idx (id_formateur ASC),
  INDEX fk_projet_session_formation_idx (id_session_formation ASC),
  CONSTRAINT fk_projet_formateur
    FOREIGN KEY (id_formateur)
    REFERENCES formateur (id_formateur),
  CONSTRAINT fk_projet_session_formation
    FOREIGN KEY (id_session_formation)
    REFERENCES session_formation (id_session_formation)
  )ENGINE = InnoDB;

CREATE USER IF NOT EXISTS 'agriotes2018user' IDENTIFIED BY 'agriotes2018pwd';
GRANT ALL ON * TO 'agriotes2018user';
GRANT EXECUTE ON * TO 'agriotes2018user';
