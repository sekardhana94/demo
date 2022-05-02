package com.tranining.nx2.entity;

import java.util.Date;

public class TeamMember {
    private int id;
    private String name;
    private String teamName;
    private Date dob;

    public TeamMember(int id, String name, String teamName, Date dob) {
        this.id = id;
        this.name = name;
        this.teamName = teamName;
        this.dob = dob;
    }

    public TeamMember() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
}
