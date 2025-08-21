package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Audit {
    @JsonProperty("employee_id")
    private String employeeId;
    private String action;
    private String section;
    private Map<String, Change> changes;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("updated_at")
    private String updatedAt;
    private String id;

    // Getters and setters

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public Map<String, Change> getChanges() {
        return changes;
    }

    public void setChanges(Map<String, Change> changes) {
        this.changes = changes;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
