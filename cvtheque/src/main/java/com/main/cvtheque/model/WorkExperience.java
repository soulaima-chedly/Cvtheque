package com.main.cvtheque.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table(name = "work_experiences")
public class WorkExperience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String role;

    @NotNull
    private String companyName;

    @NotNull
    private Date begningDate;

    @NotNull
    private Date endingDate;

    private ArrayList<String> achievements = new ArrayList<>();

    //CV
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cv_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private CV cv;

    public WorkExperience(Long id,
                          String role,
                          String companyName,
                          Date begningDate,
                          Date endingDate,
                          ArrayList<String> achievements) {
        this.id = id;
        this.role = role;
        this.companyName = companyName;
        this.begningDate = begningDate;
        this.endingDate = endingDate;
        this.achievements = achievements;
    }

    public Long getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getBegningDate() {
        return begningDate;
    }

    public void setBegningDate(Date begningDate) {
        this.begningDate = begningDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public ArrayList<String> getAchievements() {
        return achievements;
    }

    public void setAchievements(ArrayList<String> achievements) {
        this.achievements = achievements;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }
}
