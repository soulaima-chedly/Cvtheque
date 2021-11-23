package com.main.cvtheque.models;

import com.sun.istack.NotNull;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client extends User {
    @NotNull
    private String gender;

    @NotNull
    private int age;

    //CV
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
    private CV cv;

    public Client(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
