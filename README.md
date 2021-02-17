# Products Management API
API for product management.

## Docker

The image could be deployed using the follwing commands

```bash
docker build -t products-api .
```

```bash
docker run --env databaseUrl=YourDatabaseUrl --env databaseName=YourDatabaseName --env databaseUsername=YourDatabaseUsername --env databasePassword=YourDatabasePassword  -p 8080:8080 products-api
```
## Swagger

Documentation about endpoints could be found in [Swagger](http://localhost:8080/swagger-ui.html)

## Endpoints

### /authenticate

The /authenticate endpoint return a JWT for you use other endpoints. For every endpoint you should pass the token in header.
KEY=authorization VALUES=Bearer {token}

```json
{
	"username": "admin",
	"password": "password"
}
```

### /v1/products

#### POST

Add new product in database. With there is an product with same name, a HTTP Code 409 (CONFLICT) will return. 

```json
{
  "name": "string",
  "description": "string",
  "price": 0
}
```

#### PUT

Update product's name. With there is an product with same name, a HTTP Code 409 (CONFLICT) will return. The id should be pass in path. eg. http://localhost:8080/v1/products/a1b2c3d4

```json
{
  "productName": "string"
}
```

#### DELETE

Delete a product from database. The id should be pass in path. eg. http://localhost:8080/v1/products/a1b2c3d4

### /v1/products/byId
#### GET

Return a product from database. The id should be pass in path. eg. http://localhost:8080/v1/products/byId/a1b2c3d4

### /v1/products/byName
#### GET

Return a product from database. The name should be pass in path. eg. http://localhost:8080/v1/products/byName/productName

### /v1/products/all
#### GET

Return all products from database sorted by product's name.