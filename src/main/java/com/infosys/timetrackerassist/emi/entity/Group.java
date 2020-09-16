package com.infosys.timetrackerassist.emi.entity;

import lombok.Data;
import org.springframework.data.rest.core.annotation.RestResource;


import javax.persistence.Entity;
import javax.persistence.Id;

import java.sql.Timestamp;

@Data
@Entity
@RestResource(rel="group", path="group")
public class Group {

    @Id
    private Character groupId;
    private Character groupName;
    private Integer maintId;
    private Timestamp maintTs;


}