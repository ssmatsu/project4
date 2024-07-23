# Let Docker pull jdk 17 as base image to create our image
FROM openjdk:17-oracle

#Create an argument which contains the jar file path
ARG JAR_FILE=target/*.jar

#Copy jar file as project4.jar
COPY ${JAR_FILE} project4.jar

#Execute jar file
ENTRYPOINT ["java", "-jar", "/project4.jar"]