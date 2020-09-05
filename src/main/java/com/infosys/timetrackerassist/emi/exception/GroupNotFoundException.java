package com.infosys.timetrackerassist.emi.exception;

public class GroupNotFoundException extends RuntimeException {

    public GroupNotFoundException(int groupId) {
        super("Could not find group " + groupId);
    }
}
