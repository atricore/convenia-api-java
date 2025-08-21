package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Dismissal {

    private String id;
    private String date;
    private DismissalType type;

    @JsonProperty("termination_notice")
    private TerminationNotice terminationNotice;

    @JsonProperty("dismissal_step_id")
    private Integer dismissalStepId;

    @JsonProperty("dismissal_step")
    private DismissalStep dismissalStep;

    @JsonProperty("breaking_contract")
    private String breakingContract;

    @JsonProperty("remove_acess_date")
    private String removeAcessDate;

    @JsonProperty("accountancy_date")
    private String accountancyDate;

    @JsonProperty("remove_benefit")
    private Boolean removeBenefit;

    private String motive;
    private String comments;

    @JsonProperty("finished_at")
    private String finishedAt;

    private String newSupervisorId;
    private Supervisor supervisor;

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

    public DismissalType getType() {
        return type;
    }

    public void setType(DismissalType type) {
        this.type = type;
    }

    public TerminationNotice getTerminationNotice() {
        return terminationNotice;
    }

    public void setTerminationNotice(TerminationNotice terminationNotice) {
        this.terminationNotice = terminationNotice;
    }

    public Integer getDismissalStepId() {
        return dismissalStepId;
    }

    public void setDismissalStepId(Integer dismissalStepId) {
        this.dismissalStepId = dismissalStepId;
    }

    public DismissalStep getDismissalStep() {
        return dismissalStep;
    }

    public void setDismissalStep(DismissalStep dismissalStep) {
        this.dismissalStep = dismissalStep;
    }

    public String getBreakingContract() {
        return breakingContract;
    }

    public void setBreakingContract(String breakingContract) {
        this.breakingContract = breakingContract;
    }

    public String getRemoveAcessDate() {
        return removeAcessDate;
    }

    public void setRemoveAcessDate(String removeAcessDate) {
        this.removeAcessDate = removeAcessDate;
    }

    public String getAccountancyDate() {
        return accountancyDate;
    }

    public void setAccountancyDate(String accountancyDate) {
        this.accountancyDate = accountancyDate;
    }

    public Boolean getRemoveBenefit() {
        return removeBenefit;
    }

    public void setRemoveBenefit(Boolean removeBenefit) {
        this.removeBenefit = removeBenefit;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }

    public String getNewSupervisorId() {
        return newSupervisorId;
    }

    public void setNewSupervisorId(String newSupervisorId) {
        this.newSupervisorId = newSupervisorId;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
