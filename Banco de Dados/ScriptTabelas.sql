CREATE DATABASE PetMaster;
USE PetMaster;

CREATE TABLE Produtos(
  Idprod INT NOT NULL AUTO_INCREMENT,
  Codigobarrasprod Varchar (30) NOT NULL,
  Nomeprod Varchar (30) NOT NULL,
  Valor FLOAT (10,2),
  DataCadastroprod DATE,
  Descricaoprod Varchar (60) NOT NULL,
  Categoriaprod Varchar (30) NOT NULL,
  Quantidadeprod INT NOT NULL,
  PRIMARY KEY (Idprod));


INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Paulo Henrique Bezerra","Paulo.Bezerra","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Lucas Medeiros","Lucas.Medeiros","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Andre Pereira","Andre.Pereira","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Pedro Paulo Olivira","Pedro.Oliveira","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Matheus Diamantino","Matheus.Diamantino","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Guilherme Feitosa","Guilherme.Feitosa","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("Gabriel","Gabiru","Mortadela1");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("admin","admin","admin");
INSERT INTO Usuarios(NomeUser, username,Password) VALUES ("professor","professor","professor");



CREATE TABLE Clientes(
ClienteID INT NOT NULL AUTO_INCREMENT, 
Nome VARCHAR(60) NOT NULL,
Logradouro VARCHAR(50) NOT NULL,
RG VARCHAR(12) NOT NULL,
CPF VARCHAR(14) NOT NULL,
Numero VARCHAR(15) NOT NULL,  
Cidade VARCHAR(50) NOT NULL,
Estado VARCHAR(50) NOT NULL,
UF VARCHAR(2) NOT NULL,
CEP VARCHAR(8) NOT NULL,
Telefone VARCHAR(15) NOT NULL,
Celular VARCHAR(15),
Email VARCHAR(30),
Sexo VARCHAR(10) NOT NULL,
EstadoCivil VARCHAR(20),
Nascimento DATE NOT NULL,
DataCadastro DATE,
statuscliente BOOLEAN NOT NULL,	
PRIMARY KEY (ClienteID, CPF));

INSERT INTO Clientes (Nome,Logradouro,RG,CPF,Numero,Cidade,Estado,UF,CEP,Telefone,Celular,Email,Sexo,EstadoCivil,Nascimento, DataCadastro, statuscliente) 
VALUES ("Paulo Henrique Bezerra", "Rua mario Wilches 10", "466825523", "375.197.588-85","10","São Paulo", "São Paulo","SP","04858390","55268573","11981997228",
"pauloh2012sul@gmail.com","Masculino", "Solteiro",'1990-01-29',NOW(), true);
INSERT INTO Clientes (Nome,Logradouro,RG,CPF,Numero,Cidade,Estado,UF,CEP,Telefone,Celular,Email,Sexo,EstadoCivil,Nascimento, DataCadastro, statuscliente) 
VALUES ("CLIENTE NAO QUER EFETUAR O CADASTRO", "RUA GENERICA", "00000000", "000.000.000-00","00","São Paulo", "São Paulo","SP","00000000","00000000000","00000000",
" ","Masculino", "Solteiro",'1990-01-29', NOW(),true);




CREATE TABLE Vendas(
IDVenda INT NOT NULL AUTO_INCREMENT,
CPFCliente VARCHAR(14) NOT NULL,
TotalValor FLOAT (10,2),
DataVenda DATE,
QuantidadeItens INT NOT NULL,
VendaStatus BOOLEAN,
Vendedor Varchar (30) NOT NULL,
PRIMARY KEY (IDVenda, CPFCliente));



CREATE TABLE Produtos(
idproduto INT NOT NULL AUTO_INCREMENT,
codigobarras LONG NOT NULL,
Nomeproduto VARCHAR(60) NOT NULL UNIQUE,
Valor DECIMAL(12, 2),
ValorDesconto DECIMAL(12, 2),
FaixaEtaria VARCHAR(20) NOT NULL,
Fabricante VARCHAR(50),  
PrazoGarantia VARCHAR(30),
Quantidade INT NOT NULL,
DataCadastro DATE,
statusproduto BOOLEAN NOT NULL,	
PRIMARY KEY (idproduto));

DELIMITER $$
CREATE TRIGGER Desconto
 BEFORE INSERT ON Produtos
 FOR EACH ROW
 BEGIN
 SET NEW.valordesconto = (NEW.valor * 0.20);
 END$$
DELIMITER ;