-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-11-2025 a las 04:00:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cinemacentro-grupo1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprador`
--

CREATE TABLE `comprador` (
  `idComprador` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `password` varchar(50) NOT NULL,
  `medioDePago` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `comprador`
--

INSERT INTO `comprador` (`idComprador`, `dni`, `nombre`, `fechaNacimiento`, `password`, `medioDePago`) VALUES
(3, 41221751, 'Gimenez Paula', '1998-06-06', '123', 'Mercado Pago'),
(4, 45123987, 'Camila Biarnes', '2002-05-17', '1234', 'Tarjeta Visa'),
(5, 42987654, 'Franco Besso', '2000-08-09', '1234', 'Mercado Pago'),
(6, 41752369, 'Jonathan Maidana', '1998-11-03', '1234', 'Efectivo'),
(7, 43222034, 'camila aguirre', '2002-10-06', 'jPasswordField1', 'Tarjeta de Debito'),
(8, 43621472, 'marcos latini', '2000-07-08', 'jPasswordField1', 'Tarjeta de Debito');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleticket`
--

CREATE TABLE `detalleticket` (
  `idDetalleTicket` int(11) NOT NULL,
  `idFuncion` int(11) NOT NULL,
  `idLugar` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `subtotal` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detalleticket`
--

INSERT INTO `detalleticket` (`idDetalleTicket`, `idFuncion`, `idLugar`, `cantidad`, `subtotal`) VALUES
(2, 5, 46, 1, 5000),
(3, 5, 46, 1, 8000),
(4, 5, 47, 1, 8000),
(5, 6, 55, 1, 9000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `funcion`
--

CREATE TABLE `funcion` (
  `idFuncion` int(11) NOT NULL,
  `idPelicula` int(11) NOT NULL,
  `idioma` varchar(30) NOT NULL,
  `es3d` tinyint(1) NOT NULL,
  `subtitulado` tinyint(1) NOT NULL,
  `horarioInicio` datetime NOT NULL,
  `horarioFin` datetime NOT NULL,
  `lugarDisponible` int(11) NOT NULL,
  `idSala` int(11) NOT NULL,
  `precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `funcion`
--

INSERT INTO `funcion` (`idFuncion`, `idPelicula`, `idioma`, `es3d`, `subtitulado`, `horarioInicio`, `horarioFin`, `lugarDisponible`, `idSala`, `precio`) VALUES
(5, 3, 'espanol', 0, 1, '2025-12-16 16:30:00', '2025-12-16 18:30:00', 0, 3, 8000),
(6, 4, 'español', 1, 0, '2025-11-15 14:00:00', '2025-11-15 16:00:00', 0, 3, 9000),
(7, 4, 'español', 0, 1, '2025-11-15 18:00:00', '2025-11-15 20:00:00', 0, 3, 7000),
(8, 5, 'inglés', 0, 1, '2025-11-16 15:30:00', '2025-11-16 18:30:00', 0, 3, 8500),
(9, 5, 'español', 1, 0, '2025-11-16 20:00:00', '2025-11-16 23:00:00', 0, 3, 10000),
(10, 6, 'español', 1, 0, '2025-11-17 13:00:00', '2025-11-17 15:30:00', 0, 3, 9500),
(11, 6, 'inglés', 0, 1, '2025-11-17 17:00:00', '2025-11-17 19:30:00', 0, 3, 8000),
(12, 7, 'español', 0, 0, '2025-11-18 14:30:00', '2025-11-18 17:00:00', 0, 3, 7500),
(13, 8, 'español', 1, 0, '2025-11-19 16:00:00', '2025-11-19 18:30:00', 0, 3, 9000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugar`
--

CREATE TABLE `lugar` (
  `idLugar` int(11) NOT NULL,
  `fila` char(1) NOT NULL,
  `num` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `idFuncion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `lugar`
--

INSERT INTO `lugar` (`idLugar`, `fila`, `num`, `estado`, `idFuncion`) VALUES
(46, 'A', 1, 0, 5),
(47, 'A', 2, 0, 5),
(48, 'A', 3, 1, 5),
(49, 'B', 1, 1, 5),
(50, 'B', 2, 1, 5),
(51, 'B', 3, 1, 5),
(52, 'C', 1, 1, 5),
(53, 'C', 2, 1, 5),
(54, 'C', 3, 1, 5),
(55, 'A', 1, 0, 6),
(56, 'A', 2, 1, 6),
(57, 'A', 3, 1, 6),
(58, 'A', 4, 1, 6),
(59, 'B', 1, 1, 6),
(60, 'B', 2, 1, 6),
(61, 'B', 3, 1, 6),
(62, 'B', 4, 1, 6),
(63, 'C', 1, 1, 6),
(64, 'C', 2, 1, 6),
(65, 'C', 3, 1, 6),
(66, 'C', 4, 1, 6),
(67, 'A', 1, 1, 7),
(68, 'A', 2, 1, 7),
(69, 'A', 3, 1, 7),
(70, 'A', 4, 1, 7),
(71, 'B', 1, 1, 7),
(72, 'B', 2, 1, 7),
(73, 'B', 3, 1, 7),
(74, 'B', 4, 1, 7),
(75, 'C', 1, 1, 7),
(76, 'C', 2, 1, 7),
(77, 'C', 3, 1, 7),
(78, 'C', 4, 1, 7),
(79, 'A', 1, 1, 8),
(80, 'A', 2, 1, 8),
(81, 'A', 3, 1, 8),
(82, 'A', 4, 1, 8),
(83, 'B', 1, 1, 8),
(84, 'B', 2, 1, 8),
(85, 'B', 3, 1, 8),
(86, 'B', 4, 1, 8),
(87, 'C', 1, 1, 8),
(88, 'C', 2, 1, 8),
(89, 'C', 3, 1, 8),
(90, 'C', 4, 1, 8),
(91, 'A', 1, 1, 9),
(92, 'A', 2, 1, 9),
(93, 'A', 3, 1, 9),
(94, 'A', 4, 1, 9),
(95, 'B', 1, 1, 9),
(96, 'B', 2, 1, 9),
(97, 'B', 3, 1, 9),
(98, 'B', 4, 1, 9),
(99, 'C', 1, 1, 9),
(100, 'C', 2, 1, 9),
(101, 'C', 3, 1, 9),
(102, 'C', 4, 1, 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pelicula`
--

CREATE TABLE `pelicula` (
  `idPelicula` int(11) NOT NULL,
  `titulo` varchar(70) NOT NULL,
  `director` varchar(70) NOT NULL,
  `actores` varchar(200) NOT NULL,
  `origen` varchar(70) NOT NULL,
  `genero` varchar(20) NOT NULL,
  `estreno` date NOT NULL,
  `cartelera` tinyint(1) NOT NULL,
  `rutaImagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pelicula`
--

INSERT INTO `pelicula` (`idPelicula`, `titulo`, `director`, `actores`, `origen`, `genero`, `estreno`, `cartelera`, `rutaImagen`) VALUES
(3, 'El señor de los anillos', 'Peter Jackson', 'Elijah Wood, Ian McKellen, Orlando Bloom', 'Estado Unidos', 'Aventuras', '2005-03-15', 1, 'src/img/El señor de los anillos.jpg'),
(4, 'La guerra de los mundos', 'Steven Spielberg', 'Tom Cruise', 'Estados Unidos', 'Ciencia ficcion', '2005-06-25', 1, 'src/img/GuerradElosMundos.jpg'),
(5, 'Interestelar', 'Christopher Nolan', 'Matthew McConaughey, Anne Hathaway', 'Estados Unidos', 'Ciencia Ficcion, Dra', '2014-10-26', 1, 'src/img/Interestellar.jpg'),
(6, 'Star Wars Episodio I: La amenaza fantasma', 'George Lucas', 'Liam Neeson, Ewan McGregor, Natalie Portman', 'Estados Unidos', 'Ciencia Ficcion', '1999-05-19', 1, 'src/img/SW-Episodio1.png'),
(7, 'Star Wars Episodio 2: El ataque de los clones', 'George Lucas', 'Hayden Christensen, Ewan McGregor, Natalie Portman', 'Estados Unidos', 'Ciencia Ficcion', '1999-05-19', 1, 'src/img/starwars2.jpg'),
(8, 'Star Waras 3: Episodio 3', 'George Lucas', 'Heyden Christensen', 'estados unidos', 'Ciencia ficcion', '2025-11-12', 1, 'src/img/starwars3.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sala`
--

CREATE TABLE `sala` (
  `idSala` int(10) NOT NULL,
  `nroSala` int(10) NOT NULL,
  `apta3d` tinyint(1) NOT NULL,
  `capacidad` int(230) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sala`
--

INSERT INTO `sala` (`idSala`, `nroSala`, `apta3d`, `capacidad`, `estado`) VALUES
(3, 1, 1, 200, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticketcompra`
--

CREATE TABLE `ticketcompra` (
  `idTicket` int(11) NOT NULL,
  `fechaCompra` date NOT NULL,
  `fechaFuncion` datetime NOT NULL,
  `monto` double NOT NULL,
  `idComprador` int(11) NOT NULL,
  `idDetalleTicket` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ticketcompra`
--

INSERT INTO `ticketcompra` (`idTicket`, `fechaCompra`, `fechaFuncion`, `monto`, `idComprador`, `idDetalleTicket`) VALUES
(1, '2025-10-28', '2025-10-29 22:00:13', 15, 3, 2),
(2, '2025-11-12', '2025-12-16 16:30:00', 8000, 8, 4),
(3, '2025-11-12', '2025-11-15 14:00:00', 9000, 8, 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `comprador`
--
ALTER TABLE `comprador`
  ADD PRIMARY KEY (`idComprador`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  ADD PRIMARY KEY (`idDetalleTicket`),
  ADD KEY `idFuncion` (`idFuncion`),
  ADD KEY `idLugar` (`idLugar`);

--
-- Indices de la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD PRIMARY KEY (`idFuncion`),
  ADD KEY `idPelicula` (`idPelicula`),
  ADD KEY `idSala` (`idSala`);

--
-- Indices de la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD PRIMARY KEY (`idLugar`),
  ADD KEY `idFuncion` (`idFuncion`);

--
-- Indices de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  ADD PRIMARY KEY (`idPelicula`);

--
-- Indices de la tabla `sala`
--
ALTER TABLE `sala`
  ADD PRIMARY KEY (`idSala`);

--
-- Indices de la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  ADD PRIMARY KEY (`idTicket`),
  ADD KEY `idComprador` (`idComprador`),
  ADD KEY `idDetalleTicket` (`idDetalleTicket`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `comprador`
--
ALTER TABLE `comprador`
  MODIFY `idComprador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  MODIFY `idDetalleTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `funcion`
--
ALTER TABLE `funcion`
  MODIFY `idFuncion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `lugar`
--
ALTER TABLE `lugar`
  MODIFY `idLugar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;

--
-- AUTO_INCREMENT de la tabla `pelicula`
--
ALTER TABLE `pelicula`
  MODIFY `idPelicula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `sala`
--
ALTER TABLE `sala`
  MODIFY `idSala` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  MODIFY `idTicket` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `detalleticket`
--
ALTER TABLE `detalleticket`
  ADD CONSTRAINT `detalleticket_ibfk_1` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`),
  ADD CONSTRAINT `detalleticket_ibfk_2` FOREIGN KEY (`idLugar`) REFERENCES `lugar` (`idLugar`);

--
-- Filtros para la tabla `funcion`
--
ALTER TABLE `funcion`
  ADD CONSTRAINT `funcion_ibfk_1` FOREIGN KEY (`idPelicula`) REFERENCES `pelicula` (`idPelicula`),
  ADD CONSTRAINT `funcion_ibfk_2` FOREIGN KEY (`idSala`) REFERENCES `sala` (`idSala`);

--
-- Filtros para la tabla `lugar`
--
ALTER TABLE `lugar`
  ADD CONSTRAINT `lugar_ibfk_1` FOREIGN KEY (`idFuncion`) REFERENCES `funcion` (`idFuncion`);

--
-- Filtros para la tabla `ticketcompra`
--
ALTER TABLE `ticketcompra`
  ADD CONSTRAINT `ticketcompra_ibfk_1` FOREIGN KEY (`idComprador`) REFERENCES `comprador` (`idComprador`),
  ADD CONSTRAINT `ticketcompra_ibfk_2` FOREIGN KEY (`idDetalleTicket`) REFERENCES `detalleticket` (`idDetalleTicket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
