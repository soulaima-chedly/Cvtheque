/*
package com.main.cvtheque.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String gender;

    @NotNull
    private int age;

    //CV
    */
/*@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "client")
    private CV cv;*//*


    @OneToOne(fetch = FetchType.LAZY, cascade= CascadeType.ALL, mappedBy = "client")
    private Role role;

    public Client(String name, String email, String password) {
        super(name, email, password);
    }

    public Long getId() {
        return id;
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
*/
