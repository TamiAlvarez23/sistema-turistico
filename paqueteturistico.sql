-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-11-2023 a las 06:58:22
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `paqueteturistico`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alojamiento`
--

CREATE TABLE `alojamiento` (
  `idAlojamiento` int(11) NOT NULL,
  `fechaIngreso` date NOT NULL,
  `fechaEgreso` date NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `servicio` varchar(100) NOT NULL,
  `importeDiario` double NOT NULL,
  `cupoAlojamiento` int(11) NOT NULL,
  `ciudadDestino` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `tipoAlojamiento` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alojamiento`
--

INSERT INTO `alojamiento` (`idAlojamiento`, `fechaIngreso`, `fechaEgreso`, `estado`, `servicio`, `importeDiario`, `cupoAlojamiento`, `ciudadDestino`, `nombre`, `tipoAlojamiento`) VALUES
(1, '2023-02-21', '2023-03-23', 1, 'Desayuno', 20000, 45, 5, 'Santa Teresita', 'Hotel'),
(2, '2023-02-21', '2023-03-23', 1, 'Play', 4000, 78, 5, 'San Nicolas', 'Hotel'),
(3, '2023-01-01', '2023-01-01', 1, 'Aire Acondicionado', 40000, 45, 14, 'San Espedito', 'Hotel'),
(4, '2023-02-21', '2023-03-23', 1, 'Almuerzo', 7500, 50, 18, 'San Agustin', 'Hotel'),
(5, '2023-02-21', '2023-03-23', 1, 'Desayuno', 75000, 75, 14, 'Santa Tamara', 'Hostel'),
(6, '2023-01-01', '2023-01-01', 1, 'wifi', 15000, 45, 5, 'Santa Clara', 'Hostel');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `idCiudad` int(15) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `pais` varchar(100) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `provincia` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`idCiudad`, `nombre`, `pais`, `estado`, `provincia`) VALUES
(5, 'Carlos Paz', 'Argentina', 1, 'Cordoba'),
(14, 'Alta Gracia', 'Argentina', 1, 'Cordoba'),
(18, 'Mina Clavero', 'Argentina', 1, 'Cordoba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paquete`
--

CREATE TABLE `paquete` (
  `idPaquete` int(15) NOT NULL,
  `origen` int(15) NOT NULL,
  `destino` int(15) NOT NULL,
  `alojamiento` int(15) NOT NULL,
  `pasaje` int(15) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `cupo` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paquete`
--

INSERT INTO `paquete` (`idPaquete`, `origen`, `destino`, `alojamiento`, `pasaje`, `estado`, `cupo`) VALUES
(1, 5, 5, 1, 2, 1, 0),
(2, 5, 5, 1, 2, 1, 0),
(3, 5, 5, 3, 5, 1, 0),
(4, 5, 5, 1, 2, 1, 0),
(5, 14, 5, 1, 6, 1, -30);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pasaje`
--

CREATE TABLE `pasaje` (
  `idPasaje` int(11) NOT NULL,
  `tipoTransporte` varchar(100) NOT NULL,
  `importe` double NOT NULL,
  `nombreCiudadOrigen` int(11) NOT NULL,
  `cupoPasaje` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `pasaje`
--

INSERT INTO `pasaje` (`idPasaje`, `tipoTransporte`, `importe`, `nombreCiudadOrigen`, `cupoPasaje`, `estado`) VALUES
(2, 'Avión', 8, 5, 0, 1),
(3, 'Avión', 4, 5, 70, 1),
(4, 'Tren', 7400, 18, 54, 1),
(5, 'Avión', 7, 5, 0, 1),
(6, 'Colectivo', 5600, 14, 30, 1),
(7, 'Avión', 2, 14, 20, 1),
(8, 'Colectivo', 8, 5, 40, 1),
(9, 'Colectivo', 8, 14, 8, 1),
(10, 'Colectivo', 22, 5, 70, 1),
(11, 'Avión', 888, 5, 8, 1),
(12, 'Tren', 2, 5, 2, 1),
(13, 'Avión', 4500, 5, 45, 1),
(14, 'Colectivo', 7800, 5, 45, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `presupuesto`
--

CREATE TABLE `presupuesto` (
  `idPresupuesto` int(50) NOT NULL,
  `idPaquete` int(50) NOT NULL,
  `nombreCliente` varchar(100) NOT NULL,
  `apellidoCliente` varchar(100) NOT NULL,
  `dniCliente` int(50) NOT NULL,
  `telefonoCliente` int(50) NOT NULL,
  `mailCliente` varchar(100) NOT NULL,
  `pagoCliente` varchar(100) NOT NULL,
  `cuotasCliente` int(50) NOT NULL,
  `idUsuario` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(100) NOT NULL,
  `nombreUsuario` varchar(100) NOT NULL,
  `rango` varchar(50) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `claveUsuario` varchar(100) NOT NULL,
  `estadoUsuario` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `nombreUsuario`, `rango`, `nombre`, `apellido`, `claveUsuario`, `estadoUsuario`) VALUES
(6, 'Agusco24', 'Admiistrador', 'Agustin', 'Colongne', 'agus123', 1),
(7, 'fulgencio', 'Vendedor', '8', '9', 'fjhdgrdhdjhtf', 1),
(8, 'a', 'Admiistrador', 'Agustin', 'Colongn', 'a', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  ADD PRIMARY KEY (`idAlojamiento`),
  ADD KEY `ciudadDestino` (`ciudadDestino`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`idCiudad`);

--
-- Indices de la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD PRIMARY KEY (`idPaquete`),
  ADD KEY `paquete_alojamiento_foreign` (`alojamiento`),
  ADD KEY `paquete_pasaje_foreign` (`pasaje`),
  ADD KEY `origen` (`origen`),
  ADD KEY `destino` (`destino`);

--
-- Indices de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD PRIMARY KEY (`idPasaje`),
  ADD KEY `pasaje_nombreCiudadOrigen_foreign` (`nombreCiudadOrigen`);

--
-- Indices de la tabla `presupuesto`
--
ALTER TABLE `presupuesto`
  ADD PRIMARY KEY (`idPresupuesto`),
  ADD KEY `presupuesto_paquete_foreign` (`idPaquete`),
  ADD KEY `presupuesto_usuario_foreign` (`idUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  MODIFY `idAlojamiento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `idCiudad` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `paquete`
--
ALTER TABLE `paquete`
  MODIFY `idPaquete` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `pasaje`
--
ALTER TABLE `pasaje`
  MODIFY `idPasaje` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `presupuesto`
--
ALTER TABLE `presupuesto`
  MODIFY `idPresupuesto` int(50) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idUsuario` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alojamiento`
--
ALTER TABLE `alojamiento`
  ADD CONSTRAINT `alojamiento_ibfk_1` FOREIGN KEY (`ciudadDestino`) REFERENCES `ciudad` (`idCiudad`);

--
-- Filtros para la tabla `paquete`
--
ALTER TABLE `paquete`
  ADD CONSTRAINT `paquete_ibfk_1` FOREIGN KEY (`origen`) REFERENCES `ciudad` (`idCiudad`),
  ADD CONSTRAINT `paquete_ibfk_2` FOREIGN KEY (`destino`) REFERENCES `ciudad` (`idCiudad`),
  ADD CONSTRAINT `paquete_ibfk_3` FOREIGN KEY (`alojamiento`) REFERENCES `alojamiento` (`idAlojamiento`) ON DELETE CASCADE,
  ADD CONSTRAINT `paquete_pasaje_foreign` FOREIGN KEY (`pasaje`) REFERENCES `pasaje` (`idPasaje`);

--
-- Filtros para la tabla `pasaje`
--
ALTER TABLE `pasaje`
  ADD CONSTRAINT `pasaje_nombreCiudadOrigen_foreign` FOREIGN KEY (`nombreCiudadOrigen`) REFERENCES `ciudad` (`idCiudad`) ON DELETE CASCADE;

--
-- Filtros para la tabla `presupuesto`
--
ALTER TABLE `presupuesto`
  ADD CONSTRAINT `presupuesto_paquete_foreign` FOREIGN KEY (`idPaquete`) REFERENCES `paquete` (`idPaquete`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `presupuesto_usuario_foreign` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
