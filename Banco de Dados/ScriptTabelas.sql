DROP DATABASE petmaster;
CREATE DATABASE petmaster;
USE petmaster;

-- Gerenciamento de filiais (

CREATE TABLE lojas (
idloja INT NOT NULL auto_increment,
nomeloja VARCHAR (50),
logradouro VARCHAR(50) NOT NULL,
cidade VARCHAR(50) NOT NULL,
bairro VARCHAR(50) NOT NULL,
uf VARCHAR(2) NOT NULL,
cep VARCHAR(9) NOT NULL,
telefone VARCHAR(15),
PRIMARY KEY (idloja)
);



CREATE TABLE produtos(
  idprod INT NOT NULL AUTO_INCREMENT,
  codigobarrasprod Varchar (30) NOT NULL,
  nomeprod Varchar (80) NOT NULL,
  valor FLOAT (10,2),
  dataCadastroprod DATE,
  descricaoprod Varchar (80) NOT NULL,
  categoriaprod Varchar (30) NOT NULL,
  quantidadeprod INT NOT NULL,
  idloja INT NOT NULL,
  FOREIGN KEY (idloja) REFERENCES lojas (idloja),
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
  idloja INT NOT NULL,
  FOREIGN KEY (idloja) REFERENCES lojas (idloja),
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
idloja INT NOT NULL,
PRIMARY KEY (clienteid, cpfcliente));

INSERT INTO clientes (nome,logradouro,rg,cpfcliente,pais,cidade,bairro,estado,uf,cep,telefone,celular,email,sexo,estadocivil,nascimento, datacadastro, statuscliente, idloja) 
VALUES ("Paulo Henrique Bezerra", "Rua Paulo Egidio Carvalho 109", "466825523", "375.197.588-85","Brasil","São Paulo", "Santa Barbara","São Paulo","SP","04858390","55268573","11981997228",
"pauloh2012sul@gmail.com","Masculino", "Solteiro",'1990-01-29',NOW(), true, 1);


INSERT INTO clientes (nome,logradouro,rg,cpfcliente,pais,cidade,bairro,estado,uf,cep,telefone,celular,email,sexo,estadocivil,nascimento, datacadastro, statuscliente, idloja) 
VALUES ("CLIENTE NAO QUER EFETUAR O CADASTRO", "RUA GENERICA", "00000000", "000.000.000-00","Brasil","São Paulo","generico", "São Paulo","SP","00000000","00000000000","00000000",
"email@generico","Masculino", "Solteiro",'1990-01-29',NOW(),true, 1);


CREATE TABLE vendas(
idvenda INT NOT NULL AUTO_INCREMENT,
cpfcliente VARCHAR(14) NOT NULL,
totalvalor FLOAT (10,2),
datavenda DATE,
quantidadeitens INT NOT NULL,
vendastatus BOOLEAN,
vendedor Varchar (30) NOT NULL,
idloja INT NOT NULL,
FOREIGN KEY (idloja) REFERENCES lojas (idloja),	
PRIMARY KEY (idvenda, cpfcliente));

CREATE TABLE itemvenda(
idvenda INT,
idprod INT NOT NULL,
quantidadeitens INT NOT NULL,
idloja INT NOT NULL,
FOREIGN KEY (idloja) REFERENCES lojas (idloja),	
FOREIGN KEY (idvenda) REFERENCES vendas (idvenda),
FOREIGN KEY (idprod) REFERENCES produtos (idprod));
  
CREATE TABLE sessao(
id INT NOT NULL AUTO_INCREMENT,
idsessao VARCHAR(30) NOT NULL,
vendedor VARCHAR(30) NOT NULL,
idloja INT NOT NULL,
PRIMARY KEY (id));

  CREATE TABLE carrinho(
  idcarrinho INT NOT NULL AUTO_INCREMENT,
  idsessao VARCHAR(30) NOT NULL,
  nomeprod Varchar (80) NOT NULL,
  codigobarrasprod Varchar (30) NOT NULL,
  vendedor VARCHAR(30) NOT NULL,
  valorprod FLOAT (10,2),
  quantidadeitens INT NOT NULL,
  PRIMARY KEY (idcarrinho));
  

INSERT INTO lojas(nomeloja,logradouro,cidade,bairro,uf,cep,telefone) VALUES ("MATRIZ", "Avenida Roque Petroni Jr 1200", "São Paulo", "Morumbi", "SP", "05818-300", null);
INSERT INTO lojas(nomeloja,logradouro,cidade,bairro,uf,cep,telefone) VALUES ("Filial", "Rua das couves 1200", "Rio de Janeiro", "Rio de Janeiro", "RJ", "24000-300", null);

-- Gerenciamento de Lojas

CREATE TABLE grupos (
idgrupo INT NOT NULL auto_increment,
nomegrupo VARCHAR (50),
idloja INT NOT NULL,
FOREIGN KEY (idloja) REFERENCES lojas (idloja),
PRIMARY KEY (idgrupo)
);

INSERT INTO grupos(nomegrupo,idloja) VALUES ("Administradores", 1);

-- Gerenciamento de Usuarios

CREATE TABLE usuarios(
  codigouser INT NOT NULL AUTO_INCREMENT,
  nomeuser Varchar (30) NOT NULL,
  username VARCHAR(50) NOT NULL,
  password VARCHAR(20),
  idgrupo INT NOT NULL,
  idloja INT NOT NULL,
  PRIMARY KEY (codigouser),
  FOREIGN KEY (idloja) REFERENCES lojas (idloja),
  FOREIGN KEY (idgrupo) REFERENCES grupos (idgrupo)
);


  
  
-- Gerenciamento de filiais )

