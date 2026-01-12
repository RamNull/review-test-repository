# Cart Service - Spring Boot MongoDB Application

A simple REST API service for managing shopping carts using Spring Boot and MongoDB.

## Features

- Create a new shopping cart
- Add items to a cart
- View cart details
- List all carts
- Update cart status
- Delete a cart
- Automatic total calculation

## Data Model

### Cart
- `cartId`: Unique identifier (String)
- `items`: List of Item objects
- `total`: Calculated total price (double)
- `status`: Cart status (String, default: "ACTIVE")

### Item
- `name`: Item name (String)
- `price`: Item price (double)
- `quantity`: Item quantity (int)

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- MongoDB 4.0 or higher (running on localhost:27017)

## Building the Application

```bash
mvn clean compile
```

## Running the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Create a Cart
```
POST /api/carts
Response: 201 Created
```

### Get a Cart
```
GET /api/carts/{cartId}
Response: 200 OK
```

### Get All Carts
```
GET /api/carts
Response: 200 OK
```

### Add Item to Cart
```
POST /api/carts/{cartId}/items
Content-Type: application/json
Body: {
  "name": "Item Name",
  "price": 10.99,
  "quantity": 2
}
Response: 200 OK
```

### Update Cart Status
```
PUT /api/carts/{cartId}/status?status=COMPLETED
Response: 200 OK
```

### Delete a Cart
```
DELETE /api/carts/{cartId}
Response: 204 No Content
```

## Configuration

MongoDB connection settings can be configured in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=cartdb
```

## Running Tests

```bash
mvn test
```