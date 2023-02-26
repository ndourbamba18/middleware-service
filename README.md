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

# Building a Middleware Service using Open FeignIntroduction:

#### Introduction

Dans cet demo, je vais montrer comment construire un middleware service en utilisant Spring Boot a l'aide de certaines dependances telles que le Feign client, Lombok etc...
Ce middleware vous permet d'envoyer une requete HTTP a plusieurs API(Application Programming Interface) differentes. Mais il serait
plus facile de combiner uniquement ce dont vous avez besoin de ces differentes API en une seule API.
Un middleware applicatif nous permet d'avoir une source de données uniques et personnalisée. L'un des principaux avantages d'avoir 
un middleware est qu'il connecte de nombreux produits et services differents dans un systeme partagé.
Alors qu'est-ce qu'un middleware exactement?

#### Middleware :
Selon <a href="">Red Had</a>, Les middlewares sont des logiciels et des services en cloud qui fournissent des services et des capacités communs aux applications et aident les développeurs 
et les opérateurs à créer et à déployer des applications plus efficacement. Le middleware agit comme le tissu conjonctif entre les applications, les données et les utilisateurs.

Le middleware fait partie de la terminologie du génie logiciel depuis la fin des années 1960 et, en tant que catégorie, il peut s'appliquer à un large éventail de composants 
logiciels modernes. Le middleware peut inclure des moteurs d'exécution d'applications, l'intégration d'applications d'entreprise et divers types de services en cloud.
La gestion des données, les services d'application, la messagerie, l'authentification et la gestion des interfaces de programmation d'applications (API) sont tous couramment 
traités par les middlewares.

Aujourd'hui, le middleware est la base technologique des architectures cloud-native modernes. Pour les organisations disposant d'environnements multi-clouds et conteneurisés, 
les middlewares peuvent rendre rentables le développement et l'exécution d'applications à grande échelle.

#### Feign :

Le feign est un service Web déclaratif créé par Netflix qui fournit un degré élevé d'abstraction pour effectuer des appels d'API REST(Representational State Transfer).
De meme, il supprime le besoin d'écrire des codes de requetes HTTP de base tout en offrant simultanément efficacité et netteté au code source.

Par souci de simplicité, nous ferons des appels a un vrai service d'API REST nommé `employee-backend-service` utilisé pour les tests.

A la fin de cet article, le lecteur doit comprendre ce qu'est un middleware et savoir quand et comment l'utitliser.De meme, ils doivent se familiariser avec le service Web de Feign Client.

### Technologies utilises:

Java 17
Spring Boot 2.6.4
Maven
Lombok
Docker Desktop
IntelliJ Ultumate
Postman

### Commençons:

Tout d'abord, nous devons creer deux projets Spring Boot. Pour ce faire, nous utilisons <a href="">Spring Initializr<a>.Ensuite, nous ajouterons pour chaque projet les dependances telles que :

<dependances>

</dependances>

En cliquant sur "Generate", un dossier zip sera telecharger. Extrayez le contenu, puis ouvrez le projet avec un IDE. L'IDE que j'utiliserai est IntelliJ.

Pour cet demo, j'ai juste prefere de ne pas utiliser une base de donnees. Je vais stocker les donnees de chacune des applications dans un tableau dynamique Java(ArrayList}.
### NB:
A chaque fois que vous redemarrez l'application, vous perdrez toutes les donnees que vous avez deja enregistre via l'API REST.

