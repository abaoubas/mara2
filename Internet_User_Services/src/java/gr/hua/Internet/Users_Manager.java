/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.Internet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author palia_000
 */
public class Users_Manager {
    
    private Connection connection;
  
    
    
    public Users_Manager() {
        connection = Database.getConnection();
    }
 
    public Integer checkUser(Users user) {
        
        try {
            PreparedStatement ps = connection.prepareStatement("select pk_user_id from InternetUsers where username = ?");
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                return rs.getInt("pk_user_id");
            } 
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        return null;
    }
    
    
    public Integer insertUser(Users user) {
        
        try {
            PreparedStatement ps1 = connection.prepareStatement("INSERT INTO InternetUsers\n" +
"VALUES (\'?\',\'?\',\'?\',\'?\',\'?\',\'?\',\'?\',\'?\',\'?\');");
            ps1.setString(1, user.getFirst_name());
            ps1.setString(2, user.getLast_name());
            ps1.setString(3, user.getUsername());
            ps1.setString(4, user.getPassword());
            ps1.setString(5, user.getBirthdate().toString());
            ps1.setString(6, user.getGender());
            ps1.setString(7, user.getEmail());
            ps1.setString(8, user.getIBAN());
            ps1.executeQuery();
            PreparedStatement ps2 = connection.prepareStatement("select pk_user_id from InternetUsers where username = ?");
            ps2.setString(1, user.getUsername());
            ResultSet rs = ps2.executeQuery();
            if (rs.next()) // found
            {
                return rs.getInt("pk_user_id");
            } 
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        return null;
    }
}
