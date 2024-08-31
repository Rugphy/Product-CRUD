# Product CRUD API

## Overview

This is a RESTful API for managing Products and Categories. The API allows for the creation, retrieval, updating, and deletion of products and categories, and also includes features such as auto-generating product codes and validating data before storing it in the database.

## Features

- **Product Management**
  - List all products
  - Create a new product
  - Get details of a product by its ID
  - Update an existing product
  - Delete a product

- **Category Management**
  - List all categories
  - Create a new category

- **Auto-generated Product Code**
  - Automatically generate a unique code for a product if the code field is empty.
  - Increment the last character of the existing code if the product code already exists.

- **Validation**
  - Implement custom validation rules for product and category data before storing them in the database.

- **Database Integration**
  - Store product and category data in a relational database.

- **Versioning**
  - API version: `0.0.1-SNAPSHOT`


## API Endpoints

### Product Endpoints

- **Add New Product**
  - **POST** `/product`
  - Request Body: `ProductDTO`
  
- **List All Products**
  - **GET** `/product`
  
- **Get Product by ID**
  - **GET** `/product/{id}`
  - Path Parameter: `id` (number)
  
- **Update Product**
  - **PUT** `/product/{id}`
  - Path Parameter: `id` (number)
  - Request Body: `EditProductDTO`
  
- **Delete Product**
  - **DELETE** `/product/{id}`
  - Path Parameter: `id` (number)

### Category Endpoints

- **Add New Category**
  - **POST** `/category`
  - Request Body: `CategoryRequest`
  
- **List All Categories**
  - **GET** `/category`

## Running the Application

1. **Clone the repository:**

    ```bash
    git clone <repository-url>
    ```

2. **Build the project:**

    ```bash
    mvn clean install
    ```

3. **Run the application:**

    ```bash
    mvn spring-boot:run
    ```
