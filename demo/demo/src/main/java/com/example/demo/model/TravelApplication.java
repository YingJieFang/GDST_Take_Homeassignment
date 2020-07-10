package com.example.demo.model;
import com.fasterxml.jackson.annotation.JsonProperty;


import java.util.UUID;
public class TravelApplication {

    private final UUID applicationId;
    private final String companyName;
    private final String companyAddress;
    private final String UENNum;

    private final String applicantName;
    private final String applicantContact;
    private final String applicantEmail;

    private final String employeeName;
    private final String employeeID;
    private final String employeePassport;
    private final String employeeOriginCountry;
    private final String employeeDestination;
    private final String travelPeriod;

    public TravelApplication(

            @JsonProperty("id") UUID applicationId,
            @JsonProperty("companyName") String companyName,
            @JsonProperty("companyAddress") String companyAddress,
            @JsonProperty("UENNum") String UENNum,
            @JsonProperty("applicantName")String applicantName,
            @JsonProperty("applicantContact") String applicantContact,
            @JsonProperty("applicantEmail") String applicantEmail,
            @JsonProperty("employeeName") String employeeName,
            @JsonProperty("employeeID") String employeeID,
            @JsonProperty("employeePassport") String employeePassport,
            @JsonProperty("employeeOriginCountry") String employeeOriginCountry,
            @JsonProperty("employeeDestination") String employeeDestination,
            @JsonProperty("travelPeriod") String travelPeriod)
    {
        this.applicationId = applicationId;
        this.companyName = companyName;
        this.companyAddress = companyAddress;
        this.UENNum = UENNum;
        this.applicantName = applicantName;
        this.applicantContact = applicantContact;
        this.applicantEmail = applicantEmail;
        this.employeeName = employeeName;
        this.employeeID = employeeID;
        this.employeePassport = employeePassport;
        this.employeeOriginCountry = employeeOriginCountry;
        this.employeeDestination = employeeDestination;
        this.travelPeriod = travelPeriod;
    }

    public UUID getApplicationId() {
        return applicationId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getUENNum() {
        return UENNum;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public String getApplicantContact() {
        return applicantContact;
    }

    public String getApplicantEmail() {
        return applicantEmail;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getEmployeePassport() {
        return employeePassport;
    }

    public String getEmployeeOriginCountry() {
        return employeeOriginCountry;
    }

    public String getEmployeeDestination() {
        return employeeDestination;
    }

    public String getTravelPeriod() {
        return travelPeriod;
    }
}
