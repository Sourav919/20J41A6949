package com.train.reservation.reservation.model;

public class AuthRequest {
    private String companyName;
    private String clientID;
    private String ownerName;
    private String ownerEmail;
    private String rollNo;
    private String clientSecret;

    public AuthRequest(String companyName, String clientID, String ownerName, String ownerEmail, String rollNo, String clientSecret) {
        this.companyName = companyName;
        this.clientID = clientID;
        this.ownerName = ownerName;
        this.ownerEmail = ownerEmail;
        this.rollNo = rollNo;
        this.clientSecret = clientSecret;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

}
