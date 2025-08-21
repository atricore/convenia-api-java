package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Disability {
    private int id;
    @JsonProperty("disability_type_id")
    private int disabilityTypeId;
    private DisabilityType disabilityType;
    private String observations;

    // Getters and setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDisabilityTypeId() {
        return disabilityTypeId;
    }

    public void setDisabilityTypeId(int disabilityTypeId) {
        this.disabilityTypeId = disabilityTypeId;
    }

    public DisabilityType getDisabilityType() {
        return disabilityType;
    }

    public void setDisabilityType(DisabilityType disabilityType) {
        this.disabilityType = disabilityType;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }
}
