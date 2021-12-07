package com.main.cvtheque.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "headers")
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fullName;

    @NotNull
    private String domain;

    @NotNull
    private String email;

    @NotNull
    private String phoneNumber;

    //CV
    /*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "header")
    private CV cv;*/

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cv_id")
    private CV cv;

    public Header() {}

    public Header(Long id, String fullName, String domain, String email, String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.domain = domain;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }
}
