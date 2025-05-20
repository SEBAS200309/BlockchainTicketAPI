
---

## BlockchainTicketAPI

# BlockchainTicketAPI

**Back-end Spring Boot para una ticketera de conciertos sobre Solana**

Este proyecto expone una API REST que opera con una base de datos PostgreSQL (Aiven) y prepara la lógica para emitir tickets en blockchain Solana (Web3).

---

## 📋 Características

- CRUD completo para **Bands** (`/api_rest/v1/WEB3_Ticketer/BandCRUD`).
- Endpoints paginados para entidades maestras (`Bands`, `Cities`, `Countries`, `Music Genres`, `Stadiums`, `Ticket Categories`, `Tickets`).
- Conexión a PostgreSQL en Aiven, con credenciales gestionadas por **GitHub Secrets**.
- Preparado para integración futura con Solana (Web3).

---

## 🔧 Tecnologías

- **Java 17**, **Spring Boot 3**  
- **Spring Data JPA**  
- **PostgreSQL** (Aiven)  
- **Maven**  

---

## 🚀 Cómo ejecutar

1. **Clona el repositorio**  
   ```bash
   git clone https://github.com/SEBAS200309/BlockchainTicketAPI.git
   cd BlockchainTicketAPI
   cd tickets
2. Configura credenciales de base de datos:
```ini
spring.datasource.url=jdbc:postgresql://<host>:<port>/<dbname>
spring.datasource.username=<user>
spring.datasource.password=<password>
```
El codigo ya trae unas por predeterminado asi menos la contraseña, la cual se encuentra segura.

##📂 Estructura de carpetas
```css
BlockchainTicketAPI/
├── src/
│   ├── main/
│   │   ├── java/com/api_rest/tickets/
│   │   │   ├── Controllers/    ← Controladores REST (paginación, CRUD)
│   │   │   ├── Services/       ← Lógica de negocio
│   │   │   ├── Entities/       ← JPA entities
│   │   │   └── DTO/            ← Data Transfer Objects
│   │   └── resources/
│   │       └── application.properties
└── pom.xml
