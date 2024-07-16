package com.revature.DAOs;

import com.revature.models.Role;

public interface RoleDAOInterface {

    //A method that gets Roles by their ID
    //we'll call this from Postman
    //but we really need this to populate Role objects for the getEmployees method()
    Role getRoleById(int id);

    //a method that updates a Role's salary
    int updateRoleSalary(int roleId, int newSalary);

}
