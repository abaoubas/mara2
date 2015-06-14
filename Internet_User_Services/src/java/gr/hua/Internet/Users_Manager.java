/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.Internet;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author palia_000
 */
public class Users_Manager {

    private Connection connection;

    public Users_Manager() throws Exception {
        connection = Database.getConnection();
    }

    public Users checkUser(Users user) {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from InternetUsers where username = ?");
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) // found
            {
                user.setUser_id(rs.getInt("pk_user_id"));
                user.setUsername(rs.getString("username"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setBirthdate(rs.getDate("birth_date"));
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
                user.setIBAN(rs.getString("IBAN"));

                return user;
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Users> getAllUsers() {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from InternetUsers ");

            ResultSet rs = ps.executeQuery();
            ArrayList<Users> users = new ArrayList<Users>();
            while (rs.next()) // found
            {
                Users user = new Users();
                user.setUser_id(rs.getInt("pk_user_id"));
                user.setUsername(rs.getString("username"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setBirthdate(rs.getDate("birth_date"));
                user.setGender(rs.getString("gender"));
                user.setEmail(rs.getString("email"));
                user.setIBAN(rs.getString("IBAN"));

                users.add(user);
            }

            return users;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }

    public Integer insertUser(Users user) {

        try {
            PreparedStatement ps1 = connection.prepareStatement("INSERT INTO InternetUsers "
                    + "(first_name, last_name, username, password, birth_date, gender, email, IBAN) "
                    + "VALUES (?,?,?,?,?,?,?,?);");
            ps1.setString(1, user.getFirst_name());
            ps1.setString(2, user.getLast_name());
            ps1.setString(3, user.getUsername());
            ps1.setString(4, user.getPassword());
            ps1.setDate(5, user.getBirthdate());
            ps1.setString(6, user.getGender());
            ps1.setString(7, user.getEmail());
            ps1.setString(8, user.getIBAN());
            ps1.executeUpdate();
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
