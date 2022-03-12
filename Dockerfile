FROM oobsri/tomcat8
ADD /frontend/target/frontend.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD [“catalina.sh”, “run”]