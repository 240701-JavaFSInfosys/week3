package com.revature.DAOs;

import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.utils.ConnectionUtil;
import org.postgresql.util.PSQLException;

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
                        null //TODO: we need a getRoleByID DAO method
                );

                //We need to use the getRoleById method to populate the Employees Role object
                RoleDAO rDAO = new RoleDAO();
                Role role = rDAO.getRoleById(rs.getInt("role_id_fk"));

                //use the setter of Employee to populate the newly created Role object
                e.setRole(role);

                //NOTE: we could have instantiated the Role before the Employee
                //but we did things in a different order on Monday

                employees.add(e); //add the populated Employee to the ArrayList

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

        //We need a Connection object to interact with the DB
        try(Connection conn = ConnectionUtil.getConnection()){

            //create our SQL statement String
            String sql = "INSERT INTO employees (first_name, last_name, role_id_fk) VALUES (?,?,?)";

            //Instantiate a PreparedStatement to hold our SQL command and fill in the wildcards "?"
            PreparedStatement ps = conn.prepareStatement(sql);

            //fill in each wildcard with the Employee object and ps.setXYZ() methods
            ps.setString(1, emp.getFirst_name());
            ps.setString(2, emp.getLast_name());
            ps.setInt(3, emp.getRole_id_fk());

            //Now that our SQL command is complete, we can execute it
            ps.executeUpdate();
            //NOTE: executeUpdate() is used for INSERT, UPDATE, DELETE commands
                //...while executeQuery() is used for SELECT (querying the DB)

            //Now we can return the Employee to the user, assuming nothing went wrong
            return emp;

        } catch(SQLException e){
            e.printStackTrace(); //Tell us what went wrong
            System.out.println("Failed to insert employee!");
        }

        return null;
    }
}
