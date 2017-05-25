-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 18-05-2017 a las 08:38:44
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `base_csm`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avisos`
--

CREATE TABLE IF NOT EXISTS `avisos` (
  `N_Aviso` int(11) NOT NULL AUTO_INCREMENT,
  `Dni_emple` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Motivo` text COLLATE utf8_spanish_ci NOT NULL,
  `FH_Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `FH_Leido` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`N_Aviso`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci AUTO_INCREMENT=5 ;

--
-- Volcado de datos para la tabla `avisos`
--

INSERT INTO `avisos` (`N_Aviso`, `Dni_emple`, `Motivo`, `FH_Creacion`, `FH_Leido`) VALUES
(1, '47296949Z', 'Alta_lesion', '2017-05-04 09:08:37', NULL),
(2, '47296949Z', 'Baja_lesion', '2017-05-04 09:09:26', NULL),
(3, '47296949Z', 'Alta_lesion', '2017-05-04 09:09:26', NULL),
(4, '47296949Z', 'Baja_lesion', '2017-05-04 09:09:26', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `avisos_dest`
--

CREATE TABLE IF NOT EXISTS `avisos_dest` (
  `N_Aviso` int(11) NOT NULL,
  `Destinatario` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`N_Aviso`,`Destinatario`),
  KEY `N_Aviso` (`N_Aviso`),
  KEY `Destinatario` (`Destinatario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `avisos_dest`
--

