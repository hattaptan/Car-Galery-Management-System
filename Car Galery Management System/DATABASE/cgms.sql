-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 21 Haz 2021, 19:45:08
-- Sunucu sürümü: 10.4.14-MariaDB
-- PHP Sürümü: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `cgms`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `buycar`
--

CREATE TABLE `buycar` (
  `id` int(11) NOT NULL,
  `plaque` varchar(45) DEFAULT NULL,
  `color` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `model` varchar(45) DEFAULT NULL,
  `gear` varchar(45) DEFAULT NULL,
  `fuel` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `engine` varchar(45) DEFAULT NULL,
  `door` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `buycar`
--

INSERT INTO `buycar` (`id`, `plaque`, `color`, `brand`, `model`, `gear`, `fuel`, `type`, `engine`, `door`, `price`) VALUES
(12, '35hattap35', 'blue', 'BMW', 'focus', 'Manuel', 'bensin', 'Sedan', '2', 5, 23333),
(29, '33 HTP 35', 'Yellow', 'Ford', 'Focus', 'Manuel', 'benzin', 'Sedan', '4.0', 5, 85000),
(31, '47HTP35', 'blue', 'BMW', '', 'Automatic', 'diesel', 'HB', '2.0', 5, 85000),
(32, '50DEU35', 'blue', 'Mercedes-Benz', 'cls', 'Manuel', 'diesel', 'Jeep', '5.0', 5, 360000),
(33, '25deu35', 'red', 'Fiat', 'linea', 'Manuel', 'diesel', 'HB', '1.6', 5, 90000);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(256) NOT NULL,
  `surname` varchar(256) NOT NULL,
  `gender` varchar(256) NOT NULL,
  `birthday` date NOT NULL,
  `telephone` varchar(256) NOT NULL,
  `address` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `customer`
--

INSERT INTO `customer` (`id`, `name`, `surname`, `gender`, `birthday`, `telephone`, `address`) VALUES
(3, 'hattap', 'tan', 'Male', '2021-05-30', '577777777777777', 'buca'),
(11, 'HATTAP', 'TAN', 'Male', '2021-06-01', '47474747', 'BUCA/IZMIR'),
(13, 'TAN', 'HATTAP', 'Male', '2021-06-18', '8945161519', 'İZMİR/BUCA'),
(14, 'deu', 'ceng', 'Male', '2021-09-09', '3355355', 'TınazTepe');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sale`
--

CREATE TABLE `sale` (
  `id` int(11) NOT NULL,
  `customername` varchar(256) NOT NULL,
  `salestime` date NOT NULL,
  `moneydelay` int(11) NOT NULL,
  `salesprice` int(11) NOT NULL,
  `Plaque` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `sale`
--

INSERT INTO `sale` (`id`, `customername`, `salestime`, `moneydelay`, `salesprice`, `Plaque`) VALUES
(10, 'hattap', '2021-06-18', 6, 52500, 12),
(12, 'HATTAP', '2021-06-03', 0, 96000, 31),
(13, 'HATTAP', '2021-06-03', 3, 105600, 31),
(14, 'TAN', '2021-06-23', 6, 152250, 32),
(15, 'deu', '2021-06-17', 0, 350000, 33),
(16, 'deu', '2021-06-17', 6, 367500, 33);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `customername` varchar(256) NOT NULL,
  `salestime` date NOT NULL,
  `moneydelay` int(11) NOT NULL,
  `salesprice` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `sales`
--

INSERT INTO `sales` (`id`, `customername`, `salestime`, `moneydelay`, `salesprice`) VALUES
(22, 'HATTAP', '2021-06-10', 3, 95700),
(24, 'tan', '2021-06-03', 6, 89250),
(25, 'hattap', '2021-06-18', 6, 26250),
(26, 'hattap', '2021-06-11', 6, 52500);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `buycar`
--
ALTER TABLE `buycar`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`);

--
-- Tablo için indeksler `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `buycar`
--
ALTER TABLE `buycar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- Tablo için AUTO_INCREMENT değeri `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- Tablo için AUTO_INCREMENT değeri `sale`
--
ALTER TABLE `sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Tablo için AUTO_INCREMENT değeri `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
