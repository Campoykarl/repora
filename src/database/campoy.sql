-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 21, 2025 at 05:48 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `campoy`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_logs`
--

CREATE TABLE `tbl_logs` (
  `log_id` int(11) NOT NULL,
  `log_uid` int(11) NOT NULL,
  `log_action` varchar(255) NOT NULL,
  `log_timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_logs`
--

INSERT INTO `tbl_logs` (`log_id`, `log_uid`, `log_action`, `log_timestamp`) VALUES
(1, 3, 'User Login: test', '2025-04-18 16:48:37'),
(2, 3, 'User Login: test', '2025-04-18 16:50:24'),
(3, 3, 'User Login: test', '2025-04-18 16:51:37'),
(4, 3, 'User Login: test', '2025-04-18 16:57:21'),
(5, 3, 'Updated a user: test', '2025-04-18 16:57:58'),
(6, 3, 'Updated a user: test2', '2025-04-18 16:58:27'),
(7, 3, 'User Login: test', '2025-04-18 17:00:25'),
(8, 3, 'Create a user: test3', '2025-04-18 17:01:03'),
(9, 3, 'User Login: test', '2025-04-27 02:23:13'),
(10, 3, 'User Login: test', '2025-04-27 02:34:08'),
(11, 3, 'User Login: test', '2025-04-27 02:44:28'),
(12, 3, 'Created a user: NOYATHEGREATE', '2025-04-27 02:48:04'),
(13, 3, 'Updated a user: NOYATHEGREATES', '2025-04-27 02:50:36');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(11) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_phone` varchar(50) NOT NULL,
  `u_address` varchar(50) NOT NULL,
  `u_pass` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_image` varchar(255) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `question` varchar(255) NOT NULL,
  `answer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_username`, `u_fname`, `u_lname`, `u_phone`, `u_address`, `u_pass`, `u_type`, `u_image`, `u_status`, `question`, `answer`) VALUES
(3, 'test', 'test', 'test', '1234567890', 'test', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=', 'Admin', 'src/userImages/schedule_5582186 (1).png', 'Active', '', ''),
(4, 'test2', 'test2', 'test2', '1234567890', 'test2', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=', 'User', '', 'Active', '', ''),
(5, 'test3', 'test3', 'test3', '1234567890', 'test3', 'k36NX7tIvUlJU2zWW401xCa4DS+DDFwwjizexCKuIkQ=', 'User', '', 'Active', '', ''),
(6, 'Campoy', 'Karl', 'Campoy', '1234567890', 'Ward 2', 'DRMq8/pzj2GubAGvMUBmNDWzx7fpCVfUbXh+p7//Bi0=', 'User', '', 'Active', '', ''),
(12, 'NOYATHEGREATES', 'John Lloyd', 'Noyas', '12345678901', 'Lowe Calajo-an Minglanilla Cebu', '0nxbLbfcOSoM/rGLl4LzRwnR3qe9uN1yCfbUxzh8eRA=', 'User', 'src/userImages/cam5.PNG', 'Active', '', ''),
(13, 'Lion', 'Siba', 'King', '02315647892', 'secret', 'b+wqlgHVs1gclPIVD8B/o9bkWAgHlCg1S4aOQSt25rs=', 'User', '', 'Active', 'kinsa ko?', 'yes');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `log_uid` (`log_uid`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_logs`
--
ALTER TABLE `tbl_logs`
  ADD CONSTRAINT `tbl_logs_ibfk_1` FOREIGN KEY (`log_uid`) REFERENCES `tbl_user` (`u_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
