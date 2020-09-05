package com.infosys.timetrackerassist.emi.repository;

import com.infosys.timetrackerassist.emi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins="*")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
