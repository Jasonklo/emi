package com.infosys.timetrackerassist.emi.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Data
@Entity
@RestResource(rel="employee", path="employee")
public class Employee implements Serializable {

    @Id
    private Integer empId;
    private Character cId;
    private Character empName;

    @Enumerated(EnumType.STRING)
    private Access access;

    @ManyToOne(fetch = FetchType.LAZY, optional=false)
    @JoinColumn(name="groupId")
    private Group group;

    private Integer maintId;
    private Timestamp maintTs;

    //ADMIN, READ, WRITE
    public enum Access{
        A,
        R,
        W
    }

}