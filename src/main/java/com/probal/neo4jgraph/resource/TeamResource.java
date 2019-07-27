package com.probal.neo4jgraph.resource;

import com.probal.neo4jgraph.node.Team;
import com.probal.neo4jgraph.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamResource {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping("/all")
    public List<Team> getAllTeam() {
        return (List<Team>) teamRepository.findAll();
    }

    @GetMapping("/{name}")
    public Team getTeamByName(@PathVariable String name) {
        return teamRepository.findByName(name);
    }

    @PostMapping("/create")
    public String createTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return "Team saved";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCompany(@PathVariable Integer id) {
        teamRepository.deleteById(id);
        return "Team deleted id: " + id;
    }
}
