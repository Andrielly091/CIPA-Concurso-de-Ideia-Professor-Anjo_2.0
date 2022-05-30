DROP DATABASE IF EXISTS `cipa` ;
CREATE DATABASE IF NOT EXISTS `cipa` DEFAULT CHARACTER SET latin1 ;

CREATE table `cipa`.`instituicao`(
id INT NOT NULL AUTO_INCREMENT,
nome_da_empresa varchar (255),
vinculo varchar (150),
PRIMARY KEY(id) 
);

CREATE TABLE `cipa`.`login`(
    loginId int(4) AUTO_INCREMENT,
    email varchar(50) NOT NULL,
    senha varchar(20),
    PRIMARY KEY(loginId)
);

INSERT INTO `cipa`.`instituicao`(`nome_da_empresa`,`vinculo`)
VALUES ('IFPE','Cordenador');

CREATE TABLE `cipa`.`pessoas`(
id INT AUTO_INCREMENT,
nome varchar(150) NOT NULL,
email varchar(255) NOT NULL,
tipo_usuario varchar(50),
foto varchar(255),
id_inst INT,
PRIMARY KEY(id),
FOREIGN KEY (`id_inst`)	REFERENCES `cipa`.`instituicao`(`id`)
);

INSERT INTO `cipa`.`pessoas`(nome, email, tipo_usuario,id_inst)
VALUES ('Jadeilson','jadeilsom.m@gmail.com','Aluno', NULL),
	('Joas','joas@gmail.com','Aluno', NULL),
    ('Andriely','andriely@gmail.com','Aluno', NULL),
    ('ricson','ricson@gmail.com','professor',1),
    ('Lavinia','lavinia@gmail.com','Aluno', NULL);


INSERT INTO `cipa`.`login`(email, senha)
VALUES ('jadeilsom.m@gmail.com','123456'),
	('joas@gmail.com','123456'),
    ('andriely@gmail.com','123456'),
    ('lavinia@gmail.com','123456');

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
resumo_do_projeto varchar(700),
video_demostrativo varchar(255),
nota decimal(2),
id_concurso INT NOT NULL,
PRIMARY KEY (id_ideia),
FOREIGN KEY (`id_concurso`) REFERENCES `cipa`.`concurso`(`id`),
FOREIGN KEY (`id_lider`) REFERENCES `cipa`.`pessoas`(`id`)
);

INSERT INTO `cipa`.`ideias`(id_lider,temas_impactados,nota, id_concurso)
VALUES ('2','Inovação',10, 1);

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
        (5,1);

CREATE TABLE `cipa`.`notas_ideias`(
id_pessoas INT,
id_ideia INT,
nota DECIMAL(4,2),
PRIMARY KEY (id_pessoas, id_ideia),
FOREIGN KEY (`id_pessoas`) REFERENCES `cipa`.`pessoas` (`id`),
FOREIGN KEY (`id_ideia`) REFERENCES `cipa`.`ideias` (`id_ideia`)
);

CREATE TABLE `cipa`.`banca`(
id_pessoas INT,
id_concurso INT,
PRIMARY KEY (id_pessoas, id_concurso),
FOREIGN KEY (`id_pessoas`) REFERENCES `cipa`.`pessoas` (`id`),
FOREIGN KEY (`id_concurso`) REFERENCES `cipa`.`concurso` (`id`)
);

INSERT INTO `cipa`.`banca`(id_pessoas, id_concurso)
VALUES (4,1);

