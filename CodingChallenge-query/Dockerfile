FROM adoptopenjdk/openjdk17:alpine
WORKDIR /app
COPY target/CodingChallenge-query-1.0.jar /app/CodingChallenge-query-1.0.jar
EXPOSE 9090
CMD ["java", "-jar", "CodingChallenge-query-1.0.jar"]