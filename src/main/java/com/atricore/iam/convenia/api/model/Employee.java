package com.atricore.iam.convenia.api.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Employee {
    private String id;
    private String name;
    private String status;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("mother_name")
    private String motherName;
    @JsonProperty("father_name")
    private String fatherName;
    private String email;
    @JsonProperty("alternative_email")
    private String alternativeEmail;
    @JsonProperty("hiring_date")
    private String hiringDate;
    private String phone;
    private String cellphone;
    private String registration;
    private String gender;
    @JsonProperty("birth_date")
    private String birthDate;
    private double salary;
    @JsonProperty("natural_from_state_uf")
    private String naturalFromStateUf;
    @JsonProperty("natural_from_city_name")
    private String naturalFromCityName;
    @JsonProperty("marital_status_id")
    private String maritalStatusId;
    @JsonProperty("first_job")
    private boolean firstJob;
    @JsonProperty("gender_identity_id")
    private int genderIdentityId;
    @JsonProperty("social_name")
    private String socialName;
    private GenderIdentity genderIdentity;
    @JsonProperty("relationship_id")
    private int relationshipId;
    private Relationship relationship;
    @JsonProperty("ethnicity_id")
    private int ethnicityId;
    private Ethnicity ethnicity;
    private Document document;
    private Department department;
    private Job job;
    private Dismissal dismissal;
    private Supervisor supervisor;
    @JsonProperty("cost_center")
    private CostCenter costCenter;
    @JsonProperty("salary_type")
    private SalaryType salaryType;
    private Address address;
    private List<Benefit> benefits;
    @JsonProperty("custom_fields")
    private List<CustomField> customFields;
    private List<Education> educations;
    @JsonProperty("bank_account")
    private BankAccount bankAccount;
    @JsonProperty("bank_accounts")
    private List<BankAccount> bankAccounts;
    @JsonProperty("experience_period")
    private ExperiencePeriod experiencePeriod;
    private Disability disability;
    private List<Annotation> annotations;
    @JsonProperty("emergency_contacts")
    private List<EmergencyContact> emergencyContacts;
    @JsonProperty("work_period")
    private WorkPeriod workPeriod;
    private Intern intern;
    @JsonProperty("time_tracking")
    private boolean timeTracking;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public CostCenter getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(CostCenter costCenter) {
        this.costCenter = costCenter;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialName() {
        return socialName;
    }

    public void setSocialName(String socialName) {
        this.socialName = socialName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotherName() {
        return motherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getAlternativeEmail() {
        return alternativeEmail;
    }

    public void setAlternativeEmail(String alternativeEmail) {
        this.alternativeEmail = alternativeEmail;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getNaturalFromStateUf() {
        return naturalFromStateUf;
    }

    public void setNaturalFromStateUf(String naturalFromStateUf) {
        this.naturalFromStateUf = naturalFromStateUf;
    }

    public String getNaturalFromCityName() {
        return naturalFromCityName;
    }

    public void setNaturalFromCityName(String naturalFromCityName) {
        this.naturalFromCityName = naturalFromCityName;
    }

    public String getMaritalStatusId() {
        return maritalStatusId;
    }

    public void setMaritalStatusId(String maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public boolean isFirstJob() {
        return firstJob;
    }

    public void setFirstJob(boolean firstJob) {
        this.firstJob = firstJob;
    }

    public int getGenderIdentityId() {
        return genderIdentityId;
    }

    public void setGenderIdentityId(int genderIdentityId) {
        this.genderIdentityId = genderIdentityId;
    }

    public GenderIdentity getGenderIdentity() {
        return genderIdentity;
    }

    public void setGenderIdentity(GenderIdentity genderIdentity) {
        this.genderIdentity = genderIdentity;
    }

    public int getRelationshipId() {
        return relationshipId;
    }

    public void setRelationshipId(int relationshipId) {
        this.relationshipId = relationshipId;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public int getEthnicityId() {
        return ethnicityId;
    }

    public void setEthnicityId(int ethnicityId) {
        this.ethnicityId = ethnicityId;
    }

    public Ethnicity getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(Ethnicity ethnicity) {
        this.ethnicity = ethnicity;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Dismissal getDismissal() {
        return dismissal;
    }

    public void setDismissal(Dismissal dismissal) {
        this.dismissal = dismissal;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public SalaryType getSalaryType() {
        return salaryType;
    }

    public void setSalaryType(SalaryType salaryType) {
        this.salaryType = salaryType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Benefit> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<Benefit> benefits) {
        this.benefits = benefits;
    }

    public List<CustomField> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }

    public void setBankAccounts(List<BankAccount> bankAccounts) {
        this.bankAccounts = bankAccounts;
    }

    public ExperiencePeriod getExperiencePeriod() {
        return experiencePeriod;
    }

    public void setExperiencePeriod(ExperiencePeriod experiencePeriod) {
        this.experiencePeriod = experiencePeriod;
    }

    public Disability getDisability() {
        return disability;
    }

    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    public List<Annotation> getAnnotations() {
        return annotations;
    }

    public void setAnnotations(List<Annotation> annotations) {
        this.annotations = annotations;
    }

    public List<EmergencyContact> getEmergencyContacts() {
        return emergencyContacts;
    }

    public void setEmergencyContacts(List<EmergencyContact> emergencyContacts) {
        this.emergencyContacts = emergencyContacts;
    }

    public WorkPeriod getWorkPeriod() {
        return workPeriod;
    }

    public void setWorkPeriod(WorkPeriod workPeriod) {
        this.workPeriod = workPeriod;
    }

    public Intern getIntern() {
        return intern;
    }

    public void setIntern(Intern intern) {
        this.intern = intern;
    }

    public boolean isTimeTracking() {
        return timeTracking;
    }

    public void setTimeTracking(boolean timeTracking) {
        this.timeTracking = timeTracking;
    }
}
