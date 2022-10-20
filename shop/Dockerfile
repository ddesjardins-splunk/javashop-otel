FROM openjdk:8-jre
ADD target/javashop.shop-latest.jar ./app.jar
EXPOSE 8010

ADD https://github.com/signalfx/splunk-otel-java/releases/latest/download/splunk-otel-javaagent-all.jar .

ENTRYPOINT java -javaagent:splunk-otel-javaagent-all.jar -Dotel.resource.attributes=service.name=shop,environment=${USERNAME}-Apm_Instrumentation_Shop -jar ./app.jar

