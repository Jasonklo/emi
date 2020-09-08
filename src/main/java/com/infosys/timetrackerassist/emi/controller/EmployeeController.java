package com.infosys.timetrackerassist.emi.controller;

import com.infosys.timetrackerassist.emi.entity.Employee;
import com.infosys.timetrackerassist.emi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;
import java.net.URI;


@RestController
@RequestMapping(path="/employees", produces="application/json")
@CrossOrigin(origins = "*")
public class EmployeeController {

    private EmployeeRepository repo;

    @Autowired
    public EmployeeController(EmployeeRepository repo)
    {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Employee> allEmployees() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> byId(@PathVariable int id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        if (employee.getEmpId()!=(id)) {
            throw new IllegalStateException("Given employee's ID doesn't match the ID in the path.");
        }
        repo.save(employee);
    }

    @PostMapping
    public ResponseEntity<Employee> postEmployee(@RequestBody Employee employee) {
        Employee saved = repo.save(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/employees/" + employee.getEmpId()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id) {
        repo.deleteById(id);
    }

}
