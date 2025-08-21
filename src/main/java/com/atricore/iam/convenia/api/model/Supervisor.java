package com.atricore.iam.convenia.api.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Supervisor {
    private String id;
    private String name;
    @JsonProperty("last_name")
    private String lastName;

    // Getters and setters\

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
