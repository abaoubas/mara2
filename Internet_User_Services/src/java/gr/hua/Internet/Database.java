/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.Internet;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author rg
 */
public class Database {
   
     public static Connection getConnection() throws Exception {
          try  {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con = DriverManager.getConnection
                      ("jdbc:mysql://62.217.125.30:3306/itp14114?useUnicode=true&characterEncoding=utf-8",
                      "itp14114","changeit");
              return con;
          }
          catch(Exception ex) {
              System.out.println("Database.getConnection() Error -->" + ex.getMessage());
              throw ex;
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
