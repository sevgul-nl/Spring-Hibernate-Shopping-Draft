FROM arm32v7/tomcat:9-jdk15-adoptopenjdk-hotspot
ADD /frontend/target/frontend.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD [“catalina.sh”, “run”]