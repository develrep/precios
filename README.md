## PRICES Spring Boot Application
###	Objetivo
 Desarrollo de una aplicación basada en arquitectura hexagonal para consultar el precio prioritario de un producto en una fecha determinada. 
###	Tecnologías
- **Java 17**
- **Spring Boot 3.1.0**
- **Gradle**
- **Swagger**
- **Spring Data JPA**
- **H2 Database**
- **Mockito**, **JUnit**
- **MapStruct**

### Arquitectura hexagonal
- Se ha usado la arquitectura hexagonal separando las responsabilidades en diferentes capas:
 - **La capa dominio** contiene la lógica de negocio como los objetos de dominio y las excepciones personalizadas. 
 - **la capa aplicación** define los puertos de entrada (casos de uso) y salida (persistencia).
 - **la capa de infraestructura** contiene los adaptadores de entrada (como los controladores REST) y los  adaptadores de salida (como la base de datos).

### Como lanzar el proyecto y pruebas
##### Requisitos Previos
- Tener **Java 17** instalado y configurado en tu sistema.
- Este proyecto utiliza Gradle Wrapper para facilitar su ejecución
##### Ejecución
1. **Clonar el repositorio:**
   ```bash
   git clone https://github.com/develrep/precios
2. **Lanzar la aplicación:**
   ```bash
   ./gradlew bootRun
3. **Lanzar los test:**
   ```bash
   ./gradlew test
### Descripción del API
- **Obtener todos los precios:**
   - Endpoint: `GET /prices/all`
   - peticion: `http://localhost:8080/prices/all`
   - Respuesta:
       ```json
            [
              {
                "productId": 35455,
                "brandId": 1,
                "priceList": 1,
                "startDate": "2020-06-14T00:00:00",
                "endDate": "2020-12-31T23:59:59",
                "price": 35.5
              },
              {
                "productId": 35455,
                "brandId": 1,
                "priceList": 2,
                "startDate": "2020-06-14T15:00:00",
                "endDate": "2020-06-14T18:30:00",
                "price": 25.45
              },
              {
                "productId": 35455,
                "brandId": 1,
                "priceList": 3,
                "startDate": "2020-06-15T00:00:00",
                "endDate": "2020-06-15T11:00:00",
                "price": 30.5
              },
              {
                "productId": 35455,
                "brandId": 1,
                "priceList": 4,
                "startDate": "2020-06-15T16:00:00",
                "endDate": "2020-12-31T23:59:59",
                "price": 38.95
              }
            ]
- **Obtener precio prioritario según marca, producto y fecha:**
   - Endpoint: `GET /prices/find`
   - Peticion: `http://localhost:8080/prices/find?brandId=1&productId=35455&date=2020-06-15T18%3A30%3A00`
   - Respuesta:
     ```json
        {
          "productId": 35455,
          "brandId": 1,
          "priceList": 4,
          "startDate": "2020-06-15T16:00:00",
          "endDate": "2020-12-31T23:59:59",
          "price": 38.95
        }
     ```
### Como probar la aplicación manualmente
##### Swagger
- Se ha habilitado el listado de endpoints mediante swagger-ui en la siguiente url:
  `http://localhost:8080/swagger-ui/index.html`
##### cURL
  -  `curl -X 'GET' \
  'http://localhost:8080/prices/all' \
  -H 'accept: application/json'`
  - `curl -X 'GET' \
  'http://localhost:8080/prices/find?brandId=1&productId=35455&date=2020-06-15T18%3A30%3A00' \
  -H 'accept: application/json'`