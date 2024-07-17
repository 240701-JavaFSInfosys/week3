package com.revature.controllers;

import com.revature.DAOs.RoleDAO;
import com.revature.models.Role;
import com.revature.services.RoleService;
import io.javalin.http.Handler;

public class RoleController {

    //We need a RoleDAO to use it's methods
    RoleDAO rDAO = new RoleDAO();

    //OLD^ we're using the service for the update method
    RoleService rs = new RoleService();

    //This Handler will accept GET requests to /roles/{id}
    //NOTE: we never changed this one, it's still calling the DAO
    public Handler getRoleByIdHandler = ctx -> {

        //Extract the path parameter from the HTTP Request
        //We had to use parseInt because pathParam returns a String
        int role_id = Integer.parseInt(ctx.pathParam("id"));

        //Instantiate a Role object using the DAO method and the role_id we got above
        Role role = rDAO.getRoleById(role_id);

        if(role == null){
            ctx.status(400); //bad request - role not found
            ctx.result("Role not found!");
        } else {
            ctx.status(200); //200 ok
            ctx.json(role); //send the Role back as JSON
        }

    };

    //This Handler will handle PATCH requests to /roles/{id}
    public Handler updateSalaryHandler = ctx -> {

        //The user will include the role id in the path parameter...
        //...and include the new salary in the request body
        int role_id = Integer.parseInt(ctx.pathParam("id"));

        //NOTE: salary is coming in as a single value, so we'll use .body(), not .bodyAsClass()
        int salary = Integer.parseInt(ctx.body());

        try{
            //send the two values above to the service
            rs.updateRoleSalary(role_id, salary);
            ctx.status(202); //202 - accepted
            ctx.result("Role salary " + role_id + " has been updated to: " + salary);
        } catch(IllegalArgumentException e){
            ctx.status(400); //bad request
            ctx.result(e.getMessage());
        }


//        //Call the DAO method to update the salary, giving it the ID and the Salary
//        if(rDAO.updateRoleSalary(role_id, salary) > 0){
//            ctx.status(202); //202 stands for accepted - update accepted
//            ctx.result("Role salary " + role_id + " has been updated to: " + salary);
//        } else {
//            ctx.status(400); //bad request - something went wrong
//            ctx.result("Update failed! Make sure the Role Id and salary are valid.");
//        }
//
//        //TODO: we could get the role title for a more descriptive output

    };

}
