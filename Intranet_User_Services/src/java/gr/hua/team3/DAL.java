/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3;
import gr.hua.team3.intranet.Recordings;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author abaoubas
 * this is the Data Access Layer
 * it contains all database related code
 */
public class DAL {
    
    private Connection connection;
  
    
    
    public DAL() {
        connection = gr.hua.UserExists.Database.getConnection();
    }
 
    public ArrayList<Recordings> SelectRecordings() {
        
        try {
            PreparedStatement ps = connection.prepareStatement("select * from Recordings");            
            ResultSet rs = ps.executeQuery();
            ArrayList<Recordings> results = new ArrayList<Recordings>();
            
            while (rs.next()) // found
            {
                Recordings r = new Recordings();
                r.setPk_recording_id(rs.getInt("pk_recording_id"));
                r.setTitle(rs.getString("title"));
                r.setCreation_date(rs.getDate("creation_date"));
                r.setAlbum(rs.getString("album"));
                r.setCreator_name(rs.getString("creator_name"));                
                r.setFile_type(rs.getInt("fk_file_type_id"));
                r.setFoto_location(rs.getString("foto_location"));
                r.setGenre_id(rs.getInt("fk_genre_id"));
                r.setPrice(rs.getFloat("price"));
                results.add(r);
            } 
            
            
            return results;
        } catch (Exception ex) {
            PrintError(ex);
        } 
        return new ArrayList<Recordings>();
    }

    private void PrintError(Exception ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        System.out.println(errors.toString());
    }
    
    
}
