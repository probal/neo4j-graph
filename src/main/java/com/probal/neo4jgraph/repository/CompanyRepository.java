package com.probal.neo4jgraph.repository;

import com.probal.neo4jgraph.node.Company;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CompanyRepository extends Neo4jRepository<Company, Integer> {
    Company findByName(String name);

}
