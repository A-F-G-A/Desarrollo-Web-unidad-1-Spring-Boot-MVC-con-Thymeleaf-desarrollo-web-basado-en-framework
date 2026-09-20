-- Migración: renombra columnas camelCase -> snake_case SIN borrar datos.
-- Ejecutar UNA sola vez contra la base desarrollo_web si la tabla aún tiene nombres camelCase.

USE desarrollo_web;

-- Solo aplica si aún existen columnas camelCase (tabla actual del entorno).
ALTER TABLE celulares
    CHANGE COLUMN almacenamientoPrincipal almacenamiento_principal VARCHAR(20) NOT NULL,
    CHANGE COLUMN almacenamientoSecundario almacenamiento_secundario VARCHAR(20) NOT NULL,
    CHANGE COLUMN sistemaOperativo sistema_operativo VARCHAR(50) NOT NULL,
    CHANGE COLUMN tecnologiaBanda tecnologia_banda VARCHAR(50) NOT NULL,
    CHANGE COLUMN marcaCpu marca_cpu VARCHAR(50) NOT NULL,
    CHANGE COLUMN velocidadCpu velocidad_cpu VARCHAR(20) NOT NULL,
    CHANGE COLUMN resisteAgua resiste_agua VARCHAR(10) NOT NULL,
    CHANGE COLUMN cantidadSim cantidad_sim VARCHAR(10) NOT NULL;

-- Verificación
DESCRIBE celulares;
SELECT COUNT(*) AS total FROM celulares;
