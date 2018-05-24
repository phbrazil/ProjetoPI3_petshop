drop database petmaster;
CREATE DATABASE petmaster;
USE petmaster;

CREATE TABLE usuarios(
  codigouser INT NOT NULL AUTO_INCREMENT,
  nomeuser Varchar (30) NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(20), 
  PRIMARY KEY (codigouser));


INSERT INTO usuarios(nomeuser, username,password) VALUES ("Paulo Henrique Bezerra","paulo.bezerra@senac.com","123");
INSERT INTO usuarios(nomeuser, username,password) VALUES ("Lucas Medeiros","lucas.medeiros@senac.com","123");
INSERT INTO usuarios(nomeuser, username,password) VALUES ("Andre Pereira","andre.pereira@senac.com","123");
INSERT INTO usuarios(nomeuser, username,password) VALUES ("Pedro Paulo Olivira","pedro.oliveira@senac.com","123");
INSERT INTO usuarios(nomeuser, username,password) VALUES ("Aluno do terceiro semestre","visitante@senac.com","123");


CREATE TABLE produtos(
  idprod INT NOT NULL AUTO_INCREMENT,
  codigobarrasprod Varchar (30) NOT NULL,
  nomeprod Varchar (60) NOT NULL,
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

CREATE TABLE clientes(
clienteid INT NOT NULL AUTO_INCREMENT, 
nome VARCHAR(60) NOT NULL,
logradouro VARCHAR(50) NOT NULL,
rg VARCHAR(12) NOT NULL,
cpfcliente VARCHAR(14) NOT NULL,
pais VARCHAR(15) NOT NULL,  
cidade VARCHAR(50) NOT NULL,
bairro VARCHAR(50) NOT NULL,
estado VARCHAR(50) NOT NULL,
uf VARCHAR(2) NOT NULL,
cep VARCHAR(8) NOT NULL,
telefone VARCHAR(15) NOT NULL,
celular VARCHAR(15),
email VARCHAR(30),
sexo VARCHAR(10) NOT NULL,
estadocivil VARCHAR(20),
nascimento DATE NOT NULL,
datacadastro VARCHAR(20),
statuscliente BOOLEAN NOT NULL,	
PRIMARY KEY (clienteid, cpfcliente));

INSERT INTO clientes (nome,logradouro,rg,cpfcliente,pais,cidade,bairro,estado,uf,cep,telefone,celular,email,sexo,estadocivil,nascimento, datacadastro, statuscliente) 
VALUES ("Paulo Henrique Bezerra", "Rua Paulo Egidio Carvalho 109", "466825523", "375.197.588-85","Brasil","São Paulo", "Santa Barbara","São Paulo","SP","04858390","55268573","11981997228",
"pauloh2012sul@gmail.com","Masculino", "Solteiro",'1990-01-29',NOW(), true);


INSERT INTO clientes (nome,logradouro,rg,cpfcliente,pais,cidade,bairro,estado,uf,cep,telefone,celular,email,sexo,estadocivil,nascimento, datacadastro, statuscliente) 
VALUES ("CLIENTE NAO QUER EFETUAR O CADASTRO", "RUA GENERICA", "00000000", "000.000.000-00","Brasil","São Paulo","generico", "São Paulo","SP","00000000","00000000000","00000000",
"email@generico","Masculino", "Solteiro",'1990-01-29',NOW(),true);


CREATE TABLE vendas(
idvenda INT NOT NULL AUTO_INCREMENT,
cpfcliente VARCHAR(14) NOT NULL,
totalvalor FLOAT (10,2),
datavenda DATE,
quantidadeitens INT NOT NULL,
vendastatus BOOLEAN,
vendedor Varchar (30) NOT NULL,
PRIMARY KEY (idvenda, cpfcliente));

CREATE TABLE itemvenda(
idvenda INT,
idpet INT NOT NULL,
idprod INT NOT NULL,
quantidadeitens INT NOT NULL,
  FOREIGN KEY (idvenda) REFERENCES vendas (idvenda),
  FOREIGN KEY (idpet) REFERENCES pets (idpet),
  FOREIGN KEY (idprod) REFERENCES produtos (idprod)

);

INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (1,'Telefone Feliz',59.99,Now(),'0 à 12 meses','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (2,'Mordedor Macaco Brincalhão',29.99,Now(),'0 à 12 meses','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (3,'Robôzinho BeatBo',399.99,Now(),'0 à 12 meses','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (4,'Cachorrinho - Aprendendo a Brincar',179.50,Now(),'0 à 12 meses','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (5,'Lamparina Aprender e Brincar ',139.99,Now(),'0 à 12 meses','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (6,'Chocalho e Mordedor',19.99,Now(),'0 à 12 meses','ELKA',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (7,'Chocalho Galinha Pintadinha',39.99,Now(),'0 à 12 meses','ELKA',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (8,'Pirâmide de Argolas',49.99,Now(),'De 1 à 2 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (9,'Boneca Minnie - Conta histórias',99.99,Now(),'De 1 à 2 anos','ELKA',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (10,'Mega Bloks - Ônibus da Escola 123 - 45 peças',99.99,Now(),'De 1 à 2 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (11,'Figura de atividade - Montro Labirinto Divertido',189.99,Now(),'De 1 à 2 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (12,'Mochila animada do cachorrinho',199.99,Now(),'De 1 à 2 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (13,'Piano cachorrinho aprender e brincar ',179.99,Now(),'De 1 à 2 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (14,'Pelúcia Interativa ',99.99,Now(),'De 1 à 2 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (15,'Boneco Baby Alive Menino - loiro',249.60,Now(),'De 3 à 4 anos','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (16,'Boneca Baby Alive - loira',499.00,Now(),'De 3 à 4 anos','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (17,'Microfone com base - Barbie',149.60,Now(),'De 3 à 4 anos','Barão Distribuidor',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (18,'Boneca Little Mommy',89.80,Now(),'De 3 à 4 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (19,'Mini Veículo com personagem - PJ Masks',69.99,Now(),'De 3 à 4 anos','DTC',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (20,'Boneco Liga da Justiça - Superman',39.99,Now(),'De 3 à 4 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (21,'Boneco Liga da Justiça - Coringa',39.99,Now(),'De 3 à 4 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (22,'Veiculo Furgão Patrulheiro - Patrulha Canina',699.99,Now(),'De 5 à 6 anos','Sunny',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (23,'Boneco - AuthenticGames',109.99,Now(),'De 5 à 6 anos','ZR Toys',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (24,'Jogo Pizzaria maluca',59.99,Now(),'De 5 à 6 anos','Grow',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (25,'Massa de Modelar - Super massa',39.99,Now(),'De 5 à 6 anos','Estrela',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (26,'Boneco Power Ranger Dino Charger - Armadura de Luxo',79.90,Now(),'De 5 à 6 anos','Sunny',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (27,'Pista Hot Wheels - fuga em alto mar',79.99,Now(),'De 5 à 6 anos','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (28,'Luva Lança Teias - Spider Man',79.99,Now(),'De 5 à 6 anos','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (29,'Lego Super Heroes - Disney - Marvel - Spider man',149.99,Now(),'De 7 à 8 anos ','Lego',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (30,'Lego City - Veículo de Policia Off Road',49.99,Now(),'De 7 à 8 anos ','Lego',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (31,'Veiculo - Avião Patruleiro - Patrulha Canina',419,Now(),'De 7 à 8 anos ','Sunny',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (32,'Lego super Heroes - Poderosos Micros: Iron man',89.99,Now(),'De 7 à 8 anos ','Lego',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (33,'Hand Spinner - Ladybug',24.99,Now(),'De 7 à 8 anos ','Novabrink',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (34,'Hand Spinner - Batman',24.99,Now(),'De 7 à 8 anos ','Novabrink',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (35,'Lançador de Dardo - Nerf Rebelle',129.99,Now(),'De 7 à 8 anos ','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (36,'Pião Beyblade',199.99,Now(),'De 9 à 10 anos ','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (37,'Lego Speed Champions - Mercedes',129.99,Now(),'De 9 à 10 anos ','Lego',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (38,'Lego Manicraft',259.99,Now(),'De 9 à 10 anos ','Lego',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (39,'Conjunto de Pista - Hot Wheels - Super lava rápido',169.99,Now(),'De 9 à 10 anos ','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (40,'Bicicleta Pincesas Disney com Cesta - Aro 16',599.99,Now(),'De 9 à 10 anos ','Bandeirante',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (41,'Picareta do Jogo - Nível Diamante',59.90,Now(),'De 9 à 10 anos ','ZR Toys',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (42,'noneca Barbie - Fashion com acessórios',129.99,Now(),'De 9 à 10 anos ','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (43,'Casa da Barbie dos sonhos',1599.99,Now(),'De 11 ou mais','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (44,'Arena Beyblade Burst - azul',119.70,Now(),'De 11 ou mais','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (45,'Carrinho Hot Wheels - Veículo Básico',9.99,Now(),'De 11 ou mais','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (46,'Mini Figura e veículo - imaginext DC Comics',49.99,Now(),'De 11 ou mais','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (47,'Boneca Barbie - Dreamtopia - Reino dos doces ',139.99,Now(),'De 11 ou mais','Mattel',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (48,'Balde de soldados - 60 peças',49.99,Now(),'De 11 ou mais','TOYNG',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (49,'Boneco Articula 30cm - Titan Hero - Hulk',89.99,Now(),'De 11 ou mais','Hasbro',1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd) VALUES (50,'Carrinho Die Cast - Forza Motorsport',19.99,Now(),'De 11 ou mais','Mattel',1);

