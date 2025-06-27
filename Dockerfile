FROM amazoncorretto:17.0.7-alpine
WORKDIR  /app/code
ENV DATABASE_PATH=/app/code/h2db/springboot
COPY target/all-concepts-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]