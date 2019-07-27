package com.probal.neo4jgraph.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Team {

    @Id
    private Integer id;
    private String name;
    private String country;

    @Relationship(type = "Employee", direction = Relationship.INCOMING)
    private List<Employee> employees;

}
