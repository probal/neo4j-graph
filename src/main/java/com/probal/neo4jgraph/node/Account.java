package com.probal.neo4jgraph.node;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

@NodeEntity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String nid;
    private String mobile;
    private String passport;
    private String address;

    @Relationship(type = "NID_REL", direction = Relationship.INCOMING)
    private List<Nid> nids;

    @Relationship(type = "MOBILE_REL", direction = Relationship.INCOMING)
    private List<Mobile> mobiles;

    @Relationship(type = "PASSPORT_REL", direction = Relationship.INCOMING)
    private List<Passport> passports;

}
