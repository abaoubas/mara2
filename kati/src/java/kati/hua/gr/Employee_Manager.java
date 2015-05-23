/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kati.hua.gr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author palia_000
 */
public class Employee_Manager {
    
    private Connection connection;
  
    
    
    public Employee_Manager() {
        connection = Database.getConnection();
    }
 
    public String checkUser(Employee user) {
        String gi="";
        try {
            PreparedStatement ps = connection.prepareStatement("select list_last_name from employees where list_first_name = ?");
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                return rs.getString("list_last_name");
            } 
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        return gi;
    }
}
