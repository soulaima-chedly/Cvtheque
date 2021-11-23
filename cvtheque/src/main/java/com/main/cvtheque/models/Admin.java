package com.main.cvtheque.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin extends User{
    public Admin(int id, String name, String email, String password) {
        super(id, name, email, password);
    }
}
