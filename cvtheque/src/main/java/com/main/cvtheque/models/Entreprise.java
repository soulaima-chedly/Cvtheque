package com.main.cvtheque.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "entreprises")
public class Entreprise extends User {
    @NotNull
    private String matricule;

    @NotNull
    private String domain;

    //favoris: cv list

    public Entreprise(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
}
