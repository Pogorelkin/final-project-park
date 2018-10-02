package com.epam.webpark.entity;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String firstName;
    private String secondName;
    private int role; // 0=forester, 1 = owner. (hierarchy, you know)
    private String login;
    private String password;

    public User(String firstName, String secondName, int role) {
        super();
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
    }

    public User(String firstName, String secondName, int role, String login, String password) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int isOwner() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        if (role == 0) {
            return "User{" +
                    "firstName='" + firstName + '\'' +
                    ", secondName='" + secondName + '\'' +
                    ", role=Forester}" + '}';
        }
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", role=Owner" +
                '}';

    }
}
