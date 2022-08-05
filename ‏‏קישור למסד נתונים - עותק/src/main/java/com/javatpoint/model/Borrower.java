package com.javatpoint.model;

import javax.persistence.*;
import java.util.List;

@Entity 
public class Borrower {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//מפתח יגדל בצורה אוטומטית    private Long id;
    private  Long id;

    private String tz;
    private String firstName;
    private String lastName;
    private  String phoneNumber;
    private String mail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;

    @OneToMany(mappedBy = "borrower")
    private List<Lend> lends;

    public Borrower() {
    }

    public Borrower(Long id,String tz, String firstName, String lastName, String phoneNumber, String mail,Category category) {
        this.id=id;
        this.tz = tz;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.category=category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Lend> getLends() {
        return lends;
    }

    public void setLends(List<Lend> lends) {
        this.lends = lends;
    }


}
