### Tech Stacks

* Java 8
* Spring Boot 2.0 with Spring MVC
* Spring Data Jpa
* H2 database
* Open feign as other system client
* Spring cloud contract for contract test


### Quick Start

* Install latest IntelliJ IDEA
* Open project root dir as Gradle project (IDEA will auto recoganize it)
* Run ```BookingServiceApplication.main``` in IDEA
* Or run ```./gradlew bootRun``` in Command Line
* Access ```http://localhost:8080/actuator/health```


### Project Structure

```
.
├── gradle                -- gradle wrapper and code quality check gradle scripts
├── src                   -- source code
    ├── main
        ├── java
            ├── controller         -- api layer
            ├── service            -- business layer
            ├── repository         -- persistence layer
            ├── feign              -- third servce client
            ├── domain             -- domain object
        ├── resources
            ├── schema.sql         -- DDL script
    
    ├── test
            ├── java
                ├── controller         -- test for api layer
                ├── service            -- test for business layer
                ├── repository         -- test persistence layer
                ├── feign              -- test for third servce client
            ├── resources
                ├── contracts          -- contract scripts
```

