FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/demo.war
COPY ${JAR_FILE} demo.war
ENTRYPOINT ["java","-jar","/demo.war"]