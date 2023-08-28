
FROM openjdk:17-oracle
EXPOSE 8081
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/user-service.jar
COPY --from=commondtos-service:latest /app/data /app

#ENTRYPOINT ["java","-jar","/app/commondtos-service.jar"]
#ENTRYPOINT ["java","-cp","user-service.jar:/app/* com.javatechie.hims.user.UserServiceApplication"]
ENTRYPOINT ["java","-jar","/app/user-service.jar"]
# ENTRYPOINT ["java", "-cp", "/app/data:/app/user-service.jar", "UserServiceApplication"]

