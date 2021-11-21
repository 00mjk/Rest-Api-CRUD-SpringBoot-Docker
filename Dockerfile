FROM openjdk:8
EXPOSE 8080
ADD target/my-employee-crud-rest-api.jar my-employee-crud-rest-api.jar
ENTRYPOINT ["java", "-jar", "/my-employee-crud-rest-api.jar"]