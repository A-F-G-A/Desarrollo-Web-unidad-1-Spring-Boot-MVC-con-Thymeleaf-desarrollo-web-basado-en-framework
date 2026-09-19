# Desarrollo Web - Ejercicio 11 Celular

Aplicación web JSP/Servlet con MySQL para la gestión de celulares y usuarios, siguiendo la arquitectura enseñada por el Ing. John Carlos Arrieta Arrieta.

## ⚠️ REQUISITO IMPORTANTE: VERSIÓN DE TOMCAT

**Este proyecto está configurado para Tomcat 10.1.x+**

- **Tomcat 10.1.x+**: Utiliza `jakarta.servlet.*` (versión actual) ✅ **SOPORTADO**
- **Tomcat 9.x**: Utiliza `javax.servlet.*` (versión antigua) ❌ **NO SOPORTADO**

**No es posible soportar ambas versiones en el mismo WAR** porque Tomcat 10+ cambió de `javax.*` a `jakarta.*` y no son compatibles.

**Versión recomendada:** Apache Tomcat 10.1.24 o superior

## Tecnologías Utilizadas

- **Java 17**
- **Apache Tomcat 10.1.x+** (Requerido - usa Jakarta EE)
- **Maven**
- **MySQL 8.x**
- **JSP (Jakarta Server Pages)**
- **Servlet (Jakarta Servlet)**
- **MySQL Connector/J 8.3.0**

## 🔧 CONFIGURACIÓN DE BASE DE DATOS

El proyecto ahora utiliza un archivo de configuración para la conexión MySQL.

### Configuración por defecto:
- URL: `jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC`
- Usuario: `root`
- Contraseña: (vacía - DEBE configurarse)

### Pasos para configurar:

1. **Editar el archivo de configuración:**
   - Ubicación: `src/main/resources/config.properties`
   - Cambia `db.password` por tu contraseña de MySQL

```properties
db.url=jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC
db.usuario=root
db.password=tu_contraseña_mysql
```

2. **O alternativamente, configura MySQL sin contraseña:**
   - Si prefieres no configurar contraseña, asegúrate que tu usuario root de MySQL no tenga contraseña

## 🗄️ CREAR LA BASE DE DATOS

Ejecuta el script SQL ubicado en `database/schema.sql`:

```bash
mysql -u root -p < database/schema.sql
```

O desde MySQL Workbench:
1. Abre MySQL Workbench
2. Conéctate al servidor MySQL
3. Abre el archivo `database/schema.sql`
4. Ejecuta el script

## 📋 EJECUCIÓN EN DIFERENTES VERSIONES DE TOMCAT

### ⚠️ COMPATIBILIDAD DE TOMCAT

**Este proyecto está configurado EXCLUSIVAMENTE para Tomcat 10.1.x+**

**Por qué no soporta Tomcat 9.x:**
- Tomcat 9.x usa `javax.servlet.*` (Java EE 8)
- Tomcat 10.x usa `jakarta.servlet.*` (Jakarta EE 9)
- Los paquetes son incompatibles entre sí
- No es posible crear un WAR que funcione en ambas versiones

### EJECUCIÓN EN TOMCAT 10.1.x (RECOMENDADO)

**Requisitos:**
- Apache Tomcat 10.1.24 o superior
- Java 17
- MySQL 8.x

**Pasos:**
1. Instala Tomcat 10.1.x desde https://tomcat.apache.org/
2. Abre el proyecto en NetBeans
3. Configura Tomcat 10.1.x en NetBeans:
   - Services > Servers > Add Server > Apache Tomcat
   - Selecciona la ruta de instalación de Tomcat 10.1.x
4. Ejecuta el proyecto: Clic derecho > Run
5. Accede a: `http://localhost:8080/desarrollo-web-celulares/`

**Desde línea de comandos:**
```bash
mvn clean package
# Copia target/desarrollo-web-celulares.war a webapps de Tomcat 10.1.x
# Inicia Tomcat 10.1.x
```

