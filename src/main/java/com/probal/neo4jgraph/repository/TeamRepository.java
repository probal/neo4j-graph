package com.probal.neo4jgraph.repository;

import com.probal.neo4jgraph.node.Team;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface TeamRepository extends Neo4jRepository<Team, Integer> {
    Team findByName(String name);
}
