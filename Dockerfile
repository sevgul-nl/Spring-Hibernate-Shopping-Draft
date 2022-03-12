FROM arm32v7/tomcat:9-jdk15-adoptopenjdk-hotspot
ADD /frontend/target/frontend.war sphib-shopping.war
ENTRYPOINT ["java", "-jar","sphib-shopping.jar"]
EXPOSE 8080