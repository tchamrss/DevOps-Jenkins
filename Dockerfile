FROM amazoncorretto:25-alpine-jdk

EXPOSE 8080

COPY ./target/java-maven-app-*.jar app.jar

WORKDIR /usr/app

CMD java -jar java-maven-app-*.jar