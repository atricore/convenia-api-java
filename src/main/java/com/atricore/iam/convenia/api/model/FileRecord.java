package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FileRecord {
    private String id;
    private String name;
    private Boolean signable;
    private String status;

    @JsonProperty("updated_at")
    private String updatedAt;

    @JsonProperty("created_at")
    private String createdAt;

    // Getters and setters
    // ...
}
