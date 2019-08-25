package com.jackson.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {

    private String name;
    private String surname;
    private String email;
    private Set<Roles> roles;
    private Set<String> phones;

    public User() {
    }

    public User(String name, String surname, String email, Set<Roles> roles, Set<String> phones) {
        roles = new HashSet<Roles>(3);
        phones = new HashSet<String>(3);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.roles = roles;
        this.phones = phones;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public Set<String> getPhones() {
        return phones;
    }

    public void setPhones(Set<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                ", phones=" + phones +
                '}';
    }
}
