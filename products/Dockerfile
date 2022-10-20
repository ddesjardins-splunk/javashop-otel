FROM openjdk:8-jre
ADD target/javashop.products-latest.jar app.jar
ADD products.yml app-config.yml
EXPOSE 8020

#COPY splunk-otel-javaagent-all.jar .
ADD https://github.com/signalfx/splunk-otel-java/releases/latest/download/splunk-otel-javaagent-all.jar .

#ENTRYPOINT ["java","-javaagent:splunk-otel-javaagent-all.jar", "-Dotel.exporter.jaeger.service.name=shop","-jar","./app.jar"]
#ENTRYPOINT java -javaagent:splunk-otel-javaagent-all.jar -Dotel.resource.attributes=service.name=shop,environment=${USERNAME}-Apm_Instrumentation_Shop -jar ./app.jar

ENTRYPOINT ["java","-javaagent:splunk-otel-javaagent-all.jar", "-Dotel.exporter.jaeger.service.name=products,environment=${USERNAME}-Apm-Instrumentation_Shop -Dotel.exporter.jaeger.endpoint=https://localhost:9080//v1//trace", "-jar","app.jar", "server", "app-config.yml"]

