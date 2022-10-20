FROM openjdk:8-jre
ADD target/javashop.stock-latest.jar app.jar
EXPOSE 8030


#COPY splunk-otel-javaagent-all.jar .
ADD https://github.com/signalfx/splunk-otel-java/releases/latest/download/splunk-otel-javaagent-all.jar .


ENTRYPOINT ["java","-javaagent:splunk-otel-javaagent-all.jar", "-Dotel.exporter.jaeger.service.name=stock,environment=${USERNAME}-Apm-Workshop -Dotel.exporter.jaeger.endpoint=https://localhost:9080/v1/trace", "-jar", "app.jar"]

