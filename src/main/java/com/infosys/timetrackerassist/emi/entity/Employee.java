package com.infosys.timetrackerassist.emi.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;


@Data
@Entity
@RestResource(rel="employee", path="employee")
public class Employee {

    @Id
    private int empId;
    private char cId;
    private char empName;
    private char access;
    private char groupId;
    private int maintId;
    private Timestamp maintTs;

    public static enum access{
        ADMIN, READ, WRITE
    }

}