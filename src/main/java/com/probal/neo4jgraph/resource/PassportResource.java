package com.probal.neo4jgraph.resource;

import com.probal.neo4jgraph.node.Mobile;
import com.probal.neo4jgraph.node.Passport;
import com.probal.neo4jgraph.repository.MobileRepository;
import com.probal.neo4jgraph.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/passport")
public class PassportResource {

    @Autowired
    PassportRepository passportRepository;

    @PostMapping("/create")
    public String createAccount(@RequestBody Passport passport) {
        passportRepository.save(passport);
        return "Passport saved";
    }
}
