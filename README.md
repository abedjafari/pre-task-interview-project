# warehouse-pre-interview-task
Spring Project

The project is structured as follows:

project-root/
├── src/
|   ├── main/
|   |   ├── java/
|   |   |   ├── com/
|   |   |   |   ├── factory/
|   |   |   |   |   ├── warehouse/
|   |   |   |   |   |   ├── model/
|   |   |   |   |   |   |   └── Deal.java
|   |   |   |   |   ├── service/
|   |   |   |   |   |   ├── ...
|   |   |   |   |   ├── repository/
|   |   |   |   |   |   ├── ...
|   |   |   |   |   ├── controller/
|   |   |   |   |   |   ├── ...
|   |   |   |   |   └── config/
|   |   |   |   |       ├── ...
|   |   |   |   └── ...
|   ├── resources/
|   |   ├── application.properties
|   |   └── ...
|   └── test/
|       ├── java/
|       |   ├── com/
|       |   |   ├── factory/
|       |   |   |   ├── warehouse/
|       |   |   |   |   ├── model/
|       |   |   |   |   |   └── DealTest.java
|       |   |   |   ├── service/
|       |   |   |   |   ├── ...
|       |   |   |   ├── repository/
|       |   |   |   |   ├── ...
|       |   |   |   ├── controller/
|       |   |   |   |   ├── ...
|       |   |   |   └── config/
|       |   |      ├── ...
|       |   └── ...
|   └── ...
└── pom.xml

**Deal Entity**

The Deal entity is defined in the com.factory.warehouse.model package and is responsible for storing information about currency deals. The Deal class is annotated with @Entity, @Data, @Builder, and @NoArgsConstructor.


**Repository Layer**

The Repository layer is primarily concerned with data storage and retrieval.

**Database Configuration**

The project uses MySQL as the underlying database. You need to configure the database connection details in the application.properties file.

**Repository Interface and Implementation**

The Repository layer in Spring uses the Spring Data JPA framework to simplify database operations. In this project, you will find repository interfaces located in the com.your.package.repository package. These interfaces extend the CrudRepository interface provided by Spring Data JPA, which offers predefined methods for basic CRUD operations.

For example, if you have an entity called Deal in the com.your.package.model package, you might have a corresponding repository interface named DealRepository


**Service Layer**

The Service layer in a Spring project is responsible for handling business logic, validations, and coordinating interactions between the Repository and the Presentation layers. This readme.md file focuses on the structure and key concepts of the Service layer in the given com.factory.warehouse.service package.

**DealService Functionality**

The DealService class contains various methods for handling different operations on the Deal entity. Here's a brief overview of each method:

    getDealByUinqueId(Long uniqueId): Retrieves a Deal by its unique ID.
    getAllDeals(): Retrieves a list of all Deal entities.
    createDeal(@Valid DealRequest dealRequest): Creates a new Deal based on the provided DealRequest DTO. It validates the request and saves the new Deal to the database.
    updateDeal(Long uniqueId, @Valid DealRequest dealRequest): Updates an existing Deal with the provided DealRequest DTO. It validates the request, finds the Deal by its unique ID, and updates its fields.
    deleteDeal(Long uniqueId): Deletes a Deal by its unique ID.

**DTOs and Mapping**

The Service layer uses DTOs (Data Transfer Objects) to handle data transfer between layers. In this project, DealRequest and DealResponse DTOs are used to receive and send data, respectively. The mapToDealResponse(Deal deal) method is responsible for mapping a Deal entity to a DealResponse DTO.

**Controller Layer**

The Controller layer in a Spring project is responsible for handling incoming HTTP requests, invoking the appropriate Service layer methods, and returning responses to the clients. In this project, the Controller layer is implemented in the com.factory.warehouse.controller package, with a class named DealController.

**DealController Functionality**

