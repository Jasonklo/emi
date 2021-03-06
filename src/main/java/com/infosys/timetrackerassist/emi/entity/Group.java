package com.infosys.timetrackerassist.emi.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;


import javax.persistence.*;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@RestResource(rel="group", path="group")
public class Group implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Character groupId;
    private Character groupName;
    private Integer maintId;
    private Timestamp maintTs;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "group")
    private List<Employee> employees;


}