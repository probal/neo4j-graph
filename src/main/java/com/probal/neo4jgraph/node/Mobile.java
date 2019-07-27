package com.probal.neo4jgraph.node;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mobile {

    @Id
    @GeneratedValue
    private Long id;
    private String mobile;

    public Mobile(String mobile) {
        this.mobile = mobile;
    }
}