The DealController class contains various methods for handling different HTTP requests related to the Deal entity. Here's a brief overview of each method:

    getAllDeals(): Retrieves a list of all Deal entities and returns it as a response.
    getDealById(@PathVariable Long uniqueId): Retrieves a Deal by its unique ID and returns it as a response.
    createDeal(@RequestBody @Valid DealRequest dealRequest): Creates a new Deal based on the provided DealRequest DTO and returns an HTTP status of 201 (Created).
    updateDeal(@PathVariable @Valid Long uniqueId, @RequestBody @Valid DealRequest dealRequest): Updates an existing Deal with the provided DealRequest DTO and returns the updated DealResponse as a response.
    deleteDeal(@PathVariable Long uniqueId): Deletes a Deal by its unique ID and returns an HTTP status of 200 (OK).

**Request and Response Mapping**

The @RequestMapping("/deals") annotation maps the DealController to the /deals URL path. Each method within the controller is further annotated with specific annotations to handle different HTTP methods and map request parameters.
Controller Interaction with Service Layer

The DealController interacts with the DealService by injecting it as a dependency using the @Autowired annotation. The controller invokes the appropriate service methods based on the incoming HTTP requests and returns the responses.

**Unit Tests**

The unit tests use JUnit 5's @Test annotation and assertions from org.junit.jupiter.api.Assertions. Additionally, the tests use Spring Boot's @SpringBootTest and @ExtendWith(SpringExtension.class) annotations to run the tests in a Spring Boot context.

**DealModelLayerTest Functionality**

The DealModelLayerTest class contains three test methods to verify different aspects of the Deal entity:

    testNotNullFields(): Ensures that the Deal object has non-null values for its fields.
    testNotBlankFields(): Verifies that the fromCurrencyISOCode and toCurrencyISOCode fields are not empty or null.
    testEqualsAndHashCode(): Checks if two Deal objects with equal field values have the same equals() and hashCode() results.

**DealServiceLayerTest Functionality**

The DealServiceLayerTest class contains four test methods to verify different aspects of the DealService:

    testGetDealByUniqueId(): Ensures that the DealService can find a deal by its unique ID by invoking the getDealByUinqueId() method.
    testGetAllDeals(): Verifies that the DealService can retrieve all deals by invoking the getAllDeals() method.
    testCreateDeal(): Checks if the DealService can create a new deal by invoking the createDeal() method.
    testDeleteDeal(): Ensures that the DealService can delete a deal by its unique ID by invoking the deleteDeal() method.
**DealControllerLayerTest Functionality**

The DealControllerLayerTest class contains four test methods to verify different aspects of the DealController:

    testGetAllDeals(): Ensures that the DealController can retrieve all deals by invoking the getAllDeals() method.
    testCreateDeal(): Verifies that the DealController can create a new deal by invoking the createDeal() method.
    testUpdateDeal(): Ensures that the DealController can update a deal by its unique ID by invoking the updateDeal() method.
    testDeleteDeal(): Ensures that the DealController can delete a deal by its unique ID by invoking the deleteDeal() method.

**Database Configuration**

The application.properties file contains the configuration for the MySQL database connection:



# Main database configuration
spring.application.name=warehouse
spring.datasource.url=jdbc:mysql://localhost:3306/warehouse
spring.datasource.username=root
spring.datasource.password=
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

This configuration allows the application to connect to a MySQL database running on localhost with the specified URL, username, password, and driver class. The spring.jpa.hibernate.ddl-auto property ensures that the database schema is created or dropped based on the application's entities.

**H2 Database Support for Testing**

To use the H2 database for testing purposes, uncomment the following lines and update the corresponding properties:



H2 database configuration for testing
spring.datasource.url=jdbc:h2:mem:testdb spring.datasource.driverClassName=org.h2.Driver spring.datasource.username=sa
spring.datasource.password=password

**Server Settings**

The server settings in the application.properties file allow you to specify the port on which the application should run:

**Server settings**

server.port=8054

**Dockerfile and docker compose file are provided in dockerfile folder.** 
