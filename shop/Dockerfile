FROM openjdk:8-jre
ADD target/javashop.shop-latest.jar ./app.jar
EXPOSE 8010

#COPY signalfx-tracing.jar .
#COPY splunk-otel-javaagent-all.jar .
ADD https://github.com/signalfx/splunk-otel-java/releases/latest/download/splunk-otel-javaagent-all.jar .
ENTRYPOINT ["java","-javaagent:splunk-otel-javaagent-all.jar", "-Dotel.exporter.jaeger.service.name=shop","-jar","./app.jar"]
