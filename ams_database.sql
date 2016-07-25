-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Apr 10, 2016 at 04:57 PM
-- Server version: 5.6.14
-- PHP Version: 5.5.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `AMS`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'pass');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE IF NOT EXISTS `booking` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `seatno` int(11) NOT NULL,
  `class` varchar(30) NOT NULL,
  `fare` int(11) NOT NULL,
  `status` enum('a','b','c') NOT NULL,
  `userid` int(11) NOT NULL,
  `flightid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=44 ;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`id`, `seatno`, `class`, `fare`, `status`, `userid`, `flightid`) VALUES
(12, 120, 'First class', 8550, 'c', 7, 15),
(13, 121, 'First class', 8550, 'a', 7, 15),
(14, 1, 'Buisness class', 5550, 'a', 7, 15),
(15, 2, 'Buisness class', 5500, 'a', 7, 15),
(16, 10, 'First class', 8650, 'c', 7, 15),
(17, 3, 'First class', 8600, 'c', 7, 15),
(18, 1, 'First class', 52555, 'a', 10, 28),
(19, 3, 'First class', 52605, 'c', 10, 28),
(20, 2, 'First class', 52605, 'c', 10, 28),
(21, 2, 'First class', 150, 'c', 7, 27),
(22, 5, 'First class', 52605, 'a', 7, 27),
(23, 3, 'First class', 150, 'c', 7, 27),
(24, 1, 'First class', 150, 'c', 7, 27),
(25, 7, 'First class', 52605, 'a', 7, 28),
(42, 2, 'First class', 0, 'c', 7, 49),
(43, 4, 'First class', 0, 'c', 7, 49);

-- --------------------------------------------------------

--
-- Table structure for table `cities`
--

CREATE TABLE IF NOT EXISTS `cities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `cities`
--

INSERT INTO `cities` (`id`, `name`) VALUES
(1, 'KGP'),
(2, 'RNC'),
(3, 'NDLS'),
(4, 'RPR'),
(5, 'MNC'),
(6, 'myown1'),
(7, 'earth'),
(8, 'jupiter'),
(9, 'YNR');

-- --------------------------------------------------------

--
-- Table structure for table `flight`
--

CREATE TABLE IF NOT EXISTS `flight` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `departure` datetime NOT NULL,
  `arrival` datetime NOT NULL,
  `planeID` int(11) NOT NULL,
  `vac_f` int(11) NOT NULL,
  `vac_b` int(11) NOT NULL,
  `vac_e` int(11) NOT NULL,
  `fare_f` int(11) NOT NULL,
  `fare_b` int(11) NOT NULL,
  `fare_e` int(11) NOT NULL,
  `basic` int(11) NOT NULL,
  `bookinglist` varchar(200) DEFAULT NULL,
  `routeID` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=57 ;

--
-- Dumping data for table `flight`
--

INSERT INTO `flight` (`id`, `name`, `departure`, `arrival`, `planeID`, `vac_f`, `vac_b`, `vac_e`, `fare_f`, `fare_b`, `fare_e`, `basic`, `bookinglist`, `routeID`) VALUES
(15, 'Interstellar', '2016-04-06 12:12:12', '2016-04-07 12:12:12', 4, 120, 122, 78, 8000, 5000, 2000, 500, ' 12 13 14 15 16 17', 9),
(16, 'Interstellar', '2016-04-07 12:12:12', '2016-04-09 09:21:21', 4, 125, 124, 78, 8000, 5000, 2000, 500, '', 10),
(27, 'KGP express', '2016-04-22 17:12:15', '2016-04-23 19:12:19', 6, 44, 65, 12, 40000, 50000, 40000, 12555, ' 21 22 23 24', 2),
(28, 'KGP express', '2016-04-24 02:12:21', '2016-04-25 04:12:25', 6, 44, 65, 12, 40000, 50000, 40000, 12555, ' 18 19 20 25', 1),
(53, 'Interstellar2', '2016-04-27 12:12:12', '2016-04-29 12:12:12', 3, 78, 20, 100, 78797, 78979, 79879, 8787, '', 2),
(54, 'Interstellar2', '2016-04-30 12:12:12', '2016-05-02 12:12:12', 3, 78, 20, 100, 78797, 78979, 79879, 8787, '', 1),
(55, 'Nukkad ', '2016-04-26 12:12:12', '2016-04-28 12:12:12', 1, 150, 121, 124, 46546, 45665, 44545, 4555, '', 2),
(56, 'Nukkad ', '2016-04-28 19:12:12', '2016-04-30 12:12:22', 1, 150, 121, 124, 46546, 45665, 44545, 4555, '', 1);

-- --------------------------------------------------------

