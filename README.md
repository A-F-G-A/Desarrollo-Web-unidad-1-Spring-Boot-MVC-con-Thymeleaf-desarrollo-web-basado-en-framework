# Desarrollo Web - Ejercicio 11 Celular (Spring Boot MVC + Thymeleaf)

Aplicación web desarrollada con **Spring Boot MVC**, **Thymeleaf**, **Spring Data JPA** y **MySQL**.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.2.5**
- **Spring MVC (`@Controller`)**
- **Thymeleaf (Vistas HTML)**
- **Spring Data JPA / Hibernate**
- **MySQL 8.x**
- **Spring Boot Starter Mail (SMTP)**
- **Bootstrap 5.3 (CDN UI)**
- **Maven**

---

## Arquitectura del Proyecto

```
src/main/java/cel1/
├── config/
│   ├── SessionInterceptor.java    # Interceptor para proteger páginas privadas
│   └── WebConfig.java             # Registro de interceptores Spring MVC
├── controller/
│   ├── AuthController.java        # Login, Logout y Recuperación de Contraseña
│   ├── UsuarioController.java     # CRUD y Reportes de Usuarios
│   └── CelularController.java     # CRUD y Reportes de Celulares
├── entity/
│   ├── Usuario.java               # Entidad JPA @Table("usuarios")
│   └── Celular.java               # Entidad JPA @Table("celulares")
├── repository/
│   ├── UsuarioRepository.java     # Interface JpaRepository con consultas derivadas
│   └── CelularRepository.java     # Interface JpaRepository con consultas derivadas
├── service/
│   ├── UsuarioService.java        # Capa de Negocio Usuario
│   ├── CelularService.java        # Capa de Negocio Celular
│   └── CorreoService.java         # Servicio de correo SMTP Spring Mail
└── WebApplicationCelApplication.java # Main Application
```

---

## 🔧 Configuración de Base de Datos y SMTP

Las credenciales y variables se configuran de forma desacoplada en `src/main/resources/application.properties` o mediante variables de entorno del sistema:

### Variables de entorno (obligatorias en producción):
- `DB_URL`: URL JDBC de MySQL
- `DB_USER`: Usuario MySQL
- `DB_PASSWORD`: Contraseña MySQL
- `SMTP_HOST`: Host SMTP (por defecto `smtp.gmail.com`)
- `SMTP_PORT`: Puerto SMTP (por defecto `587`)
- `SMTP_USER`: Correo remitente
- `SMTP_PASSWORD`: App Password / contraseña SMTP
- `PORT`: Puerto HTTP (Railway lo define; local por defecto `8080`)

> No almacene credenciales reales en el repositorio. Use variables de entorno o un archivo `.env` local (ignorado por Git).

---

## 🗄️ Creación e Inserción Inicial de Base de Datos

Ejecute el script en MySQL Workbench o vía CLI:

```bash
mysql -u root -p < database/schema.sql
```

---

## 🚀 Cómo Ejecutar la Aplicación

### Opción 1: Mediante Maven Spring Boot Plugin

```bash
mvn spring-boot:run
```

### Opción 2: Compilar JAR/WAR y ejecutar

```bash
mvn clean package
java -jar target/desarrollo-web-celulares-1.0-SNAPSHOT.jar
```

Acceda en el navegador a: `http://localhost:8080/`

---

## 👥 Usuarios de Prueba

| ID | Contraseña | Nombre | Rol | Email |
|---|---|---|---|---|
| `admin` | `admin123` | Administrador | admin | `admin@ejemplo.com` |
| `usuario1` | `user123` | Juan Pérez | usuario | `juan@ejemplo.com` |
| `usuario2` | `user456` | María García | usuario | `maria@ejemplo.com` |
