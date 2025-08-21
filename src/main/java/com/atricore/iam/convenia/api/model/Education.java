package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Education {
    private String id;
    @JsonProperty("education_type_id")
    private int educationTypeId;
    @JsonProperty("education_type")
    private EducationType educationType;
    private String course;
    private String institution;
    @JsonProperty("graduation_year")
    private String graduationYear;

    // Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getEducationTypeId() {
        return educationTypeId;
    }

    public void setEducationTypeId(int educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public EducationType getEducationType() {
        return educationType;
    }

    public void setEducationType(EducationType educationType) {
        this.educationType = educationType;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(String graduationYear) {
        this.graduationYear = graduationYear;
    }
}