--
-- Table structure for table `plane`
--

CREATE TABLE IF NOT EXISTS `plane` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL,
  `flightlist` varchar(200) DEFAULT NULL,
  `capacity_f` int(11) NOT NULL,
  `capacity_b` int(11) NOT NULL,
  `capacity_e` int(11) NOT NULL,
  `cost_per_km` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `plane`
--

INSERT INTO `plane` (`id`, `name`, `flightlist`, `capacity_f`, `capacity_b`, `capacity_e`, `cost_per_km`) VALUES
(1, 'a', '55 56', 150, 121, 124, 150),
(2, 'h', '', 120, 131, 111, 400),
(3, 'Spice', '53 54', 78, 20, 100, 1000),
(4, 'Ritvik', '15 16', 125, 124, 78, 1005),
(5, 'jahaz', '', 100, 100, 100, 1000),
(6, 'ks', '19 20 27 28', 45, 65, 12, 789);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE IF NOT EXISTS `route` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `flightlist` varchar(200) DEFAULT NULL,
  `start` varchar(11) NOT NULL,
  `dest` varchar(11) NOT NULL,
  `distance` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`id`, `flightlist`, `start`, `dest`, `distance`) VALUES
(1, '28 54 56', 'NDLS', 'KGP', 789),
(2, '27 53 55', 'KGP', 'NDLS', 123),
(3, '', 'YNR', 'KGP', 1900),
(4, '', 'KGP', 'YNR', 1900),
(5, '', 'RNC', 'KGP', 1200),
(6, '', 'KGP', 'RNC', 1200),
(7, '', 'myown1', 'NDLS', 1500),
(8, '', 'NDLS', 'myown1', 1500),
(9, '15', 'earth', 'jupiter', 78888),
(10, '16', 'jupiter', 'earth', 78888),
(11, '19', 'KGP', 'RPR', 780),
(12, '20', 'RPR', 'KGP', 780),
(13, '', 'myown1', 'RPR', 1000),
(14, '', 'RPR', 'myown1', 1000);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `bookinglist` varchar(200) DEFAULT NULL,
  `password` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `address` varchar(60) NOT NULL,
  `telno` varchar(30) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `name`, `bookinglist`, `password`, `email`, `address`, `telno`) VALUES
(1, 'hell', 'hel', NULL, 'o', 'o', 'o', 'o'),
(2, 'ritz302', 'dsf', NULL, 'sdf', 'fsd', 'fdsd', 'fs'),
(3, 'ritz303', 'hello', NULL, 'yo', 'sd', 'sa', '879897'),
(6, 'ritz304', 'new', NULL, 'hello', 'r@jjd.s', 'da', '879879'),
(7, 'dk', 'dk', 'null 12 13 14 15 16 17 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43', 'u', 'k', 'k', '8999'),
(9, 'ritz', 'ritz', NULL, 'r', 'r', 'r', '89789'),
(10, 'kk', 'gulab', 'null 18 19 20', 'kk', 'aslkdf', 'alsdkfj', 'aslkdfjj');
--
-- Database: `cdcol`
--

-- --------------------------------------------------------

--
-- Table structure for table `cds`
--

