FROM openjdk:8-jre

ARG JAR_FILENAME 

ADD maven/${JAR_FILENAME} /app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar", "lco.demo.docker.Main"]
