package com.javatpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javatpoint.model.Category;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class BorrowerDTO {
    @JsonProperty("id")
    private  String id;

    @JsonProperty("ageCategory")
    private String ageCategory;

    @JsonProperty("tz")
    private String tz;
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("phoneNumber")
    private  String phoneNumber;
    @JsonProperty("mail")
    private String mail;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAgeCategory() {
        return ageCategory;
    }

    public void setAgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getTz() {
        return tz;
    }

    public void setTz(String tz) {
        this.tz = tz;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
