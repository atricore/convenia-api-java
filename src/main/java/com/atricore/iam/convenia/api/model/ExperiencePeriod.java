package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExperiencePeriod {
    @JsonProperty("type_id")
    private int typeId;
    private ExperiencePeriodType type;
    @JsonProperty("first_end")
    private String firstEnd;
    @JsonProperty("second_end")
    private String secondEnd;
    @JsonProperty("total_days")
    private String totalDays;

    // Getters and setters

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public ExperiencePeriodType getType() {
        return type;
    }

    public void setType(ExperiencePeriodType type) {
        this.type = type;
    }

    public String getFirstEnd() {
        return firstEnd;
    }

    public void setFirstEnd(String firstEnd) {
        this.firstEnd = firstEnd;
    }

    public String getSecondEnd() {
        return secondEnd;
    }

    public void setSecondEnd(String secondEnd) {
        this.secondEnd = secondEnd;
    }

    public String getTotalDays() {
        return totalDays;
    }

    public void setTotalDays(String totalDays) {
        this.totalDays = totalDays;
    }
}

