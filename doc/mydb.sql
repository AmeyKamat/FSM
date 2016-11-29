-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 22, 2016 at 10:54 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.5.37

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `id` int(11) NOT NULL,
  `country_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`id`, `country_id`, `name`) VALUES
(1, 1, 'Pune'),
(2, 1, 'Noida');

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`id`, `name`) VALUES
(1, 'India'),
(2, 'UK');

-- --------------------------------------------------------

--
-- Table structure for table `desk`
--

CREATE TABLE `desk` (
  `id` int(11) NOT NULL,
  `desk_code` varchar(255) NOT NULL,
  `table_col` int(11) NOT NULL,
  `table_row` int(11) NOT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `table_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `desk`
--

INSERT INTO `desk` (`id`, `desk_code`, `table_col`, `table_row`, `employee_id`, `table_id`) VALUES
(1, '7', 2, 0, 1, 1),
(2, '9', 1, 0, NULL, 1),
(3, '8', 0, 0, NULL, 1),
(4, '6', 3, 0, NULL, 1),
(5, '5', 4, 0, NULL, 1),
(6, '13', 1, 0, NULL, 2),
(7, '15', 0, 1, NULL, 2),
(8, '14', 2, 0, NULL, 2),
(9, '17', 2, 1, NULL, 2),
(10, '12', 0, 0, NULL, 2),
(11, '16', 1, 1, NULL, 2),
(12, '45', 0, 1, NULL, 3),
(13, '28', 0, 0, NULL, 3),
(14, '47', 0, 2, NULL, 3),
(15, '69', 1, 2, NULL, 3),
(16, '88', 1, 1, NULL, 3),
(17, '45', 1, 0, NULL, 3),
(18, '1', 0, 0, NULL, 4),
(19, '2', 1, 0, NULL, 4),
(20, '3', 2, 0, NULL, 4),
(21, '4', 3, 0, NULL, 4),
(22, '62', 1, 3, NULL, 5),
(23, '67', 1, 1, NULL, 5),
(24, '89', 1, 0, NULL, 5),
(25, '99', 0, 1, NULL, 5),
(26, '67', 0, 2, NULL, 5),
(27, '61', 0, 3, NULL, 5),
(28, '98', 0, 0, NULL, 5),
(29, '12', 0, 0, NULL, 6),
(30, '13', 1, 0, NULL, 6),
(31, '14', 2, 0, NULL, 6),
(32, '15', 0, 1, NULL, 6),
(33, '16', 1, 1, NULL, 6),
(34, '17', 2, 1, NULL, 6),
(35, '28', 0, 0, NULL, 7),
(36, '45', 1, 0, NULL, 7),
(37, '45', 0, 1, NULL, 7),
(38, '88', 1, 1, NULL, 7),
(39, '47', 0, 2, NULL, 7),
(40, '69', 1, 2, NULL, 7),
(41, '8', 0, 0, NULL, 8),
(42, '9', 1, 0, NULL, 8),
(43, '7', 2, 0, NULL, 8),
(44, '6', 3, 0, NULL, 8),
(45, '5', 4, 0, NULL, 8),
(46, '98', 0, 0, NULL, 9),
(47, '89', 1, 0, NULL, 9),
(48, '99', 0, 1, NULL, 9),
(49, '67', 1, 1, NULL, 9),
(50, '67', 0, 2, NULL, 9),
(51, '61', 0, 3, NULL, 9),
(52, '62', 1, 3, NULL, 9),
(53, '1', 0, 0, NULL, 10),
(54, '2', 1, 0, NULL, 10),
(55, '3', 2, 0, NULL, 10),
(56, '4', 3, 0, NULL, 10);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `brid` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `group_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `brid`, `name`, `group_id`) VALUES
(1, 'g0102120120', 'JAIMINI', 1);

-- --------------------------------------------------------

--
-- Table structure for table `floor`
--

CREATE TABLE `floor` (
  `id` int(11) NOT NULL,
  `location_id` int(11) NOT NULL,
  `floor_code` varchar(45) NOT NULL,
  `min_x` int(11) NOT NULL,
  `min_y` int(11) NOT NULL,
  `max_x` int(11) NOT NULL,
  `max_y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `floor`
--

INSERT INTO `floor` (`id`, `location_id`, `floor_code`, `min_x`, `min_y`, `max_x`, `max_y`) VALUES
(4, 1, '4', 3, 1, 17, 23),
(5, 1, '4', 3, 1, 17, 23);

