package com.edu.neo4jgraph.repository;

import com.edu.neo4jgraph.node.Nid;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface NidRepository extends Neo4jRepository<Nid, Long> {

    List<Nid> findByNid(String nid);
}
