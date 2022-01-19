-- PostgreSQL


-- Schema

DROP SCHEMA  IF EXISTS  nounou  CASCADE;
CREATE SCHEMA  nounou;

SET search_path TO nounou, public;


-- Tables


------------------------------------------------------------
-- Table: garde
------------------------------------------------------------
CREATE TABLE garde(
	idGarde       SERIAL NOT NULL ,
	date          DATE  NOT NULL ,
	heureArrive   TIMETZ  NOT NULL ,
	heureDepart   TIMETZ  NOT NULL ,
	repas         BOOL  NOT NULL  ,
	CONSTRAINT garde_PK PRIMARY KEY (idGarde)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: compte
------------------------------------------------------------
CREATE TABLE compte(
	idCompte     SERIAL NOT NULL ,
	email        VARCHAR (255) NOT NULL ,
	motdepasse   VARCHAR (255) NOT NULL ,
	role         VARCHAR (255) NOT NULL  ,
	CONSTRAINT compte_PK PRIMARY KEY (idCompte)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: parent
------------------------------------------------------------
CREATE TABLE parent(
	idParent    SERIAL NOT NULL ,
	nom         VARCHAR (255) NOT NULL ,
	prenom      VARCHAR (255) NOT NULL ,
	adresse     VARCHAR (255) NOT NULL ,
	telephone   INT  NOT NULL ,
	idCompte    INT  NOT NULL  ,
	CONSTRAINT parent_PK PRIMARY KEY (idParent)

	,CONSTRAINT parent_compte_FK FOREIGN KEY (idCompte) REFERENCES compte(idCompte)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: assistante
------------------------------------------------------------
CREATE TABLE assistante(
	idAssistante   SERIAL NOT NULL ,
	nom            VARCHAR (255) NOT NULL ,
	prenom         VARCHAR (255) NOT NULL ,
	telephone      INT  NOT NULL ,
	email          VARCHAR (255) NOT NULL ,
	idCompte       INT  NOT NULL  ,
	CONSTRAINT assistante_PK PRIMARY KEY (idAssistante)

	,CONSTRAINT assistante_compte_FK FOREIGN KEY (idCompte) REFERENCES compte(idCompte)
)WITHOUT OIDS;


------------------------------------------------------------
-- Table: contrat
------------------------------------------------------------
CREATE TABLE contrat(
	id                    SERIAL NOT NULL ,
	nomEnfant             VARCHAR (255) NOT NULL ,
	prenomEnfant          VARCHAR (255) NOT NULL ,
	dateDeNaissance       DATE  NOT NULL ,
	dateDeDebut           DATE  NOT NULL ,
	dateDeFin             DATE  NOT NULL ,
	tarifHoraire          FLOAT  NOT NULL ,
	indemniteDentretien   FLOAT  NOT NULL ,
	indemniteDeRepas      FLOAT  NOT NULL ,
	idParent              INT  NOT NULL ,
	idGarde               INT  NOT NULL ,
	idAssistante          INT  NOT NULL  ,
	CONSTRAINT contrat_PK PRIMARY KEY (id)

	,CONSTRAINT contrat_parent_FK FOREIGN KEY (idParent) REFERENCES parent(idParent)
	,CONSTRAINT contrat_garde0_FK FOREIGN KEY (idGarde) REFERENCES garde(idGarde)
	,CONSTRAINT contrat_assistante1_FK FOREIGN KEY (idAssistante) REFERENCES assistante(idAssistante)
)WITHOUT OIDS;

	
-- Insertion des données

INSERT INTO compte (idCompte, email, motdepasse, role ) 
VALUES (1, 'admin@3il.fr', 'admin', 'ADMIN' );

INSERT INTO compte (idCompte, email, motdepasse, role ) 
VALUES (2, 'parent@3il.fr', 'parent', 'PARENT' );
	
	
---- Compte utilisateur
--DROP USER  IF EXISTS  nounou;
--CREATE USER  nounou  WITH PASSWORD 'nounou';
GRANT ALL PRIVILEGES ON SCHEMA nounou TO nounou;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA nounou TO nounou;