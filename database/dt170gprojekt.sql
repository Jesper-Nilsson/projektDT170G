-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Värd: 127.0.0.1
-- Tid vid skapande: 03 mars 2024 kl 20:54
-- Serverversion: 10.4.32-MariaDB
-- PHP-version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Databas: `dt170gprojekt`
--

-- --------------------------------------------------------

--
-- Tabellstruktur `a_la_carte_menu`
--

CREATE TABLE `a_la_carte_menu` (
  `a_la_carte_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `a_la_carte_menu`
--

INSERT INTO `a_la_carte_menu` (`a_la_carte_id`, `name`, `description`, `type`, `price`) VALUES
(1, 'köttbullar', 'köttbullar och potatis med gräddsås', 'huvudrätt', 99),
(2, 'carbonara', 'Spaghetti carbonara med pancetta och parmesanost', 'huvudrätt', 119),
(3, 'lax och potatis', 'grillad lax med potatis och dillsås', 'huvudrätt', 139),
(4, 'toast skagen', 'en toast med skagenröra ', 'förrätt', 69),
(5, 'kladdkaka', 'EN TOAST', 'efterrätt', 59),
(7, 'testmat', 'test', 'huvudrätt', 99);

-- --------------------------------------------------------

--
-- Tabellstruktur `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `telephone` varchar(12) NOT NULL,
  `amount` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `booking`
--

INSERT INTO `booking` (`booking_id`, `name`, `telephone`, `amount`, `date`, `time`) VALUES
(1, 'anders andersson', '761363895', 4, '2024-02-20', '18:30:00'),
(2, 'jesper', '06512453', 3, '2024-02-21', '19:30:00');

-- --------------------------------------------------------

--
-- Tabellstruktur `drinks`
--

CREATE TABLE `drinks` (
  `drink_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `drinks`
--

INSERT INTO `drinks` (`drink_id`, `name`, `description`, `price`) VALUES
(1, 'Fanta', 'EN TOAST', 38),
(2, 'Somersby cider', '4,5 %', 75),
(3, 'vatten', 'glas vatten', 0),
(4, 'vatten', 'glas vatten', 0),
(5, 'vatten', 'glas vatten', 0),
(6, 'vatten', 'glas vatten', 0),
(7, 'vatten', 'glas vatten', 0),
(8, 'vatten', 'glas vatten', 0),
(9, 'vatten', 'glas vatten', 0),
(10, 'vatten', 'glas vatten', 19),
(11, 'vatten', 'glas vatten', 19),
(12, 'vatten', 'glas vatten', 19);

-- --------------------------------------------------------

--
-- Tabellstruktur `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `adress` varchar(255) NOT NULL,
  `telephone` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `employee`
--

INSERT INTO `employee` (`employee_id`, `name`, `role`, `adress`, `telephone`) VALUES
(1, 'Anton Antonsson', 'Kock', 'Storgatan 12\r\n54822 Sundsvall', 70516546),
(2, 'Cecilia Servitris', 'Service', 'Storgatan 23\r\n54654 Sundsvall', 7064654),
(3, 'Benjamin Bok', 'Service', 'Storgatan 3\r\n46545 Sundsvall', 70544654);

-- --------------------------------------------------------

--
-- Tabellstruktur `events`
--

CREATE TABLE `events` (
  `event_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `price` int(11) NOT NULL,
  `description` varchar(255) NOT NULL,
  `image_url` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `events`
--

INSERT INTO `events` (`event_id`, `name`, `date`, `time`, `price`, `description`, `image_url`) VALUES
(1, 'vinprov', '2024-02-29', '20:51:52', 299, 'prova vin', '/path/');

-- --------------------------------------------------------

--
-- Tabellstruktur `lunch_menu`
--

CREATE TABLE `lunch_menu` (
  `lunch_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `lunch_menu`
--

INSERT INTO `lunch_menu` (`lunch_id`, `name`, `description`, `date`, `price`) VALUES
(1, 'köttbullar och potatis', 'köttbullar och potatis med gräddsås och lingonsylt', '2024-02-08', 99),
(2, 'fiskgratäng', 'fiskgratäng på torsk', '2024-02-09', 99),
(3, 'prujolökssoppa', 'en soppa med potatis och purjolök', '2024-02-04', 99),
(5, 'hasselbackspotatis', 'smörgratinerad hasselbackspotatis med lövbiff', '2024-02-12', 99),
(6, 'vintergryta', 'vintergryta gjord på älgstek, serveras med ris', '2024-02-10', 99),
(7, 'tagatelli', 'af', '2024-02-20', 99),
(8, 'hej', 'dfsdf', '2024-02-21', 13),
(9, 'giu', 'fjk', '2024-02-24', 99),
(10, 'potatis', 'med kött', '2024-02-26', 99),
(11, 'glass', 'glass', '2024-02-22', 75),
(12, 'kaka', 'kaka', '2024-02-28', 15),
(15, 'mat', 'mat', '2024-02-29', 110);

-- --------------------------------------------------------

--
-- Tabellstruktur `purchased_a_la_carte`
--

CREATE TABLE `purchased_a_la_carte` (
  `purchased_ID` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `a_la_carte_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur `purchased_drinks`
--

CREATE TABLE `purchased_drinks` (
  `purchased_ID` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `drink_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur `receipt`
--

CREATE TABLE `receipt` (
  `receipt_id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur `restaurant_order`
--

CREATE TABLE `restaurant_order` (
  `restaurant_order_id` int(11) NOT NULL,
  `status_appetizer` varchar(255) NOT NULL,
  `status_main` varchar(255) NOT NULL,
  `status_dessert` varchar(255) NOT NULL,
  `restaurant_table_id` int(11) NOT NULL,
  `comment` varchar(255) NOT NULL,
  `order_status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Tabellstruktur `shift`
--

CREATE TABLE `shift` (
  `shift_id` int(11) NOT NULL,
  `date` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `employee_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `shift`
--

INSERT INTO `shift` (`shift_id`, `date`, `type`, `employee_id`) VALUES
(1, '2024-03-01', 'kväll', 1),
(2, '2024-03-02', 'kväll', 2),
(3, '2024-03-01', 'morgon', 3),
(4, '2024-03-03', 'kväll', 1),
(5, '2024-03-03', 'kväll', 2),
(6, '2024-03-03', 'kväll', 3),
(7, '2024-03-04', 'morgon', 1),
(8, '2024-03-05', 'kväll', 1),
(9, '2024-03-05', 'morgon', 2);

-- --------------------------------------------------------

--
-- Tabellstruktur `table_session`
--

CREATE TABLE `table_session` (
  `session_id` int(11) NOT NULL,
  `table_number` int(11) NOT NULL,
  `status` varchar(255) NOT NULL,
  `table_size` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumpning av Data i tabell `table_session`
--

INSERT INTO `table_session` (`session_id`, `table_number`, `status`, `table_size`) VALUES
(1, 1, 'Ledig', 6),
(2, 2, 'Ledig', 6),
(3, 3, 'Ledig', 6),
(4, 4, 'Ledig', 6),
(5, 5, 'Ledig', 4),
(6, 6, 'Ledig', 4),
(7, 7, 'Bokat', 4),
(8, 8, 'Ledig', 4);

--
-- Index för dumpade tabeller
--

--
-- Index för tabell `a_la_carte_menu`
--
ALTER TABLE `a_la_carte_menu`
  ADD PRIMARY KEY (`a_la_carte_id`);

--
-- Index för tabell `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`);

--
-- Index för tabell `drinks`
--
ALTER TABLE `drinks`
  ADD PRIMARY KEY (`drink_id`);

--
-- Index för tabell `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`);

--
-- Index för tabell `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`);

--
-- Index för tabell `lunch_menu`
--
ALTER TABLE `lunch_menu`
  ADD PRIMARY KEY (`lunch_id`);

--
-- Index för tabell `purchased_a_la_carte`
--
ALTER TABLE `purchased_a_la_carte`
  ADD PRIMARY KEY (`purchased_ID`),
  ADD KEY `aLaCartePuchasedByOrder` (`order_id`),
  ADD KEY `ALaCartePurchasedByALaCarte` (`a_la_carte_id`);

--
-- Index för tabell `purchased_drinks`
--
ALTER TABLE `purchased_drinks`
  ADD PRIMARY KEY (`purchased_ID`),
  ADD KEY `DrinkPurchasedByOrderID` (`order_id`),
  ADD KEY `DrinkPurchasedByDrinkID` (`drink_id`);

--
-- Index för tabell `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`receipt_id`);

--
-- Index för tabell `restaurant_order`
--
ALTER TABLE `restaurant_order`
  ADD PRIMARY KEY (`restaurant_order_id`);

--
-- Index för tabell `shift`
--
ALTER TABLE `shift`
  ADD PRIMARY KEY (`shift_id`);

--
-- Index för tabell `table_session`
--
ALTER TABLE `table_session`
  ADD PRIMARY KEY (`session_id`);

--
-- AUTO_INCREMENT för dumpade tabeller
--

--
-- AUTO_INCREMENT för tabell `a_la_carte_menu`
--
ALTER TABLE `a_la_carte_menu`
  MODIFY `a_la_carte_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT för tabell `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT för tabell `drinks`
--
ALTER TABLE `drinks`
  MODIFY `drink_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT för tabell `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT för tabell `lunch_menu`
--
ALTER TABLE `lunch_menu`
  MODIFY `lunch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT för tabell `purchased_a_la_carte`
--
ALTER TABLE `purchased_a_la_carte`
  MODIFY `purchased_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=91;

--
-- AUTO_INCREMENT för tabell `purchased_drinks`
--
ALTER TABLE `purchased_drinks`
  MODIFY `purchased_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT för tabell `restaurant_order`
--
ALTER TABLE `restaurant_order`
  MODIFY `restaurant_order_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT för tabell `table_session`
--
ALTER TABLE `table_session`
  MODIFY `session_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restriktioner för dumpade tabeller
--

--
-- Restriktioner för tabell `purchased_a_la_carte`
--
ALTER TABLE `purchased_a_la_carte`
  ADD CONSTRAINT `ALaCartePurchasedByALaCarte` FOREIGN KEY (`a_la_carte_id`) REFERENCES `a_la_carte_menu` (`a_la_carte_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `aLaCartePuchasedByOrder` FOREIGN KEY (`order_id`) REFERENCES `restaurant_order` (`restaurant_order_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restriktioner för tabell `purchased_drinks`
--
ALTER TABLE `purchased_drinks`
  ADD CONSTRAINT `DrinkPurchasedByDrinkID` FOREIGN KEY (`drink_id`) REFERENCES `drinks` (`drink_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `DrinkPurchasedByOrderID` FOREIGN KEY (`order_id`) REFERENCES `restaurant_order` (`restaurant_order_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
