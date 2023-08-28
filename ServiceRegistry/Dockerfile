
# FROM openjdk:17-jdk-alpine
# FROM openjdk:17-jdk-slim
# openjdk:17-jdk-slim-buster
FROM openjdk:17-oracle
EXPOSE 8761
ARG JAR_FILE=target/*.jar
# ADD target/springboot-crud-k8s.jar springboot-crud-k8s.jar
# ADD target/*.jar springboot-k8s-demo.jar
COPY ${JAR_FILE} service-registry.jar
#COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/service-registry.jar"]
