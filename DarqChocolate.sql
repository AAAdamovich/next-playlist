-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 27, 2020 at 12:09 AM
-- Server version: 8.0.19
-- PHP Version: 7.2.24-0ubuntu0.18.04.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `darqchocolate`
--

-- --------------------------------------------------------

--
-- Table structure for table `Song`
--

CREATE TABLE `Song` (
  `title` varchar(120) DEFAULT NULL,
  `artist` varchar(100) DEFAULT NULL,
  `album` varchar(120) DEFAULT NULL,
  `genre` varchar(20) DEFAULT NULL,
  `length` time NOT NULL,
  `releaseyear` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `Song`
--

INSERT INTO `Song` (`title`, `artist`, `album`, `genre`, `length`, `releaseyear`) VALUES
('Toosie Slide', 'Drake', 'N/A', 'Trap', '00:04:07', 2020),
('Blinding Lights', 'The Weekend', 'After Hours', 'Synthwave', '00:03:22', 2019),
('The Box', 'Roddy Ricch', 'Please Excuse Me for Being Antisocial', 'Rap', '00:03:16', 2019),
('Don\'t Start Now', 'Dua Lipa', 'Don\'t Start Now', 'Pop', '00:03:03', 2019),
('Life Is Good', 'Future', 'Life Is Good', 'Trap', '00:03:58', 2020),
('Circles', 'Post Malone', 'Circles', 'Pop', '00:03:34', 2019),
('Adore You', 'Harry Styles', 'Adore You', 'Pop', '00:03:27', 2019),
('Say SO', 'Doja Cat', 'Hot Pink', 'R&B', '00:03:58', 2019),
('Intentions', 'Justin Bieber', 'Changes', 'R&B', '00:03:32', 2020),
('Everything I Wanted', 'Billie Eilish', 'When We All Fall Asleep, Where Do We Go?', 'Pop', '00:04:05', 2019),
('Cyber Sex', 'Doja Cat', 'Hot Pink', 'Pop', '00:02:46', 2020),
('Won\'t Bite', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:15', 2020),
('Rules', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:07', 2020),
('Bottom Bitch', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:18', 2020),
('Say So', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:58', 2020),
('Like That', 'Doja Cat', 'Hot Pink', 'Pop', '00:02:43', 2020),
('Talk Dirty', 'Doja Cat', 'Hot Pink', 'Pop', '00:04:01', 2020),
('Addiction', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:28', 2020),
('Streets', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:47', 2020),
('Shine', 'Doja Cat', 'Hot Pink', 'Pop', '00:02:40', 2020),
('Better Than Me', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:22', 2020),
('Juicy', 'Doja Cat', 'Hot Pink', 'Pop', '00:03:23', 2020),
('Fancy', 'Doja Cat', 'Amala', 'Pop', '00:02:59', 2020),
('Candy', 'Doja Cat', 'Amala', 'Pop', '00:03:10', 2020),
('Game', 'Doja Cat', 'Amala', 'Pop', '00:03:15', 2020);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
