package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TerminationNotice {
    private String id;
    private String date;

    @JsonProperty("termination_notice_type_id")
    private Integer terminationNoticeTypeId;

    @JsonProperty("termination_notice_type")
    private TerminationNoticeType terminationNoticeType;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getTerminationNoticeTypeId() {
        return terminationNoticeTypeId;
    }

    public void setTerminationNoticeTypeId(Integer terminationNoticeTypeId) {
        this.terminationNoticeTypeId = terminationNoticeTypeId;
    }

    public TerminationNoticeType getTerminationNoticeType() {
        return terminationNoticeType;
    }

    public void setTerminationNoticeType(TerminationNoticeType terminationNoticeType) {
        this.terminationNoticeType = terminationNoticeType;
    }
}
