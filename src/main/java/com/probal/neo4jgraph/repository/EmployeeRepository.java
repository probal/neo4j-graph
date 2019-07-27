package com.probal.neo4jgraph.repository;

import com.probal.neo4jgraph.node.Employee;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EmployeeRepository extends Neo4jRepository<Employee, Integer> {
    Employee findByName(String name);
}
