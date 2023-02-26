# Middleware Service using Open Feign

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

# Building a Middleware Service using Open Feign:

#### Introduction

Dans cet demo, je vais montrer comment construire un middleware service en utilisant Spring Boot a l'aide de certaines dependances telles que le Feign client, Lombok etc...
Ce middleware vous permet d'envoyer une requete HTTP a plusieurs API(Application Programming Interface) differentes. Mais il serait
plus facile de combiner uniquement ce dont vous avez besoin de ces differentes API en une seule API.
Un middleware applicatif nous permet d'avoir une source de données uniques et personnalisée. L'un des principaux avantages d'avoir 
un middleware est qu'il connecte de nombreux produits et services differents dans un systeme partagé.
Alors qu'est-ce qu'un middleware exactement?

#### Middleware :
Selon <a href="https://www.redhat.com/en/topics/middleware/what-is-middleware">Red Had</a>, Les middlewares sont des logiciels et des services en cloud qui fournissent des services et des capacités communs aux applications et aident les développeurs 
et les opérateurs à créer et à déployer des applications plus efficacement. Le middleware agit comme le tissu conjonctif entre les applications, les données et les utilisateurs.

Le middleware fait partie de la terminologie du génie logiciel depuis la fin des années 1960 et, en tant que catégorie, il peut s'appliquer à un large éventail de composants 
logiciels modernes. Le middleware peut inclure des moteurs d'exécution d'applications, l'intégration d'applications d'entreprise et divers types de services en cloud.
La gestion des données, les services d'application, la messagerie, l'authentification et la gestion des interfaces de programmation d'applications (API) sont tous couramment traités par les middlewares.

Aujourd'hui, le middleware est la base technologique des architectures cloud-native modernes. Pour les organisations disposant d'environnements multi-clouds et conteneurisés, 
les middlewares peuvent rendre rentables le développement et l'exécution d'applications à grande échelle.

#### Feign :

Le feign est un service Web déclaratif créé par Netflix qui fournit un degré élevé d'abstraction pour effectuer des appels d'API REST(Representational State Transfer). De meme, il supprime le besoin d'écrire des codes de requetes HTTP de base tout en offrant simultanément efficacité et netteté au code source.

Par souci de simplicité, nous ferons des appels a un vrai service d'API REST nommé `employee-backend-service` utilisé pour les tests.

A la fin de cet article, le lecteur doit comprendre ce qu'est un middleware et savoir quand et comment l'utitliser.De meme, ils doivent se familiariser avec le service Web de Feign Client.

### Technologies utilises:

- Java 17
- Spring Boot 2.6.4
- Maven
- Lombok
- Docker Desktop
- IntelliJ Ultumate
- Postman

### Commençons:

Tout d'abord, nous devons créer deux projets Spring Boot. Pour ce faire, nous utilisons <a href="https://start.spring.io/">Spring Initializr<a>.Ensuite, nous ajouterons pour chaque projet les dependances telles que :

- pom.xml pour `employee-backend-service`
 
 ```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.ndourcodeur</groupId>
	<artifactId>employee-backend-service</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>employee-backend-service</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
		<spring-cloud.version>2021.0.0</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	
	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

```xml  
###
- pom.xml pour `department-backend-service`
 
 ```xml
 
 <?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.4</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.ndourcodeur</groupId>
	<artifactId>department-backend-service</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>department-backend-service</name>
	<description>Demo project for Spring Boot</description>
	<properties>
		<java.version>17</java.version>
		<spring-cloud.version>2021.0.0</spring-cloud.version>
	</properties>
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>
	
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	
	</dependencies>
	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<excludes>
						<exclude>
							<groupId>org.projectlombok</groupId>
							<artifactId>lombok</artifactId>
						</exclude>
					</excludes>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>

 ```xml
-

En cliquant sur "Generate", un dossier zip sera télécharger. Extrayez le contenu, puis ouvrez le projet avec un IDE. L'IDE que j'utiliserai est IntelliJ.

Pour cet demo, j'ai juste préféré de ne pas utiliser une base de données.
Je vais stocker les données de chacune des applications dans un tableau dynamique Java(ArrayList).
# NB:
N'oubliez pas qu'à chaque fois que vous redémarrez l'application, vous perdrez toutes les données que vous avez déjà enregistré via l'API REST.

- Configure Spring Datasource, App properties
Ouvrez `src/main/resources/application.properties`
 
- Pour `employee-backend-service`:
server.port = 8082	
spring.application.name = "employee-service"

- Pour `department-backend-service`
server.port = 8081
spring.application.name = "department-service"
 
# Architecture des projets
 
 - Pour `employee-backend-service`
 
![employee-service-project](https://user-images.githubusercontent.com/82464964/221434220-2cadbe3b-aa7a-4d49-b880-3f73f85f6e38.PNG)
 
 - Pour `department-backend-service`
 
![department-service-project](https://user-images.githubusercontent.com/82464964/221434204-48e6b34f-4236-42e2-9b20-e54be1222ad2.PNG)

 
 ##  Run les projets Spring Boot 
 
 ```
 mvn clean install
 
 mvn spring-boot:run
```
 - Pour `employee-backend-service`
	
![employee-server](https://user-images.githubusercontent.com/82464964/221433997-cacd9f67-bd83-44c0-b9d3-4d325a27a73a.PNG)
	
- Pour `department-backend-service`
	
![department-server](https://user-images.githubusercontent.com/82464964/221433980-72407676-edbf-4895-82b6-e6f0291366c7.PNG)
	
 ### Postman pour tester les APIs
 
 <a href="">Les captures d'ecrans</a>
