package com.probal.neo4jgraph.resource;

import com.probal.neo4jgraph.node.Company;
import com.probal.neo4jgraph.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/company")
public class CompanyResource {

    @Autowired
    CompanyRepository companyRepository;

    @GetMapping("/all")
    public List<Company> getAllTeam() {
        return (List<Company>) companyRepository.findAll();
    }

    @GetMapping("/{name}")
    public Company getCompanyByName(@PathVariable String name) {
        return companyRepository.findByName(name);
    }

    @PostMapping("/create")
    public String createCompany(@RequestBody Company company) {
        companyRepository.save(company);
        return "Company saved";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteTeam(@PathVariable Integer id) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()) {
            companyRepository.deleteById(id);
            return "Company deleted. " + company.toString();
        } else {
            return "No such company found";
        }
    }
}
