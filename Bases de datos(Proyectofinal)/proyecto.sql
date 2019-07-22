-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 31-05-2018 a las 12:43:52
-- Versión del servidor: 5.7.15-log
-- Versión de PHP: 5.6.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `habitaciones` (
  `id` int(11) NOT NULL,
  `clase` varchar(100) NOT NULL,
  `capacidad` int(10) NOT NULL,
  `alojados` int(10) NOT NULL,
  `estado` int(1) NOT NULL,
  `precioIndividual` int(100) NOT NULL,
  `numHab` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `habitaciones` (`id`, `clase`, `capacidad`, `alojados`, `estado`, `precioIndividual`, `numHab`, `usuario`) VALUES
(1, 'Familiar', 5, 0, 1, 100000, 120, ''),
(2, 'Presidencial', 8, 0, 1, 100000, 120, ''),
(3, 'Presidencial', 8, 0, 1, 100000, 120, ''),
(4, 'Presidencial', 8, 0, 1, 120000, 103, '');
CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `identificacion` varchar(100) NOT NULL,
  `telefono` varchar(100) NOT NULL,
  `usuario` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `saldo` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `identificacion`, `telefono`, `usuario`, `pass`, `saldo`) VALUES
(1, 'Jairo', 'Buitrago', '1001053835', '3002763289', 'jairo0320', 'jairosam', 300000),
(3, 'Jairo', 'Buitrago', '1001053835', '3002763289', 'jairo032', '1234', 100000);
ALTER TABLE `habitaciones`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `habitaciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
