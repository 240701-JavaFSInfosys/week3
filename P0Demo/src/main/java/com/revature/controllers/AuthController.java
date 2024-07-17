package com.revature.controllers;

import com.revature.models.Employee;
import com.revature.models.LoginDTO;
import com.revature.services.AuthService;
import io.javalin.http.Handler;
import jakarta.servlet.http.HttpSession;

//This Controller deals with Authentication functionalities
//in the future, I'll have register here too, but for now we have insertEmployee in the EmpController
public class AuthController {

    //Instantiate the AuthService to use the login() method
    AuthService as = new AuthService();

    //uninitialized HttpSession object - to be filled upon successful login
    public static HttpSession ses;

    //login will be a POST request, since we're sending login creds in the HTTP Request body
    public Handler loginHandler = ctx -> {

        //extract the Request body as a LoginDTO
        LoginDTO lDTO = ctx.bodyAsClass(LoginDTO.class);

        //send the login credentials to the AuthService
        Employee loggedInEmployee = as.login(lDTO);

        //if the login was successful, return the Employee object
        if(loggedInEmployee != null){
            //set the session object
            ses = ctx.req().getSession();

            //TODO: set user attributes in the session

            ctx.status(202); //accepted
            ctx.json(loggedInEmployee);

        }

    };

}
