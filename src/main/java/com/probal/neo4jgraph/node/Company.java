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
public class Company {

    @Id
    private Integer id;
    private String name;

    @Relationship(type = "Team", direction = Relationship.INCOMING)
    private List<Team> teams;
}
