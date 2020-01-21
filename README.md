# Car Charging Management Project
The following documentation is for the Java Interview Test for Everon

## Built With

* 	[Maven](https://maven.apache.org/) - Dependency Management
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform, Standard Edition Development Kit 
* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[git](https://git-scm.com/) - Free and Open-Source distributed version control system 
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[Swagger](https://swagger.io/) - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.
*	[Mockito](https://site.mockito.org/) - Mocking framework for unit tests in Java

## External Tools Used

* [Postman](https://www.getpostman.com/) - API Development Environment (Testing Docmentation)


## Running the application locally

To Run the Application locally : 

- Download the zip file
- Unzip the zip file 
- Open Command Prompt and Change directory (cd) to folder containing pom.xml
- Open Eclipse 
   - File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
   - Select the project
- Choose the Spring Boot Application file (search for @SpringBootApplication)
- Right Click on the file and Run as Java Application

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```


### URLs

|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:8080/chargingSessions`    | POST | Custom Response Headers|
|`http://localhost:8080/chargingSessions/Id` | PUT  | 
|`http://localhost:8080/chargingSessions/`   | GET  | 
|`http://localhost:8080/chargingSessions/summary` | GET | |



## Files and Directories

The project (a.k.a. project directory) has a particular directory structure. A representative project is shown below:

```
carchargingmanagement 
├── 
├── src
│   └── main
│       └── java
│           ├── com.everon.carcharging
│           ├── com.everon.carcharging.controller
│           ├── com.arc.application.exception
│           ├── com.arc.application.session
│           ├── com.arc.application.dao
│           └── com.arc.application.service
├── src
│   └── test
│       └── java
│           ├── com.everon.carcharging
│           

├── JRE System Library
├── Maven Dependencies
├── bin
├── logs
│   └── application.log
├── src
├── target
│   └──carchargingmanagement-1.0-SNAPSHOT.jar
├── pom.xml
└── README.md
```

## packages

- `session` — to hold our Objects;
- `dao` — not necessary for this specific usecase but is a good practice to facilitate extensible development and can also facilitate db implementation in future;
- `services` — to hold our business logic;
- `controllers` — to listen to the client;

- `test/` - contains unit and integration tests

- `pom.xml` - contains all the project dependencies
 


