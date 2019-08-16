package com.edu.neo4jgraph.resource;

import com.edu.neo4jgraph.node.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginResource {

    @PostMapping("/login")
    public String createAccount(@ModelAttribute User user) {
        return "index";
    }
}
