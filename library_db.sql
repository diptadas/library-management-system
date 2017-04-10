-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Feb 23, 2017 at 01:40 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `library_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_info`
--

CREATE TABLE IF NOT EXISTS `book_info` (
`book_id` int(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `edition` int(20) NOT NULL,
  `category` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `publisher` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data for table `book_info`
--

INSERT INTO `book_info` (`book_id`, `name`, `edition`, `category`, `author`, `publisher`, `quantity`) VALUES
(1, 'Data Structure', 3, 'Computer Science', 'saimon', 'Shaumes', 10),
(2, 'Algorithm', 2, 'Computer Science', 'sahani', 'xyz', 9),
(3, 'Algorithm', 7, 'Computer Science', 'corman', 'xyz', 18),
(4, 'Data Structure', 7, 'Computer Science', 'saimon', 'Shaumes', 14),
(5, 'Computer Networks', 7, 'Computer Science', 'Mir Saki', 'Batman', 12),
(6, 'VLSI', 7, 'Electronics', 'Linda', 'Linda', 15);

-- --------------------------------------------------------

--
-- Table structure for table `issue_info`
--

CREATE TABLE IF NOT EXISTS `issue_info` (
`issue_id` int(100) NOT NULL,
  `student_id` int(100) NOT NULL,
  `book_id` int(100) NOT NULL,
  `date_issue` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `date_return` datetime DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `issue_info`
--

INSERT INTO `issue_info` (`issue_id`, `student_id`, `book_id`, `date_issue`, `date_return`) VALUES
(1, 1104051, 1, '2017-02-21 19:30:23', '2017-02-21 19:33:20'),
(2, 1104051, 2, '2017-02-21 20:25:13', '2017-02-21 22:24:17'),
(3, 1104051, 3, '2017-02-21 20:28:19', '2017-02-21 22:28:25'),
(8, 1104051, 6, '2017-02-21 20:53:25', NULL),
(9, 1104051, 1, '2017-02-21 20:55:28', NULL),
(10, 1104051, 4, '2017-02-21 20:59:21', NULL),
(11, 1104051, 2, '2017-02-23 01:20:51', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE IF NOT EXISTS `librarian` (
  `user_id` int(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `librarian`
--

INSERT INTO `librarian` (`user_id`, `name`, `password`, `email`) VALUES
(101, 'Admin', 'admin', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `student_id` int(100) NOT NULL,
  `name` varchar(200) NOT NULL,
  `department` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`student_id`, `name`, `department`, `password`, `email`) VALUES
(1004005, 'Imtiaz', 'CSE', '12345', 'imtiaz@gmail.com'),
(1104051, 'Dipta', 'CSE', '12345', 'dipta@gmail.com'),
(1104084, 'Jayed', 'CSE', '12345', 'jayed@gmail.com'),
(1104103, 'Simanto', 'CSE', '12345', 'simanto@gmail.com'),
(1104118, 'Pantho', 'CSE', '12345', 'pantho@gmail.com');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_info`
--
ALTER TABLE `book_info`
 ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `issue_info`
--
ALTER TABLE `issue_info`
 ADD PRIMARY KEY (`issue_id`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
 ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
 ADD PRIMARY KEY (`student_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_info`
--
ALTER TABLE `book_info`
MODIFY `book_id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `issue_info`
--
ALTER TABLE `issue_info`
MODIFY `issue_id` int(100) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
