package com.infosys.timetrackerassist.emi.controller;


import com.infosys.timetrackerassist.emi.entity.Group;
import com.infosys.timetrackerassist.emi.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(path="/groups", produces="application/json")
@CrossOrigin(origins = "*")
public class GroupController {

    private GroupRepository repo;

    @Autowired
    public GroupController(GroupRepository repo)
    {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Group> allGroups() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Group> byId(@PathVariable char id) {
        return repo.findById(id);
    }

    @PutMapping("/{id}")
    public void updateGroup(@PathVariable char id, @RequestBody Group group) {
        if (group.getGroupId()!=(id)) {
            throw new IllegalStateException("Given ingredient's ID doesn't match the ID in the path.");
        }
        repo.save(group);
    }

    @PostMapping
    public ResponseEntity<Group> postEmployee(@RequestBody Group group) {
        Group saved = repo.save(group);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("http://localhost:8080/groups/" + group.getGroupId()));
        return new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable char id) {
        repo.deleteById(id);
    }

}

