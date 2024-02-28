-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 22, 2024 at 08:03 PM
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
-- Database: `dt170gprojekt`
--
CREATE DATABASE IF NOT EXISTS `dt170gprojekt` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `dt170gprojekt`;

-- --------------------------------------------------------

--
-- Table structure for table `a_la_carte_menu`
--

DROP TABLE IF EXISTS `a_la_carte_menu`;
CREATE TABLE `a_la_carte_menu` (
  `a_la_carte_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `a_la_carte_menu`
--

INSERT INTO `a_la_carte_menu` (`a_la_carte_id`, `name`, `description`, `type`, `price`) VALUES
(1, 'köttbullar', 'köttbullar och potatis med gräddsås', 'huvudrätt', 99),
(2, 'carbonara', 'Spaghetti carbonara med pancetta och parmesanost', 'huvudrätt', 119),
(3, 'lax och potatis', 'grillad lax med potatis och dillsås', 'huvudrätt', 139),
(4, 'toast skagen', 'en toast med skagenröra ', 'förrätt', 69),
(5, 'kladdkaka', 'kladdkaka på belgisk choklad med vispgrädde', 'efterrätt', 59),
(6, 'pannacotta', 'panacotta gjord på grädde och vanilj', 'efterrätt', 79);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `amount` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `name`, `telephone`, `amount`, `date`, `time`) VALUES
(1, 'anders andersson', '761363895', 4, '2024-02-20', '18:30:00'),
(2, 'jesper', '06512453', 3, '2024-02-21', '19:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `drinks`
--

DROP TABLE IF EXISTS `drinks`;
CREATE TABLE `drinks` (
  `drink_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `drinks`
--

INSERT INTO `drinks` (`drink_id`, `name`, `description`, `price`) VALUES
(1, 'Fanta', 'Läsk', 38),
(2, 'Somersby cider', '4,5 %', 75);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `name`, `role`, `adress`, `telephone`) VALUES
(1, 'Anton Antonsson', 'Kock', 'Storgatan 12\r\n54822 Sundsvall', 70516546),
(2, 'Cecilia Servitris', 'Service', 'Storgatan 23\r\n54654 Sundsvall', 7064654),
(3, 'Benjamin Bok', 'Service', 'Storgatan 3\r\n46545 Sundsvall', 70544654);

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

