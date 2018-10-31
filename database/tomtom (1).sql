-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 31, 2018 at 06:34 PM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tomtom`
--

-- --------------------------------------------------------

--
-- Table structure for table `driver`
--

CREATE TABLE `driver` (
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `license_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `driver`
--

INSERT INTO `driver` (`username`, `password`, `mobile_no`, `license_id`) VALUES
('saravanan', '1234', '7904015965', '1234'),
('Gk', 'login', '1234567890\n', 'kdkdk'),
('gk', 'pppp', '9696969696', 'gkgk'),
('sarav', 'sarav', '7904015965', '9876552'),
('dine', 'dine', '7904015965', 'hdhdjdjd');

-- --------------------------------------------------------

--
-- Table structure for table `garbage`
--

CREATE TABLE `garbage` (
  `latitude` varchar(255) NOT NULL,
  `longitude` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `garbage`
--

INSERT INTO `garbage` (`latitude`, `longitude`) VALUES
('12.97001882427871', '80.03572682678964'),
('12.758250772614687', '77.36196079390936');

-- --------------------------------------------------------

--
-- Table structure for table `people`
--

CREATE TABLE `people` (
  `name` varchar(255) NOT NULL,
  `mobile_no` varchar(255) NOT NULL,
  `latitude` varchar(255) NOT NULL DEFAULT '0',
  `longitude` varchar(255) NOT NULL DEFAULT '0',
  `status` varchar(255) NOT NULL DEFAULT '0',
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `people`
--

INSERT INTO `people` (`name`, `mobile_no`, `latitude`, `longitude`, `status`, `password`) VALUES
('sara', '7904015965', '0', '0', '0', 'sara'),
('balaji', '7010205692', '0', '0', '0', '9345870898'),
('Gk', '9095151374', '0', '0', '0', 'sara'),
('gopal', '7904015965', '0', '0', '0', '1234'),
('Udhay', '9976455655', '0', '0', '0', '1234'),
('gop', '7904015965', '0', '0', '0', 'gop'),
('god', '7904015965', '0', '0', '0', 'god');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
