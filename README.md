# Expense Tracker
## Project Overview

The Expense Tracker is a Spring Boot-based application designed to help users efficiently manage and track their expenses. It offers features such as user authentication,expense logging, categorisation, and report generation.
This application uses Spring Security for authentication,Data JPA for database operations and provides a good robust backend system for managing financial data
## Features
- *User Authentication*: Secure registration, login,and logout using Spring Security.

- *Expense Logging*: User can login expenses with details including amount ,date,description,and category.

- *Expense Categorisation*: Expense can be categorised into predefined groups for easy and better management and analysis.

- *Report Generation*: Users can generate detailed reports based on the date range, category, and expense type. Report are generated in CSV format and saved in Resource folder.

- *Data Validation*: Comprehensive validation and error handling to ensure data integrity and meaningful feedback.

## Technologies

- *Spring Boot*: for the backend framework.
- *Spring Security*: for authentication and authorisation.
- *Spring DataJPA*: for database operations/integration.
- *Database*:MySql or PostgresSql for data storage.
- *Other Dependencies*: Lombok, Apache Commons CSV,etc.

## Getting Started

### Dependencies

- *JDK17*
- *Spring Boot Version*: 3.2.2
- *Maven*
- *PostgresSQL*
### Setup
1. *Clone the repository*: git clone https://github.com
2. *Configure the Database*: Create a database in my PostgresSQL and update
### Reference Documentation


For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.2/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web)
* [Spring Security](https://docs.spring.io/spring-boot/docs/3.2.2/reference/htmlsingle/index.html#web.security)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Securing a Web Application](https://spring.io/guides/gs/securing-web/)
* [Spring Boot and OAuth2](https://spring.io/guides/tutorials/spring-boot-oauth2/)
* [Authenticating a User with LDAP](https://spring.io/guides/gs/authenticating-ldap/)

