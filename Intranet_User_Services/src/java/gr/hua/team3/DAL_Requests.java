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
                r.setSinger_name(rs.getString("singer_name"));
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

    public boolean SetRequestPrices(Float totalc, Float disc, Integer req_id, Integer status) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Request set totalCost = ?, discount = ?, status = ? WHERE  request_id = ?");
            ps.setFloat(1, totalc);
            ps.setFloat(2, disc);
            ps.setInt(3, status);
            ps.setInt(4, req_id);

            ps.executeUpdate();

            return true;

        } catch (Exception ex) {
            PrintError(ex);
        }
        return false;

    }

    public boolean RejectRequest(Integer request_id, Integer emp_no) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Request "
                    + "SET status = 98 , fk_emp_no = ? "
                    + "WHERE  request_id = ? ");
            ps.setInt(1, emp_no);
            ps.setInt(2, request_id);

            ps.executeUpdate();

            return true;

        } catch (Exception ex) {
            PrintError(ex);
        }
        return false;

    }

    public boolean insertMngApproval(Request req) {
        try {
            String insertEmployee = "UPDATE Request SET discount=?, status=?  WHERE request_id=?;";

            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployee);

            preparedStatement.setFloat(1, req.getDiscount());
            preparedStatement.setInt(2, 21);
            preparedStatement.setInt(3, req.getRequest_id());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }

        return false;
    }

    public boolean insertSalesApproval(Request req) {
        try {

            /*private int request_id,fk_user_id,title,album,creator_name,singer_name,fk_genre_id,fk_file_type_id,creation_date;
             */
            String insertEmployee = "UPDATE Request SET finalcost=?, status=?  WHERE request_id=?;";

            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployee);
            //preparedStatement.setInt(1, req.getRequest_id());

            preparedStatement.setFloat(1, req.getFinalCost());
            preparedStatement.setInt(2, 25);
            preparedStatement.setInt(3, req.getRequest_id());

            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;

        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }

        return false;
    }

    public boolean PaidRequest(Integer request_id, Integer emp_no) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE Request set status = 31 , fk_emp_no = ? WHERE  request_id = ? ");
            ps.setFloat(1, emp_no);
            ps.setInt(2, request_id);

            ps.executeUpdate();

            return true;

        } catch (Exception ex) {
            PrintError(ex);
        }
        return false;

    }

}
