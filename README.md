Middleware Service using Open Feign

# Spring Boot and MongoDB REST API Crud Example

### E-Commerce Backend Application using Spring Boot & MySQL and Spring Data JPA & JWT

> [E-Commerce Rest Api Backend App](https://github.com/ndourbamba18/ecommerce-spring-api-rest)

## Crud Rest Api using Spring Boot & MongoDB

> [Spring Boot + MongoDB](https://github.com/ndourbamba18/spring-mongodb-rest-api-crud-example)


## Backend Authentication

> [Spring Boot + JWT Authentication + MySQL](https://github.com/ndourbamba18/user-registration-jwt-api-rest)

## Backend CRUD App

> [Spring Boot + MySQL Example Company Service App](https://github.com/ndourbamba18/company-service)

> [Spring Boot + Spring MVC + MySQL Example Employee Manager App ](https://github.com/ndourbamba18/spring-boot-mvc-employee-manager)

> [Spring Boot + Java Mail Sender Example Contact Form](https://github.com/ndourbamba18/contact-form)

> [Spring Boot + MySQL Example Training App](https://github.com/ndourbamba18/training-rest-api)

> [Aws amazon lambda using Spring Boot](https://github.com/ndourbamba18/aws-amazon-lambda-backend-using-spring-boot)

## Front End

> [Angular Basic Example](https://github.com/ndourbamba18/angular-app)

> [Frontend App With Angular](https://github.com/ndourbamba18/aws-amazon-lambda-using-angular)

## Microservices:
> [Spring Boot + MySQL + Rest Template](https://github.com/ndourbamba18/Microservices)
 
> [Spring Boot + MySQL + Open Feign](https://github.com/ndourbamba18/SpringBoot-Microservices-Using-FeignClients)

> [Spring Boot + MySQL + Rest Template](https://github.com/ndourbamba18/spring-boot-rest-template)

### More Practice:

> [Spring Boot + MySQL Example Microservice](https://github.com/ndourbamba18/SpringBoot-Microservices)

>  [Django + SQlite3 Example Login and Registration User](https://github.com/ndourbamba18/login-registration-app)

> [Spring Boot + MySQL Example Customer App](https://github.com/ndourbamba18/customer-app)

# Building a REST API using Spring Boot & MongoDB

![image-project](https://user-images.githubusercontent.com/97687670/173406465-825fddc2-2727-4d0d-9e76-31a7704dd3aa.png)

In this demo we are going to learn how to build a simple crud rest api backend application using Spring Boot and MongoDB.

### Prerequisites
In order to complete this tutorial, you should have knowledge of beginner or intermediate Java 8 programming skills, some familiarity with Spring Boot, and also you should have a general familiarity with the Windows command prompt.
#### Tools Used in this Project
- Java 11
- Spring Boot 2.6.6
- Maven
- Lombok
- Intelli J
- MongoDB 5.0
- Postman

## Install and Launch MongoDB
To start working with MongoDB, first, we have to install it on our local machines. Go to the MongoDB website and download the MongoDB installer from the downloads section.

Once the download is complete double click the file and follow the prompts to install Mongo. Mongo is most likely to be installed in the “C:\Program Files\MongoDB..” directory unless you specify a custom path.

Open a command prompt window and direct it to the bin folder inside the MongoDB folder path.

### Let's start the server
![Capture](https://user-images.githubusercontent.com/97687670/173399458-eae551e5-905d-4260-8d3b-f0c33c1f0e06.PNG)
### Server started
![Capture02](https://user-images.githubusercontent.com/97687670/173399485-03942c01-90fb-413a-9a2a-29078e1e0424.PNG)
### Let's create a new Database and a new Collection
![Capture03](https://user-images.githubusercontent.com/97687670/173399498-9ae6942d-50ca-400e-8291-fed8ca8e1d3a.PNG)

## Spring Boot MongoDB APIs
We will have the following functionalities and Database interactions in our app.

- Get all employees
- Get a employee with ID
- Save a employee
- Update a employee
- Delete a employee

### Spring Boot Project Setup
We will make use of the Spring Initializr tool for quickly setting up the project. Don’t forget to add the dependencies Spring WEB & Spring Data MongoDB.  
![spring-boot-mongodb](https://user-images.githubusercontent.com/97687670/173395599-ccb75ce4-2c4d-41bf-9d88-2546a684c99e.PNG)
### All Dependencies

- Spring Data MongoDB
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>
```
- Spring Web
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
- Lombok
```xml
<dependency>
  <groupId>org.projectlombok</groupId>
  <artifactId>lombok</artifactId>
  <optional>true</optional>
</dependency>
``` 
- dev tools
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
```
- Spring Validator
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
 ```  
### Configure Spring Datasource, MongoDB, App properties
Open `src/main/resources/application.properties`
- For application.properties:
```
# MongoDB
spring.data.mongodb.host=[host]
spring.data.mongodb.port=[port]
spring.data.mongodb.username=[username]
spring.data.mongodb.password=[password]
spring.data.mongodb.database=[database_name]
spring.application.name=[Your Application Name]
spring.banner.charset=[UTF-8]
# logging
logging.level.org.springframework.data=debug
logging.level.=error
```
- For application.yml
```
spring:
  data:
     mongodb:
        authentication-database: admin
        port: 27017
        host: localhost
        database: EmployeeBackend
  application:
     name: employee-rest-api

  banner:
    charset: UTF-8
 
```
### Now you can see the project

![Project](https://user-images.githubusercontent.com/97687670/173406499-b44a75b6-aa2d-4929-a2fe-98497827dba4.PNG)

## Download All Packages
```
mvn package
```

## Running the Project and Testing with Postman
Now let’s test our API calls using postman. Right-click on the project and select Run as a Spring boot App.

## Run Spring Boot application
```
mvn spring-boot:run
```
![running](https://user-images.githubusercontent.com/97687670/173396186-612fc4d8-6d4b-47f1-b30f-1e1a68108305.PNG)

## Postman
Testing With Postman

### Get all employees 
![00](https://user-images.githubusercontent.com/97687670/173397128-f38ab287-b7f4-4ccd-8618-d7bff4e3bb49.PNG)
### Save employee
![01](https://user-images.githubusercontent.com/97687670/173397164-347b38da-8d3c-4e71-9946-77eba1a33000.PNG)
### Save employee again
![02](https://user-images.githubusercontent.com/97687670/173397181-6c4f2824-62df-4d5c-a98c-a38c64dfe23a.PNG)
### Get all employees
![05](https://user-images.githubusercontent.com/97687670/173397590-9176a395-7c8a-41f6-bbdd-61ea68989687.PNG)
### Get employee by id
![03](https://user-images.githubusercontent.com/97687670/173400014-eb236cc7-a5a9-4d7f-8acb-50727cd582dc.PNG)
### Get employee by a valid id
![04](https://user-images.githubusercontent.com/97687670/173399137-185424c2-7b6b-4ecb-8b11-abc78884baec.PNG)
### Edit employee by id
![edit](https://user-images.githubusercontent.com/97687670/173397899-6c0f28f6-1ee1-4d0c-a16d-56e46dc0a2ce.PNG)
### Delete employee by id
![delete](https://user-images.githubusercontent.com/97687670/173397922-dfa3d458-b73e-45b6-87fd-09645791343b.PNG)
### Get the number of employees that exist in the database
![count](https://user-images.githubusercontent.com/97687670/173397936-1e367496-f5f6-4400-a0b7-bebb356532c7.PNG)
### All data in the database
![all-data](https://user-images.githubusercontent.com/97687670/173398034-9bf9c736-aa16-4446-b1e0-acc485183765.PNG)


## Other branches

> [main](!#)

> [docker-compose-demo](!#)

> [Swagger-demo](!#)

