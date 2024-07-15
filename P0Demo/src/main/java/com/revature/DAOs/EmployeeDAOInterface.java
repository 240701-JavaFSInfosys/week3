package com.revature.DAOs;

import com.revature.models.Employee;

import java.util.ArrayList;

//This Interface will lay out the methods that EmployeeDAO implements
//Why take this extra step? This is a great way to document what methods are found in EmployeeDAO
//Imagine a DAO class with 50 JDBC methods. That's gonna be really long. This is a quick reference
public interface EmployeeDAOInterface {

    //a method to select all employees
    ArrayList<Employee> getEmployees();

    //a method to insert a new employee
    Employee insertEmployee(Employee emp);
    /*If we're sending an Employee to be inserted into the DB, why are returning one back?
    we can send the data back to the User to be used in other functionalities or just to verify the insert*/

    //TODO: MAYBE show delete, but it should be easy if you know how to update

}
