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
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `sr_no` int(11) NOT NULL,
  `stream` varchar(50) DEFAULT NULL,
  `class_name` varchar(50) DEFAULT NULL,
  `divison` varchar(50) DEFAULT NULL,
  `no_of_students` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`sr_no`, `stream`, `class_name`, `divison`, `no_of_students`) VALUES
(1, 'BSC IT', 'F.Y.', 'A', 60),
(2, 'BSC IT', 'F.Y.', 'B', 60),
(3, 'BSC IT', 'F.Y.', 'C', 60),
(4, 'BSC IT', 'S.Y.', 'A', 60),
(5, 'BSC IT', 'S.Y.', 'B', 60),
(6, 'BSC IT', 'S.Y.', 'C', 60),
(7, 'BSC IT', 'T.Y.', 'A', 60),
(8, 'BSC IT', 'T.Y.', 'B', 60),
(9, 'BSC IT', 'T.Y.', 'C', 60),
(10, 'B.A.', 'F.Y.', 'A', 60),
(11, 'B.A.', 'F.Y.', 'B', 60),
(12, 'B.A.', 'F.Y.', 'C', 60),
(13, 'B.A.', 'S.Y.', 'A', 60),
(14, 'B.A.', 'S.Y.', 'B', 60),
(15, 'B.A.', 'S.Y.', 'C', 60),
(16, 'B.A.', 'T.Y.', 'A', 60),
(17, 'B.A.', 'T.Y.', 'B', 60),
(18, 'B.A.', 'T.Y.', 'C', 60),
(19, 'BMM.', 'F.Y.', 'A', 60),
(20, 'BMM.', 'F.Y.', 'B', 60),
(21, 'BMM.', 'F.Y.', 'C', 60),
(22, 'BMM.', 'S.Y.', 'A', 60),
(23, 'BMM.', 'S.Y.', 'B', 60),
(24, 'BMM.', 'S.Y.', 'C', 60),
(25, 'BMM.', 'T.Y.', 'A', 60),
(26, 'BMM.', 'T.Y.', 'B', 60),
(27, 'BMM.', 'T.Y.', 'C', 60);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`sr_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `sr_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
