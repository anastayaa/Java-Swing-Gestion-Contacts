-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 24, 2018 at 02:21 PM
-- Server version: 10.1.34-MariaDB
-- PHP Version: 7.2.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `soundex_levenshtein_contacts`
--

-- --------------------------------------------------------

--
-- Table structure for table `contact`
--

CREATE TABLE `contact` (
  `idcontact` int(11) NOT NULL,
  `idtypescontact` int(11) NOT NULL,
  `nom` varchar(45) NOT NULL,
  `prenom` varchar(45) NOT NULL,
  `soundexnom` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `contact`
--

INSERT INTO `contact` (`idcontact`, `idtypescontact`, `nom`, `prenom`, `soundexnom`) VALUES
(1, 1, 'Dupont', 'Tomy', '5'),
(2, 2, 'Durant', 'Mark', '5'),
(13, 1, 'Dupond', 'smithh', 'D153'),
(14, 1, 'Rubert', 'Robin', 'R163'),
(15, 2, 'Rupert', 'Robin', 'R163');

-- --------------------------------------------------------

--
-- Table structure for table `typescontact`
--

CREATE TABLE `typescontact` (
  `idtypescontact` int(11) NOT NULL,
  `libelle` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `typescontact`
--

INSERT INTO `typescontact` (`idtypescontact`, `libelle`) VALUES
(1, 'Email'),
(2, 'Phone');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `contact`
--
ALTER TABLE `contact`
  ADD PRIMARY KEY (`idcontact`),
  ADD KEY `idtypescontact` (`idtypescontact`);

--
-- Indexes for table `typescontact`
--
ALTER TABLE `typescontact`
  ADD PRIMARY KEY (`idtypescontact`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `contact`
--
ALTER TABLE `contact`
  MODIFY `idcontact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `typescontact`
--
ALTER TABLE `typescontact`
  MODIFY `idtypescontact` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contact`
--
ALTER TABLE `contact`
  ADD CONSTRAINT `contact_ibfk_1` FOREIGN KEY (`idtypescontact`) REFERENCES `typescontact` (`idtypescontact`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
