-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 01/12/2018 às 05:29
-- Versão do servidor: 5.7.22
-- Versão do PHP: 7.0.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `diario_digitalbeta2`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `aluno`
--

CREATE TABLE `aluno` (
  `Id_Aluno` smallint(6) NOT NULL,
  `Id_Turma` smallint(6) DEFAULT NULL,
  `RA` varchar(30) DEFAULT NULL,
  `Nome` varchar(40) DEFAULT NULL,
  `Data_Nascimento` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `aluno`
--

INSERT INTO `aluno` (`Id_Aluno`, `Id_Turma`, `RA`, `Nome`, `Data_Nascimento`) VALUES
(435, 42, '2112', 'Shereck', '2003-03-09'),
(436, 42, '32434', 'Tia', '2004-06-09'),
(437, 42, '342432', 'socatia', '2003-03-09'),
(438, 42, 'dsfsdf', 'Naruto', '2003-03-09'),
(439, 42, 'jkhkh', 'Goku', '2003-03-09'),
(440, 42, 'd21', 'Sasuke', '2003-03-01'),
(441, 42, '2112', 'Sakura', '2003-03-09'),
(442, 42, '32434', 'Jose', '2004-06-09'),
(443, 42, '342432', 'Soraima', '2003-03-09'),
(444, 42, 'dsfsdf', 'Mariana', '2003-03-09'),
(453, 40, '10000000-1', 'Alberto', '2004-01-01'),
(454, 40, '20000000-2', 'Ana', '2004-02-02'),
(455, 40, '30000000-3', 'Bianca', '2004-03-03'),
(456, 40, '40000000-4', 'Bruna', '2004-04-04'),
(457, 40, '50000000-5', 'Carol', '2004-05-05'),
(458, 40, '60000000-6', 'Cornlio', '2004-06-06'),
(459, 40, '70000000-7', 'Dejair', '2004-07-07'),
(460, 40, '80000000-8', 'Fbio', '2004-08-08'),
(461, 40, '90000000-9', 'Goulart', '2004-09-09'),
(462, 40, '1100000-10', 'Juscelino', '2004-10-10'),
(475, 42, '1329029330', 'Fiona', '2000-11-25'),
(486, 47, '10000000-1', 'Alberto', '2004-01-01'),
(487, 47, '20000000-2', 'Ana', '2004-02-02'),
(488, 47, '30000000-3', 'Bianca', '2004-03-03'),
(489, 47, '40000000-4', 'Bruna', '2004-04-04'),
(490, 47, '50000000-5', 'Carol', '2004-05-05'),
(491, 47, '60000000-6', 'Cornélio', '2004-06-06'),
(492, 47, '70000000-7', 'Dejair', '2004-07-07'),
(493, 47, '80000000-8', 'Fábio', '2004-08-08'),
(494, 47, '90000000-9', 'Goulart', '2004-09-09'),
(495, 47, '1100000-10', 'Juscelino', '2004-10-10'),
(496, 47, '1100000-01', 'Maria', '2005-10-10'),
(497, 47, '10009373', 'Julio', '2018-11-30');

-- --------------------------------------------------------

--
-- Estrutura para tabela `avaliacao`
--

CREATE TABLE `avaliacao` (
  `Id_Avaliacao` smallint(10) NOT NULL,
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Bimestre` smallint(6) DEFAULT NULL,
  `Id_Turma` int(6) DEFAULT NULL,
  `Serie` varchar(20) DEFAULT NULL,
  `Titulo` varchar(50) DEFAULT NULL,
  `Bimestre` varchar(20) DEFAULT NULL,
  `Descricao` varchar(60) DEFAULT NULL,
  `Data_Avaliacao` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `avaliacao`
--

INSERT INTO `avaliacao` (`Id_Avaliacao`, `Id_Professor`, `Id_Bimestre`, `Id_Turma`, `Serie`, `Titulo`, `Bimestre`, `Descricao`, `Data_Avaliacao`) VALUES
(76, 165, 1, 41, 'Serie A', 'Fisica Quantica', '1º Bimestre', 'Fazer Calculos', '2018-11-30'),
(77, 165, 1, 42, '7 Serie', 'Fisica Quantica', '1º Bimestre', 'Fazer Calculos', '2018-11-30'),
(78, 165, 1, 9, '5 Serie A', 'Fisica Boladona', '1º Bimestre', 'Fazer Calculos Bolado', '2018-11-30'),
(79, 165, 1, 41, 'Serie A', 'Fisica Boladona', '1º Bimestre', 'Fazer Calculos Bolado', '2018-11-30'),
(80, 165, 1, 42, '7 Serie', 'Fisica Boladona', '1º Bimestre', 'Fazer Calculos Bolado', '2018-11-30'),
(81, 165, 1, 42, '7 Serie', 'Leis de Newton', '1º Bimestre', 'Leis de Newton', '2018-11-30'),
(82, 165, 1, 9, '5 Serie A', 'Leis de Newton', '1º Bimestre', 'Leis de Newton', '2018-11-30'),
(83, 166, 1, 40, 'agora', 'Atividade', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(84, 166, 1, 41, 'Serie A', 'Atividade', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(85, 166, 1, 42, '7 Serie', 'Atividade', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(86, 166, 1, 47, '3 Ano A', 'Atividade', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(87, 166, 1, 40, 'agora', 'Caderno', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(88, 166, 1, 41, 'Serie A', 'Caderno', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(89, 166, 1, 42, '7 Serie', 'Caderno', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(90, 166, 1, 47, '3 Ano A', 'Caderno', '1º Bimestre', 'Atividade em aula', '2018-11-28'),
(91, 166, 1, 40, 'agora', 'Trabalho Quimica Organica', '1º Bimestre', 'Atividade em aula', '2018-11-06'),
(92, 166, 1, 41, 'Serie A', 'Trabalho Quimica Organica', '1º Bimestre', 'Atividade em aula', '2018-11-06'),
(93, 166, 1, 42, '7 Serie', 'Trabalho Quimica Organica', '1º Bimestre', 'Atividade em aula', '2018-11-06'),
(94, 166, 1, 47, '3 Ano A', 'Trabalho Quimica Organica', '1º Bimestre', 'Atividade em aula', '2018-11-06'),
(95, 112, 1, 47, '3 Ano A', 'Prova Rosa dos Vento', '1º Bimestre', '', '2018-11-30'),
(96, 112, 1, 47, '3 Ano A', 'Trabalho', '1º Bimestre', '', '2018-11-30'),
(97, 112, 1, 47, '3 Ano A', 'Prova Bimestral', '1º Bimestre', '', '2018-11-30');

-- --------------------------------------------------------

--
-- Estrutura para tabela `bimestre`
--

CREATE TABLE `bimestre` (
  `Id_Bimestre` smallint(6) NOT NULL,
  `Bimestre` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `bimestre`
--

INSERT INTO `bimestre` (`Id_Bimestre`, `Bimestre`) VALUES
(1, '1º Bimestre'),
(2, '2º Bimestre'),
(3, '3º Bimestre'),
(4, '4º Bimestre');

-- --------------------------------------------------------

--
-- Estrutura para tabela `chamada`
--

CREATE TABLE `chamada` (
  `Id_Turma` smallint(6) DEFAULT NULL,
  `Id_Aluno` smallint(6) DEFAULT NULL,
  `Numero_Chamada` smallint(3) DEFAULT NULL,
  `Nome` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `chamada`
--

INSERT INTO `chamada` (`Id_Turma`, `Id_Aluno`, `Numero_Chamada`, `Nome`) VALUES
(42, 439, 1, 'Goku'),
(42, 442, 2, 'Jose'),
(42, 444, 3, 'Mariana'),
(42, 438, 4, 'Naruto'),
(42, 441, 5, 'Sakura'),
(42, 440, 6, 'Sasuke'),
(42, 435, 7, 'Shereck'),
(42, 437, 8, 'socatia'),
(42, 443, 9, 'Soraima'),
(42, 436, 10, 'Tia'),
(47, 486, 1, 'Alberto'),
(47, 487, 2, 'Ana'),
(47, 488, 3, 'Bianca'),
(47, 489, 4, 'Bruna'),
(47, 490, 5, 'Carol'),
(47, 491, 6, 'Cornélio'),
(47, 492, 7, 'Dejair'),
(47, 493, 8, 'Fábio'),
(47, 494, 9, 'Goulart'),
(47, 497, 10, 'Julio'),
(47, 495, 11, 'Juscelino'),
(47, 496, 12, 'Maria');

-- --------------------------------------------------------

--
-- Estrutura para tabela `conteudo_programatico`
--

CREATE TABLE `conteudo_programatico` (
  `Id_conteudoProgramatico` smallint(10) NOT NULL,
  `Id_Turma` smallint(6) DEFAULT NULL,
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Bimestre` smallint(6) DEFAULT NULL,
  `Conteudo_Programatico` varchar(600) DEFAULT NULL,
  `Data_Conteudo` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `conteudo_programatico`
--

INSERT INTO `conteudo_programatico` (`Id_conteudoProgramatico`, `Id_Turma`, `Id_Professor`, `Id_Bimestre`, `Conteudo_Programatico`, `Data_Conteudo`) VALUES
(8, 42, 166, 1, '', '2018-11-30'),
(9, 47, 166, 1, '', '2018-11-30'),
(10, 47, 166, 1, '', '2018-11-29');

-- --------------------------------------------------------

--
-- Estrutura para tabela `frequencia`
--

CREATE TABLE `frequencia` (
  `Id_Aluno` smallint(6) DEFAULT NULL,
  `Id_Turma` smallint(6) DEFAULT NULL,
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Bimestre` smallint(6) DEFAULT NULL,
  `Falta` char(1) DEFAULT NULL,
  `Data` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `frequencia`
--

INSERT INTO `frequencia` (`Id_Aluno`, `Id_Turma`, `Id_Professor`, `Id_Bimestre`, `Falta`, `Data`) VALUES
(439, 42, 112, 1, 'F', '2018-11-29'),
(442, 42, 112, 1, 'F', '2018-11-29'),
(444, 42, 112, 1, 'C', '2018-11-29'),
(438, 42, 112, 1, 'C', '2018-11-29'),
(441, 42, 112, 1, 'C', '2018-11-29'),
(440, 42, 112, 1, 'C', '2018-11-29'),
(435, 42, 112, 1, 'C', '2018-11-29'),
(437, 42, 112, 1, 'C', '2018-11-29'),
(443, 42, 112, 1, 'C', '2018-11-29'),
(436, 42, 112, 1, 'C', '2018-11-29'),
(439, 42, 112, 1, 'F', '2018-11-30'),
(442, 42, 112, 1, 'F', '2018-11-30'),
(444, 42, 112, 1, 'C', '2018-11-30'),
(438, 42, 112, 1, 'C', '2018-11-30'),
(441, 42, 112, 1, 'C', '2018-11-30'),
(440, 42, 112, 1, 'C', '2018-11-30'),
(435, 42, 112, 1, 'C', '2018-11-30'),
(437, 42, 112, 1, 'C', '2018-11-30'),
(443, 42, 112, 1, 'F', '2018-11-30'),
(436, 42, 112, 1, 'C', '2018-11-30'),
(439, 42, 112, 1, 'F', '2018-12-01'),
(442, 42, 112, 1, 'F', '2018-12-01'),
(444, 42, 112, 1, 'C', '2018-12-01'),
(438, 42, 112, 1, 'C', '2018-12-01'),
(441, 42, 112, 1, 'C', '2018-12-01'),
(440, 42, 112, 1, 'C', '2018-12-01'),
(435, 42, 112, 1, 'C', '2018-12-01'),
(437, 42, 112, 1, 'C', '2018-12-01'),
(443, 42, 112, 1, 'F', '2018-12-01'),
(436, 42, 112, 1, 'C', '2018-12-01'),
(439, 42, 166, 1, 'F', '2018-11-30'),
(442, 42, 166, 1, 'C', '2018-11-30'),
(444, 42, 166, 1, 'C', '2018-11-30'),
(438, 42, 166, 1, 'C', '2018-11-30'),
(441, 42, 166, 1, 'C', '2018-11-30'),
(440, 42, 166, 1, 'C', '2018-11-30'),
(435, 42, 166, 1, 'C', '2018-11-30'),
(437, 42, 166, 1, 'C', '2018-11-30'),
(443, 42, 166, 1, 'C', '2018-11-30'),
(436, 42, 166, 1, 'C', '2018-11-30'),
(486, 47, 166, 1, 'F', '2018-11-30'),
(487, 47, 166, 1, 'C', '2018-11-30'),
(488, 47, 166, 1, 'C', '2018-11-30'),
(489, 47, 166, 1, 'C', '2018-11-30'),
(490, 47, 166, 1, 'C', '2018-11-30'),
(491, 47, 166, 1, 'C', '2018-11-30'),
(492, 47, 166, 1, 'C', '2018-11-30'),
(493, 47, 166, 1, 'C', '2018-11-30'),
(494, 47, 166, 1, 'C', '2018-11-30'),
(497, 47, 166, 1, 'C', '2018-11-30'),
(495, 47, 166, 1, 'C', '2018-11-30'),
(496, 47, 166, 1, 'F', '2018-11-30'),
(486, 47, 166, 1, 'F', '2018-11-29'),
(487, 47, 166, 1, 'C', '2018-11-29'),
(488, 47, 166, 1, 'C', '2018-11-29'),
(489, 47, 166, 1, 'F', '2018-11-29'),
(490, 47, 166, 1, 'C', '2018-11-29'),
(491, 47, 166, 1, 'C', '2018-11-29'),
(492, 47, 166, 1, 'C', '2018-11-29'),
(493, 47, 166, 1, 'C', '2018-11-29'),
(494, 47, 166, 1, 'C', '2018-11-29'),
(497, 47, 166, 1, 'C', '2018-11-29'),
(495, 47, 166, 1, 'C', '2018-11-29'),
(496, 47, 166, 1, 'F', '2018-11-29');

-- --------------------------------------------------------

--
-- Estrutura para tabela `media_final`
--

CREATE TABLE `media_final` (
  `Id_Media` smallint(6) NOT NULL,
  `Id_Aluno` smallint(6) DEFAULT NULL,
  `Id_Turma` smallint(6) DEFAULT NULL,
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Bimestre` smallint(6) DEFAULT NULL,
  `Falta_Total` smallint(4) DEFAULT NULL,
  `Media` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `media_final`
--

INSERT INTO `media_final` (`Id_Media`, `Id_Aluno`, `Id_Turma`, `Id_Professor`, `Id_Bimestre`, `Falta_Total`, `Media`) VALUES
(3, 439, 42, 112, 1, 0, '7.20'),
(4, 442, 42, 112, 1, 0, '6.20'),
(5, 444, 42, 112, 1, 0, '6.40'),
(6, 438, 42, 112, 1, 0, '5.00'),
(7, 441, 42, 112, 1, 0, '6.80'),
(8, 440, 42, 112, 1, 0, '4.60'),
(9, 435, 42, 112, 1, 0, '6.20'),
(10, 437, 42, 112, 1, 0, '3.80'),
(11, 443, 42, 112, 1, 0, '7.60'),
(12, 436, 42, 112, 1, 0, '8.20'),
(13, 439, 42, 165, 1, 0, '5.00'),
(14, 442, 42, 165, 1, 0, '3.00'),
(15, 444, 42, 165, 1, 0, '5.80'),
(16, 438, 42, 165, 1, 0, '6.80'),
(17, 441, 42, 165, 1, 0, '5.40'),
(18, 440, 42, 165, 1, 0, '5.20'),
(19, 435, 42, 165, 1, 0, '6.20'),
(20, 437, 42, 165, 1, 0, '6.60'),
(21, 443, 42, 165, 1, 0, '6.40'),
(22, 436, 42, 165, 1, 0, '7.60'),
(23, 486, 47, 166, 1, 0, '6.60'),
(24, 487, 47, 166, 1, 0, '5.30'),
(25, 488, 47, 166, 1, 0, '4.50'),
(26, 489, 47, 166, 1, 0, '7.10'),
(27, 490, 47, 166, 1, 0, '7.40'),
(28, 491, 47, 166, 1, 0, '6.40'),
(29, 492, 47, 166, 1, 0, '1.80'),
(30, 493, 47, 166, 1, 0, '7.60'),
(31, 494, 47, 166, 1, 0, '8.90'),
(32, 497, 47, 166, 1, 0, '5.00'),
(33, 495, 47, 166, 1, 0, '8.00'),
(34, 496, 47, 166, 1, 0, '9.00'),
(35, 486, 47, 112, 1, 0, '3.00'),
(36, 487, 47, 112, 1, 0, '3.67'),
(37, 488, 47, 112, 1, 0, '5.00'),
(38, 489, 47, 112, 1, 0, '6.00'),
(39, 490, 47, 112, 1, 0, '7.00'),
(40, 491, 47, 112, 1, 0, '6.00'),
(41, 492, 47, 112, 1, 0, '6.33'),
(42, 493, 47, 112, 1, 0, '7.33'),
(43, 494, 47, 112, 1, 0, '7.00'),
(44, 497, 47, 112, 1, 0, '8.33'),
(45, 495, 47, 112, 1, 0, '1.00'),
(46, 496, 47, 112, 1, 0, '7.00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `nota`
--

CREATE TABLE `nota` (
  `Id_Aluno` smallint(6) DEFAULT NULL,
  `Id_Turma` smallint(6) DEFAULT NULL,
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Avaliacao` smallint(10) DEFAULT NULL,
  `Id_Bimestre` smallint(6) DEFAULT NULL,
  `Nota` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `nota`
--

INSERT INTO `nota` (`Id_Aluno`, `Id_Turma`, `Id_Professor`, `Id_Avaliacao`, `Id_Bimestre`, `Nota`) VALUES
(486, 47, 166, 86, 1, '5.00'),
(487, 47, 166, 86, 1, '5.00'),
(488, 47, 166, 86, 1, '7.00'),
(489, 47, 166, 86, 1, '8.00'),
(490, 47, 166, 86, 1, '9.00'),
(491, 47, 166, 86, 1, '4.00'),
(492, 47, 166, 86, 1, '5.00'),
(493, 47, 166, 86, 1, '6.00'),
(494, 47, 166, 86, 1, '7.00'),
(497, 47, 166, 86, 1, '7.00'),
(495, 47, 166, 86, 1, '8.00'),
(496, 47, 166, 86, 1, '9.00'),
(486, 47, 166, 90, 1, '7.00'),
(487, 47, 166, 90, 1, '5.00'),
(488, 47, 166, 90, 1, '5.00'),
(489, 47, 166, 90, 1, '5.00'),
(490, 47, 166, 90, 1, '7.00'),
(491, 47, 166, 90, 1, '7.00'),
(492, 47, 166, 90, 1, '1.00'),
(493, 47, 166, 90, 1, '8.00'),
(494, 47, 166, 90, 1, '9.00'),
(497, 47, 166, 90, 1, '6.00'),
(495, 47, 166, 90, 1, '8.00'),
(496, 47, 166, 90, 1, '9.00'),
(486, 47, 166, 94, 1, '7.00'),
(487, 47, 166, 94, 1, '6.00'),
(488, 47, 166, 94, 1, '2.00'),
(489, 47, 166, 94, 1, '10.00'),
(490, 47, 166, 94, 1, '7.00'),
(491, 47, 166, 94, 1, '7.00'),
(492, 47, 166, 94, 1, '1.00'),
(493, 47, 166, 94, 1, '8.00'),
(494, 47, 166, 94, 1, '10.00'),
(497, 47, 166, 94, 1, '2.00'),
(495, 47, 166, 94, 1, '8.00'),
(496, 47, 166, 94, 1, '9.00'),
(486, 47, 112, 95, 1, '2.00'),
(487, 47, 112, 95, 1, '3.00'),
(488, 47, 112, 95, 1, '4.00'),
(489, 47, 112, 95, 1, '5.00'),
(490, 47, 112, 95, 1, '6.00'),
(491, 47, 112, 95, 1, '7.00'),
(492, 47, 112, 95, 1, '7.00'),
(493, 47, 112, 95, 1, '8.00'),
(494, 47, 112, 95, 1, '7.00'),
(497, 47, 112, 95, 1, '9.00'),
(495, 47, 112, 95, 1, '1.00'),
(496, 47, 112, 95, 1, '7.00'),
(486, 47, 112, 96, 1, '2.00'),
(487, 47, 112, 96, 1, '3.00'),
(488, 47, 112, 96, 1, '4.00'),
(489, 47, 112, 96, 1, '5.00'),
(490, 47, 112, 96, 1, '6.00'),
(491, 47, 112, 96, 1, '7.00'),
(492, 47, 112, 96, 1, '7.00'),
(493, 47, 112, 96, 1, '8.00'),
(494, 47, 112, 96, 1, '7.00'),
(497, 47, 112, 96, 1, '9.00'),
(495, 47, 112, 96, 1, '1.00'),
(496, 47, 112, 96, 1, '7.00'),
(486, 47, 112, 97, 1, '5.00'),
(487, 47, 112, 97, 1, '5.00'),
(488, 47, 112, 97, 1, '7.00'),
(489, 47, 112, 97, 1, '8.00'),
(490, 47, 112, 97, 1, '9.00'),
(491, 47, 112, 97, 1, '4.00'),
(492, 47, 112, 97, 1, '5.00'),
(493, 47, 112, 97, 1, '6.00'),
(494, 47, 112, 97, 1, '7.00'),
(497, 47, 112, 97, 1, '7.00'),
(495, 47, 112, 97, 1, '1.00'),
(496, 47, 112, 97, 1, '7.00');

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor`
--

CREATE TABLE `professor` (
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Usuario` smallint(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `professor`
--

INSERT INTO `professor` (`Id_Professor`, `Id_Usuario`) VALUES
(112, 19),
(113, 20),
(114, 21),
(114, 22),
(165, 27),
(166, 28);

-- --------------------------------------------------------

--
-- Estrutura para tabela `professor_cadastro`
--

CREATE TABLE `professor_cadastro` (
  `Id_Professor` smallint(6) NOT NULL,
  `Nome` varchar(40) DEFAULT NULL,
  `Disciplina` varchar(40) DEFAULT NULL,
  `CPF` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `professor_cadastro`
--

INSERT INTO `professor_cadastro` (`Id_Professor`, `Nome`, `Disciplina`, `CPF`) VALUES
(112, 'Paulo', 'Geografia', '986'),
(113, 'Francisco', 'Elétrica', '1223'),
(114, 'Daniela', 'Física', '898'),
(115, 'Meire', 'Português', '615'),
(165, 'Riberto', 'Fisica', '363636'),
(166, 'Holinda', 'quimica', '12121313');

-- --------------------------------------------------------

--
-- Estrutura para tabela `secretaria`
--

CREATE TABLE `secretaria` (
  `Id_Secretaria` smallint(6) NOT NULL,
  `Login` varchar(20) DEFAULT NULL,
  `Senha` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `secretaria`
--

INSERT INTO `secretaria` (`Id_Secretaria`, `Login`, `Senha`) VALUES
(1, 'admin', 'admin'),
(2, 'teste', 'teste');

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma`
--

CREATE TABLE `turma` (
  `Id_Turma` smallint(6) NOT NULL,
  `Serie` varchar(10) DEFAULT NULL,
  `Ano` varchar(5) DEFAULT NULL,
  `Periodo` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `turma`
--

INSERT INTO `turma` (`Id_Turma`, `Serie`, `Ano`, `Periodo`) VALUES
(40, 'agora', '2000', 'agora'),
(41, 'Serie A', '2000', 'nunca'),
(42, '7 Serie', '2000', 'Manha'),
(47, '3 Ano A', '2018', 'Manha');

-- --------------------------------------------------------

--
-- Estrutura para tabela `turma_professor`
--

CREATE TABLE `turma_professor` (
  `Id_Professor` smallint(6) DEFAULT NULL,
  `Id_Turma` smallint(6) DEFAULT NULL,
  `Serie` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `turma_professor`
--

INSERT INTO `turma_professor` (`Id_Professor`, `Id_Turma`, `Serie`) VALUES
(112, 42, '7 Serie'),
(113, 42, '7 Serie'),
(114, 42, '7 Serie'),
(115, 42, '7 Serie'),
(165, 41, 'Serie A'),
(165, 42, '7 Serie'),
(166, 40, 'agora'),
(166, 41, 'Serie A'),
(166, 42, '7 Serie'),
(166, 47, '3 Ano A'),
(112, 47, '3 Ano A'),
(113, 47, '3 Ano A');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `Id_Usuario` smallint(6) NOT NULL,
  `Login` varchar(20) NOT NULL,
  `Senha` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Fazendo dump de dados para tabela `usuario`
--

INSERT INTO `usuario` (`Id_Usuario`, `Login`, `Senha`) VALUES
(19, 'PaulãoGeo', '123'),
(20, 'ChicãoEletricero', '123'),
(21, 'DanielaFisica', '123'),
(22, 'Meire@meire', '123'),
(27, 'RibertoFisica', '123'),
(28, 'Holindassa', '123');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario_aluno`
--

CREATE TABLE `usuario_aluno` (
  `Id_Usuario_Aluno` smallint(6) NOT NULL,
  `Id_Aluno` smallint(6) DEFAULT NULL,
  `Login` varchar(20) NOT NULL,
  `Senha` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Fazendo dump de dados para tabela `usuario_aluno`
--

INSERT INTO `usuario_aluno` (`Id_Usuario_Aluno`, `Id_Aluno`, `Login`, `Senha`) VALUES
(1, 439, 'Gokuzika', '123'),
(2, 487, 'Ana2', '123'),
(3, 496, 'MariaJ', '123');

--
-- Índices de tabelas apagadas
--

--
-- Índices de tabela `aluno`
--
ALTER TABLE `aluno`
  ADD PRIMARY KEY (`Id_Aluno`),
  ADD KEY `fk_Id_TurmaAlunoA` (`Id_Turma`);

--
-- Índices de tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD PRIMARY KEY (`Id_Avaliacao`),
  ADD KEY `fk_Id_ProfessorAvaliacao` (`Id_Professor`),
  ADD KEY `fk_ID_BimestreAvaliacao` (`Id_Bimestre`),
  ADD KEY `Id_Turma` (`Id_Turma`);

--
-- Índices de tabela `bimestre`
--
ALTER TABLE `bimestre`
  ADD PRIMARY KEY (`Id_Bimestre`);

--
-- Índices de tabela `chamada`
--
ALTER TABLE `chamada`
  ADD KEY `fk_Id_Turma_TurmaAluno` (`Id_Turma`);

--
-- Índices de tabela `conteudo_programatico`
--
ALTER TABLE `conteudo_programatico`
  ADD PRIMARY KEY (`Id_conteudoProgramatico`),
  ADD KEY `fk_Id_TurmaconteudoProgramatico` (`Id_Turma`),
  ADD KEY `fk_Id_BimestreconteudoProgramatico` (`Id_Bimestre`),
  ADD KEY `fk_Id_ProfessorConteudo_Programatico` (`Id_Professor`);

--
-- Índices de tabela `frequencia`
--
ALTER TABLE `frequencia`
  ADD KEY `fk_Id_Turma` (`Id_Turma`),
  ADD KEY `fk_Id_ProfessorFrequencia` (`Id_Professor`),
  ADD KEY `fk_Id_BimestreFrequencia` (`Id_Bimestre`),
  ADD KEY `fk_Id_AlunoFrequencia` (`Id_Aluno`);

--
-- Índices de tabela `media_final`
--
ALTER TABLE `media_final`
  ADD PRIMARY KEY (`Id_Media`),
  ADD KEY `fk_Id_AlunoMedia` (`Id_Aluno`),
  ADD KEY `fk_Id_TurmaMedia` (`Id_Turma`),
  ADD KEY `fk_Id_ProfessorMedia` (`Id_Professor`),
  ADD KEY `fk_Id_BimestreMedia` (`Id_Bimestre`);

--
-- Índices de tabela `nota`
--
ALTER TABLE `nota`
  ADD KEY `fk_Id_AlunoNota` (`Id_Aluno`),
  ADD KEY `fk_Id_TurmaNota` (`Id_Turma`),
  ADD KEY `fk_Id_ProfessorNota` (`Id_Professor`),
  ADD KEY `fk_Id_BimestreNota` (`Id_Bimestre`),
  ADD KEY `fk_AvaliacaoNota` (`Id_Avaliacao`);

--
-- Índices de tabela `professor`
--
ALTER TABLE `professor`
  ADD KEY `fk_Id_Usuario` (`Id_Usuario`),
  ADD KEY `fk_Id_Professor` (`Id_Professor`);

--
-- Índices de tabela `professor_cadastro`
--
ALTER TABLE `professor_cadastro`
  ADD PRIMARY KEY (`Id_Professor`);

--
-- Índices de tabela `secretaria`
--
ALTER TABLE `secretaria`
  ADD PRIMARY KEY (`Id_Secretaria`);

--
-- Índices de tabela `turma`
--
ALTER TABLE `turma`
  ADD PRIMARY KEY (`Id_Turma`);

--
-- Índices de tabela `turma_professor`
--
ALTER TABLE `turma_professor`
  ADD KEY `fk_Id_ProfessorTurmaProfessor` (`Id_Professor`),
  ADD KEY `fk_Id_TurmaProfessor` (`Id_Turma`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id_Usuario`);

--
-- Índices de tabela `usuario_aluno`
--
ALTER TABLE `usuario_aluno`
  ADD PRIMARY KEY (`Id_Usuario_Aluno`),
  ADD KEY `fk_Id_Id_AlunoUsuarioAluno` (`Id_Aluno`);

--
-- AUTO_INCREMENT de tabelas apagadas
--

--
-- AUTO_INCREMENT de tabela `aluno`
--
ALTER TABLE `aluno`
  MODIFY `Id_Aluno` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=498;

--
-- AUTO_INCREMENT de tabela `avaliacao`
--
ALTER TABLE `avaliacao`
  MODIFY `Id_Avaliacao` smallint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT de tabela `bimestre`
--
ALTER TABLE `bimestre`
  MODIFY `Id_Bimestre` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `conteudo_programatico`
--
ALTER TABLE `conteudo_programatico`
  MODIFY `Id_conteudoProgramatico` smallint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `media_final`
--
ALTER TABLE `media_final`
  MODIFY `Id_Media` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT de tabela `professor_cadastro`
--
ALTER TABLE `professor_cadastro`
  MODIFY `Id_Professor` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=167;

--
-- AUTO_INCREMENT de tabela `secretaria`
--
ALTER TABLE `secretaria`
  MODIFY `Id_Secretaria` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `turma`
--
ALTER TABLE `turma`
  MODIFY `Id_Turma` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id_Usuario` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de tabela `usuario_aluno`
--
ALTER TABLE `usuario_aluno`
  MODIFY `Id_Usuario_Aluno` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `aluno`
--
ALTER TABLE `aluno`
  ADD CONSTRAINT `fk_Id_TurmaAlunoA` FOREIGN KEY (`Id_Turma`) REFERENCES `turma` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `avaliacao`
--
ALTER TABLE `avaliacao`
  ADD CONSTRAINT `fk_ID_BimestreAvaliacao` FOREIGN KEY (`Id_Bimestre`) REFERENCES `bimestre` (`Id_Bimestre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_ProfessorAvaliacao` FOREIGN KEY (`Id_Professor`) REFERENCES `professor` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `chamada`
--
ALTER TABLE `chamada`
  ADD CONSTRAINT `fk_Id_Turma_TurmaAluno` FOREIGN KEY (`Id_Turma`) REFERENCES `turma` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `conteudo_programatico`
--
ALTER TABLE `conteudo_programatico`
  ADD CONSTRAINT `fk_Id_BimestreconteudoProgramatico` FOREIGN KEY (`Id_Bimestre`) REFERENCES `bimestre` (`Id_Bimestre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_ProfessorConteudo_Programatico` FOREIGN KEY (`Id_Professor`) REFERENCES `professor` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_ProfessorconteudoProgramatico` FOREIGN KEY (`Id_Professor`) REFERENCES `professor` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_TurmaconteudoProgramatico` FOREIGN KEY (`Id_Turma`) REFERENCES `turma_professor` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `frequencia`
--
ALTER TABLE `frequencia`
  ADD CONSTRAINT `fk_Id_AlunoFrequencia` FOREIGN KEY (`Id_Aluno`) REFERENCES `aluno` (`Id_Aluno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_BimestreFrequencia` FOREIGN KEY (`Id_Bimestre`) REFERENCES `bimestre` (`Id_Bimestre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_ProfessorFrequencia` FOREIGN KEY (`Id_Professor`) REFERENCES `professor` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_Turma` FOREIGN KEY (`Id_Turma`) REFERENCES `turma` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `media_final`
--
ALTER TABLE `media_final`
  ADD CONSTRAINT `fk_Id_AlunoMedia` FOREIGN KEY (`Id_Aluno`) REFERENCES `aluno` (`Id_Aluno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_BimestreMedia` FOREIGN KEY (`Id_Bimestre`) REFERENCES `bimestre` (`Id_Bimestre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_ProfessorMedia` FOREIGN KEY (`Id_Professor`) REFERENCES `professor` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_TurmaMedia` FOREIGN KEY (`Id_Turma`) REFERENCES `turma` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `nota`
--
ALTER TABLE `nota`
  ADD CONSTRAINT `fk_AvaliacaoNota` FOREIGN KEY (`Id_Avaliacao`) REFERENCES `avaliacao` (`Id_Avaliacao`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_AlunoNota` FOREIGN KEY (`Id_Aluno`) REFERENCES `aluno` (`Id_Aluno`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_BimestreNota` FOREIGN KEY (`Id_Bimestre`) REFERENCES `bimestre` (`Id_Bimestre`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_ProfessorNota` FOREIGN KEY (`Id_Professor`) REFERENCES `professor` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_TurmaNota` FOREIGN KEY (`Id_Turma`) REFERENCES `turma_professor` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `professor`
--
ALTER TABLE `professor`
  ADD CONSTRAINT `fk_Id_Professor` FOREIGN KEY (`Id_Professor`) REFERENCES `professor_cadastro` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_Usuario` FOREIGN KEY (`Id_Usuario`) REFERENCES `usuario` (`Id_Usuario`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `turma_professor`
--
ALTER TABLE `turma_professor`
  ADD CONSTRAINT `fk_Id_ProfessorTurmaProfessor` FOREIGN KEY (`Id_Professor`) REFERENCES `professor_cadastro` (`Id_Professor`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Id_TurmaProfessor` FOREIGN KEY (`Id_Turma`) REFERENCES `turma` (`Id_Turma`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `usuario_aluno`
--
ALTER TABLE `usuario_aluno`
  ADD CONSTRAINT `fk_Id_Id_AlunoUsuarioAluno` FOREIGN KEY (`Id_Aluno`) REFERENCES `aluno` (`Id_Aluno`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
