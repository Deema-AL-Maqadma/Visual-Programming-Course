-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 10, 2025 at 01:26 PM
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
-- Database: `library_finalproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(30) NOT NULL,
  `title` varchar(280) NOT NULL,
  `author` varchar(280) NOT NULL,
  `genre` varchar(280) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `title`, `author`, `genre`) VALUES
(2, 'Le Petit Prince', 'Antoine Exupéry', 'Poem'),
(3, 'Harry Potter and the Philosopher\'s Stone', 'Joanne Rowling', 'Novel'),
(4, 'And Then There Were None', 'Agatha Miller', 'Novel'),
(5, 'Alice\'s Adventures in Wonderland', 'Lewis Carroll', 'Novel'),
(6, 'Toys', 'Ali', 'Poem'),
(7, 'Candrilla', 'Amal', 'Story'),
(9, 'Boys', 'Ali', 'Story'),
(11, 'Sbaider Man', 'Jan', 'Story'),
(14, 'Boys', 'Ahmad', 'Story'),
(16, 'Toys', 'Ali', 'Story'),
(17, 'Girls', 'Asmaa', 'Magazine');

-- --------------------------------------------------------

--
-- Table structure for table `list_users`
--

CREATE TABLE `list_users` (
  `id` int(30) NOT NULL,
  `fullname` varchar(280) NOT NULL,
  `username` varchar(280) NOT NULL,
  `password` varchar(280) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `list_users`
--

INSERT INTO `list_users` (`id`, `fullname`, `username`, `password`) VALUES
(3, 'Ahmad', 'Ahmad', '61243c7b9a4022cb3f8dc3106767ed12'),
(6, 'Mohammed AL-Maqadma', 'Mohammed', 'd79cd06799863224b7324d969c1e2084'),
(7, 'ديمة المقادمة', 'ديمة', 'fe7791abc7241797aa983226ec4b331e'),
(8, 'Deema AL-Maqadma', 'Deema', 'e86e5be89ce865f851cd48e4583ba35a'),
(11, 'Mahmoud Ashour', 'Mahmoud', 'd47268e9db2e9aa3827bba3afb7ff94a');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(30) NOT NULL,
  `username` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(16, 'ديمة', 'fe7791abc7241797aa983226ec4b331e'),
(17, 'ديمة', 'fe7791abc7241797aa983226ec4b331e'),
(18, 'Deema', 'e86e5be89ce865f851cd48e4583ba35a'),
(19, 'Deema', 'e86e5be89ce865f851cd48e4583ba35a'),
(24, 'Mahmoud', 'd47268e9db2e9aa3827bba3afb7ff94a'),
(25, 'Mahmoud', 'd47268e9db2e9aa3827bba3afb7ff94a');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `list_users`
--
ALTER TABLE `list_users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `list_users`
--
ALTER TABLE `list_users`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