### EJECUCIÓN EN TOMCAT 9.x (NO SOPORTADO)

**Para usar Tomcat 9.x, se requiere una versión diferente del proyecto con:**
- Dependencias `javax.servlet.*` en lugar de `jakarta.servlet.*`
- `web.xml` versión 4.0 en lugar de 6.0
- Imports `javax.*` en lugar de `jakarta.*` en Servlets

**No incluyo esta versión porque:**
- Tomcat 9.x es tecnología antigua (final de vida útil)
- Tomcat 10.1.x es la versión actual y recomendada
- Mantener dos versiones duplica innecesariamente el código

**Si necesitas Tomcat 9.x, tendrás que:**
1. Cambiar todas las dependencias en `pom.xml` a `javax.*`
2. Cambiar `web.xml` a versión 4.0
3. Cambiar todos los imports en Servlets a `javax.*`
4. Cambiar imports de mail a `javax.mail.*`

### Estructura de Archivos Web

- `index.jsp`: Página principal del sistema
- `login.jsp`: Formulario de inicio de sesión
- `recuperar.jsp`: Formulario de recuperación de contraseña
- `mensaje.jsp`: Página para mostrar mensajes del sistema
- `usuario/`: Carpeta con páginas JSP para gestión de usuarios
  - `agregar.jsp`: Formulario para agregar usuarios
  - `buscar.jsp`: Formulario para buscar usuarios
  - `modificar.jsp`: Formulario para modificar usuarios
  - `eliminar.jsp`: Formulario para eliminar usuarios
  - `listar.jsp`: Listado de todos los usuarios
- `celular/`: Carpeta con páginas JSP para gestión de celulares
  - `agregar.jsp`: Formulario para agregar celulares
  - `buscar.jsp`: Formulario para buscar celulares
  - `modificar.jsp`: Formulario para modificar celulares
  - `eliminar.jsp`: Formulario para eliminar celulares
  - `listar.jsp`: Listado de todos los celulares
  - `reportes.jsp`: Formularios para reportes parametrizados

## Funcionalidades

### Gestión de Usuarios
- CRUD completo (Crear, Leer, Actualizar, Eliminar)
- Inicio de sesión con validación
- Cierre de sesión
- Reporte por rol
- Reporte por nombre

### Gestión de Celulares
- CRUD completo (Crear, Leer, Actualizar, Eliminar)
- Reporte por marca
- Reporte por sistema operativo
- Reporte por operador

### Recuperación de Contraseña
- Envío de contraseña por correo electrónico

## Configuración de la Base de Datos

### Crear la Base de Datos

1. Asegúrese de tener MySQL Server instalado y ejecutándose
2. Ejecute el script SQL ubicado en `database/schema.sql`

```bash
mysql -u root -p < database/schema.sql
```

O bien, desde MySQL Workbench:
1. Abra MySQL Workbench
2. Conéctese al servidor MySQL
3. Abra el archivo `database/schema.sql`
4. Ejecute el script

### Configuración de la Conexión

La configuración de la conexión se encuentra en `src/main/resources/config.properties`:

```properties
db.url=jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC
db.usuario=root
db.password=tu_contraseña_mysql
```

**IMPORTANTE:** Modifique el valor de `db.password` según su configuración de MySQL:
- Si su usuario `root` tiene contraseña, colóquela en `db.password`
- Si no tiene contraseña, deje el valor vacío
- Si usa un usuario diferente de MySQL, cambie `db.usuario`

## Configuración de Correo Electrónico

Para habilitar la recuperación de contraseña por correo, debe configurar los datos en `src/main/resources/config.properties`:

```properties
mail.smtp.host=smtp.gmail.com
mail.smtp.port=587
mail.smtp.auth=true
mail.smtp.starttls.enable=true
mail.smtp.user=tu_correo@gmail.com
mail.smtp.password=tu_app_password
```

