/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.team3;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author abaoubas
 */
public class Database2 {
    
     public static Connection getConnection() {
          try  {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://62.217.125.30:3306/itp14116",
                      "itp14116","changeit");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              return null;
          }
      }
 
       public static void close(Connection con) {
          try  {
              con.close();
          }
          catch(Exception ex) {
          }
      }
}
