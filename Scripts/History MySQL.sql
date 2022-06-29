DROP DATABASE IF EXISTS `cipa` ;
CREATE DATABASE IF NOT EXISTS `cipa` DEFAULT CHARACTER SET latin1 ;

CREATE table `cipa`.`instituicao`(
id INT NOT NULL AUTO_INCREMENT,
nome_da_empresa varchar (255),
vinculo varchar (150),
PRIMARY KEY(id) 
);

INSERT INTO `cipa`.`instituicao`(`nome_da_empresa`,`vinculo`)
VALUES ('IFPE','Cordenador');

CREATE TABLE `cipa`.`pessoas`(
id INT AUTO_INCREMENT,
nome varchar(150) NOT NULL,
email varchar(255) NOT NULL UNIQUE,
senha varchar(255) NOT NULL,
tipo_usuario varchar(50),
foto varchar(255),
id_inst INT,
PRIMARY KEY(id),
FOREIGN KEY (`id_inst`)	REFERENCES `cipa`.`instituicao`(`id`)
);

INSERT INTO `cipa`.`pessoas`(nome, email, tipo_usuario,senha, id_inst)
VALUES ('Jadeilson','jadeilsom.m@gmail.com','Aluno',123456789, NULL),
	('Joas','joas@gmail.com','Aluno',123456789, NULL),
    ('Andriely','andriely@gmail.com','Aluno',123456789, NULL),
    ('ricson','ricson@gmail.com','professor',123456789,1),
    ('Lavinia','lavinia@gmail.com','Aluno', 123456789,NULL),
    ('Robson','robson@gmail.com','Aluno', 123456789,NULL),
     ('Hiane','andriely@gmail.com','Aluno',123456789, NULL),
    ('Priscila','priscila@gmail.com','Aluno',123456789,NULL),
    ('Frenacievely','francievely@gmail.com','Aluno', 123456789,NULL);
    
CREATE TABLE `cipa`.`concurso`(
id INT AUTO_INCREMENT PRIMARY KEY,
data_submissao date,
data_e_hora_apuracao DATETIME,
data_criacao date
);

INSERT INTO `cipa`.`concurso`(data_submissao, data_e_hora_apuracao, data_criacao)
VALUES ('2022-05-01','2022-05-01 14:15:15.000','2022-05-01');

CREATE TABLE `cipa`.`ideias`(
id_ideia INT NOT NULL auto_increment,
id_lider INT NOT NULL,
temas_impactados varchar(50),
nome VARCHAR(100),
resumo_do_projeto varchar(700),
video_demostrativo varchar(255),
nota decimal(2),
imagem VARCHAR(255),
id_concurso INT NOT NULL,
PRIMARY KEY (id_ideia),
FOREIGN KEY (`id_concurso`) REFERENCES `cipa`.`concurso`(`id`),
FOREIGN KEY (`id_lider`) REFERENCES `cipa`.`pessoas`(`id`)
);

INSERT INTO `cipa`.`ideias`(id_lider,temas_impactados,nota, nome, id_concurso, resumo_do_projeto, imagem)
VALUES (2,'Inovação',10,'cipa',1,'O cipa (Concurso de ideias professor anjo), é uma plataforma web que tem como objeto realizar a inscrição de projetos e ideias dos alunos, e gerar uma votação para cada ideia/projeto apresentado, fazer o cadastros dos alunos e projetos,também com a banca de júri que irá avaliar e dar uma certa pontuação. Tendo como objetivo incentivar a criatividade e inovações, resoluções de problemas da nossa sociedade.','https://camo.githubusercontent.com/defe39fdbdf16ae79915be63d4b7f1ef234b078799be2e12a401a1fc035d73f0/68747470733a2f2f692e696d6775722e636f6d2f48634c4e6a7a6e2e706e67'),
	(6,'Inovação',10,'Posto de Saude virtual',1,'O posto de saúde virtual,tem como objetivo visar o uso da tecnologia.Sua aplicação irá atuar em áreas específicas visando a necessidades da saúde,criando metas e planejando ações que buscam melhorar a facilidade entre as redes municipais de saúde e os cidadãos,trazendo a facilidade digital para a população.','https://i.ibb.co/4JBj079/atendimento-Virtual.png');

CREATE TABLE `cipa`.`equipe`(
id_pessoas INT,
id_ideia INT,
PRIMARY KEY (id_pessoas, id_ideia),
FOREIGN KEY (`id_pessoas`) REFERENCES `cipa`.`pessoas` (`id`),
FOREIGN KEY (`id_ideia`) REFERENCES `cipa`.`ideias` (`id_ideia`)
);

INSERT INTO `cipa`.`equipe` (id_pessoas, id_ideia)
values 	(1,1),
		(3,1),
        (5,1),
        (7,2),
        (8,2),
        (9,2);

CREATE TABLE `cipa`.`notas_ideias`(
id_pessoas INT,
id_ideia INT,
nota DECIMAL(4,2),
PRIMARY KEY (id_pessoas, id_ideia),
FOREIGN KEY (`id_pessoas`) REFERENCES `cipa`.`pessoas` (`id`),
FOREIGN KEY (`id_ideia`) REFERENCES `cipa`.`ideias` (`id_ideia`)
);

INSERT INTO `cipa`.`notas_ideias`(id_pessoas, id_ideia, nota)
VALUES 	(1,1,10),
		(1,2,10),
		(2,1,10),
        (2,2,10),
        (3,1,10),
		(3,2,10),
		(4,1,10),
        (4,2,10),
		(5,1,10),
		(5,2,10),
		(6,1,10),
        (6,2,10);

CREATE TABLE `cipa`.`banca`(
id_pessoas INT,
id_concurso INT,
PRIMARY KEY (id_pessoas, id_concurso),
FOREIGN KEY (`id_pessoas`) REFERENCES `cipa`.`pessoas` (`id`),
FOREIGN KEY (`id_concurso`) REFERENCES `cipa`.`concurso` (`id`)
);

INSERT INTO `cipa`.`banca`(id_pessoas, id_concurso)
VALUES (4,1);

