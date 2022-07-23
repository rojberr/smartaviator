FROM openjdk:17-jdk-alpine

MAINTAINER rojberr <rojberr@outlook.com>

# Add group for spring
RUN addgroup -S spring && adduser -S spring -G spring

# Set user
USER spring:spring

# copy application .jar
ARG JAR_FILE=build/libs/smartaviator-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

# copy testfile.json used for database init
COPY

# expose port
EXPOSE 8080

# start app
ENTRYPOINT ["java","-jar","/app.jar"]