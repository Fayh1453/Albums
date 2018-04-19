-- phpMyAdmin SQL Dump
-- version 4.4.15.9
-- https://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 19 Avril 2018 à 19:56
-- Version du serveur :  5.6.37
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `LucDereck_Albums`
--

-- --------------------------------------------------------

--
-- Structure de la table `Album`
--

CREATE TABLE IF NOT EXISTS `Album` (
  `numero` int(11) NOT NULL,
  `titre` varchar(255) COLLATE utf8_bin NOT NULL,
  `prix` double NOT NULL,
  `genre` varchar(255) COLLATE utf8_bin NOT NULL,
  `annee` int(11) NOT NULL,
  `maison` varchar(255) COLLATE utf8_bin NOT NULL,
  `image` varchar(255) COLLATE utf8_bin NOT NULL,
  `numeroArtiste` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `Album`
--

INSERT INTO `Album` (`numero`, `titre`, `prix`, `genre`, `annee`, `maison`, `image`, `numeroArtiste`) VALUES
(2, 'All The Way... A Decade of Song', 19.99, 'pop', 1999, 'Columbia', 'allTheWay.png', 1),
(3, 'Comment le dire', 7.99, 'Country', 2007, 'Disque GPN', 'commentLeDire.png', 2),
(4, 'Too Much Too Late', 12.99, 'Disco', 1986, 'UniDisc', 'tooMuchTooLate.png', 3),
(5, 'Coeur de pirate', 23.99, 'Pop', 2008, 'GrosseBoite', 'coeurPirateAlbum.png', 4),
(6, 'Moody Blue', 39.99, 'Rock ''n'' roll', 1977, 'RCA Records', 'moodyBlue.png', 5);

-- --------------------------------------------------------

--
-- Structure de la table `Artistes`
--

CREATE TABLE IF NOT EXISTS `Artistes` (
  `numero` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_bin NOT NULL,
  `Membre` tinyint(1) NOT NULL,
  `photo` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Contenu de la table `Artistes`
--

INSERT INTO `Artistes` (`numero`, `nom`, `Membre`, `photo`) VALUES
(1, 'Céline Dion', 1, 'celineDion.png'),
(2, 'Patrick Norman', 0, 'patickNorman.png'),
(3, 'Martin Stevens', 0, 'martinStevens.png'),
(4, 'Coeur de pirate', 1, 'coeurDePirate.png'),
(5, 'Elvis Presley', 0, 'elvisPresley.png');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Album`
--
ALTER TABLE `Album`
  ADD PRIMARY KEY (`numero`),
  ADD KEY `numeroArtiste` (`numeroArtiste`);

--
-- Index pour la table `Artistes`
--
ALTER TABLE `Artistes`
  ADD PRIMARY KEY (`numero`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Album`
--
ALTER TABLE `Album`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT pour la table `Artistes`
--
ALTER TABLE `Artistes`
  MODIFY `numero` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `Album`
--
ALTER TABLE `Album`
  ADD CONSTRAINT `album_ibfk_1` FOREIGN KEY (`numeroArtiste`) REFERENCES `Artistes` (`numero`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
