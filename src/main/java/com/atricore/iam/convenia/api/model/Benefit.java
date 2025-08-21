package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Benefit {
    private String id;
    @JsonProperty("benefit_id")
    private String benefitId;
    private String name;
    private String operator;
    @JsonProperty("employee_value")
    private double employeeValue;
    @JsonProperty("company_value")
    private double companyValue;
    private String type;
    @JsonProperty("payment_method")
    private String paymentMethod;

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBenefitId() {
        return benefitId;
    }

    public void setBenefitId(String benefitId) {
        this.benefitId = benefitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public double getEmployeeValue() {
        return employeeValue;
    }

    public void setEmployeeValue(double employeeValue) {
        this.employeeValue = employeeValue;
    }

    public double getCompanyValue() {
        return companyValue;
    }

    public void setCompanyValue(double companyValue) {
        this.companyValue = companyValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}