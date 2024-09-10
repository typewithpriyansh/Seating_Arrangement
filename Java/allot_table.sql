-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 10, 2024 at 04:45 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `priyansh_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `allot_table`
--

CREATE TABLE `allot_table` (
  `stream` varchar(50) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `divison` varchar(50) DEFAULT NULL,
  `no_of_students` int(11) DEFAULT NULL,
  `class_alloted` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `allot_table`
--

INSERT INTO `allot_table` (`stream`, `class_name`, `divison`, `no_of_students`, `class_alloted`) VALUES
('BSC IT', 'F.Y.', 'A', 60, 'Room No 1'),
('BSC IT', 'F.Y.', 'B', 60, 'Room No 1'),
('BSC IT', 'F.Y.', 'C', 60, 'Room No 2');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
