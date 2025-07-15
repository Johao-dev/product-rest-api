# API REST CRUD de productos

Esta es una API REST completa para operaciones CRUD sobre productos, desarrollada con Spring Boot y documentada con
OpenAPI v3 + Swagger UI.

---

## Requisitos previos

* Java 21 o superior
* Maven 3.x o superior

---

## Tecnologias utilizadas

* Spring boot 3.5.3
* Spring Web MVC
* Spring Validation
* OpenAPI v3 + Swagger UI
* Maven
* JUnit 5
* Spring Test

---

## Instalacion y ejecucion

### 1. Clonar el repositorio:

```bash
git clone https://github.com/Johao-dev/product-rest-api.git
cd product-rest-api
```

### 2. Compila y ejecuta la aplicacion:

```bash
mvn spring-boot:run
```

### 3. La aplicacion estara disponible en:

  `http://localhost:8080`

---

## Ejecutar tests

### Tests unitarios

```bash
mvn test
```

### Tests de integracion (endpoints)

```
mvn integration-test -P integration-test
```

### Ejecutar todos los tests

```bash
mvn verify
```

---

## Documentacion de la API

### OpenAPI v3 (JSON)

Accede a la especificacion completa en formato JSON:

`http://localhost:8080/v3/api-docs`

### Swagger UI

Interfaz interactiva para explorar y probar la API:

`http://localhost:8080/swagger-ui/index.html`

---

## Estructura del proyecto

```txt
src/
├── main/               # Codigo fuente de la API
├── test/               # Tests unitarios
├── integration_test/   # Tests de integracion
│
```