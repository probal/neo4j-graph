package com.probal.neo4jgraph.node;


import org.neo4j.ogm.annotation.*;

import java.util.List;

@NodeEntity
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

    public Account() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Nid> getNids() {
        return nids;
    }

    public void setNids(List<Nid> nids) {
        this.nids = nids;
    }

    public List<Mobile> getMobiles() {
        return mobiles;
    }

    public void setMobiles(List<Mobile> mobiles) {
        this.mobiles = mobiles;
    }

    public List<Passport> getPassports() {
        return passports;
    }

    public void setPassports(List<Passport> passports) {
        this.passports = passports;
    }
}
