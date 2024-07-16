package com.revature.DAOs;

import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;

import java.sql.*;

public class RoleDAO implements RoleDAOInterface{
    @Override
    public Role getRoleById(int id) {

        //Try to open a Connection to the DB
        try(Connection conn = ConnectionUtil.getConnection()){

            //String representing our SQL query
            String sql = "SELECT * FROM roles WHERE role_id = ?";

            //We need a prepared statement to fill in the wildcard "?"
            PreparedStatement ps = conn.prepareStatement(sql);

            //now we can use the id parameter to fill in the variable
            ps.setInt(1, id);

            //Execute the query, save the results in a ResultSet
            ResultSet rs = ps.executeQuery();

            //while loop to extract the data (even though there's only one record)
            while(rs.next()){

                //Instantiate the Role found in the ResultSet using the all args constructor
                Role role = new Role(
                    rs.getInt("role_id"),
                    rs.getString("role_title"),
                    rs.getInt("role_salary")
                );

                return role; //return the Role object

            }

        } catch(SQLException e){
            e.printStackTrace();
            System.out.println("Couldn't get Role by ID!");
        }

        return null;
    }

    @Override
    public int updateRoleSalary(int roleId, int newSalary) {
        return 0;
    }
}
