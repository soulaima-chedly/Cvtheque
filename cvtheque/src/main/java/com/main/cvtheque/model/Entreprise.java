package com.main.cvtheque.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "entreprises")
public class Entreprise extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String matricule;

    @NotNull
    private String domain;

    //favoris: cv list

    public Entreprise(String name, String email, String password) {
        super(name, email, password);
    }

    public Long getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
