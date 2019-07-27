package com.probal.neo4jgraph.resource;

import com.probal.neo4jgraph.node.Employee;
import com.probal.neo4jgraph.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeResource {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/all")
    public List<Employee> getAllTeam() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @GetMapping("/{name}")
    public Employee getEmployeeByName(@PathVariable String name) {
        return employeeRepository.findByName(name);
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody Employee employee) {
        employeeRepository.save(employee);
        return "Employee saved";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Integer id) {
        employeeRepository.deleteById(id);
        return "Employee deleted id: " + id;
    }
}
