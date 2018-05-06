drop database PetMaster;
CREATE DATABASE PetMaster;
USE PetMaster;

CREATE TABLE produtos(
  idprod INT NOT NULL AUTO_INCREMENT,
  codigobarrasprod Varchar (30) NOT NULL,
  nomeprod Varchar (30) NOT NULL,
  valor FLOAT (10,2),
  dataCadastroprod DATE,
  descricaoprod Varchar (60) NOT NULL,
  categoriaprod Varchar (30) NOT NULL,
  quantidadeprod INT NOT NULL,
  PRIMARY KEY (Idprod));

CREATE TABLE pets(
  idpet INT NOT NULL AUTO_INCREMENT,
  codigobarraspet Varchar (30) NOT NULL,
  nomepet Varchar (30) NOT NULL,
  valorpet FLOAT (10,2),
  dataCadastropet DATE,
  descricaopet Varchar (60) NOT NULL,
  categoriapet Varchar (30) NOT NULL,
  quantidadepet INT NOT NULL,
  PRIMARY KEY (Idpet));

CREATE TABLE Clientes(
ClienteID INT NOT NULL AUTO_INCREMENT, 
Nome VARCHAR(60) NOT NULL,
Logradouro VARCHAR(50) NOT NULL,
RG VARCHAR(12) NOT NULL,
CPF VARCHAR(14) NOT NULL,
Pais VARCHAR(15) NOT NULL,  
Cidade VARCHAR(50) NOT NULL,
Bairro VARCHAR(50) NOT NULL,
Estado VARCHAR(50) NOT NULL,
UF VARCHAR(2) NOT NULL,
CEP VARCHAR(8) NOT NULL,
Telefone VARCHAR(15) NOT NULL,
Celular VARCHAR(15),
Email VARCHAR(30),
Sexo VARCHAR(10) NOT NULL,
EstadoCivil VARCHAR(20),
Nascimento DATE NOT NULL,
DataCadastro VARCHAR(20),
statuscliente BOOLEAN NOT NULL,	
PRIMARY KEY (ClienteID, CPF));

INSERT INTO Clientes (Nome,Logradouro,RG,CPF,Pais,Cidade,Bairro,Estado,UF,CEP,Telefone,Celular,Email,Sexo,EstadoCivil,Nascimento, DataCadastro, statuscliente) 
VALUES ("Paulo Henrique Bezerra", "Rua mario Wilches 10", "466825523", "375.197.588-85","Brasil","São Paulo", "Santa Barbara","São Paulo","SP","04858390","55268573","11981997228",
"pauloh2012sul@gmail.com","Masculino", "Solteiro",'1990-01-29',NOW(), true);


INSERT INTO Clientes (Nome,Logradouro,RG,CPF,Pais,Cidade,Bairro,Estado,UF,CEP,Telefone,Celular,Email,Sexo,EstadoCivil,Nascimento, DataCadastro, statuscliente) 
VALUES ("CLIENTE NAO QUER EFETUAR O CADASTRO", "RUA GENERICA", "00000000", "000.000.000-00","Brasil","São Paulo","generico", "São Paulo","SP","00000000","00000000000","00000000",
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

