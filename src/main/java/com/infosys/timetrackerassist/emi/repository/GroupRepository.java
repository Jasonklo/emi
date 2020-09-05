package com.infosys.timetrackerassist.emi.repository;

import com.infosys.timetrackerassist.emi.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
public interface GroupRepository extends JpaRepository<Group, Character> {
}
