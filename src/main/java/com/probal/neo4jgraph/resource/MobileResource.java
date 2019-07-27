package com.probal.neo4jgraph.resource;

import com.probal.neo4jgraph.node.Mobile;
import com.probal.neo4jgraph.repository.MobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/mobile")
public class MobileResource {

    @Autowired
    MobileRepository mobileRepository;

    @PostMapping("/create")
    public String createAccount(@RequestBody Mobile mobile) {
        mobileRepository.save(mobile);
        return "Mobile saved";
    }
}
