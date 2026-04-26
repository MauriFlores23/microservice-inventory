# 🚀 Inventory Microservices System

Sistema de microservicios construido con Spring Boot 3 y Java 21, con arquitectura hexagonal, API Gateway y resiliencia

---

## 📦 Arquitectura

El sistema esta compuesto por:

### 1. Inventory Service
Microservicio encargado de la gestión de productos.

- CRUD de productos
- Persistencia con H2
- Validaciones con Jakarta Validation
- Arquitectura hexagonal

### 2. API Gateway
Punto único de entrada al sistema.

- Routing de requests
- Circuit Breaker con Resilience4j
- Fallback en caso de fallos del servicio

---

## 🛠️ Tecnologías

- Java 21
- Spring Boot 3.2+
- Spring Data JPA
- H2 Database
- Spring Cloud Gateway
- Resilience4j
- SpringDoc OpenAPI
- JUnit 5 + Mockito

---


## 📡 Endpoints principales

- POST /api/products
- GET /api/products
- GET /api/products/{id}
- PUT /api/products/{id}/stock
- DELETE /api/products/{id}

