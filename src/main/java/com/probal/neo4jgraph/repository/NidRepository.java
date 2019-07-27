package com.probal.neo4jgraph.repository;

import com.probal.neo4jgraph.node.Nid;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface NidRepository extends Neo4jRepository<Nid, Long> {

    List<Nid> findByNid(String nid);
}
