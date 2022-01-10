-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 21 Haz 2021, 19:45:32
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

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `buycar`
--
ALTER TABLE `buycar`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `buycar`
--
ALTER TABLE `buycar`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
