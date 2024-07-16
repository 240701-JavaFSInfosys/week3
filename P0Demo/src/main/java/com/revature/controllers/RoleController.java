package com.revature.controllers;

import com.revature.DAOs.RoleDAO;
import com.revature.models.Role;
import io.javalin.http.Handler;

public class RoleController {

    //We need a RoleDAO to use it's methods
    RoleDAO rDAO = new RoleDAO();

    //This Handler will accept GET requests to /roles/{id}
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

        //TODO: actually send this to the DAO

        //mock response
        ctx.status(202); //202 stands for accepted - update accepted
        ctx.result("Role salary " + role_id + " has been updated to: " + salary);

        //TODO: we could get the role title for a more descriptive output

    };

}
