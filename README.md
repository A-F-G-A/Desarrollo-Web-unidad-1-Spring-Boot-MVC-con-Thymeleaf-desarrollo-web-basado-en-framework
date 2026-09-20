# Desarrollo Web - Unidad 1: Spring Boot MVC con Thymeleaf

Aplicación web académica para gestión de **usuarios** y **celulares**, desarrollada con **Spring Boot MVC**, **Thymeleaf**, **Spring Data JPA** y **MySQL**.

Repositorio de entrega:

`https://github.com/A-F-G-A/Desarrollo-Web-unidad-1-Spring-Boot-MVC-con-Thymeleaf-desarrollo-web-basado-en-framework`

---

## Objetivo

Demostrar una aplicación web completa basada en framework con:

- Autenticación por sesión
- CRUD de usuarios y celulares
- Reportes
- Recuperación de contraseña por correo SMTP
- Persistencia relacional con MySQL

---

## Tecnologías

| Tecnología | Uso |
|---|---|
| Java 17 | Lenguaje |
| Spring Boot 3.2.5 | Framework |
| Spring MVC (`@Controller`) | Controladores web |
| Thymeleaf | Vistas HTML |
| Spring Data JPA / Hibernate | Persistencia |
| MySQL 8.x | Base de datos |
| Spring Boot Mail | SMTP / recuperación de clave |
| Bootstrap 5.3 (CDN) | UI |
| Maven | Build |

---

## Arquitectura

```
Controller → Service → Repository → Entity → MySQL
                ↓
            Thymeleaf (templates)
```

```
src/main/java/cel1/
├── config/          # Interceptor de sesión y WebMvc
├── controller/      # Auth, Usuario, Celular
├── entity/          # Usuario, Celular (@Column snake_case)
├── repository/      # Spring Data JPA
├── service/         # Lógica de negocio + CorreoService
└── WebApplicationCelApplication.java
```

Mapeo de columnas en `Celular`:

```text
Java camelCase  →  @Column(name = "snake_case")  →  MySQL snake_case
```

Ejemplo: `almacenamientoPrincipal` → `almacenamiento_principal`

---

## Requisitos

- JDK 17+
- Maven 3.9+ (o usar `mvnw` / `mvnw.cmd` incluidos)
- MySQL 8.x en ejecución

---

## Base de datos (MySQL)

1. Crear el esquema e insertar datos de demostración:

```bash
mysql -u TU_USUARIO -p < database/schema.sql
```

2. Si su tabla `celulares` aún tiene columnas en camelCase (instalación antigua), ejecute **una sola vez**:

```bash
mysql -u TU_USUARIO -p < database/migrate_celulares_to_snake_case.sql
```

> El script de migración **no** hace `DROP TABLE` y conserva los datos existentes.

Hibernate usa `spring.jpa.hibernate.ddl-auto=validate`: la aplicación fallará al arrancar si el esquema no coincide (comportamiento intencional).

---

## Variables de entorno

Copie `.env.example` como referencia. Spring Boot lee variables del **sistema operativo** / IDE / Railway (no carga `.env` automáticamente).

| Variable | Descripción | Ejemplo local |
|---|---|---|
| `DB_URL` | JDBC URL | `jdbc:mysql://localhost:3306/desarrollo_web?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true` |
| `DB_USER` | Usuario MySQL | `TU_USUARIO` |
| `DB_PASSWORD` | Contraseña MySQL | `TU_CONTRASEÑA` |
| `SMTP_HOST` | Host SMTP | `smtp.gmail.com` |
| `SMTP_PORT` | Puerto SMTP | `587` |
| `SMTP_USER` | Correo remitente | `TU_CORREO` |
| `SMTP_PASSWORD` | App Password SMTP | `TU_APP_PASSWORD` |
| `PORT` | Puerto HTTP | `8080` (Railway lo inyecta) |

En Windows (PowerShell, sesión actual):

```powershell
$env:DB_USER="root"
$env:DB_PASSWORD="TU_CONTRASEÑA"
$env:SMTP_USER="TU_CORREO"
$env:SMTP_PASSWORD="TU_APP_PASSWORD"
```

En NetBeans / IntelliJ: configure las mismas variables en la Run Configuration.

**Nunca** suba credenciales reales al repositorio.

---

## Ejecución local

```bash
# Compilar
.\mvnw.cmd clean package

# Ejecutar
.\mvnw.cmd spring-boot:run
```

O:

```bash
java -jar target/desarrollo-web-celulares-1.0-SNAPSHOT.jar
```

Abrir: [http://localhost:8080/](http://localhost:8080/)

---

## Usuarios de demostración

| ID | Contraseña | Rol |
|---|---|---|
| `admin` | `admin123` | admin |
| `usuario1` | `user123` | usuario |
| `usuario2` | `user456` | usuario |

Estas credenciales son **solo de prueba académica**, no de producción.

---

## Funcionalidades

- Login / logout con control de sesión
- CRUD Usuario + reportes
- CRUD Celular + reportes
- Recuperación de contraseña (requiere SMTP configurado)

---


## Seguridad

- Las contraseñas de MySQL y SMTP **no** van en el código versionado.
- Use variables de entorno en local y en producción.
- Si alguna credencial real llegó a un commit antiguo, **revóquela y cámbiela**.
