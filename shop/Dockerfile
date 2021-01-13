FROM openjdk:8-jre
ADD target/shop-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE 8010

#COPY signalfx-tracing.jar .
COPY splunk-otel-javaagent-all.jar .
ENTRYPOINT ["java","-javaagent:splunk-otel-javaagent-all.jar", "-Dotel.exporter.jaeger.service.name=shop","-jar","./app.jar"]
