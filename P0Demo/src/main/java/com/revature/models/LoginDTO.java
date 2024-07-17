package com.revature.models;

/* What is a DTO? Data Transfer Object. It's meant to model some data that doesn't pertain to a DB table
For instance, maybe we have login functionality that only takes a username/password
We want a user to be able to log in with ONLY their username/password, instead of an entire Employee object
NOTE: we never store DTOs in the DB - they're solely for DATA TRANSFER

Two main use cases:

1) When you don't want to send or use an entire object (we only need username/password to log in)
2) When you don't intend to store the incoming data in the DB (it's only for java logic) */
public class LoginDTO {

    //TODO: We should have probably included username/password in the employee table
    //so we'll just have to use firstname and lastname and pretend they're username/password

    private String first_name;
    private String last_name;

    //for DTOs we typically just need an all-args constructor and getters/setters.


    public LoginDTO(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    @Override
    public String toString() {
        return "LoginDTO{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
