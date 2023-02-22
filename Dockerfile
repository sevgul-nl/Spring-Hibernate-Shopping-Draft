FROM  tomcat:9.0-alpine 
ADD /frontend/target/frontend.war /usr/local/tomcat/webapps/
RUN mkdir -p /h2-data
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]
# CMD /usr/local/tomcat/bin/catalina.sh start && tail -f /usr/local/tomcat/logs/catalina.out


