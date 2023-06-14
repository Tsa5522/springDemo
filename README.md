## Springboot Demo

The **Springboot Demo** is a Spring Boot project that incorporates MyBatis and MySQL to create a user management system. This project serves as my first attempt at using Spring Boot and involves the utilization of a local MySQL database named "users". The "users" database contains the following fields: `userId` (auto-incremented), `userName`, `password`, and a `role` for each user.

## Project Description

This project aims to demonstrate the integration of Spring Boot, MyBatis, and MySQL to create a basic user management system. Initially, the project was set up to use a local database. However, I successfully connected to a remote server and ran the clean packaged .jar file by making the necessary changes to the datasource. The application worked properly after the modification.

## Project Goals

The primary goal of this project is to implement a more sophisticated user management system using Spring Boot. By building upon the foundation of this initial attempt, I aim to incorporate additional features and enhance the overall functionality of the application.

## Installation and Setup

To run this project locally, follow these steps:

1. Clone the repository: `git clone https://github.com/Tsa5522/springDemo.git`
2. Navigate to the project directory: `cd repository`
3. Ensure that you have Java Development Kit (JDK) installed and configured(I used JDK 17 as you can see in the pom.xml file).
4. Install the necessary dependencies
5. Modify the database configuration in the `application.yml` file to match your local MySQL setup.
6. Build the project using: `clean package`
7. Run the application using: `java -jar target/project-name.jar`

Please note that you may need to adjust the database configuration and dependencies according to your specific environment.
