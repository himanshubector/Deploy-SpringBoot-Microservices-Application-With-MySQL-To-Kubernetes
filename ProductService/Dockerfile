

FROM openjdk:17-oracle
EXPOSE 8082
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} product-service.jar
CMD ["java","-jar","/product-service.jar"]






