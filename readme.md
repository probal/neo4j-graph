docker run --publish=7474:7474 --publish=7687:7687 neo4j:3.0

http://localhost:8080/swagger-ui.html

MATCH (n:Account) WHERE n.mobile = '01816576058' RETURN n

MATCH (a:Account)<-[:Mobile]-(a:Person)
 RETURN m.title as movie, collect(a.name) as cast
 LIMIT {limit}
 
 MATCH (a:Account)
 MERGE (m:Mobile{mobile:"123"})
 MERGE (a)-[r:test]->(v)