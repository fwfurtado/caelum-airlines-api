FROM openjdk:11-jdk-slim as compile-stage

WORKDIR /cline

COPY pom.xml mvnw  /cline/
COPY .mvn/ /cline/.mvn/

RUN ./mvnw --no-transfer-progress dependency:go-offline

COPY src/ /cline/src/

RUN ./mvnw package

FROM openjdk:11-jre-slim

WORKDIR /cline

COPY --from=compile-stage /cline/target/api-0.0.1-SNAPSHOT.jar /cline/app.jar

ENV JAVA_OPTS ''

EXPOSE 8080

CMD java $JAVA_OPTS -jar app.jar