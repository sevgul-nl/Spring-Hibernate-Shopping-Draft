FROM openjdk:8
ADD frontend/target/frontend.jar sphib-shopping.jar
ENTRYPOINT ["java", "-jar","sphib-shopping.jar"]
EXPOSE 8080