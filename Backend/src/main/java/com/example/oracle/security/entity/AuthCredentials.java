package com.example.oracle.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USUARIOS")
public class AuthCredentials {
    @Id
    @Column(name = "USUACODI")
    private int id;
    @Column(name = "USUAEMAI")
    private String email;
    @Column(name = "USUAPASS")
    private String password;

    public AuthCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AuthCredentials() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
