package com.probal.neo4jgraph.node;


import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class Mobile {

    @Id
    @GeneratedValue
    private Long id;
    private String mobile;

    public Mobile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Mobile(String mobile) {
        this.mobile = mobile;
    }
}
