FROM openjdk:8-jre
WORKDIR /app
COPY target/echoserver-1.0.jar /app
CMD ["java", "-cp", "echoserver-1.0.jar", "com.dbattisti.echoserver.EchoServerApp"]