package com.revature.models;

public class Employee {

    private int employee_id;
    private String first_name;
    private String last_name;

    /*Employees in Java will contain entire Role objects instead of just an int foreign key
      an int FK is less useful to us than an entire Role object
      If we have an entire Role object, we have access to all the Role's DATA as well. (not just a number) */
    private Role role;

    //TODO: another role_id_fk field to be used with inserts

    //boilerplate code-------------

    //no-args constructor
    public Employee() {
    }

    //all-args constructor
    public Employee(int employee_id, String first_name, String last_name, Role role) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.role = role;
    }

    //TODO: constructor to be used with inserts

    //getters and setters
    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //toString
    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", role=" + role +
                '}';
    }
}
