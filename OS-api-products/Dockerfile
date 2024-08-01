#
# Build stage
#
FROM maven:3.9.7-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean install

#
# Package stage
#
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/products-0.0.1-SNAPSHOT.jar products.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","products.jar"]