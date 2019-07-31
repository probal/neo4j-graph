package com.edu.neo4jgraph.repository;

import com.edu.neo4jgraph.node.Account;
import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.List;

public interface AccountRepository extends Neo4jRepository<Account, Long> {

    List<Account> findByName(String name);
    List<Account> findByNid(String nid);
    List<Account> findByPassport(String passport);
    List<Account> findByMobile(String mobile);
    List<Account> findByAddress(String address);
}
