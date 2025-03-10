# 🎨 ArtGallery - Spring Boot Application

ArtGallery is a Spring Boot-based REST API designed for managing an online art gallery. It allows users to create, retrieve, update, and delete art pieces while providing robust error handling and structured data persistence using MySQL.

## 🚀 Features

- RESTful API for managing art pieces 🖼️
- CRUD operations for artworks 🎨
- Custom exception handling for better API responses ⚠️
- MySQL database integration for persistent storage 💾
- API documentation with OpenAPI (Swagger UI) 📜

## 📂 Project Structure

- **Controller:** `ArtPieceController` - Handles API endpoints for artwork management.
- **Service:** `ArtPieceService` - Implements business logic for CRUD operations.
- **Repository:** `ArtPieceRepository` - Interacts with the MySQL database using JPA.
- **Model:** `ArtPiece` - Represents an art piece entity.
- **Exception Handling:** Custom exceptions for improved error reporting.
- **Configuration:** `application.properties` - Configures database and API settings.

## 🔧 Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/ArtGallery.git
   cd ArtGallery
   ```
2. Configure the database connection in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/artgallery
   spring.datasource.username=root
   spring.datasource.password=YourPassword
   ```
3. Run the application:
   ```bash
   mvn spring-boot:run
   ```
4. Access API documentation:
   ```bash
   http://localhost:8080/api-docs
   ```
5. Access the swagger OpenAPI through browser:
   `https://localhost:8080/swagger-ui/index.html`

## 📜 API Endpoints

| Method | Endpoint | Description |
|--------|--------------------------------|------------------------------|
| GET    | `/artgallery/displayAllArts`   | Get all artworks |
| GET    | `/artgallery/displayArtWithID/{id}` | Get artwork by ID |
| GET    | `/artgallery/displayArtWithMedium/{medium}` | Get artworks by medium |
| POST   | `/artgallery/addArt` | Add a new artwork |
| PUT    | `/artgallery/updateArtWithId/{id}` | Update an existing artwork |
| DELETE | `/artgallery/deleteArtWithId/{id}` | Delete an artwork |

## 📌 Contributing

Feel free to fork this project, submit issues, and contribute improvements! 🛠️

## 📄 License

This project is licensed under the MIT License.
