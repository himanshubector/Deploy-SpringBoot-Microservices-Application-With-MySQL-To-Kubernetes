


FROM openjdk:17-oracle
EXPOSE 8081

# WORKDIR /app

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} user-service.jar
ENTRYPOINT ["java","-jar","/user-service.jar"]


#COPY target/user-service.jar /app/user-service.jar
#COPY lib/* /app/lib/
#CMD ["java", "-cp", ".:/app/lib/*", "-jar", "user-service.jar"]





