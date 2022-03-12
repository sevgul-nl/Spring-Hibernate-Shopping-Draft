FROM tomcat:9.0.59-jdk8-temurin

ENV RELEASE_DATE 2019-10-14
ENV H2DATA /h2-data

RUN curl http://www.h2database.com/h2-$RELEASE_DATE.zip -o h2.zip \
    && unzip h2.zip -d . \
    && rm h2.zip

VOLUME /h2-data

EXPOSE 9092 9092

CMD java -cp /h2/bin/h2*.jar org.h2.tools.Server \
  -web -webAllowOthers -tcp -tcpAllowOthers -baseDir $H2DATA
ADD /frontend/target/frontend.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["/usr/local/tomcat/bin/catalina.sh", "run"]



