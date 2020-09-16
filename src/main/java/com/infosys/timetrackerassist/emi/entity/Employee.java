package com.infosys.timetrackerassist.emi.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@Entity
@RestResource(rel="employee", path="employee")
public class Employee {

    @Id
    private Integer empId;
    private Character cId;
    private Character empName;
    private Character access;

    private Character groupId;
    private Integer maintId;
    private Timestamp maintTs;

    //ADMIN, READ, WRITE
    public enum access{
        A, R, W
    }

}