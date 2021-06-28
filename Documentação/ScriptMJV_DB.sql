create database mjv_db;
use mjv_db;
	
	
    create table endereco(
    id_endereco integer not null auto_increment PRIMARY KEY,
    logradouro varchar (50) NOT NULL,
    numero varchar (6) NOT NULL,
    complemento varchar (30) NOT NULL,
    bairro varchar (40) NOT NULL,
    cidade varchar (50) NOT NULL,
    uf  char(2) NOT NULL,
    cep char(8) NOT NULL);
    
    
    CREATE TABLE cadastro (
	codigo integer not null auto_increment PRIMARY KEY,
	pf_pj char(1) NOT NULL,
	razao_social varchar (50) NOT NULL,
	cpf_cnpj varchar (14) NOT null, 
	telefone1 numeric (11) NOT NULL,
	telefone2 numeric (11) NULL,
	email varchar (70) NOT NULL,
	obs varchar(100),
    site_instagram varchar (50),
	fk_endereco integer,
    FOREIGN KEY (fk_endereco) REFERENCES endereco (id_endereco));
    
    
delimiter $$
create procedure novo_cad (
	pf_pj char(1),razao_social varchar (50),cpf_cnpj varchar (14),telefone1 numeric (11),telefone2 numeric (11),email varchar(70),
    obs varchar(100),site_instagram varchar (50),logradouro varchar (50),numero varchar(6),complemento varchar (30),bairro varchar(40),
    cidade varchar (50),uf char(2),cep char(8))
    begin
    insert into endereco(logradouro,numero,complemento,bairro,cidade,uf,cep) values (logradouro,numero,complemento,bairro,cidade,uf,cep);
    insert into cadastro(pf_pj,razao_social,cpf_cnpj,telefone1,telefone2,email,obs,site_instagram,fk_endereco)values(pf_pj,razao_social,cpf_cnpj,telefone1,telefone2,email,obs,site_instagram,@@identity);
    end $$
        
call novo_cad('F','Alexsandro','11111111111111',11111111111,22222222222,'fulando@email.com','Observações','fulando@instagram','Avenida algum lugar','1','Complemento','Bairro','São Paulo','SP','5547025');
