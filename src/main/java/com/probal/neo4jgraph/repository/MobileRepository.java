package com.probal.neo4jgraph.repository;

import com.probal.neo4jgraph.node.Mobile;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface MobileRepository extends Neo4jRepository<Mobile, Long> {
    List<Mobile> findByMobile(String mobile);
}
