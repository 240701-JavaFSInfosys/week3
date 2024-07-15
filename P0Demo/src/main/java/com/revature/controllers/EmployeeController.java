package com.revature.controllers;

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;
import io.javalin.http.Handler;

import java.util.ArrayList;

/* The Controller Layer is where HTTP Requests get sent after Javalin directs them
 It's in this layer that JSON comes in and gets translated to Java and vice versa
 We'll be taking in HTTP Requests from the client and sending back HTTP Responses
 The Controllers job is processing HTTP Requests */
public class EmployeeController {

    //We need an EmployeeDAO to use its employee data methods
    EmployeeDAO eDAO = new EmployeeDAO();

    //This Handler will get used to handle GET requests to /employees
    public Handler getEmployeesHandler = ctx -> {

        //Get an ArrayList of employees, populated by the getEmployees DAO method
        ArrayList<Employee> employees = eDAO.getEmployees();

        //PROBLEM: we can't send plain Java in an HTTP Response - it only takes JSON

        //We can use the .json() method to convert this ArrayList to JSON
        //NOTE: This method also returns the object once the code block is done
        ctx.json(employees);

        //We can also set the HTTP Response status code with ctx.status()
        ctx.status(200);

    };

}
