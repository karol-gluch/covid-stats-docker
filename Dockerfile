FROM openjdk:17
ADD target/covid_stats-0.0.1-SNAPSHOT.jar .
EXPOSE 8000
CMD java -jar covid_stats-0.0.1-SNAPSHOT.jar
