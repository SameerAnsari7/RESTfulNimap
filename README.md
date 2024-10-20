# RESTfulNimap
REST API for the Nimap Infotech machine test, focusing on product and category management.

## Table of Contents
- [Overview](#overview)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [API Endpoints](#api-endpoints)
- [Categories](#categories)
- [Products](#products)
- [Test Cases](#test-cases)
- [Project Structure](#project-structure)
- [Database Configuration](#database-configuration)
- [Usage](#usage)
- [License](#license)

## Overview
This Spring Boot application provides a RESTful API for managing categories and products. It supports CRUD operations and implements server-side pagination using JPA and Hibernate with a relational database.

## Requirements
- Spring Boot
- REST Controller
- Relational Database Configuration (RDB)
- Annotation-based Configuration (no XML)
- JPA & Hibernate


## Getting Started
1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/RESTfulNimap.git
   cd RESTfulNimap
   ```
2. **Install dependencies:**
   ```bash
    mvn clean install
   ```
3.**Configure your database in:** 
`src/main/resources/application.properties.`
   
## API Endpoints

### Categories
**Get All Categories:**
`GET http://localhost:8080/api/categories?page={pageNumber}`

**Example Response:**
```bash
[
  {
    "id": 1,
    "name": "Electronics"
  },
  {
    "id": 2,
    "name": "Books"
  }
]
```
**Create Category:**
`POST http://localhost:8080/api/categories`

**Request Body:**
```json
    { "name": "Category Name" }
```
**Example Response:**
```json
{
  "id": 3,
  "name": "Category Name"
}
```
Get Category by ID:
GET http://localhost:8080/api/categories/{id}

Example Response:
```bash
{
  "id": 1,
  "name": "Electronics"
}
```
**Update Category:**
`PUT http://localhost:8080/api/categories/{id}`

**Request Body:** 
```json
{ "name": "Updated Category Name" }
```
**Example Response:**
```json
{
  "id": 1,
  "name": "Updated Category Name"
}
```
**Delete Category:**
`DELETE http://localhost:8080/api/categories/{id}`

**Example Response:**
```json
{
  "message": "Category deleted successfully."
}
```
### Products
**Get All Products:**
`GET http://localhost:8080/api/products?page={pageNumber}`

**Example Response:**
```json
[
  {
    "id": 1,
    "name": "Smartphone",
    "category": "Electronics"
  },
  {
    "id": 2,
    "name": "Novel",
    "category": "Books"
  }
]
```
**Create Product:**
`POST http://localhost:8080/api/products`

**Request Body:** 
```json
{ "name": "Product Name", "categoryId": 1 }
```
**Example Response:**
```json
{
  "id": 3,
  "name": "Product Name",
  "category": "Electronics"
}
```
**Get Product by ID:**
`GET http://localhost:8080/api/products/{id}`

**Example Response:**
```json
{
  "id": 1,
  "name": "Smartphone",
  "category": "Electronics"
}
```
**Update Product:**
`PUT http://localhost:8080/api/products/{id}`

**Request Body:** 
```json
{ "name": "Updated Product Name" }
```
**Example Response:**
```json
{
  "id": 1,
  "name": "Updated Product Name",
  "category": "Electronics"
}
```
**Delete Product:**
`DELETE http://localhost:8080/api/products/{id}`

**Example Response:**
```json
{
  "message": "Product deleted successfully."
}
```
## Test Cases
![Test Passed](https://github.com/SameerAnsari7/RESTfulNimap/blob/main/testpassed.jpg)
### Passed Test Cases
1. **Successfully created a category.**
2. **Retrieved all categories with pagination.**
3. **Retrieved a category by ID.**
4. **Updated a category by ID.**
5. **Deleted a category by ID.**
6. **Successfully created a product.**
7. **Retrieved all products with pagination.**
8. **Retrieved a product by ID.**
9. **Updated a product by ID.**
10. **Deleted a product by ID.**

## Project Structure
```plaintext
src/main/java/com/SAMEER/NIMAPMACHINETEST/
├── controller
│   ├── CategoryController.java
│   └── ProductController.java
├── model
│   ├── Category.java
│   └── Product.java
├── repository
│   ├── CategoryRepository.java
│   └── ProductRepository.java
└── service
    ├── CategoryService.java
    └── ProductService.java

src/main/resources/
└── application.properties
```
## Database Configuration
Edit src/main/resources/application.properties to configure your database:
```
For MySQL:
spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
spring.datasource.username=yourusername
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```
## Usage
To run the application, use the following command:

```bash
mvn spring-boot:run
```
Once the application is running, you can access the API through your web browser or a tool like Postman to test the endpoints.

## License
This project is for personal use and testing purposes only. Please do not distribute or use for commercial purposes without permission. Future uses may require different terms.

