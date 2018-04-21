-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.19 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for web
CREATE DATABASE IF NOT EXISTS `web` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `web`;

-- Dumping structure for table web.alunos
CREATE TABLE IF NOT EXISTS `alunos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nomeCompleto` varchar(50) NOT NULL DEFAULT '0',
  `endereco` varchar(50) NOT NULL DEFAULT '0',
  `telefone` varchar(50) NOT NULL DEFAULT '0',
  `naturalidade` varchar(50) NOT NULL DEFAULT '0',
  `nomeMae` varchar(50) NOT NULL DEFAULT '0',
  `nomePai` varchar(50) NOT NULL DEFAULT '0',
  `cpf` varchar(50) NOT NULL DEFAULT '0',
  `rg` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.anaiscongressos
CREATE TABLE IF NOT EXISTS `anaiscongressos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL DEFAULT '0',
  `nomeCongresso` varchar(50) NOT NULL DEFAULT '0',
  `local` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.cursos
CREATE TABLE IF NOT EXISTS `cursos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL DEFAULT '0',
  `area` varchar(50) NOT NULL DEFAULT '0',
  `nivel` varchar(50) NOT NULL DEFAULT '0',
  `sigla` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.livros
CREATE TABLE IF NOT EXISTS `livros` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `isbn` varchar(50) DEFAULT '0',
  `editora` varchar(50) DEFAULT '0',
  `titulo` varchar(50) DEFAULT '0',
  `autores` varchar(50) DEFAULT '0',
  `edicao` int(11) DEFAULT '0',
  `anoPublicacao` int(11) DEFAULT '0',
  `numPaginas` int(11) DEFAULT '0',
  `areaConhecimento` varchar(50) DEFAULT '0',
  `tema` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.midiaseletronicas
CREATE TABLE IF NOT EXISTS `midiaseletronicas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) DEFAULT '0',
  `titulo` varchar(50) DEFAULT '0',
  `dataGravacao` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.rdm
CREATE TABLE IF NOT EXISTS `rdm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(50) NOT NULL DEFAULT '0',
  `senha` varchar(50) DEFAULT NULL,
  `ano` int(11) DEFAULT NULL,
  `periodo` int(11) DEFAULT NULL,
  `idAluno` int(11) DEFAULT NULL,
  `idCurso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idAluno` (`idAluno`),
  KEY `FK_rdm_cursos` (`idCurso`),
  CONSTRAINT `FK_rdm_cursos` FOREIGN KEY (`idCurso`) REFERENCES `cursos` (`id`),
  CONSTRAINT `idAluno` FOREIGN KEY (`idAluno`) REFERENCES `alunos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.revistas
CREATE TABLE IF NOT EXISTS `revistas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `editora` varchar(50) DEFAULT '0',
  `edicao` int(11) DEFAULT '0',
  `numPaginas` int(11) DEFAULT '0',
  `titulo` varchar(50) DEFAULT '0',
  `dataPublicacao` varchar(50) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.trabalhosconclusao
CREATE TABLE IF NOT EXISTS `trabalhosconclusao` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(50) NOT NULL DEFAULT '0',
  `local` varchar(50) NOT NULL DEFAULT '0',
  `titulo` varchar(50) NOT NULL DEFAULT '0',
  `autor` varchar(50) NOT NULL DEFAULT '0',
  `orientador` varchar(50) NOT NULL DEFAULT '0',
  `anoDefesa` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
-- Dumping structure for table web.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(50) CHARACTER SET big5 DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `nivelAcesso` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Data exporting was unselected.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
