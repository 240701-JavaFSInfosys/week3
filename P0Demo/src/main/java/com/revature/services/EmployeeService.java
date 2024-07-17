package com.revature.services;

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;

import java.util.ArrayList;

//The Service Layer is typically where any extra data processing happens
//Data may need to be validated, formatted, or otherwise "handled" before hitting the DAO or controller
public class EmployeeService {

    //We need an EmployeeDAO to call its methods
    EmployeeDAO eDAO = new EmployeeDAO();

    //In general, "get all" methods are very simple in the service layer. Not much to process
    //no user inputs, no crazy outputs, just a bridge between the controller and the DAO.
    public ArrayList<Employee> getEmployees(){
        return eDAO.getEmployees();
    }

    //Here's a more useful example - the incoming employee data has 3 fields we can validate
    public Employee insertEmployee(Employee employee) throws IllegalArgumentException {

        //we'll run some checks on each of the employee's fields

        //check that the first name is not empty or null
        if(employee.getFirst_name() == null || employee.getFirst_name().equals("")){
            throw new IllegalArgumentException("First Name must not be empty!");
        }
        //NOTE: null checks should happen BEFORE empty checks

        //TODO: we can do the same checks for last name

        //check that the first name is not vulgar
        if(employee.getFirst_name().equalsIgnoreCase("JavaScript")){
            throw new IllegalArgumentException("First Name cannot be vulgar!");
        }

        //check that the role id is non zero and non negative
        if(employee.getRole_id_fk() <= 0){
            throw new IllegalArgumentException("Role ID must be a positive number!");
        }

        //check that the role id is not 1 (assuming there is already a manager)
//TODO: we would probably ACTUALLY make a call to the DB to see if there's an employee where role = 1;
        if(employee.getRole_id_fk() == 1){
            throw new IllegalArgumentException("There is already a manager!");
        }

        //If all of these checks pass, send the employee to the DAO to be inserted
        eDAO.insertEmployee(employee);

        //TODO: we would wrap this^ call in a try/catch as well, or just let the DAO handle

        return employee;

    }

}
