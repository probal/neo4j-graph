FROM openjdk:8
ADD target/neo4j-graph.jar neo4j-graph.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "neo4j-graph.jar"]