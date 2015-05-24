/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3;

import gr.hua.UserExists.Request;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author palia_000
 */
public class DAL_Requests {
    
    private Connection connection;
  
    
    
    public DAL_Requests() {
        connection = gr.hua.UserExists.Database.getConnection();
    }
 
    public ArrayList<Request> SelectRequests() {
        
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Request");            
            ResultSet rs = ps.executeQuery();
            ArrayList<Request> results = new ArrayList<Request>();
            
            while (rs.next()) // found
            {
                Request r = new Request();
                r.setRequest_id(rs.getInt("request_id"));
                r.setFk_user_id(rs.getInt("fk_user_id"));
                r.setFk_emp_no(rs.getInt("fk_emp_no"));
                r.setDateInserted(rs.getDate("dateInserted"));
                r.setDateModified(rs.getDate("dateModified"));
                r.setTotalCost(rs.getFloat("totalCost"));
                r.setDiscount(rs.getFloat("discount"));
                r.setFinalCost(rs.getFloat("finalCost"));
                r.setStatus(rs.getInt("status"));
                r.setTitle(rs.getString("title"));
                r.setAlbum(rs.getString("album"));
                r.setCreator_name(rs.getString("creator_name")); 
                r.setSinger_name(null);
                r.setFk_file_type_id(rs.getInt("fk_file_type_id"));
                r.setFk_genre_id(rs.getInt("fk_genre_id"));
                r.setCreation_date(rs.getDate("creation_date"));
                results.add(r);
            } 
            
            
            return results;
        } catch (Exception ex) {
            PrintError(ex);
        } 
        return new ArrayList<Request>();
    }

    private void PrintError(Exception ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        System.out.println(errors.toString());
    }
    
    
    
    
}
