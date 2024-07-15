package com.revature.DAOs;

import com.revature.models.Employee;
import com.revature.utils.ConnectionUtil;

import java.sql.*; //import everything from java.sql
import java.util.ArrayList;

public class EmployeeDAO implements EmployeeDAOInterface{


    @Override
    public ArrayList<Employee> getEmployees() {

        //instantiate a Connection object so we can talk to the DB
        try(Connection conn = ConnectionUtil.getConnection()){

            //A String that will represent the SQL we send to the DB
            String sql = "SELECT * FROM employees";

            //We need to create a Statement object to execute our query
            //NOTE: The query above has no variables, so we'll use Statement, not PreparedStatement
            Statement s = conn.createStatement();

            //We execute the query, and save the results into a ResultSet
            ResultSet rs = s.executeQuery(sql);

            //We need an ArrayList to hold the SELECTed Employees
            ArrayList<Employee> employees = new ArrayList<>();

            //rs.next() will iterate through the ResultSet...
            //and return false when there are no more records
            while(rs.next()){

                //For every Employee found, add it to the ArrayList
                //We will need to instantiate a new Employee object for each record
                //We can get each column from the ResultSet with rs.getXYZ()
                Employee e = new Employee(
                        rs.getInt("employee_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        //TODO: Ben will see about rs.getObject
                        null //TODO: we need a getRoleByID DAO method
                );

                employees.add(e);

            } //end of while loop - no more employees to see!

            return employees; //return the ArrayList of Employees

        } catch(SQLException e){
            e.printStackTrace(); //Tell us what went wrong
        }

        return null;
        //Why return null at the end? we need to satisfy the return type.
        //Something needs to be returned no matter what

    }

    @Override
    public Employee insertEmployee(Employee emp) {
        return null;
    }
}
