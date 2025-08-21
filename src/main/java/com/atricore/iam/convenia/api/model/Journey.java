package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Journey {

    @JsonProperty("monthly_hours")
    private String monthlyHours;

    // Getters and setters

    public String getMonthlyHours() {
        return monthlyHours;
    }

    public void setMonthlyHours(String monthlyHours) {
        this.monthlyHours = monthlyHours;
    }
}
