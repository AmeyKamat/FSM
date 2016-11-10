-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2016 at 08:11 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `layout_parser`
--

-- --------------------------------------------------------

--
-- Table structure for table `desk`
--

CREATE TABLE `desk` (
  `u_Id` int(11) NOT NULL,
  `location_Id` varchar(255) DEFAULT NULL,
  `desk_id` int(11) DEFAULT NULL,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `width` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `brid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `desk`
--

INSERT INTO `desk` (`u_Id`, `location_Id`, `desk_id`, `x`, `y`, `width`, `height`, `brid`) VALUES
(1, '1', 38, 10, 12, 1, 2, ''),
(2, '1', 39, 10, 14, 1, 2, ''),
(3, '1', 40, 10, 16, 1, 2, ''),
(4, '1', 10909000, 4, 19, 3, 3, ''),
(5, '1', 24, 7, 12, 1, 2, ''),
(6, '1', 25, 7, 14, 1, 2, ''),
(7, '1', 26, 7, 16, 1, 2, ''),
(8, '1', 35, 8, 12, 1, 2, ''),
(9, '1', 36, 8, 14, 1, 2, ''),
(10, '1', 37, 8, 16, 1, 2, ''),
(11, '1', 1, 1, 3, 1, 2, ''),
(12, '1', 2, 2, 3, 1, 2, ''),
(13, '1', 3, 3, 3, 1, 2, ''),
(14, '1', 4, 4, 3, 1, 2, ''),
(15, '1', 5, 5, 3, 1, 2, ''),
(16, '1', 6, 1, 6, 1, 2, ''),
(17, '1', 7, 2, 6, 1, 2, ''),
(18, '1', 8, 3, 6, 1, 2, ''),
(19, '1', 9, 4, 6, 1, 2, ''),
(20, '1', 10, 5, 6, 1, 2, ''),
(21, '1', 16, 10, 3, 1, 1, ''),
(22, '1', 18, 11, 3, 1, 1, ''),
(23, '1', 20, 12, 3, 1, 1, ''),
(24, '1', 22, 13, 3, 1, 1, ''),
(25, '1', 17, 10, 4, 1, 1, ''),
(26, '1', 19, 11, 4, 1, 1, ''),
(27, '1', 21, 12, 4, 1, 1, ''),
(28, '1', 23, 13, 4, 1, 1, ''),
(29, '1', 27, 10, 6, 1, 1, ''),
(30, '1', 28, 11, 6, 1, 1, ''),
(31, '1', 29, 12, 6, 1, 1, ''),
(32, '1', 30, 13, 6, 1, 1, ''),
(33, '1', 31, 10, 7, 1, 1, ''),
(34, '1', 32, 11, 7, 1, 1, ''),
(35, '1', 33, 12, 7, 1, 1, ''),
(36, '1', 34, 13, 7, 1, 1, ''),
(37, '1', 11, 1, 9, 1, 1, ''),
(38, '1', 12, 2, 9, 1, 1, ''),
(39, '1', 13, 3, 9, 1, 1, ''),
(40, '1', 14, 4, 9, 1, 1, ''),
(41, '1', 15, 5, 9, 1, 1, ''),
(42, '1', 41, 13, 17, 1, 1, ''),
(43, '1', 42, 14, 17, 1, 1, ''),
(44, '1', 43, 15, 17, 1, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `layout_extremes`
--

CREATE TABLE `layout_extremes` (
  `layout_id` varchar(255) NOT NULL,
  `minimum_x` int(11) DEFAULT NULL,
  `minimum_y` int(11) DEFAULT NULL,
  `maximum_x` int(11) DEFAULT NULL,
  `maximum_y` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `layout_extremes`
--

INSERT INTO `layout_extremes` (`layout_id`, `minimum_x`, `minimum_y`, `maximum_x`, `maximum_y`) VALUES
('1', 3, 1, 17, 23);

-- --------------------------------------------------------

--
-- Table structure for table `office_details`
--

CREATE TABLE `office_details` (
  `office_uid` int(11) NOT NULL,
  `branch` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `floor` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `office_details`
--

INSERT INTO `office_details` (`office_uid`, `branch`, `country`, `city`, `floor`) VALUES
(1, 'Kharadi', 'India', 'Pune', '3');

-- --------------------------------------------------------

--
-- Table structure for table `table_data`
--

CREATE TABLE `table_data` (
  `table_uid` int(11) NOT NULL,
  `layout_id` varchar(255) DEFAULT NULL,
  `table_number` int(11) DEFAULT NULL,
  `top_left_x` int(11) DEFAULT NULL,
  `top_left_y` int(11) DEFAULT NULL,
  `rows` int(11) DEFAULT NULL,
  `columns` int(11) DEFAULT NULL,
  `desk_string` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `table_data`
--

INSERT INTO `table_data` (`table_uid`, `layout_id`, `table_number`, `top_left_x`, `top_left_y`, `rows`, `columns`, `desk_string`) VALUES
(1, '1', 1, 1, 3, 1, 5, '[[1,2,3,4,5]]'),
(2, '1', 2, 1, 6, 1, 5, '[[6,7,8,9,10]]'),
(3, '1', 3, 1, 9, 1, 5, '[[11,12,13,14,15]]'),
(4, '1', 4, 4, 19, 1, 1, '[[10909000]]'),
(5, '1', 5, 7, 12, 3, 2, '[[24,25,26],[35,36,37]]'),
(6, '1', 6, 10, 3, 2, 4, '[[16,18,20,22],[17,19,21,23]]'),
(7, '1', 7, 10, 6, 2, 4, '[[27,28,29,30],[31,32,33,34]]'),
(8, '1', 8, 10, 12, 3, 1, '[[38,39,40]]'),
(9, '1', 9, 13, 17, 1, 3, '[[41,42,43]]');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_uid` int(11) NOT NULL,
  `id` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_uid`, `id`, `password`) VALUES
(1, 'mohit@gmail.com', 'mohit');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `desk`
--
ALTER TABLE `desk`
  ADD PRIMARY KEY (`u_Id`);

--
-- Indexes for table `layout_extremes`
--
ALTER TABLE `layout_extremes`
  ADD PRIMARY KEY (`layout_id`);

--
-- Indexes for table `office_details`
--
ALTER TABLE `office_details`
  ADD PRIMARY KEY (`office_uid`);

--
-- Indexes for table `table_data`
--
ALTER TABLE `table_data`
  ADD PRIMARY KEY (`table_uid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_uid`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
