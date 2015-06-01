/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.UserExists;

import gr.hua.team3.InternetDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Helen
 */
public class Consumer_Manager {
    private Connection connection;
  
    
    
    public Consumer_Manager() {
        connection = Database.getConnection();
    }
    
    public boolean insertNewRequest(InitialRequests req){
        try {
                    
            /*private int request_id,fk_user_id,title,album,creator_name,singer_name,fk_genre_id,fk_file_type_id,creation_date;
            */
        
            String insertEmployee = "INSERT INTO Request"
		+ "(fk_user_id,dateInserted,status,title,album,creator_name,singer_name,fk_genre_id,fk_file_type_id,creation_date) VALUES"
		+ "(?,CURDATE(),0,?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployee);
            //preparedStatement.setInt(1, req.getRequest_id());
            preparedStatement.setInt(1, req.getFk_user_id());
            preparedStatement.setString(2, req.getTitle());
            preparedStatement.setString(3, req.getAlbum());
            preparedStatement.setString(4, req.getCreator_name());
            preparedStatement.setString(5, req.getSinger_name());
            preparedStatement.setInt(6, req.getFk_genre_id());
            preparedStatement.setInt(7, req.getFk_file_type_id());
            preparedStatement.setDate(8,new java.sql.Date( req.getCreation_date().getTime()));
            // execute insert SQL stetement
            preparedStatement .executeUpdate();
           
            
            
            
            return true;
            
        }catch(Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        
        return false;
    }
 
    public boolean acceptRequest(UserAcceptanceArgs user_acc_args){
        
        try {
            String updateEmployee = "UPDATE Request set status = ? WHERE fk_user_id = ? and request_id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(updateEmployee);
            preparedStatement.setInt(1, user_acc_args.isAccept());
            preparedStatement.setInt(2, user_acc_args.getUser_id());
            preparedStatement.setInt(3, user_acc_args.getRequest_id());
            
            preparedStatement.executeUpdate();
            
            return true;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        
        return false;
    }
    
    public ArrayList<Request> getUserRequests(User_id_Request user_id_req) {
           
        ArrayList<Request> user_reqs = new ArrayList<Request>();
        
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * from Request where fk_user_id = ?");
            ps.setInt(1, user_id_req.getUser_id());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()){
                                
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
                r.setSinger_name(rs.getString("singer_name"));
                r.setFk_genre_id(rs.getInt("fk_genre_id"));
                r.setFk_file_type_id(rs.getInt("fk_file_type_id"));
                r.setCreation_date(rs.getDate("creation_date"));
                         
                user_reqs.add(r);
            } 
            
            return user_reqs;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        } 
        return null;
    }
}