**Para Gmail:**
1. Habilite la autenticación de dos pasos en su cuenta de Gmail
2. Genere una "Contraseña de aplicación" en la configuración de seguridad de Google
3. Use esa contraseña de aplicación en `mail.smtp.password`

## Cómo Abrir en NetBeans

1. Abra NetBeans IDE
2. Seleccione `File` > `Open Project`
3. Navegue hasta la carpeta del proyecto (`WebApplicationCel`)
4. Seleccione el proyecto y haga clic en `Open Project`
5. NetBeans reconocerá automáticamente el proyecto Maven

## Cómo Ejecutar el Proyecto

### Desde NetBeans:
1. Asegúrese de que Tomcat esté configurado en NetBeans
2. Haga clic derecho en el proyecto
3. Seleccione `Run`
4. El proyecto se desplegará en Tomcat y se abrirá en el navegador

### Desde línea de comandos con Maven:
```bash
mvn clean package
```

Luego despliegue el archivo WAR generado en `target/desarrollo-web-celulares.war` en Tomcat.

## Usuarios de Prueba

El script SQL incluye los siguientes usuarios de prueba:

| ID | Clave | Nombre | Rol | Email |
|----|-------|--------|-----|-------|
| admin | admin123 | Administrador | admin | admin@ejemplo.com |
| usuario1 | user123 | Juan Pérez | usuario | juan@ejemplo.com |
| usuario2 | user456 | María García | usuario | maria@ejemplo.com |

## Datos de Prueba - Celulares

El script SQL incluye 5 celulares de prueba de diferentes marcas (Samsung, Apple, Xiaomi).

## Generación del WAR

Para generar el archivo WAR para despliegue:

```bash
mvn clean package
```

El archivo WAR se generará en: `target/desarrollo-web-celulares.war`

## Historial de Commits Sugerido

```bash
git init
git add .
git commit -m "Configuración inicial Maven y estructura de proyecto"

git add .
git commit -m "Clases Usuario y Celular (modelos)"

git add .
git commit -m "ConexionBaseDatos según guía del profesor"

git add .
git commit -m "CRUD Usuario con métodos estáticos"

git add .
git commit -m "CRUD Celular con métodos de búsqueda"

git add .
git commit -m "Servlets Usuario y Celular con parámetro acción"

git add .
git commit -m "Páginas JSP de Usuario (login, agregar, buscar, eliminar, modificar, listar)"

git add .
git commit -m "Páginas JSP de Celular (agregar, buscar, eliminar, modificar, listar, reportes)"

git add .
git commit -m "Login y sesiones con HttpSession"

git add .
git commit -m "Reportes parametrizados por entidad"

git add .
git commit -m "Recuperación de contraseña por correo"

git add .
git commit -m "Script SQL y configuración web.xml"

git add .
git commit -m "Ajustes finales y documentación README"
```

## Requisitos Académicos Cumplidos

- ✅ Servlet/JSP
- ✅ Mínimo Usuario + Celular
- ✅ CRUD Usuario completo
- ✅ CRUD Celular completo
- ✅ Mínimo 2 reportes parametrizados por entidad
  - Usuario: por rol y por nombre
  - Celular: por marca, sistema operativo y operador
- ✅ Login con validación
- ✅ Sesión con HttpSession
- ✅ Recuperación de clave por correo
- ✅ MySQL con script SQL
- ✅ Git/GitHub compatible
- ✅ README completo
- ✅ Despliegue WAR

## Notas Importantes

- El proyecto utiliza **Jakarta EE** (no javax) para compatibilidad con Tomcat 10.x
- El driver MySQL actualizado es `com.mysql.cj.jdbc.Driver`
- La arquitectura respeta estrictamente la guía del Ing. John Carlos Arrieta Arrieta
- No se han utilizado frameworks modernos (Spring, Hibernate, etc.) para mantener la arquitectura académica

## Licencia

Este proyecto es un ejercicio académico basado en la guía didáctica del Ing. John Carlos Arrieta Arrieta.