INSERT INTO `avisos_dest` (`N_Aviso`, `Destinatario`) VALUES
(1, '37198985H'),
(1, '77598912M'),
(2, '77598912M'),
(3, '77598912M'),
(4, '77598912M');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE IF NOT EXISTS `empleados` (
  `Dni_Emple` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `F_Nacimiento` date NOT NULL,
  `Tfno_Contacto` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Alta_Club` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Cuenta_Bancaria` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Cargo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Correo` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`Dni_Emple`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`Dni_Emple`, `Nombre`, `F_Nacimiento`, `Tfno_Contacto`, `Alta_Club`, `Cuenta_Bancaria`, `Cargo`, `Correo`) VALUES
('37198985H', 'Florentino Perez', '1978-01-22', '664134507', '2017-05-02 20:00:00', 'ES00-0000-0000-00-000000060', 'Presidente', 'FlorentinoPerez@Futbolistacsm.es'),
('47296949Z', 'Pablo Montes', '1980-05-29', '664134503', '2017-05-02 20:00:00', 'ES00-0000-0000-00-000000063', 'Fisioterapeuta', 'PabloMontes@Futbolistacsm.es'),
('57298999E', 'Ivan Garcia', '1985-07-25', '664134504', '2017-05-02 20:00:00', 'ES00-0000-0000-00-000000064', 'Financiero', 'IvanGarcia@Futbolistacsm.es'),
('68497919C', 'Jose Pedrerol', '1976-03-15', '664134506', '2017-05-02 20:00:00', 'ES00-0000-0000-00-000000062', 'SegundoEntrenador', 'JosePedrerol@Futbolistacsm.es'),
('77598912M', 'David Valverde', '1975-11-12', '664134505', '2017-05-02 20:00:00', 'ES00-0000-0000-00-000000061', 'Entrenador', 'DavidValverde@Futbolistacsm.es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugadores`
--

CREATE TABLE IF NOT EXISTS `jugadores` (
  `Dni_Jugador` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `F_Nacimiento` date NOT NULL,
  `Tfno_Contacto` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Alta_Club` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Cuenta_Bancaria` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Demarcacion` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `Correo` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Lesionado` varchar(2) CHARACTER SET utf8 COLLATE utf8_spanish2_ci NOT NULL DEFAULT 'No',
  PRIMARY KEY (`Dni_Jugador`),
  UNIQUE KEY `Tfno_Contacto` (`Tfno_Contacto`,`Cuenta_Bancaria`,`Correo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `jugadores`
--

INSERT INTO `jugadores` (`Dni_Jugador`, `Nombre`, `F_Nacimiento`, `Tfno_Contacto`, `Alta_Club`, `Cuenta_Bancaria`, `Demarcacion`, `Correo`, `Lesionado`) VALUES
('47298910A', 'Aleix Garcia', '1991-05-15', '664124577', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00002001', 'DC', 'AleixGarcia@futbolistascsm.es', 'No'),
('47298911Z', 'Javier Espinosa', '1990-06-16', '664124566', '2017-05-03 09:13:11', 'ES00-0000-0000-00-07000001', 'EI', 'JavierEspinosa@futbolistascsm.es', 'No'),
('47298912D', 'David Valverde', '1988-07-17', '664124555', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00900001', 'MC', 'DavidValverde@futbolistascsm.es', 'No'),
('47298913F', 'Cesar Manzanilla', '1996-08-18', '664124540', '2017-05-03 09:13:11', 'ES00-0000-0000-00-50000001', 'LD', 'CesarManzanilla@futbolistascsm.es', 'No'),
('47298914J', 'Armindo Zubizareta', '1992-09-19', '664124539', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00009001', 'DFC', 'ArmindoZubizareta@futbolistascsm.es', 'No'),
('47298915K', 'Jose Garcia', '1991-11-20', '664124527', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00000301', 'LI', 'JoseGarcia@futbolistascsm.es', 'No'),
('47298916L', 'Gregorio Montes', '1990-12-21', '664124515', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00700001', 'MCD', 'GregorioMontes@futbolistascsm.es', 'No'),
('47298917M', 'Jon Monteño', '1986-12-22', '664124533', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00000041', 'MC', 'JonMonteño@futbolistascsm.es', 'No'),
('47298918P', 'Javier Del rio', '1985-11-23', '664124595', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00070001', 'POR', 'JavierDelrio@futbolistascsm.es', 'No'),
('47298919O', 'Abel Roncero', '1984-09-24', '664124598', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00000801', 'DC', 'AbelRoncero@futbolistascsm.es', 'No'),
('47298920W', 'Alfredo Soria', '1994-08-25', '664124599', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00005001', 'ED', 'AlfredoSoria@futbolistascsm.es', 'No'),
('47298921C', 'Jorge Monteño', '1997-07-26', '664124578', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00009001', 'EI', 'JorgeMonteño@futbolistascsm.es', 'No'),
('47298922B', 'Lucas Blazquez', '1988-05-27', '664124522', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00020001', 'MI', 'LucasBlazquez@futbolistascsm.es', 'No'),
('47298923N', 'Enzo Perez', '1989-04-28', '664124509', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00000501', 'CAI', 'EnzoPerez@futbolistascsm.es', 'No'),
('47298924Y', 'Mariano Elvira', '1991-03-29', '664124510', '2017-05-03 09:13:11', 'ES00-0000-0000-00-06000001', 'DFC', 'MarianoElvira@futbolistascsm.es', 'No'),
('47298925U', 'Deco Casillas', '1992-05-30', '664124511', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00080001', 'POR', 'DecoCasillas@futbolistascsm.es', 'No'),
('47298990V', 'Sergio Sanchez', '1992-04-14', '664124588', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00700001', 'ED', 'SergioSanchez@futbolistascsm.es', 'No'),
('47298991V', 'Pablo Motors', '1994-03-10', '665450885', '2017-05-03 08:34:43', 'ES00-0000-0000-00-00000001', 'POR', 'PabloMotors@futbolistacsm.es', 'No'),
('47298992H', 'Angel Morillo', '1993-10-03', '665430789', '2017-05-03 08:53:27', 'ES00-0000-0000-00-00000002', 'LD', 'AngelMorillo@futbolistascsm.es', 'No'),
('47298993G', 'Javier Viloria', '1995-03-21', '663230550', '2017-05-03 08:58:39', 'ES00-0000-0000-00-00000021', 'DFC', 'JavierVilora@futbolistascsm.es', 'No'),
('47298994Q', 'Francisco Levenga', '1994-01-01', '664124571', '2017-05-03 09:11:15', 'ES00-0000-0000-00-00000301', 'DFC', 'FranciscoLevenga@futbolistascsm.es', 'No'),
('47298995E', 'Kisko Kajko', '1993-05-13', '664124581', '2017-05-03 09:11:29', 'ES00-0000-0000-00-00000401', 'LI', 'Kiskokajko@futbolistascsm.es', 'No'),
('47298996R', 'Diego Vazquez', '1993-01-11', '664124517', '2017-05-03 09:11:41', 'ES00-0000-0000-00-00010001', 'MCD', 'DiegoVazquez@futbolistascsm.es', 'No'),
('47298997T', 'Diego Caldera', '1996-02-12', '664124516', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00040001', 'MC', 'DiegoCaldera@futbolistascsm.es', 'No'),
('47298998I', 'Carlos Vaute', '1994-03-13', '664124523', '2017-05-03 09:13:11', 'ES00-0000-0000-00-00005001', 'MC', 'CarlosVaute@futbolistascsm.es', 'No');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sesion`
--

CREATE TABLE IF NOT EXISTS `sesion` (
  `Dni_Jugador` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `Dni_emple` varchar(9) COLLATE utf8_spanish_ci NOT NULL,
  `FH_Sesion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `Motivo` text COLLATE utf8_spanish_ci NOT NULL,
  `Diagnostico` text COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`FH_Sesion`),
  KEY `Dni_emple` (`Dni_emple`),
  KEY `Dni_Jugador` (`Dni_Jugador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `sesion`
--

INSERT INTO `sesion` (`Dni_Jugador`, `Dni_emple`, `FH_Sesion`, `Motivo`, `Diagnostico`) VALUES
('47298994Q', '47296949Z', '2017-05-04 08:49:58', 'Rotura Muscular', 'Observaremos su evolucion durante las proximas dos semanas'),
('47298997T', '47296949Z', '2017-05-04 08:50:05', 'Rotura Muscular', 'Observaremos su evolucion durante un corto periodo de tiempo');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `avisos_dest`
--
ALTER TABLE `avisos_dest`
  ADD CONSTRAINT `avisos_dest_ibfk_1` FOREIGN KEY (`N_Aviso`) REFERENCES `avisos` (`N_Aviso`),
  ADD CONSTRAINT `avisos_dest_ibfk_2` FOREIGN KEY (`Destinatario`) REFERENCES `empleados` (`Dni_Emple`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
