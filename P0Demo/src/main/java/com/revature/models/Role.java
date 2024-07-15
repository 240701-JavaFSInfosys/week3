package com.revature.models;

public class Role {

    //Fields should mirror DB columns as closely as possible
    private int role_id;
    private String role_title;
    private int role_salary;

    //boilerplate code--------------

    //no-args constructor
    public Role() {
    }

    //all-args constructor
    public Role(int role_id, String role_title, int role_salary) {
        this.role_id = role_id;
        this.role_title = role_title;
        this.role_salary = role_salary;
    }

    //getters and setters
    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getRole_title() {
        return role_title;
    }

    public void setRole_title(String role_title) {
        this.role_title = role_title;
    }

    public int getRole_salary() {
        return role_salary;
    }

    public void setRole_salary(int role_salary) {
        this.role_salary = role_salary;
    }

    //toString so we can print out roles, not memory addresses
    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", role_title='" + role_title + '\'' +
                ", role_salary=" + role_salary +
                '}';
    }
}