-- --------------------------------------------------------

--
-- Table structure for table `group_s`
--

CREATE TABLE `group_s` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `parent_group_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `group_s`
--

INSERT INTO `group_s` (`id`, `name`, `parent_group_id`) VALUES
(1, 'CCD', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `location`
--

CREATE TABLE `location` (
  `id` int(11) NOT NULL,
  `city_id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `location_code` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `location`
--

INSERT INTO `location` (`id`, `city_id`, `name`, `location_code`) VALUES
(1, 1, 'Kharadi', 'P3'),
(2, 1, 'Hinjewadi', 'P2'),
(3, 1, 'Yerwada', 'P1');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `role_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `worktable`
--

CREATE TABLE `worktable` (
  `id` int(11) NOT NULL,
  `length` int(11) NOT NULL,
  `top_left_x` int(11) NOT NULL,
  `top_left_y` int(11) NOT NULL,
  `width` int(11) NOT NULL,
  `floor_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `worktable`
--

INSERT INTO `worktable` (`id`, `length`, `top_left_x`, `top_left_y`, `width`, `floor_id`) VALUES
(1, 5, 1, 6, 1, 4),
(2, 3, 13, 3, 2, 4),
(3, 3, 14, 9, 2, 4),
(4, 4, 1, 3, 1, 4),
(5, 4, 10, 7, 2, 4),
(6, 3, 13, 3, 1, 5),
(7, 2, 14, 9, 1, 5),
(8, 5, 1, 6, 1, 5),
(9, 2, 10, 7, 1, 5),
(10, 4, 1, 3, 1, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_city_country_idx` (`country_id`),
  ADD KEY `FK1F916B75D1D1E` (`country_id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `desk`
--
ALTER TABLE `desk`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1FF699D00F5456` (`employee_id`),
  ADD KEY `FK1FF6997AA08B1E` (`table_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `brid_UNIQUE` (`brid`),
  ADD KEY `fk_employee_group1_idx` (`group_id`);

--
-- Indexes for table `floor`
--
ALTER TABLE `floor`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_floor_location1_idx` (`location_id`),
  ADD KEY `FK3FE2BECE4ABE2F6` (`location_id`);

--
-- Indexes for table `group_s`
--
ALTER TABLE `group_s`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_group_group1_idx` (`parent_group_id`);

--
-- Indexes for table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_location_city1_idx` (`city_id`),
  ADD KEY `FK9FF58FB566030D36` (`city_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK27E3CB894AAD56` (`role_id`),
  ADD KEY `FK27E3CBD00F5456` (`employee_id`);

--
-- Indexes for table `worktable`
--
ALTER TABLE `worktable`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKE837473D27D3BA5E` (`floor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `city`
--
ALTER TABLE `city`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `desk`
--
ALTER TABLE `desk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `floor`
--
ALTER TABLE `floor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `group_s`
--
ALTER TABLE `group_s`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `location`
--
ALTER TABLE `location`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `worktable`
--
ALTER TABLE `worktable`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `city`
--
ALTER TABLE `city`
  ADD CONSTRAINT `FK1F916B75D1D1E` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`),
  ADD CONSTRAINT `fk_city_country` FOREIGN KEY (`country_id`) REFERENCES `country` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `desk`
--
ALTER TABLE `desk`
  ADD CONSTRAINT `FK1FF6997AA08B1E` FOREIGN KEY (`table_id`) REFERENCES `worktable` (`id`),
  ADD CONSTRAINT `FK1FF699D00F5456` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_employee_group1` FOREIGN KEY (`group_id`) REFERENCES `group_s` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `floor`
--
ALTER TABLE `floor`
  ADD CONSTRAINT `FK3FE2BECE4ABE2F6` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  ADD CONSTRAINT `fk_floor_location1` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `group_s`
--
ALTER TABLE `group_s`
  ADD CONSTRAINT `fk_group_group1` FOREIGN KEY (`parent_group_id`) REFERENCES `group_s` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `location`
--
ALTER TABLE `location`
  ADD CONSTRAINT `FK9FF58FB566030D36` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`),
  ADD CONSTRAINT `fk_location_city1` FOREIGN KEY (`city_id`) REFERENCES `city` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK27E3CB894AAD56` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `FK27E3CBD00F5456` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `worktable`
--
ALTER TABLE `worktable`
  ADD CONSTRAINT `FKE837473D27D3BA5E` FOREIGN KEY (`floor_id`) REFERENCES `floor` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
