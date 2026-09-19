-- Crear base de datos
CREATE DATABASE IF NOT EXISTS desarrollo_web;
USE desarrollo_web;

-- Tabla usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id VARCHAR(50) PRIMARY KEY,
    clave VARCHAR(100) NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    rol VARCHAR(20) NOT NULL,
    email VARCHAR(100)
);

-- Tabla celulares
CREATE TABLE IF NOT EXISTS celulares (
    id VARCHAR(50) PRIMARY KEY,
    marca VARCHAR(50) NOT NULL,
    imei VARCHAR(50) NOT NULL,
    pulgadas VARCHAR(20) NOT NULL,
    megapixeles VARCHAR(20) NOT NULL,
    ram VARCHAR(20) NOT NULL,
    almacenamientoPrincipal VARCHAR(20) NOT NULL,
    almacenamientoSecundario VARCHAR(20) NOT NULL,
    sistemaOperativo VARCHAR(50) NOT NULL,
    operador VARCHAR(50) NOT NULL,
    tecnologiaBanda VARCHAR(50) NOT NULL,
    wifi VARCHAR(10) NOT NULL,
    bluetooth VARCHAR(10) NOT NULL,
    camaras VARCHAR(50) NOT NULL,
    marcaCpu VARCHAR(50) NOT NULL,
    velocidadCpu VARCHAR(20) NOT NULL,
    nfc VARCHAR(10) NOT NULL,
    huella VARCHAR(10) NOT NULL,
    ir VARCHAR(10) NOT NULL,
    resisteAgua VARCHAR(10) NOT NULL,
    cantidadSim VARCHAR(10) NOT NULL
);

-- Insertar datos de prueba en usuarios
INSERT INTO usuarios (id, clave, nombre, rol, email) VALUES
('admin', 'admin123', 'Administrador', 'admin', 'admin@ejemplo.com'),
('usuario1', 'user123', 'Juan Pérez', 'usuario', 'juan@ejemplo.com'),
('usuario2', 'user456', 'María García', 'usuario', 'maria@ejemplo.com');

-- Insertar datos de prueba en celulares
INSERT INTO celulares (id, marca, imei, pulgadas, megapixeles, ram, almacenamientoPrincipal, almacenamientoSecundario, sistemaOperativo, operador, tecnologiaBanda, wifi, bluetooth, camaras, marcaCpu, velocidadCpu, nfc, huella, ir, resisteAgua, cantidadSim) VALUES
('CEL001', 'Samsung', '123456789012345', '6.5', '108', '8GB', '128GB', '256GB', 'Android', 'Claro', '5G', 'Si', 'Si', '4', 'Qualcomm', '2.4GHz', 'Si', 'Si', 'No', 'Si', '2'),
('CEL002', 'Apple', '987654321098765', '6.1', '12', '6GB', '128GB', '0GB', 'iOS', 'Movistar', '5G', 'Si', 'Si', '3', 'Apple', '3.2GHz', 'Si', 'Si', 'No', 'Si', '1'),
('CEL003', 'Xiaomi', '456789012345678', '6.4', '64', '6GB', '64GB', '128GB', 'Android', 'Tigo', '4G', 'Si', 'Si', '3', 'MediaTek', '2.0GHz', 'No', 'Si', 'Si', 'No', '2'),
('CEL004', 'Samsung', '321654987012345', '6.7', '48', '8GB', '256GB', '512GB', 'Android', 'Claro', '5G', 'Si', 'Si', '5', 'Qualcomm', '3.0GHz', 'Si', 'Si', 'Si', 'Si', '2'),
('CEL005', 'Apple', '654321098765432', '6.7', '12', '8GB', '256GB', '0GB', 'iOS', 'Movistar', '5G', 'Si', 'Si', '3', 'Apple', '3.2GHz', 'Si', 'Si', 'No', 'Si', '1');
