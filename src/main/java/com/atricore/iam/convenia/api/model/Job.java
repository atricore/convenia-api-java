package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Job {
    private String id;
    private String name;
    private String description;
    @JsonProperty(value = "cbo_code")
    private String cboCode;
    @JsonProperty(value = "cbo", required = false)
    private Cbo cbo;
    private boolean apprenticeQuota;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
