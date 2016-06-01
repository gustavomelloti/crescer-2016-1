-- Gerado por Oracle SQL Developer Data Modeler 4.1.3.901
--   em:        2016-05-31 15:51:02 BRT
--   site:      Oracle Database 11g
--   tipo:      Oracle Database 11g




CREATE TABLE Aposta
  (
    IDAposta            INTEGER NOT NULL ,
    IDConcurso          INTEGER NOT NULL ,
    IDNumeroApostaValor INTEGER NOT NULL ,
    DataAposta          DATE NOT NULL ,
    Bolao               CHAR (1) NOT NULL
  ) ;
ALTER TABLE Aposta ADD CONSTRAINT Aposta_PK PRIMARY KEY ( IDAposta ) ;


CREATE TABLE Concurso
  (
    IDConcurso INTEGER NOT NULL ,
    Data       DATE NOT NULL ,
    Premio     NUMBER (12,2) NOT NULL
  ) ;
ALTER TABLE Concurso ADD CONSTRAINT Concurso_PK PRIMARY KEY ( IDConcurso ) ;


CREATE TABLE ConcursoNumeroSorteado
  (
    IDConcursoNumeroSorteado INTEGER NOT NULL ,
    IDConcurso               INTEGER NOT NULL ,
    Numero                   INTEGER NOT NULL
  ) ;
ALTER TABLE ConcursoNumeroSorteado ADD CONSTRAINT ConcursoNumeroSorteado_PK PRIMARY KEY ( IDConcursoNumeroSorteado ) ;


CREATE TABLE Ganhador
  (
    ID                INTEGER NOT NULL ,
    IDAposta          INTEGER NOT NULL ,
    QuantidadeAcertos INTEGER NOT NULL ,
    ValorPremio       NUMBER (12,2) NOT NULL
  ) ;
ALTER TABLE Ganhador ADD CONSTRAINT Ganhador_PK PRIMARY KEY ( ID ) ;


CREATE TABLE NumeroAposta
  (
    IDNumeroAposta INTEGER NOT NULL ,
    IDAposta       INTEGER NOT NULL ,
    Numero         INTEGER NOT NULL
  ) ;
ALTER TABLE NumeroAposta ADD CONSTRAINT NumerosAposta_PK PRIMARY KEY ( IDNumeroAposta ) ;


CREATE TABLE NumeroApostaValor
  (
    IDNumeroApostaValor INTEGER NOT NULL ,
    QuantidadeNumeros   INTEGER NOT NULL ,
    Valor               NUMBER (6,2)
  ) ;
ALTER TABLE NumeroApostaValor ADD CONSTRAINT NumeroApostaValor_PK PRIMARY KEY ( IDNumeroApostaValor ) ;


CREATE TABLE ValorPago
  (
    IDValorPago INTEGER NOT NULL ,
    Percentual  INTEGER NOT NULL ,
    Descricao   VARCHAR2 (200) NOT NULL
  ) ;
ALTER TABLE ValorPago ADD CONSTRAINT ValorPago_PK PRIMARY KEY ( IDValorPago ) ;


CREATE TABLE ValorPagoConcurso
  (
    IDValorPagoConcurso INTEGER NOT NULL ,
    IDValorPago         INTEGER NOT NULL ,
    IDConcurso          INTEGER NOT NULL ,
    Valor               NUMBER (10,2) NOT NULL
  ) ;
ALTER TABLE ValorPagoConcurso ADD CONSTRAINT PercentualPremioBruto_PK PRIMARY KEY ( IDValorPagoConcurso ) ;


ALTER TABLE Aposta ADD CONSTRAINT Aposta_Concurso_FK FOREIGN KEY ( IDConcurso ) REFERENCES Concurso ( IDConcurso ) ;

ALTER TABLE Aposta ADD CONSTRAINT Aposta_NumeroApostaValor_FK FOREIGN KEY ( IDNumeroApostaValor ) REFERENCES NumeroApostaValor ( IDNumeroApostaValor ) ;

ALTER TABLE ConcursoNumeroSorteado ADD CONSTRAINT ConcursoNumeroSorteado_FK FOREIGN KEY ( IDConcurso ) REFERENCES Concurso ( IDConcurso ) ;

ALTER TABLE Ganhador ADD CONSTRAINT Ganhador_Aposta_FK FOREIGN KEY ( IDAposta ) REFERENCES Aposta ( IDAposta ) ;

ALTER TABLE NumeroAposta ADD CONSTRAINT NumerosAposta_Aposta_FK FOREIGN KEY ( IDAposta ) REFERENCES Aposta ( IDAposta ) ;

ALTER TABLE ValorPagoConcurso ADD CONSTRAINT ValorPagoConcurso_Concurso_FK FOREIGN KEY ( IDConcurso ) REFERENCES Concurso ( IDConcurso ) ;

ALTER TABLE ValorPagoConcurso ADD CONSTRAINT ValorPagoConcurso_ValorPago_FK FOREIGN KEY ( IDValorPago ) REFERENCES ValorPago ( IDValorPago ) ;


-- Relatório do Resumo do Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             8
-- CREATE INDEX                             0
-- ALTER TABLE                             15
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
