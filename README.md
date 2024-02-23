# Subway Sandwich Truck Order Management System

## Overview
This repository contains two Spring Boot applications for managing orders in a Subway Sandwich Truck Order Management System. The applications are divided into:

1. **CodingChallengeCommandApplication**: This application handles commands related to order management, such as placing new orders.
2. **CodingChallengeQueryApplication**: This application handles queries related to order management, such as retrieving order information.

Additionally, the repository includes a Docker Compose file (`zk-single-kafka-single.yml`) to set up Kafka and Zookeeper for message queuing between the applications.

## Features
- Secure endpoints with Spring Security
- Password encryption using a password encoder
- Utilization of Kafka for asynchronous communication between microservices
- Swagger documentation for API endpoints

## Prerequisites
Before running the projects, ensure you have the following installed:
- Docker
- Docker Compose
- Java Development Kit (JDK) 17
- Maven

## Build, Run, and Usage Instructions
### 1. Start Kafka and Zookeeper
To start Kafka and Zookeeper, run the following command:

docker-compose -f zk-single-kafka-single.yml up -d

### 2. Build and Run CodingChallengeCommandApplication
1. Navigate to the root directory of `CodingChallengeCommandApplication`.
2. Open the `application.properties` file and ensure the configurations are set correctly.
3. Build the application using Maven:
    mvn clean package
4. Run the application using this command:
  mvn spring-boot:run

### 3. Build and Run CodingChallengeQueryApplication
1. Navigate to the root directory of `CodingChallengeQueryApplication`.
2. Open the `application.properties` file and ensure the configurations are set correctly.
3. Build the application using Maven:
    mvn clean package
4. Run the application using this command:
  mvn spring-boot:run

### Swagger Documentation
- Once the applications are running, you can access the Swagger documentation for `CodingChallengeCommandApplication` at:
    
    http://localhost:9090/swagger-ui.html


## Integration with Kafka
- To demonstrate the functionality of Kafka producer and consumer, screenshots of Kafka producer and consumer are provided in the repository.

### Screenshots of Kafka producer and consumer:
- ![kafka consumer](https://github.com/RafrafiNawress/CodingChallenge/assets/47082699/b740a9d8-c0b5-41fa-95e4-2cbd4f0a6676)

![kafka producer](https://github.com/RafrafiNawress/CodingChallenge/assets/47082699/ab38a723-bca9-40ae-9d55-ce841221002c)

By following these instructions, you can set up and run the Subway Sandwich Truck Order Management System and explore its functionalities, including Kafka integration and Swagger documentation.

![addOrder](https://github.com/RafrafiNawress/CodingChallenge/assets/47082699/126eee70-a406-413b-b438-1c201c5a0f8b)

![getIngredients](https://github.com/RafrafiNawress/CodingChallenge/assets/47082699/12ed8530-ec62-478b-be71-608c500fc5f5)


# Thank you ! 
