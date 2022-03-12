FROM tomcat:jre8-temurin
ADD /frontend/target/frontend.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD [“catalina.sh”, “run”]