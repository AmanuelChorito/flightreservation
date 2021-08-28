FROM openjdk:8
ADD target/flightreservation-springboot-api.jar flightreservation-springboot-api.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","flightreservation-springboot-api.jar"]