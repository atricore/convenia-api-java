package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HrApproval {
    private String id;
    private String status;

    @JsonProperty("employee_id")
    private String employeeId;

    @JsonProperty("action_date")
    private String actionDate;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("created_at")
    private String createdAt;

    // Getters and setters
    // ...
}
