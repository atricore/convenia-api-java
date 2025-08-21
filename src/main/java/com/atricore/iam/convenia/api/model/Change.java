package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Change {
    @JsonProperty("old_value")
    private Object oldValue;
    @JsonProperty("new_value")
    private Object newValue;
    @JsonProperty("old_id")
    private String oldId;
    @JsonProperty("new_id")
    private String newId;

    // Getters and setters

    public Object getOldValue() {
        return oldValue;
    }

    public void setOldValue(Object oldValue) {
        this.oldValue = oldValue;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public String getOldId() {
        return oldId;
    }

    public void setOldId(String oldId) {
        this.oldId = oldId;
    }

    public String getNewId() {
        return newId;
    }

    public void setNewId(String newId) {
        this.newId = newId;
    }
}
