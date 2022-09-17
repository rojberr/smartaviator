FROM openjdk:17-jdk-alpine3.14

LABEL maintainer="rojberr"
LABEL build_date="2022-09-17"

# Add group for spring
RUN addgroup -S spring && adduser -S spring -G spring

# Set user
USER spring:spring

# copy application .jar
ARG JAR_FILE=build/libs/smartaviator-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# copy testfiles .json used for database init
COPY src/main/resources /

# expose port
EXPOSE 8080

# start app
ENTRYPOINT ["java","-jar","/app.jar"]