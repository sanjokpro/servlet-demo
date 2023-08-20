/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sanjok.generator.modules.usermgmt.model;

import java.io.Serializable;

/**
 * @author Sanjok
 */
public class User implements Serializable {

    private Role role;
    private int id;
    private String username;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    private String password;
    private String email;
    public boolean isValid;

    @Override
    public String toString() {
        return "User{" + "id=" + User.this.id + ", username=" + username + ", password=" + password + ", email=" + email + ", isValid=" + isValid + '}';
    }

}
