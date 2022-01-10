-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 21 Haz 2021, 19:45:56
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

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `sale`
--
ALTER TABLE `sale`
  ADD PRIMARY KEY (`id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `sale`
--
ALTER TABLE `sale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
