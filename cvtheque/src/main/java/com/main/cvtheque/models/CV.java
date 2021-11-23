package com.main.cvtheque.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "cvs")
public class CV {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String domain;

    //skills
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "cv_skills",
            joinColumns = { @JoinColumn(name = "cv_id") },
            inverseJoinColumns = { @JoinColumn(name = "skill_id") })
    private ArrayList<Skills> skills = new ArrayList<>();

    //experience
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cv")
    private ArrayList<WorkExperience> workExperience = new ArrayList<>();

    //education
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "cv")
    private ArrayList<Education> educations = new ArrayList<>();

    public CV(int id, String domain) {
        this.id = id;
        this.domain = domain;
    }

    public int getId() {
        return id;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
