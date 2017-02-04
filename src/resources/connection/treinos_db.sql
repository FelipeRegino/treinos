-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: 01-Fev-2017 às 02:51
-- Versão do servidor: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `treinos_db`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `corredor`
--

CREATE TABLE `corredor` (
  `idCorredor` int(11) NOT NULL,
  `nome` varchar(155) NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `nivel` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `corrida`
--

CREATE TABLE `corrida` (
  `idCorrida` int(11) NOT NULL,
  `data` date NOT NULL,
  `distancia` double NOT NULL,
  `tempo` double NOT NULL,
  `dificuldade` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `treinos`
--

CREATE TABLE `treinos` (
  `idTreino` int(11) NOT NULL,
  `corredor` int(11) NOT NULL,
  `corridas` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `corredor`
--
ALTER TABLE `corredor`
  ADD PRIMARY KEY (`idCorredor`),
  ADD UNIQUE KEY `idCorredor` (`idCorredor`);

--
-- Indexes for table `corrida`
--
ALTER TABLE `corrida`
  ADD PRIMARY KEY (`idCorrida`),
  ADD UNIQUE KEY `idCorrida` (`idCorrida`);

--
-- Indexes for table `treinos`
--
ALTER TABLE `treinos`
  ADD PRIMARY KEY (`idTreino`),
  ADD UNIQUE KEY `idTreino` (`idTreino`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `corredor`
--
ALTER TABLE `corredor`
  MODIFY `idCorredor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `corrida`
--
ALTER TABLE `corrida`
  MODIFY `idCorrida` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `treinos`
--
ALTER TABLE `treinos`
  MODIFY `idTreino` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
