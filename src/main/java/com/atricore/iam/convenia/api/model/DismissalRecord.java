package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DismissalRecord {

    private String id;

    @JsonProperty("corporate_email")
    private String corporateEmail;

    private Dismissal dismissal;

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCorporateEmail() {
        return corporateEmail;
    }

    public void setCorporateEmail(String corporateEmail) {
        this.corporateEmail = corporateEmail;
    }

    public Dismissal getDismissal() {
        return dismissal;
    }

    public void setDismissal(Dismissal dismissal) {
        this.dismissal = dismissal;
    }
}
