FROM --platform=linux/amd64 maven:3.8.4-openjdk-17-slim AS build
WORKDIR /build
COPY pom.xml ./
COPY src ./src/
RUN mvn clean package -DskipTests


FROM --platform=linux/amd64 eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /build/target/catalog-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=cloud", "catalog-service-0.0.1-SNAPSHOT.jar"]
