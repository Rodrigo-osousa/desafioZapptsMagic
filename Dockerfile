FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/magic.jar magic.jar
ENTRYPOINT ["java","-jar","/magic.jar"]