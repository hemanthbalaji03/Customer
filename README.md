# Customer Service

Minimal microservice (Java + Spring Boot) with CRUD on /api/customers.

Requirements:
- Java 17+
- Maven

Run locally:
1. mvn clean package
2. java -jar target/customer-service-0.0.1-SNAPSHOT.jar

Or run with Docker:
1. mvn clean package
2. docker build -t customer-service .
3. docker run -p 8080:8080 customer-service

API examples:
- Create:
  curl -X POST -H "Content-Type: application/json" -d '{"name":"Alice","email":"alice@example.com"}' http://localhost:8080/api/customers

- List:
  curl http://localhost:8080/api/customers

- Get:
  curl http://localhost:8080/api/customers/1

- Update:
  curl -X PUT -H "Content-Type: application/json" -d '{"name":"Alice B","email":"aliceb@example.com"}' http://localhost:8080/api/customers/1

- Delete:
  curl -X DELETE http://localhost:8080/api/customers/1

H2 console:
- http://localhost:8080/h2-console
  JDBC URL: jdbc:h2:mem:customerdb
