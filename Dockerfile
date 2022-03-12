FROM arm32v7/openjdk
ADD /frontend/target/frontend.jar sphib-shopping.jar
ENTRYPOINT ["java", "-jar","sphib-shopping.jar"]
EXPOSE 8080