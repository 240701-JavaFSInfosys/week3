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

}
