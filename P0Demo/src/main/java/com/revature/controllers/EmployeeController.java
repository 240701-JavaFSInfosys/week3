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

    //This Handler will handle GET requests to /employees
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

    //This Handler will handle POST requests to /employees
    public Handler insertEmployeeHandler = ctx -> {

        //We have JSON data coming in, which we need to convert into a Java object before the DAO can use it
        //We're going to use ctx.bodyAsClass(), to convert the incoming JSON into a Java Employee object
        Employee newEmployee = ctx.bodyAsClass(Employee.class);

        //TODO: send this employee to the DAO to be inserted into the DB

        ctx.status(201); //201 stands for "created", as in some new data was created

        ctx.result("Employee was inserted into the database! (not really)");

        //NOTE: we can have the json() and status() methods in either order

    };

}
