package com.main.cvtheque.models;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class Admin extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public Admin(String name, String email, String password) {
        super(name, email, password);
    }

    public int getId() {
        return id;
    }
}
