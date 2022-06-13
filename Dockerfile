FROM openjdk:8-alpine
MAINTAINER goba011291@gmail.com
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} WSXaldigital-0.0.1.jar
ENTRYPOINT ["java","-jar","/WSXaldigital-0.0.1.jar"]