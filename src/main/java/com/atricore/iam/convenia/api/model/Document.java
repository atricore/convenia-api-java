package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {
    private String cpf;
    private String rg;
    @JsonProperty("rg_expedition")
    private String rgExpedition;
    @JsonProperty("rg_emission")
    private String rgEmission;
    @JsonProperty("rg_uf")
    private String rgUf;
    private String pis;
    private String ctps;
    @JsonProperty("ctps_serial")
    private String ctpsSerial;
    @JsonProperty("ctps_emission_date")
    private String ctpsEmissionDate;
    @JsonProperty("ctps_uf")
    private String ctpsUf;
    @JsonProperty("voter_card")
    private String voterCard;
    @JsonProperty("voter_card_zone")
    private String voterCardZone;
    @JsonProperty("voter_card_section")
    private String voterCardSection;

    // Getters and setters

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getRgExpedition() {
        return rgExpedition;
    }

    public void setRgExpedition(String rgExpedition) {
        this.rgExpedition = rgExpedition;
    }

    public String getRgEmission() {
        return rgEmission;
    }

    public void setRgEmission(String rgEmission) {
        this.rgEmission = rgEmission;
    }

    public String getRgUf() {
        return rgUf;
    }

    public void setRgUf(String rgUf) {
        this.rgUf = rgUf;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getCtpsSerial() {
        return ctpsSerial;
    }

    public void setCtpsSerial(String ctpsSerial) {
        this.ctpsSerial = ctpsSerial;
    }

    public String getCtpsEmissionDate() {
        return ctpsEmissionDate;
    }

    public void setCtpsEmissionDate(String ctpsEmissionDate) {
        this.ctpsEmissionDate = ctpsEmissionDate;
    }

    public String getCtpsUf() {
        return ctpsUf;
    }

    public void setCtpsUf(String ctpsUf) {
        this.ctpsUf = ctpsUf;
    }

    public String getVoterCard() {
        return voterCard;
    }

    public void setVoterCard(String voterCard) {
        this.voterCard = voterCard;
    }

    public String getVoterCardZone() {
        return voterCardZone;
    }

    public void setVoterCardZone(String voterCardZone) {
        this.voterCardZone = voterCardZone;
    }

    public String getVoterCardSection() {
        return voterCardSection;
    }

    public void setVoterCardSection(String voterCardSection) {
        this.voterCardSection = voterCardSection;
    }
}
