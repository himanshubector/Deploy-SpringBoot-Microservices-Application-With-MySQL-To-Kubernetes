

FROM openjdk:17-oracle
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} commondtos-service.jar
ENTRYPOINT ["java","-jar","/commondtos-service.jar"]






