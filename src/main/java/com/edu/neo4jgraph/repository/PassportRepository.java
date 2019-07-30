package com.edu.neo4jgraph.repository;

import com.edu.neo4jgraph.node.Passport;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface PassportRepository extends Neo4jRepository<Passport, Long> {
    List<Passport> findByPassport(String passport);
}
