package com.main.cvtheque.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cvs")
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String cvFileName;

    //header
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="header_id")
    private Header header;

    //client
    /*@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="client_id")
    private Client client;*/

    //skills
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "cv_skills",
            joinColumns = { @JoinColumn(name = "cv_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") })
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
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },
            mappedBy = "cvs")
    private List<Entreprise> entreprises = new ArrayList<>();

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
}
