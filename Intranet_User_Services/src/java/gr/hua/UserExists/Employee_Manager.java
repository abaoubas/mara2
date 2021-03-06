/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.hua.UserExists;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
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
        String gi = "";
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

    public Employee getEmp(Employee emp) {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from IntranetUsers where username = ? and password = ?");
            ps.setString(1, emp.getUsername());
            ps.setString(2, emp.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                emp.setEmp_id(rs.getInt("pk_emp_no"));
                emp.setFirst_name(rs.getString("first_name"));
                emp.setLast_name(rs.getString("last_name"));
                emp.setUsername(rs.getString("username"));
                emp.setBirthdate(rs.getDate("birth_date").getYear(), rs.getDate("birth_date").getMonth(), rs.getDate("birth_date").getMinutes());
                emp.setGender(rs.getString("gender"));

                return emp;
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }

    public Employee getEmp2(String username) {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from IntranetUsers where username = ? ");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                Employee emp = new Employee();
                emp.setEmp_id(rs.getInt("pk_emp_no"));
                emp.setFirst_name(rs.getString("first_name"));
                emp.setLast_name(rs.getString("last_name"));
                emp.setUsername(rs.getString("username"));
                emp.setBirthdate(rs.getDate("birth_date"));
                emp.setGender(rs.getString("gender"));

                return emp;
            }
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }

    public ArrayList<Employee> getAllEmp() {

        try {
            PreparedStatement ps = connection.prepareStatement("select * from IntranetUsers  ");

            ResultSet rs = ps.executeQuery();
            ArrayList<Employee> emps = new ArrayList<>();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setEmp_id(rs.getInt("pk_emp_no"));
                emp.setFirst_name(rs.getString("first_name"));
                emp.setLast_name(rs.getString("last_name"));
                emp.setUsername(rs.getString("username"));
                emp.setBirthdate(rs.getDate("birth_date"));
                emp.setGender(rs.getString("gender"));

                emps.add(emp);
            }
            return emps;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }
        return null;
    }

    public Employee insertEmp(Employee emp) {

        try {
            String insertEmployee = "INSERT INTO IntranetUsers"
                    + "(first_name, last_name, username, password, birth_date, gender) VALUES"
                    + "(?,?,?,?,?,?)";

            PreparedStatement preparedStatement = connection.prepareStatement(insertEmployee);
            preparedStatement.setString(1, emp.getFirst_name());
            preparedStatement.setString(2, emp.getLast_name());
            preparedStatement.setString(3, emp.getUsername());
            preparedStatement.setString(4, emp.getPassword());
            preparedStatement.setDate(5, new java.sql.Date(emp.getBirthdate().getTime()));
            preparedStatement.setString(6, emp.getGender());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            return emp;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }

        return null;
    }

    public Employee updateEmp(Employee emp) {

        try {
            String updateEmployee = "UPDATE IntranetUsers set "
                    + "first_name = ?, "
                    + "last_name = ?, "
                    + "username = ?, "
                    + "password = ?, "
                    + "birth_date = ?, "
                    + "gender = ? "
                    + "where pk_emp_no = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(updateEmployee);
            preparedStatement.setString(1, emp.getFirst_name());
            preparedStatement.setString(2, emp.getLast_name());
            preparedStatement.setString(3, emp.getUsername());
            preparedStatement.setString(4, emp.getPassword());
            preparedStatement.setDate(5, (Date) emp.getBirthdate());
            preparedStatement.setString(6, emp.getGender());
            preparedStatement.setInt(7, emp.getEmp_id());
            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            return emp;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }

        return null;
    }

    public boolean deleteEmp(int pk_emp_no) {

        try {
            String deleteEmployee = "DELETE FROM IntranetUsers WHERE pk_emp_no = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(deleteEmployee);
            preparedStatement.setInt(1, pk_emp_no);
            // execute insert SQL stetement
            preparedStatement.executeUpdate();

            return true;
        } catch (Exception ex) {
            System.out.println("Error in check() -->" + ex.getMessage());
        }

        return false;
    }
}
