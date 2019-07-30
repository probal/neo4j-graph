package com.edu.neo4jgraph.repository;

import com.edu.neo4jgraph.node.Account;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AccountRepository extends Neo4jRepository<Account, Long> {

    Account findByName(String name);
    Account findByNid(String nid);
    Account findByPassport(String name);
    Account findByMobile(String passport);
    Account findByAddress(String address);
}
