FROM arm32v7/openjdk
ADD /snl-SAShopping/frontend/target/frontend.jar sphib-shopping.jar
ENTRYPOINT ["java", "-jar","sphib-shopping.jar"]
EXPOSE 8080