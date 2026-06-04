# Comparador de Jugadores

## Descripción

Es una aplicación web desarrollada con Spring Boot y MySQL.

El sistema permite seleccionar dos jugadores de fútbol desde una base de datos y compararlos según sus estadísticas.
La aplicación muestra un ganador, un perdedor y los datos principales de cada jugador.

---

## Funcionalidades

* Selección de dos jugadores.
* Filtros por nacionalidad, posición y nombre.
* Comparación de estadísticas.
* Cálculo de puntaje.
* Pantalla de resultado con ganador y perdedor.
* Script SQL incluido para cargar la base de datos.

---

## Tecnologías utilizadas

* Java
* Spring Boot
* Maven
* Spring Data JPA
* Thymeleaf
* MySQL
* HTML
* JavaScript
* Git y GitHub

---

## Integrantes

| Integrantes          | 
| -------------------- | 
| Enzo Zanel           |
| Facundo Minniti      | 

---

## Base de datos

Antes de ejecutar el proyecto se debe crear una base de datos en MySQL con el siguiente nombre:

```sql
CREATE DATABASE comparador_jugadores;
```

Luego se debe ejecutar el archivo SQL que se encuentra en:

```text
database/jugadores.sql
```

Ese archivo crea la tabla `jugador` y carga los datos necesarios para probar el sistema.

---

## Configuración

La conexión a la base de datos se configura en el archivo:

```text
src/main/resources/application.properties
```

Configuración usada:

```properties
server.port=8090
server.servlet.context-path=/comparador

spring.datasource.url=jdbc:mysql://localhost:3306/comparador_jugadores?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=
```

Si MySQL tiene contraseña, se debe completar esta línea:

```properties
spring.datasource.password=tu_contraseña
```

---

## Cómo ejecutar el proyecto

### 1. Clonar el repositorio

```bash
git clone https://github.com/USUARIO/comparador-jugadores.git
```

### 2. Entrar a la carpeta del proyecto

```bash
cd comparador-jugadores
```

### 3. Crear la base de datos

En MySQL o HeidiSQL ejecutar:

```sql
CREATE DATABASE comparador_jugadores;
```

### 4. Ejecutar el archivo SQL

Ejecutar el archivo:

```text
database/jugadores.sql
```

### 5. Iniciar el proyecto

Desde la carpeta donde está el archivo `pom.xml`, ejecutar:

```bash
.\mvnw spring-boot:run
```

### 6. Abrir en el navegador

```text
http://localhost:8090/comparador/
```

---

## Observaciones

El proyecto tiene una estructura básica por capas:

* `entities`
* `dao`
* `service`
* `servicesimp`
* `controller`
