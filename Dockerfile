FROM java:7

ENV RELEASE_DATE 2022-01-04
ENV VERSION 2.0.206
ENV H2DATA /h2-data

RUN curl https://github.com/h2database/h2database/releases/download/version-2.0.206/h2-2022-01-04.zip -o h2.zip \
    && unzip h2.zip -d . \
    && rm h2.zip

RUN ln -s $(ls /h2/bin/*jar) /h2/bin/h2.jar

RUN mkdir /docker-entrypoint-initdb.d

VOLUME /h2-data

EXPOSE 8083 9092

COPY docker-entrypoint.sh /usr/local/bin/
ENTRYPOINT ["docker-entrypoint.sh"]

CMD java -cp /h2/bin/h2.jar org.h2.tools.Server \
  -web -webAllowOthers -tcp -tcpAllowOthers -baseDir $H2DATA