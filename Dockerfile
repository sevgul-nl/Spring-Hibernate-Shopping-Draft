FROM tomcat:9.0.59-jdk8-temurin
ADD /frontend/target/frontend.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]