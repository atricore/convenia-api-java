package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeaveRequest {

    private String id;

    @JsonProperty("employee_id")
    private String employeeId;

    private Integer allowance;
    private Boolean thirteenth;

    @JsonProperty("period_id")
    private String periodId;

    @JsonProperty("collective_id")
    private String collectiveId;

    private String justification;

    @JsonProperty("requested_days")
    private Integer requestedDays;

    @JsonProperty("sent_to_accountant")
    private Boolean sentToAccountant;

    @JsonProperty("spent_balance")
    private Integer spentBalance;

    @JsonProperty("starts_at")
    private String startsAt;

    @JsonProperty("finishes_at")
    private String finishesAt;

    private String status;

    @JsonProperty("paid_leave")
    private Integer paidLeave;

    @JsonProperty("accounting_started_at")
    private String accountingStartedAt;

    @JsonProperty("hr_approvals_started_at")
    private String hrApprovalsStartedAt;

    @JsonProperty("supervisor_approvals_started_at")
    private String supervisorApprovalsStartedAt;

    @JsonProperty("signature_started_at")
    private String signatureStartedAt;

    @JsonProperty("supervisor_approvals")
    private List<SupervisorApproval> supervisorApprovals;

    @JsonProperty("hr_approvals")
    private List<HrApproval> hrApprovals;

    private List<FileRecord> files;

    @JsonProperty("available_steps")
    private Map<String, Boolean> availableSteps;

    private Canceled canceled;

    @JsonProperty("created_at")
    private String createdAt;

    @JsonProperty("updated_at")
    private String updatedAt;

    // Getters and setters for each field

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getAllowance() {
        return allowance;
    }

    public void setAllowance(Integer allowance) {
        this.allowance = allowance;
    }

    public Boolean getThirteenth() {
        return thirteenth;
    }

    public void setThirteenth(Boolean thirteenth) {
        this.thirteenth = thirteenth;
    }

    public String getPeriodId() {
        return periodId;
    }

    public void setPeriodId(String periodId) {
        this.periodId = periodId;
    }

    public String getCollectiveId() {
        return collectiveId;
    }

    public void setCollectiveId(String collectiveId) {
        this.collectiveId = collectiveId;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public Integer getRequestedDays() {
        return requestedDays;
    }

    public void setRequestedDays(Integer requestedDays) {
        this.requestedDays = requestedDays;
    }

    public Boolean getSentToAccountant() {
        return sentToAccountant;
    }

    public void setSentToAccountant(Boolean sentToAccountant) {
        this.sentToAccountant = sentToAccountant;
    }

    public Integer getSpentBalance() {
        return spentBalance;
    }

    public void setSpentBalance(Integer spentBalance) {
        this.spentBalance = spentBalance;
    }

    public String getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(String startsAt) {
        this.startsAt = startsAt;
    }

    public String getFinishesAt() {
        return finishesAt;
    }

    public void setFinishesAt(String finishesAt) {
        this.finishesAt = finishesAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getPaidLeave() {
        return paidLeave;
    }

    public void setPaidLeave(Integer paidLeave) {
        this.paidLeave = paidLeave;
    }

    public String getAccountingStartedAt() {
        return accountingStartedAt;
    }

    public void setAccountingStartedAt(String accountingStartedAt) {
        this.accountingStartedAt = accountingStartedAt;
    }

    public String getHrApprovalsStartedAt() {
        return hrApprovalsStartedAt;
    }

    public void setHrApprovalsStartedAt(String hrApprovalsStartedAt) {
        this.hrApprovalsStartedAt = hrApprovalsStartedAt;
    }

    public String getSupervisorApprovalsStartedAt() {
        return supervisorApprovalsStartedAt;
    }

    public void setSupervisorApprovalsStartedAt(String supervisorApprovalsStartedAt) {
        this.supervisorApprovalsStartedAt = supervisorApprovalsStartedAt;
    }

    public String getSignatureStartedAt() {
        return signatureStartedAt;
    }

    public void setSignatureStartedAt(String signatureStartedAt) {
        this.signatureStartedAt = signatureStartedAt;
    }

    public List<SupervisorApproval> getSupervisorApprovals() {
        return supervisorApprovals;
    }

    public void setSupervisorApprovals(List<SupervisorApproval> supervisorApprovals) {
        this.supervisorApprovals = supervisorApprovals;
    }

    public List<HrApproval> getHrApprovals() {
        return hrApprovals;
    }

    public void setHrApprovals(List<HrApproval> hrApprovals) {
        this.hrApprovals = hrApprovals;
    }

    public List<FileRecord> getFiles() {
        return files;
    }

    public void setFiles(List<FileRecord> files) {
        this.files = files;
    }

    public Map<String, Boolean> getAvailableSteps() {
        return availableSteps;
    }

    public void setAvailableSteps(Map<String, Boolean> availableSteps) {
        this.availableSteps = availableSteps;
    }

    public Canceled getCanceled() {
        return canceled;
    }

    public void setCanceled(Canceled canceled) {
        this.canceled = canceled;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
