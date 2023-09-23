package com.train.reservation.reservation.model;

public class RegisterRequest {
    private String companyName;
    private String ownerName;
    private String rollNo;
    private String accessCode;
    private String ownerEmail;

    public RegisterRequest(String companyName, String ownerName, String rollNo, String accessCode, String ownerEmail) {
        this.companyName = companyName;
        this.ownerName = ownerName;
        this.rollNo = rollNo;
        this.accessCode = accessCode;
        this.ownerEmail = ownerEmail;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }



    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }
}
