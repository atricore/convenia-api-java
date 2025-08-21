package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Intern {
    private String id;
    @JsonProperty("initial_at")
    private String initialAt;
    @JsonProperty("finish_at")
    private String finishAt;
    @JsonProperty("internship_category")
    private String internshipCategory;
    @JsonProperty("is_mandatory")
    private String isMandatory;
    @JsonProperty("occupation_area")
    private String occupationArea;
    private String college;
    private String cnpj;
    @JsonProperty("zip_code")
    private String zipCode;
    private String address;
    private String number;
    private String complement;
    private String district;
    private String state;
    private String city;
    @JsonProperty("internship_supervisor")
    private InternshipSupervisor internshipSupervisor;

    // Getters and setters


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitialAt() {
        return initialAt;
    }

    public void setInitialAt(String initialAt) {
        this.initialAt = initialAt;
    }

    public String getFinishAt() {
        return finishAt;
    }

    public void setFinishAt(String finishAt) {
        this.finishAt = finishAt;
    }

    public String getInternshipCategory() {
        return internshipCategory;
    }

    public void setInternshipCategory(String internshipCategory) {
        this.internshipCategory = internshipCategory;
    }

    public String getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(String isMandatory) {
        this.isMandatory = isMandatory;
    }

    public String getOccupationArea() {
        return occupationArea;
    }

    public void setOccupationArea(String occupationArea) {
        this.occupationArea = occupationArea;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public InternshipSupervisor getInternshipSupervisor() {
        return internshipSupervisor;
    }

    public void setInternshipSupervisor(InternshipSupervisor internshipSupervisor) {
        this.internshipSupervisor = internshipSupervisor;
    }
}