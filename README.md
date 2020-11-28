# spring_boot_microservices
spring_boot_microservices

# Tech Stack and Runtime
# Java 1.8
# Eclipse IDE
# Spring cloud
# Spring boot
# Spring Rest
# Maven


# Eureka Service Registry Server 
This microservice will provide the service registry and discovery server.

# Student Microservice
Which will give some functionality based on Student entity. It will be a rest based service and most importantly it will be a eureka client service, which will talk with eureka service to register itself in the service registry.

# School Microservice – 
Same type as of Student service – only added feature is that it will invoke Student service with service look up mechanism. We will not use absolute URL of student service to interact with that service.