INSERT INTO usuarios(nomeuser, username,password, idgrupo, idloja) VALUES ("Paulo Henrique Bezerra","paulo.bezerra@senac.com","123", 1, 1);
INSERT INTO usuarios(nomeuser, username,password, idgrupo, idloja) VALUES ("Lucas Medeiros","lucas.medeiros@senac.com","123", 1, 1);
INSERT INTO usuarios(nomeuser, username,password, idgrupo, idloja) VALUES ("Andre Pereira","andre.pereira@senac.com","123", 1, 1);
INSERT INTO usuarios(nomeuser, username,password, idgrupo, idloja) VALUES ("Pedro Paulo Olivira","pedro.oliveira@senac.com","123", 1, 1);
INSERT INTO usuarios(nomeuser, username,password, idgrupo, idloja) VALUES ("Aluno do terceiro semestre","visitante@senac.com","123", 1, 1);
INSERT INTO usuarios(nomeuser, username,password, idgrupo, idloja) VALUES ("Professor","professor@senac.com","123", 1, 2);



INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('1','Ração Golden Adulto Special 15KG',104.9,now(),'Ração Golden Adulto Special 15KG','Cachorro',21,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('2','Ração Golden Adulto Special 20KG',137.9,now(),'Ração Golden Adulto Special 20KG','Cachorro',43,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('3','Ração Golden Seleção Natural Cães Adultos Frango e Arroz Mini Bits 1KG',18.9,now(),'Ração Golden Seleção Natural Cães Adultos Frango e Arroz Mini Bits 1KG','Cachorro',97,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('4','Ração Golden Seleção Natural Cães Adultos Frango e Arroz Mini Bits 10,1KG',99.9,now(),'Ração Golden Seleção Natural Cães Adultos Frango e Arroz Mini Bits 10,1KG','Cachorro',46,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('5','Kit Shampoo, Colônia e Condicionador Sanol Dog',24.9,now(),'Kit Shampoo, Colônia e Condicionador Sanol Dog','Cachorro',76,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('6','Sabonete Sarnicida Matacura 80g',7.5,now(),'Sabonete Sarnicida Matacura 80g','Cachorro',49,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('7','Casinha Pinus Mokoi nº3',105,now(),'Casinha Pinus Mokoi nº3','Cachorro',70,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('8','Guia Retrátil Standard Preta Flexi',71.9,now(),'Guia Retrátil Standard Preta Flexi','Cachorro',97,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('9','Focinheira Nylon Nº 2 AMF',7.9,now(),'Focinheira Nylon Nº 2 AMF','Cachorro',40,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('10','Coleira para Cães Lisa Preta Aspen Pet',15.9,now(),'Coleira para Cães Lisa Preta Aspen Pet','Cachorro',35,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('11','Ração Golden Gatos Castrados Salmão 3KG',39.9,now(),'Ração Golden Gatos Castrados Salmão 3KG','Gato',1,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('12','Ração Golden Gatos Castrados Salmão 10,1KG',109.9,now(),'Ração Golden Gatos Castrados Salmão 10,1KG','Gato',39,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('13','Bola com Penas Western',8.9,now(),'Bola com Penas Western','Gato',63,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('14','Brinquedo para Gatos com CatNip Jambo',21.9,now(),'Brinquedo para Gatos com CatNip Jambo','Gato',10,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('15','Sabonete Sarnicida Matacura 80g',7.5,now(),'Sabonete Sarnicida Matacura 80g','Gato',80,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('16','Phisio Antiodor Limpador Auricular 100 ml Virbac',42.5,now(),'Phisio Antiodor Limpador Auricular 100 ml Virbac','Gato',24,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('17','Shampoo 500ml Gatos Sanol',11.9,now(),'Shampoo 500ml Gatos Sanol','Gato',82,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('18','Areia Higiênica Granulada Pipicat Classic 4 kg',7.9,now(),'Areia Higiênica Granulada Pipicat Classic 4 kg','Gato',20,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('19','Banheiro para Gato Cat Box Pop Azul',134.5,now(),'Banheiro para Gato Cat Box Pop Azul','Gato',84,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('20','Cama Azul Jully Bichinho Chic',88,now(),'Cama Azul Jully Bichinho Chic','Gato',74,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('21','Ração Colorbits Granules Tetra 75g',53.9,now(),'Ração Colorbits Granules Tetra 75g','Peixe',56,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('22','Ração Colorbits Granules Tetra 300g',159.9,now(),'Ração Colorbits Granules Tetra 300g','Peixe',62,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('23','Ração Colours Alcon',11.5,now(),'Ração Colours Alcon','Peixe',15,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('24','Aquecedor 110 V Vigo Ar',17.5,now(),'Aquecedor 110 V Vigo Ar','Peixe',71,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('25','Alimentador Automático para Peixes com LCD Resun',229.9,now(),'Alimentador Automático para Peixes com LCD Resun','Peixe',15,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('26','Kit Aquário para Peixe Betta Ying Yang Marina Hagen 2L',35.9,now(),'Kit Aquário para Peixe Betta Ying Yang Marina Hagen 2L','Peixe',32,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('27','Moto Bomba SB1000A Sarlobetter',69.9,now(),'Moto Bomba SB1000A Sarlobetter','Peixe',68,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('28','Bomba Submersa Hj-311 50/300Lh 127V Sun Sun',41.5,now(),'Bomba Submersa Hj-311 50/300Lh 127V Sun Sun','Peixe',70,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('29','Rede de Arame Vermelha Tudo Pet',6.9,now(),'Rede de Arame Vermelha Tudo Pet','Peixe',81,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('30','Condicionador para Aquário Prime Seachem',25.5,now(),'Condicionador para Aquário Prime Seachem','Peixe',92,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('31','Ração Nutrópica Seleção Natural Calopsitas 300g',19.9,now(),'Ração Nutrópica Seleção Natural Calopsitas 300g','Pássaro',86,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('32','Ração Nutrópica Seleção Natural Calopsitas 900g',49.9,now(),'Ração Nutrópica Seleção Natural Calopsitas 900g','Pássaro',4,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('33','Alimento para Pássaros com Prebiótico Nutripássaros 500g',4,now(),'Alimento para Pássaros com Prebiótico Nutripássaros 500g','Pássaro',3,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('34','Girassol Comum 250g Sempre Vita',2.9,now(),'Girassol Comum 250g Sempre Vita','Pássaro',39,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('35','Comedouro Suporte Kakatoo',22.9,now(),'Comedouro Suporte Kakatoo','Pássaro',59,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('36','Caixa Transporte Calopsita e Pequenas Aves Vermelho Bleckmann',81.5,now(),'Caixa Transporte Calopsita e Pequenas Aves Vermelho Bleckmann','Pássaro',67,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('37','Comedouro Chão Limpo Amarelo Bragança - 200ml',12.9,now(),'Comedouro Chão Limpo Amarelo Bragança - 200ml','Pássaro',32,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('38','Bebedouro Médio K47 - 110ml',3.5,now(),'Bebedouro Médio K47 - 110ml','Pássaro',78,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('39','Cobertura Lateral TNT TudoPet',4.9,now(),'Cobertura Lateral TNT TudoPet','Pássaro',10,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('40','Ninho Madeira Pinus Agapornis TudoPet',24.5,now(),'Ninho Madeira Pinus Agapornis TudoPet','Pássaro',21,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('41','Antipulgas Revolution 12% 60mg Cães 5,1 a 10kg',55.8,now(),'Antipulgas Revolution 12% 60mg Cães 5,1 a 10kg','Farmácia',16,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('42','Antipulgas Bravecto 250mg Cães 4,5 a 10kg',189.9,now(),'Antipulgas Bravecto 250mg Cães 4,5 a 10kg','Farmácia',93,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('43','Butox 20 ml Pulverização Intervet',5.9,now(),'Butox 20 ml Pulverização Intervet','Farmácia',63,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('44','Combo Advocate Gatos +4kg',149.9,now(),'Combo Advocate Gatos +4kg','Farmácia',41,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('45','Graminha Gatos Erva Finas Petpira - 50g',18.9,now(),'Graminha Gatos Erva Finas Petpira - 50g','Farmácia',60,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('46','Floral Gotas Traumas e Medo Animal Flower',21.9,now(),'Floral Gotas Traumas e Medo Animal Flower','Farmácia',10,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('47','Antipulgas Comfortis 560mg Cães e Gatos Elanco',52.9,now(),'Antipulgas Comfortis 560mg Cães e Gatos Elanco','Farmácia',40,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('48','Suplemento Glicopan Pet',21.5,now(),'Suplemento Glicopan Pet','Farmácia',55,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('49','Mebendazole Cães e Gatos Vetnil',4.5,now(),'Mebendazole Cães e Gatos Vetnil','Farmácia',8,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('50','Frontline Spray 250ml Antipulgas',189.5,now(),'Frontline Spray 250ml Antipulgas','Farmácia',26,1);
INSERT INTO produtos (codigobarrasprod, Nomeprod, Valor,DataCadastroProd, DescricaoProd, CategoriaProd, QuantidadeProd, idloja) VALUES ('51','Frontline Spray 250ml Antipulgas',200,now(),'Frontline Spray 250ml Antipulgas','Farmácia',93,1);