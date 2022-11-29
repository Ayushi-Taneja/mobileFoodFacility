#FROM maven:alpine as build
#COPY pom.xml /tmp/
#COPY src /tmp/src/
#WORKDIR /tmp/
#RUN mvn install

#FROM openjdk:17
#ARG JAR_FILE=target/*.jar
#COPY --from=build ${JAR_FILE} app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]