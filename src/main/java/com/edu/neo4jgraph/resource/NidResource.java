package com.edu.neo4jgraph.resource;

import com.edu.neo4jgraph.node.Nid;
import com.edu.neo4jgraph.repository.NidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nid")
public class NidResource {

    @Autowired
    NidRepository nidRepository;

    @PostMapping("/create")
    public String createAccount(@RequestBody Nid nid) {
        nidRepository.save(nid);
        return "NID saved";
    }
}
