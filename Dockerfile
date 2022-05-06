FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/magic-0.0.1-SNAPSHOT.jar magic-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/magic-0.0.1-SNAPSHOT.jar"]