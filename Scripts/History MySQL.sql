DROP database IF EXISTS `cipa` ;
CREATE database IF NOT EXISTS `cipa` DEFAULT CHARACTER SET latin1 ;
USE `cipa` ;
--- MS SQL
CREATE table `cipa`.`instituicao`(
id int(3) NOT NULL AUTO_INCREMENT,
nome_da_empresa varchar (255),
vinculo varchar (150),
PRIMARY KEY(id) 
);

INSERT INTO `cipa`.`instituicao`(`nome_da_empresa`,`vinculo`)
VALUES ('IFPE','Cordenador');

CREATE TABLE `cipa`.`pessoas`(
nome varchar(150),
email varchar(255),
senha varchar(255),
tipo_usuario varchar(50),
foto varchar(255),
id_inst INT(3),
PRIMARY KEY(email),
FOREIGN KEY (`id_inst`)	REFERENCES `cipa`.`instituicao`(`id`)
);

INSERT INTO `cipa`.`pessoas`(nome, email, senha, tipo_usuario,id_inst)
VALUES ('Jadeilson','jadeilsom.m@gmail.com','123456','Aluno', NULL),
	('Joas','joas@gmail.com','123456','Aluno', NULL),
    ('Andriely','andriely@gmail.com','123456','Aluno', NULL),
    ('ricson','ricson@gmail.com','123456','professor',1),
    ('Lavinia','lavinia@gmail.com','123456','Aluno', NULL);

CREATE TABLE `cipa`.`ideias`(
id_ideias INT(3) NOT NULL auto_increment,
nome_do_lider varchar(150),
nomes_da_equipe varchar(255),
temas_impactados varchar(50),
resumo_do_projeto varchar(700),
video_demostrativo varchar(255),
nota decimal(2),
PRIMARY KEY(id_ideias)
);

INSERT INTO `cipa`.`ideias`(nome_do_lider,temas_impactados,nota)
VALUES ('JOAS','Inovação',10);

CREATE TABLE `cipa`.`concurso`(
data_submissao date,
data_e_hora_apuracao DATETIME,
data_criacao date,
id_ideias INT(3),
FOREIGN KEY (`id_ideias`) REFERENCES `cipa`.`ideias`(`id_ideias`)
);

INSERT INTO `cipa`.`concurso`( id_ideias)
VALUES (1);