CREATE TABLE IF NOT EXISTS `cds` (
  `titel` varchar(200) DEFAULT NULL,
  `interpret` varchar(200) DEFAULT NULL,
  `jahr` int(11) DEFAULT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=13 ;

--
-- Dumping data for table `cds`
--

INSERT INTO `cds` (`titel`, `interpret`, `jahr`, `id`) VALUES
('Beauty', 'Ryuichi Sakamoto', 1990, 1),
('Goodbye Country (Hello Nightclub)', 'Groove Armada', 2001, 4),
('Glee', 'Bran Van 3000', 1997, 5);
--
-- Database: `phpmyadmin`
--

-- --------------------------------------------------------

--
-- Table structure for table `pma__bookmark`
--

CREATE TABLE IF NOT EXISTS `pma__bookmark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dbase` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `user` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `label` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `query` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Bookmarks' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pma__column_info`
--

CREATE TABLE IF NOT EXISTS `pma__column_info` (
  `id` int(5) unsigned NOT NULL AUTO_INCREMENT,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `column_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `comment` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `mimetype` varchar(255) CHARACTER SET utf8 NOT NULL DEFAULT '',
  `transformation` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `transformation_options` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `db_name` (`db_name`,`table_name`,`column_name`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Column information for phpMyAdmin' AUTO_INCREMENT=12 ;

--
-- Dumping data for table `pma__column_info`
--

INSERT INTO `pma__column_info` (`id`, `db_name`, `table_name`, `column_name`, `comment`, `mimetype`, `transformation`, `transformation_options`) VALUES
(7, 'AMS', 'users', 'bookinglist', '', '', '_', ''),
(6, 'AMS', 'booking', 'status', '', '', '_', ''),
(5, 'AMS', 'booking', 'class', '', '', '_', ''),
(8, 'AMS', 'plane', 'flightlist', '', '', '_', ''),
(9, 'AMS', 'route', 'flightlist', '', '', '_', ''),
(10, 'AMS', 'route', 'distance', '', '', '_', ''),
(11, 'AMS', 'flight', 'name', '', '', '_', '');

-- --------------------------------------------------------

--
-- Table structure for table `pma__designer_coords`
--

CREATE TABLE IF NOT EXISTS `pma__designer_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `v` tinyint(4) DEFAULT NULL,
  `h` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for Designer';

-- --------------------------------------------------------

--
-- Table structure for table `pma__history`
--

CREATE TABLE IF NOT EXISTS `pma__history` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `sqlquery` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`),
  KEY `username` (`username`,`db`,`table`,`timevalue`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='SQL history for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pma__pdf_pages`
--

CREATE TABLE IF NOT EXISTS `pma__pdf_pages` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `page_nr` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `page_descr` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT '',
  PRIMARY KEY (`page_nr`),
  KEY `db_name` (`db_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='PDF relation pages for phpMyAdmin' AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `pma__recent`
--

CREATE TABLE IF NOT EXISTS `pma__recent` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `tables` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Recently accessed tables';

--
-- Dumping data for table `pma__recent`
--

INSERT INTO `pma__recent` (`username`, `tables`) VALUES
('root', '[{"db":"AMS","table":"booking"},{"db":"AMS","table":"flight"},{"db":"AMS","table":"plane"},{"db":"AMS","table":"route"},{"db":"AMS","table":"users"},{"db":"AMS","table":"cities"},{"db":"AMS","table":"admin"},{"db":"hello_world","table":"first"}]');

-- --------------------------------------------------------

--
-- Table structure for table `pma__relation`
--

CREATE TABLE IF NOT EXISTS `pma__relation` (
  `master_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `master_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_db` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_table` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `foreign_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`master_db`,`master_table`,`master_field`),
  KEY `foreign_field` (`foreign_db`,`foreign_table`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Relation table';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_coords`
--

CREATE TABLE IF NOT EXISTS `pma__table_coords` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `pdf_page_number` int(11) NOT NULL DEFAULT '0',
  `x` float unsigned NOT NULL DEFAULT '0',
  `y` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`db_name`,`table_name`,`pdf_page_number`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table coordinates for phpMyAdmin PDF output';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_info`
--

CREATE TABLE IF NOT EXISTS `pma__table_info` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  `display_field` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '',
  PRIMARY KEY (`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Table information for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__table_uiprefs`
--

CREATE TABLE IF NOT EXISTS `pma__table_uiprefs` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `prefs` text COLLATE utf8_bin NOT NULL,
  `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`username`,`db_name`,`table_name`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='Tables'' UI preferences';

-- --------------------------------------------------------

--
-- Table structure for table `pma__tracking`
--

CREATE TABLE IF NOT EXISTS `pma__tracking` (
  `db_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `table_name` varchar(64) COLLATE utf8_bin NOT NULL,
  `version` int(10) unsigned NOT NULL,
  `date_created` datetime NOT NULL,
  `date_updated` datetime NOT NULL,
  `schema_snapshot` text COLLATE utf8_bin NOT NULL,
  `schema_sql` text COLLATE utf8_bin,
  `data_sql` longtext COLLATE utf8_bin,
  `tracking` set('UPDATE','REPLACE','INSERT','DELETE','TRUNCATE','CREATE DATABASE','ALTER DATABASE','DROP DATABASE','CREATE TABLE','ALTER TABLE','RENAME TABLE','DROP TABLE','CREATE INDEX','DROP INDEX','CREATE VIEW','ALTER VIEW','DROP VIEW') COLLATE utf8_bin DEFAULT NULL,
  `tracking_active` int(1) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`db_name`,`table_name`,`version`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT COMMENT='Database changes tracking for phpMyAdmin';

-- --------------------------------------------------------

--
-- Table structure for table `pma__userconfig`
--

CREATE TABLE IF NOT EXISTS `pma__userconfig` (
  `username` varchar(64) COLLATE utf8_bin NOT NULL,
  `timevalue` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `config_data` text COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='User preferences storage for phpMyAdmin';
--
-- Database: `test`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `test_multi_sets`()
    DETERMINISTIC
begin
        select user() as first_col;
        select user() as first_col, now() as second_col;
        select user() as first_col, now() as second_col, now() as third_col;
        end$$

DELIMITER ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
