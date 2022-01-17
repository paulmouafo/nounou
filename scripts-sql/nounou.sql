-- PostgreSQL


-- Schema

DROP SCHEMA  IF EXISTS  nounou  CASCADE;
CREATE SCHEMA  nounou;

SET search_path TO nounou, public;


-- Tables


------------------------------------------------------------
-- Table: suivie
------------------------------------------------------------
CREATE TABLE  suivie(
	idSuivie      SERIAL NOT NULL ,
	date          DATE  NOT NULL ,
	heureArrive   TIMETZ  NOT NULL ,
	heureDepart   TIMETZ  NOT NULL ,
	repas         BOOL  NOT NULL  ,
	CONSTRAINT suivie_PK PRIMARY KEY (idSuivie)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: compte
------------------------------------------------------------
CREATE TABLE  compte(
	idCompte     SERIAL NOT NULL ,
	email        VARCHAR (255) NOT NULL ,
	motdepasse   VARCHAR (255) NOT NULL ,
	role         VARCHAR (255) NOT NULL  ,
	CHECK( role IN ('ADMIN','PARENT') ),	
	CONSTRAINT compte_PK PRIMARY KEY (idCompte)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: parent
------------------------------------------------------------
CREATE TABLE  parent(
	idParent    SERIAL NOT NULL ,
	nom         VARCHAR (255) NOT NULL ,
	prenom      VARCHAR (255) NOT NULL ,
	adresse     VARCHAR (255) NOT NULL ,
	telephone   INT  NOT NULL ,
	idCompte    INT  NOT NULL  ,
	CONSTRAINT parent_PK PRIMARY KEY (idParent)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: assistante
------------------------------------------------------------
CREATE TABLE  assistante(
	idAssistante   SERIAL NOT NULL ,
	nom            VARCHAR (255) NOT NULL ,
	prenom         VARCHAR (255) NOT NULL ,
	telephone      INT  NOT NULL ,
	email          VARCHAR (255) NOT NULL ,
	idCompte       INT  NOT NULL  ,
	CONSTRAINT assistante_PK PRIMARY KEY (idAssistante)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: contrat
------------------------------------------------------------
CREATE TABLE  contrat(
	id                    SERIAL NOT NULL ,
	dateDeDebut           DATE  NOT NULL ,
	dateDeFin             DATE  NOT NULL ,
	tarifHoraire          FLOAT  NOT NULL ,
	indemniteDentretien   FLOAT  NOT NULL ,
	indemniteDeRepas      FLOAT  NOT NULL ,
	idEnfant              INT  NOT NULL  ,
	CONSTRAINT contrat_PK PRIMARY KEY (id)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: enfant
------------------------------------------------------------
CREATE TABLE  enfant(
	idEnfant          SERIAL NOT NULL ,
	nom               VARCHAR (255) NOT NULL ,
	prenom            VARCHAR (255) NOT NULL ,
	dateDeNaissance   DATE  NOT NULL ,
	id                INT  NOT NULL ,
	idSuivie          INT  NOT NULL  ,
	CONSTRAINT enfant_PK PRIMARY KEY (idEnfant)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: avoir
------------------------------------------------------------
CREATE TABLE  avoir(
	idParent   INT  NOT NULL ,
	idEnfant   INT  NOT NULL  ,
	CONSTRAINT avoir_PK PRIMARY KEY (idParent,idEnfant)
)WITHOUT OIDS;




ALTER TABLE  parent
	ADD CONSTRAINT parent_compte0_FK
	FOREIGN KEY (idCompte)
	REFERENCES  compte(idCompte);

ALTER TABLE  assistante
	ADD CONSTRAINT assistante_compte0_FK
	FOREIGN KEY (idCompte)
	REFERENCES  compte(idCompte);

ALTER TABLE  contrat
	ADD CONSTRAINT contrat_enfant0_FK
	FOREIGN KEY (idEnfant)
	REFERENCES  enfant(idEnfant);

ALTER TABLE  contrat 
	ADD CONSTRAINT contrat_enfant0_AK 
	UNIQUE (idEnfant);

ALTER TABLE  enfant
	ADD CONSTRAINT enfant_contrat0_FK
	FOREIGN KEY (id)
	REFERENCES  contrat(id);

ALTER TABLE  enfant
	ADD CONSTRAINT enfant_suivie1_FK
	FOREIGN KEY (idSuivie)
	REFERENCES  suivie(idSuivie);

ALTER TABLE  enfant 
	ADD CONSTRAINT enfant_contrat0_AK 
	UNIQUE (id);

ALTER TABLE  avoir
	ADD CONSTRAINT avoir_parent0_FK
	FOREIGN KEY (idParent)
	REFERENCES  parent(idParent);

ALTER TABLE  avoir
	ADD CONSTRAINT avoir_enfant1_FK
	FOREIGN KEY (idEnfant)
	REFERENCES  enfant(idEnfant);

	
-- Insertion des données

INSERT INTO compte (idCompte, email, motdepasse, role ) 
VALUES (1, 'admin@3il.fr', 'admin', 'ADMIN' );

INSERT INTO compte (idCompte, email, motdepasse, role ) 
VALUES (2, 'parent@3il.fr', 'parent', 'PARENT' );
	
	
---- Compte utilisateur
--DROP USER  IF EXISTS  nounou;
--CREATE USER  nounou  WITH PASSWORD 'nounou';
--GRANT ALL PRIVILEGES ON SCHEMA nounou TO nounou;
--GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA nounou TO nounou;