package com.revature.controllers;

import com.revature.DAOs.EmployeeDAO;
import com.revature.models.Employee;
import com.revature.services.EmployeeService;
import io.javalin.http.Handler;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;
import java.util.ArrayList;

/* The Controller Layer is where HTTP Requests get sent after Javalin directs them
 It's in this layer that JSON comes in and gets translated to Java and vice versa
 We'll be taking in HTTP Requests from the client and sending back HTTP Responses
 The Controllers job is processing HTTP Requests */
public class EmployeeController {

    //We need an EmployeeDAO to use its employee data methods
    EmployeeDAO eDAO = new EmployeeDAO();

    //OLD^ we're using services now:
    EmployeeService es = new EmployeeService();

    //This Handler will handle GET requests to /employees
    public Handler getEmployeesHandler = ctx -> {

        //Get an ArrayList of employees, populated by the getEmployees service method
        ArrayList<Employee> employees = es.getEmployees();

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

        try {
            //Send this employee to the service to be inserted into the DB
            Employee insertedEmployee = es.insertEmployee(newEmployee);
            ctx.status(201); //201 "created" - the resource was created
            ctx.json(insertedEmployee); //send the employee back to the user
        } catch (IllegalArgumentException e){
            ctx.status(400); //400 stands for bad request
            ctx.result(e.getMessage()); //send back the specific exception message - user friendly!
        } catch (NullPointerException e){
            ctx.status(400);
            ctx.result("NullPointer got thrown - we didn't do lastname checks");
        }



//        //If something goes wrong in the DAO, it will return null.
//        //We can send back an error code/message if so
//        if (insertedEmployee == null) {
//            ctx.status(400); //400 stands for bad request
//            //TODO: we could make a custom exception like "ManagerAlreadyExistsException"
//            ctx.result("Failed to insert Employee! Check your JSON!");
//        } else{
//            //if the insert is successful, return 201 and the new Employee
//            ctx.status(201); //201 stands for "created", as in some new data was created
//            ctx.json(insertedEmployee); //send the new inserted Employee back to the user
//        }

        //NOTE: we can have the json() and status() methods in either order

    };

    //TODO: (for you) figure out how to make a DELETE handler

}
