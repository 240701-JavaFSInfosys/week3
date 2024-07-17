package com.revature.services;

import com.revature.DAOs.RoleDAO;

public class RoleService {

    //Instantiate a RoleDAO to use its methods
    RoleDAO rDAO = new RoleDAO();

    public int updateRoleSalary(int roleId, int newSalary){

        //check that the roleId is greater than zero
        if(roleId <= 0){
            throw new IllegalArgumentException("Role ID must be a positive number!");
        }

        //check that the role exists
        if(rDAO.getRoleById(roleId) == null){
            throw new IllegalArgumentException("Role ID does not exist!");
        }

        //check that the new salary is greater than 2 and less than a million
        if(newSalary <= 2 || newSalary >= 1000000){
            throw new IllegalArgumentException("Salary must be between $2 and $999,999!");
        }

        //if these checks pass, send the update to the DB
        return rDAO.updateRoleSalary(roleId, newSalary);

    }

}
