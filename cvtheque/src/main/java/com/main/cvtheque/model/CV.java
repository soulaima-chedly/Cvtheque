package com.main.cvtheque.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cvs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cvFileName;

    //header
    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="header_id")
    private Header header;*/

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cv")
    private Header header;

    //client
    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;*/

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cv")
    private List<Skill> skills = new ArrayList<>();

    //experience
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cv")
    private List<WorkExperience> workExperiences = new ArrayList<>();

    //education
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cv")
    private List<Education> educations = new ArrayList<>();

    //entreprises
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                    CascadeType.PERSIST,
//                    CascadeType.MERGE
//            },
//            mappedBy = "cvs")
//    private List<Entreprise> entreprises = new ArrayList<>();

    public CV() { }

    public CV(Long id, String cvFileName) {
        this.id = id;
        this.cvFileName = cvFileName;

    }

    public Long getId() {
        return id;
    }

    public String getCvFileName() {
        return cvFileName;
    }

    public void setCvFileName(String cvFileName) {
        this.cvFileName = cvFileName;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public List<WorkExperience> getWorkExperiences() {
        return workExperiences;
    }

    public void setWorkExperiences(List<WorkExperience> workExperiences) {
        this.workExperiences = workExperiences;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

//    public List<Entreprise> getEntreprises() {
//        return entreprises;
//    }
//
//    public void setEntreprises(List<Entreprise> entreprises) {
//        this.entreprises = entreprises;
//    }
}
