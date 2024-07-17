package com.revature.services;

import com.revature.models.Employee;
import com.revature.models.LoginDTO;

public class AuthService {

    //TODO: make the actual login DAO method... hardcoded for now

    //Again, this would realistically be username/password but we just have firstname/lastname
    public Employee login(LoginDTO lDTO){

        if(lDTO.getFirst_name().equals("Spongebob") && lDTO.getLast_name().equals("Squarepants")){
            return new Employee(2, "Spongebob", "Squarepants", null);
        } else {
            return null;
        }

    }

}
