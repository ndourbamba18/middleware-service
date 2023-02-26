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

![spring-boot-mongodb](https://user-images.githubusercontent.com/97687670/173395599-ccb75ce4-2c4d-41bf-9d88-2546a684c99e.PNG)

#### Introduction

<p>Dans cet demo, je vais montrer comment construire un middleware service en utilisant Spring Boot a l'aide de certaines dependances telles que le Feign client, Lombok etc...
Ce middleware vous permet d'envoyer une requete HTTP a plusieurs API(Application Programming Interface) differentes. Mais il serait
plus facile de combiner uniquement ce dont vous avez besoin de ces differentes API en une seule API.
Un middleware applicatif nous permet d'avoir une source de données uniques et personnalisée. L'un des principaux avantages d'avoir 
un middleware est qu'il connecte de nombreux produits et services differents dans un systeme partagé.
Alors qu'est-ce qu'un middleware exactement?</p>

#### Middleware :
<p>Selon <a href="https://www.redhat.com/en/topics/middleware/what-is-middleware">Red Had</a>, Les middlewares sont des logiciels et des services en cloud qui fournissent des services et des capacités communs aux applications et aident les développeurs 
et les opérateurs à créer et à déployer des applications plus efficacement. Le middleware agit comme le tissu conjonctif entre les applications, les données et les utilisateurs.</p>

<p>Le middleware fait partie de la terminologie du génie logiciel depuis la fin des années 1960 et, en tant que catégorie, il peut s'appliquer à un large éventail de composants 
logiciels modernes. Le middleware peut inclure des moteurs d'exécution d'applications, l'intégration d'applications d'entreprise et divers types de services en cloud.
La gestion des données, les services d'application, la messagerie, l'authentification et la gestion des interfaces de programmation d'applications (API) sont tous couramment traités par les middlewares.</p>

<p>Aujourd'hui, le middleware est la base technologique des architectures cloud-native modernes. Pour les organisations disposant d'environnements multi-clouds et conteneurisés, 
les middlewares peuvent rendre rentables le développement et l'exécution d'applications à grande échelle.</p>

#### Feign :

<p>Le feign est un service Web déclaratif créé par Netflix qui fournit un degré élevé d'abstraction pour effectuer des appels d'API REST(Representational State Transfer). De meme, il supprime le besoin d'écrire des codes de requetes HTTP de base tout en offrant simultanément efficacité et netteté au code source.</p>

<p>Par souci de simplicité, nous ferons des appels a un vrai service d'API REST nommé `employee-backend-service` utilisé pour les tests.</p>

<p>A la fin de cet article, le lecteur doit comprendre ce qu'est un middleware et savoir quand et comment l'utitliser.De meme, ils doivent se familiariser avec le service Web de Feign Client.</p>

### Technologies utilises:

- Java 17
- Spring Boot 2.6.4
- Maven
- Lombok
- Docker Desktop
- IntelliJ Ultumate
- Postman

### Commençons:

<p>Tout d'abord, nous devons créer deux projets Spring Boot. Pour ce faire, nous utilisons <a href="https://start.spring.io/">Spring Initializr<a>.Ensuite, nous ajouterons pour chaque projet les dependances telles que :</p>

 ##### pom.xml pour `employee-backend-service`
 
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

 ##### pom.xml pour `department-backend-service`
 
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

<p>En cliquant sur "Generate", un dossier zip sera télécharger. 
  Extrayez le contenu, puis ouvrez le projet avec un IDE. 
  L'IDE que j'utiliserai est IntelliJ.</p>

<p>Pour cet demo, j'ai juste préféré de ne pas utiliser une base de données.
 Je vais stocker les données de chacune des applications dans un tableau dynamique Java(ArrayList).</p>
#### NB:
<p>N'oubliez pas qu'à chaque fois que vous redémarrez l'application, vous perdrez toutes les données que vous avez déjà 
	enregistré via l'API REST.</p>

 ### Configure Spring Datasource, App properties
Oovrez `src/main/resources/application.properties`
 
- Pour `employee-backend-service`:
```
### application.properties
 
##### Server Configuration
server.port = 8082

##### Application Name
spring.application.name = "employee-service"

```
- Pour `department-backend-service`
```
 ### application.properties
##### Server Configuration
server.port = 8081

##### Application Name
spring.application.name = "department-service"
 
```
 
 ### Architecture des projets
 
 - Pour `employee-backend-service`
 
 ![Project](https://user-images.githubusercontent.com/97687670/173406499-b44a75b6-aa2d-4929-a2fe-98497827dba4.PNG)
 
 - Pour `department-backend-service`
 
 ![Project](https://user-images.githubusercontent.com/97687670/173406499-b44a75b6-aa2d-4929-a2fe-98497827dba4.PNG)

 
 ##  Spring Boot 
 
 ```
 mvn clean install
 
 mvn spring-boot:run
```
 
 ### Testing With Postman
 
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