DROP TABLE IF EXISTS `events`;
CREATE TABLE `events` (
  `event_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date` datetime NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `lunch_menu`
--

DROP TABLE IF EXISTS `lunch_menu`;
CREATE TABLE `lunch_menu` (
  `lunch_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `lunch_menu`
--

INSERT INTO `lunch_menu` (`lunch_id`, `name`, `description`, `date`, `price`) VALUES
(1, 'köttbullar och potatis', 'köttbullar och potatis med gräddsås och lingonsylt', '2024-02-08', 99),
(2, 'fiskgratäng', 'fiskgratäng på torsk', '2024-02-09', 99),
(3, 'prujolökssoppa', 'en soppa med potatis och purjolök', '2024-02-04', 99),
(4, 'kycklingspett', 'kyckling spett med potatisgratäng', '2024-02-05', 99),
(5, 'hasselbackspotatis', 'smörgratinerad hasselbackspotatis med lövbiff', '2024-02-12', 99),
(6, 'vintergryta', 'vintergryta gjord på älgstek, serveras med ris', '2024-02-10', 99),
(7, 'tagatelli', 'af', '2024-02-20', 99),
(8, 'hej', 'dfsdf', '2024-02-21', 13),
(9, 'giu', 'fjk', '2024-02-24', 99),
(10, 'potatis', 'med kött', '2024-02-26', 99);

-- --------------------------------------------------------

--
-- Table structure for table `purchased_a_la_carte`
--

DROP TABLE IF EXISTS `purchased_a_la_carte`;
CREATE TABLE `purchased_a_la_carte` (
  `purchased_ID` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `a_la_carte_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchased_a_la_carte`
--

INSERT INTO `purchased_a_la_carte` (`purchased_ID`, `order_id`, `a_la_carte_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(33, 53, 1),
(38, 56, 1),
(39, 56, 2),
(40, 57, 1),
(41, 57, 2),
(42, 58, 1),
(43, 58, 2);

-- --------------------------------------------------------

--
-- Table structure for table `purchased_drinks`
--

DROP TABLE IF EXISTS `purchased_drinks`;
CREATE TABLE `purchased_drinks` (
  `purchased_ID` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `drink_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchased_drinks`
--

INSERT INTO `purchased_drinks` (`purchased_ID`, `order_id`, `drink_id`) VALUES
(1, 1, 1),
(2, 58, 1);

-- --------------------------------------------------------

--
-- Table structure for table `receipt`
--

DROP TABLE IF EXISTS `receipt`;
CREATE TABLE `receipt` (
  `receipt_id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_order`
--

DROP TABLE IF EXISTS `restaurant_order`;
CREATE TABLE `restaurant_order` (
  `restaurant_order_id` int(11) NOT NULL,
  `status_appetizer` varchar(255) NOT NULL,
  `status_main` varchar(255) NOT NULL,
  `status_dessert` varchar(255) NOT NULL,
  `restaurant_table_id` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `restaurant_order`
--

INSERT INTO `restaurant_order` (`restaurant_order_id`, `status_appetizer`, `status_main`, `status_dessert`, `restaurant_table_id`, `comment`) VALUES
(1, 'begun', '', '', 1, 'no cheese'),
(13, 'none', 'begun', 'none', 3, 'test'),
(14, 'none', 'begun', 'none', 3, 'test'),
(15, 'none', 'begun', 'none', 3, 'test'),
(16, 'none', 'begun', 'none', 3, 'test'),
(17, 'none', 'begun', 'none', 3, 'test'),
(22, 'none', 'begun', 'none', 3, 'test'),
(24, 'none', 'begun', 'none', 3, 'test'),
(33, 'none', 'begun', 'none', 3, 'test'),
(37, 'none', 'begun', 'none', 3, 'test'),
(43, 'none', 'begun', 'none', 3, 'test'),
(44, 'none', 'begun', 'none', 3, 'test'),
(52, 'none', 'begun', 'none', 3, 'test'),
(53, 'none', 'begun', 'none', 3, 'test'),
(56, 'none', 'begun', 'none', 3, 'test'),
(57, 'none', 'begun', 'none', 3, 'test'),
(58, 'none', 'begun', 'none', 3, 'test');

-- --------------------------------------------------------

--
-- Table structure for table `shift`
--

DROP TABLE IF EXISTS `shift`;
CREATE TABLE `shift` (
  `shift_id` int(11) NOT NULL,
  `date` date NOT NULL,
  `type` varchar(255) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `table_session`
--

DROP TABLE IF EXISTS `table_session`;
CREATE TABLE `table_session` (
  `session_id` int(11) NOT NULL,
  `table_number` int(11) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `a_la_carte_menu`
--
ALTER TABLE `a_la_carte_menu`
  ADD PRIMARY KEY (`a_la_carte_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`);

--
-- Indexes for table `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`drink_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `lunch_menu`
--
ALTER TABLE `lunch_menu`
  ADD PRIMARY KEY (`lunch_id`);

--
-- Indexes for table `purchased_a_la_carte`
--
ALTER TABLE `purchased_a_la_carte`
  ADD PRIMARY KEY (`purchased_ID`),
  ADD KEY `aLaCartePuchasedByOrder` (`order_id`),
  ADD KEY `ALaCartePurchasedByALaCarte` (`a_la_carte_id`);

--
-- Indexes for table `purchased_drinks`
--
ALTER TABLE `purchased_drinks`
  ADD PRIMARY KEY (`purchased_ID`),
  ADD KEY `DrinkPurchasedByOrderID` (`order_id`),
  ADD KEY `DrinkPurchasedByDrinkID` (`drink_id`);

--
-- Indexes for table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`receipt_id`);

--
-- Indexes for table `restaurant_order`
--
ALTER TABLE `restaurant_order`
  ADD PRIMARY KEY (`restaurant_order_id`);

--
-- Indexes for table `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`shift_id`);

--
-- Indexes for table `table_session`
--
ALTER TABLE `table_session`
  ADD PRIMARY KEY (`session_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `a_la_carte_menu`
--
ALTER TABLE `a_la_carte_menu`
  MODIFY `a_la_carte_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `drinks`
--
ALTER TABLE `drinks`
  MODIFY `drink_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `lunch_menu`
--
ALTER TABLE `lunch_menu`
  MODIFY `lunch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `purchased_a_la_carte`
--
ALTER TABLE `purchased_a_la_carte`
  MODIFY `purchased_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT for table `purchased_drinks`
--
ALTER TABLE `purchased_drinks`
  MODIFY `purchased_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `restaurant_order`
--
ALTER TABLE `restaurant_order`
  MODIFY `restaurant_order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `table_session`
--
ALTER TABLE `table_session`
  MODIFY `session_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `purchased_a_la_carte`
--
ALTER TABLE `purchased_a_la_carte`
  ADD CONSTRAINT `ALaCartePurchasedByALaCarte` FOREIGN KEY (`a_la_carte_id`) REFERENCES `a_la_carte_menu` (`a_la_carte_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aLaCartePuchasedByOrder` FOREIGN KEY (`order_id`) REFERENCES `restaurant_order` (`restaurant_order_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `purchased_drinks`
--
ALTER TABLE `purchased_drinks`
  ADD CONSTRAINT `DrinkPurchasedByDrinkID` FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`drink_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DrinkPurchasedByOrderID` FOREIGN KEY (`order_id`) REFERENCES `restaurant_order` (`restaurant_order_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
