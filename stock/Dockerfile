FROM openjdk:8-jre
ADD target/stock-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8030


COPY splunk-otel-javaagent-all.jar .
ENTRYPOINT ["java","-javaagent:splunk-otel-javaagent-all.jar", "-Dotel.exporter.jaeger.service.name=stock","-jar","./app.jar"]

